/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import model.validation.ValidacaoProduto;


/**
 *
 * @author rafae
 */
@Entity
public class Cadastro {
    private String nome;
    private String cpf;
    private String senha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    public Cadastro(String nome, String cpf, String senha, String matricula) {
        ValidacaoProduto.validarStringNaoVazia(nome, "Nome não pode ser vazio");
        ValidacaoProduto.validarStringNaoVazia(cpf, "CPF não pode ser vazio");
        ValidacaoProduto.validarCPF(cpf);
        ValidacaoProduto.validarStringNaoVazia(senha, "Senha não pode ser vazia");
        ValidacaoProduto.validarMatricula(matricula);

        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.matricula = matricula;
    }
    
    public Cadastro() {
        this.nome = "";
        this.cpf = "";
        this.senha = "";
        this.matricula = "";

    }

    @Override
    public String toString() {
        return " Nome: " + nome +  "\n CPF: " + cpf + "\n Matrícula: " + matricula + "\n Senha: " + senha + "\n ********************";
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
