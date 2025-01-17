/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.validation.Validacao;

/**
 *
 * @author rafae
 */
public class Cadastro {

    private String nome;
    private String email;
    private String cpf;
    private String cargo;
    private String senha;
    private String matricula;

    public Cadastro(String nome, String email, String cpf, String cargo, String senha, String matricula) {
        Validacao.validarStringNaoVazia(nome, "Nome não pode ser vazio");
        Validacao.validarStringNaoVazia(email, "E-mail não pode ser vazio");
        Validacao.validarEmail(email);
        Validacao.validarStringNaoVazia(cpf, "CPF não pode ser vazio");
        Validacao.validarCPF(cpf);
        Validacao.validarStringNaoVazia(cargo, "Cargo não pode ser vazio");
        Validacao.validarStringNaoVazia(senha, "Senha não pode ser vazia");
        Validacao.validarMatricula(matricula);

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.senha = senha;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return " Nome: " + nome + "\n Email: " + email + "\n CPF: " + cpf + "\n Cargo: " + cargo + "\n Matrícula: " + matricula + "\n Senha: " + senha + "\n ********************";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
