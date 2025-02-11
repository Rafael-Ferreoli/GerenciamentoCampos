package model.DAO;

import java.util.List;

public interface IDAO<T> {

    // Salva um objeto do tipo T
    void save(T entity);

    // Atualiza um objeto do tipo T pelo identificador
    void update(String id, T entity);

    // Remove um objeto do tipo T pelo identificador
    void delete(String id);

    // Encontra um objeto do tipo T pelo identificador
    T findById(String id);

    // Retorna todos os objetos do tipo T
    List<T> findAll();
}
