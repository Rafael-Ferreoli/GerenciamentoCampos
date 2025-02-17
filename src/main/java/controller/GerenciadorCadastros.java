package controller;

import factory.Persistencia;
import java.util.List;
import model.Funcionario;
import model.DAO.IDAO;
import model.validation.CadastroValidation;

public class GerenciadorCadastros {

    private IDAO<Funcionario> funcionarioDAO;

    public GerenciadorCadastros() {
        Persistencia.closeConnection();
        this.funcionarioDAO = Persistencia.getFuncionarioDAO();
    }

    public void adicionarCadastro(Funcionario funcionario) {
        List<Funcionario> lista = funcionarioDAO.findAll();
        CadastroValidation.validarCamposObrigatorios(funcionario);
        CadastroValidation.validarUnicidade(funcionario.getCpf(), funcionario.getMatricula(), lista);
        funcionarioDAO.save(funcionario);
        System.out.println("Cadastro adicionado com sucesso.");
    }

    public boolean removerCadastro(String matricula) {
        Funcionario funcionario = buscarCadastro(matricula);
        if (funcionario != null) {
            funcionarioDAO.delete(matricula);
            System.out.println("Cadastro removido");
            return true;
        }
        System.out.println("Cadastro não encontrado");
        return false;
    }

    public Funcionario buscarCadastro(String matricula) {
        return funcionarioDAO.findById(matricula);
    }

    public void atualizarCadastro(String matricula, Funcionario funcionarioNovo) {
        if (buscarCadastro(matricula) != null) {
            funcionarioDAO.update(matricula, funcionarioNovo);
            System.out.println("Cadastro atualizado");
        } else {
            System.out.println("Cadastro não encontrado");
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioDAO.findAll();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Funcionario> funcionarios = funcionarioDAO.findAll();
        for (Funcionario funcionario : funcionarios) {
            sb.append(funcionario.toString()).append("\n");
        }
        return sb.toString();
    }
}
