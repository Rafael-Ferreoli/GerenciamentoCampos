package model.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Funcionario;
import java.util.List;
import model.Administrador;
import model.Operador;

public class CadastroSQLiteJPADAO implements IDAO<Funcionario> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CamposDistribuidoraPU");

    @Override
    public void save(Funcionario entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(String matricula, Funcionario entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            TypedQuery<Funcionario> query = em.createQuery(
                    "SELECT f FROM Funcionario f WHERE f.matricula = :matricula", Funcionario.class);
            query.setParameter("matricula", matricula);
            Funcionario existing = query.getSingleResult();

            if (existing != null) {
                existing.setNome(entity.getNome());
                existing.setCpf(entity.getCpf());
                existing.setMatricula(entity.getMatricula());
                existing.setSenha(entity.getSenha());
                existing.setEmail(entity.getEmail());

                if (existing instanceof Operador operadorExistente && entity instanceof Operador operadorNovo) {
                    Administrador novoAdmin = operadorNovo.getAdministrador();
                    if (novoAdmin != null) {
                        Administrador adminGerenciado = em.find(Administrador.class, novoAdmin.getId());
                        operadorExistente.setAdministrador(adminGerenciado);
                    }
                }

                em.merge(existing);
                em.flush();
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Funcionario entity = em.find(Funcionario.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Funcionario findById(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                    "SELECT f FROM Funcionario f WHERE f.matricula = :matricula", Funcionario.class);
            query.setParameter("matricula", id);
            List<Funcionario> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Funcionario> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
