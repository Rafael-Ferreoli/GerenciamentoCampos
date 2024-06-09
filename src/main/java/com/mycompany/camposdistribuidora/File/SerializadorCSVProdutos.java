/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora.File;

import com.mycompany.camposdistribuidora.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class SerializadorCSVProdutos {

    public String toCSV(List<Produto> produtos) {
        String csv = "Nome;CódigoInterno;CódigoBarras;Preço;Quantidade";
        for(Produto produto : produtos){
            csv += "\n";
            csv += produto.getNome() + ";"
                    + produto.getCodigoInterno()+ ";"
                    + produto.getCodigoBarra()+ ";"
                    + produto.getPreco()+ ";"
                    + produto.getQuantidade();
        }
        return csv;
    }

    public List<Produto> fromCSV(String data) {
        List<Produto> produtos = new ArrayList<>();
        String[] linhas = data.split("\n"); //ignora cabeça~lho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 5) {
                Produto produto = new Produto();
                produto.setNome(partes[0]);
                produto.setCodigoInterno(partes[1]);
                produto.setCodigoBarra(partes[2]);
                produto.setPreco(partes[3]);
                produto.setQuantidade(partes[4]);
                produtos.add(produto);
            }
        }
        return produtos;
    }
}