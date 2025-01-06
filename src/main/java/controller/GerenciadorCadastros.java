/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cadastro;
import model.FilePersistence;
import model.SerializadorCSVCadastro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class GerenciadorCadastros {

    private List<Cadastro> cadastros;

    public GerenciadorCadastros() {
        this.cadastros = new ArrayList<>();
    }

    public void adicionarCadastro(Cadastro cadastro) {
        // A validação já ocorre no momento da criação do Cadastro
        cadastros.add(cadastro);
        System.out.println("Cadastro adicionado");
    }

    public boolean removerCadastro(String matricula) {
        for (Cadastro cadastro : cadastros) {
            if (cadastro.getMatricula().equals(matricula)) {
                cadastros.remove(cadastro);
                System.out.println("Cadastro removido");
                return true;
            }
        }
        System.out.println("Cadastro não encontrado");
        return false;
    }

    public Cadastro buscarCadastro(String matricula) {
        for (Cadastro cadastro : cadastros) {
            if (cadastro.getMatricula().equals(matricula)) {
                return cadastro;
            }
        }
        return null;
    }

    public void atualizarCadastro(String matricula, Cadastro cadastroNovo) {
        Cadastro cadastroExistente = buscarCadastro(matricula);
        if (cadastroExistente != null) {
            int indice = cadastros.indexOf(cadastroExistente);
            cadastros.set(indice, cadastroNovo);
            System.out.println("Cadastro atualizado");
        } else {
            System.out.println("Cadastro não encontrado");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cadastro cadastro : cadastros) {
            sb.append(cadastro.toString()).append("\n");
        }
        return sb.toString();
    }

    public void salvarNoArquivo(String pathFile) throws IOException {
        SerializadorCSVCadastro serializadorCSV = new SerializadorCSVCadastro();
        String csvData = serializadorCSV.toCSV(this.cadastros);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, pathFile);
        System.out.println("Cadastro salvo");
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(pathFile);
        SerializadorCSVCadastro serializadorCSV = new SerializadorCSVCadastro();
        this.cadastros = serializadorCSV.fromCSV(csvData);
        System.out.println("Cadastros carregados");
    }
}
