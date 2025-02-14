/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 *
 * @author rafae
 */
@Entity
public class Cadastro {
    private String nome;
    private String cpf;   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;
    private String senha;

    public Cadastro(String nome, String cpf, String matricula, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.senha = senha;
    }
    
    public Cadastro() {
        this.nome = "";
        this.cpf = "";
        this.matricula = "";
        this.senha = "";

    }

    @Override
    public String toString() {
        return " Nome: " + nome +  "\n CPF: " + cpf + "\n Senha: " + senha + "\n Matrícula: " + matricula +  "\n ********************";
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
