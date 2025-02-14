package controller;

import factory.Persistencia;
import java.util.List;
import model.Cadastro;
import model.DAO.IDAO;
import model.validation.CadastroValidacao;

public class GerenciadorCadastros {

    private IDAO<Cadastro> cadastroDAO;

    public GerenciadorCadastros() {
        this.cadastroDAO = Persistencia.getCadastroDAO();
    }

    public void adicionarCadastro(Cadastro cadastro) {
        List<Cadastro> lista = cadastroDAO.findAll();
        CadastroValidacao.validarCamposObrigatorios(cadastro);
        CadastroValidacao.validarUnicidade(cadastro.getCpf(), cadastro.getMatricula(), lista);
        cadastroDAO.save(cadastro);
        System.out.println("Cadastro adicionado com sucesso.");
    }

    public boolean removerCadastro(String matricula) {
        Cadastro cadastro = buscarCadastro(matricula);
        if (cadastro != null) {
            cadastroDAO.delete(matricula);
            System.out.println("Cadastro removido");
            return true;
        }
        System.out.println("Cadastro não encontrado");
        return false;
    }

    public Cadastro buscarCadastro(String matricula) {
        return cadastroDAO.findById(matricula);
    }

    public void atualizarCadastro(String matricula, Cadastro cadastroNovo) {
        if (buscarCadastro(matricula) != null) {
            cadastroDAO.update(matricula, cadastroNovo);
            System.out.println("Cadastro atualizado");
        } else {
            System.out.println("Cadastro não encontrado");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Cadastro> cadastros = cadastroDAO.findAll();
        for (Cadastro cadastro : cadastros) {
            sb.append(cadastro.toString()).append("\n");
        }
        return sb.toString();
    }
}
