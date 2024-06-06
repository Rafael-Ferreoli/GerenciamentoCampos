/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora.File;

import com.mycompany.camposdistribuidora.Cadastro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class SerializadorCSVCadastro {

    public String toCSV(List<Cadastro> cadastros) {
        String csv = "Nome;Cargo;CPF;Email;Matricula;Senha";
        for(Cadastro cadastro : cadastros){
            csv += "\n";
            csv += cadastro.getNome() + ";"
                    + cadastro.getCargo() + ";"
                    + cadastro.getCpf() + ";"
                    + cadastro.getMatricula() + ";"
                    + cadastro.getEmail() + ";"
                    + cadastro.getSenha();
        }
        return csv;
    }

    public List<Cadastro> fromCSV(String data) {
        List<Cadastro> cadastros = new ArrayList<>();
        String[] linhas = data.split("\n"); //ignora cabeça~lho
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 6) {
                Cadastro cadastro = new Cadastro();
                cadastro.setNome(partes[0]);
                cadastro.setCargo(partes[1]);
                cadastro.setCpf(partes[2]);
                cadastro.setMatricula(partes[3]);
                cadastro.setEmail(partes[4]);
                cadastro.setSenha(partes[5]);
                cadastros.add(cadastro);
            }
        }
        return cadastros;
    }
}