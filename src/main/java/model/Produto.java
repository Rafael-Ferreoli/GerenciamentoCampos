/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.validation.ValidacaoProduto;

/**
 *
 * @author rafae
 */
public class Produto {
    
    private String nome;
    private String codigoInterno;
    private String codigoBarra;
    private double preco;
    private int  quantidade;

    public Produto() {
        this.nome = "";
        this.codigoInterno = "";
        this.codigoBarra = "";
        this.preco = 0;
        this.quantidade = 0;
    }
    
        @Override
    public String toString() {
        return " Nome: " + nome + "\n Código Interno: " + codigoInterno + "\n Código de Barras: " + codigoBarra + "\n Preço: R$" + preco + "\n Quantidade: " + getQuantidade() + "\n ********************";
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
     * @return the codigoInterno
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * @param codigoInterno the codigoInterno to set
     */
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return the valor
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param valor the valor to set
     */
    public void setPreco(double preco) {
        ValidacaoProduto.validarPreco(preco);
        this.preco = preco;
    }    

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        ValidacaoProduto.validarQuantidade(quantidade);
        this.quantidade = quantidade;
    }
    
    
}
