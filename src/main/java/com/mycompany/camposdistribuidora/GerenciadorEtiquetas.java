/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora;

import com.mycompany.camposdistribuidora.File.FilePersistence;
import com.mycompany.camposdistribuidora.File.SerializadorCSVEtiquetas;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEtiquetas {

    private List<Etiqueta> etiquetas;

    public GerenciadorEtiquetas() {
        this.etiquetas = new ArrayList<>();
    }

    public void adicionarEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
        System.out.println("Etiqueta adicionada");
    }

    public boolean removerEtiqueta(int numero) {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getNumEtiqueta() == numero) {
                etiquetas.remove(etiqueta);
                System.out.println("Etiqueta removida");
                return true;
            }
        }
        System.out.println("Etiqueta não encontrada");
        return false;
    }

    public Etiqueta buscarEtiqueta(int numero) {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getNumEtiqueta() == numero) {
                return etiqueta;
            }
        }
        return null;
    }

    public void atualizarEtiqueta(int numero, Etiqueta etiquetaNova) {
        Etiqueta etiquetaExistente = buscarEtiqueta(numero);
        if (etiquetaExistente != null) {
            int indice = etiquetas.indexOf(etiquetaExistente);
            etiquetas.set(indice, etiquetaNova);
            System.out.println("Etiqueta atualizada");
        } else {
            System.out.println("Etiqueta " + numero + " não encontrada");
        }
    }

    public String[] toStringArray() {
        StringBuilder[] textAreas = new StringBuilder[6];
        for (int i = 0; i < textAreas.length; i++) {
            textAreas[i] = new StringBuilder();
        }

        for (Etiqueta etiqueta : etiquetas) {
            int index = etiqueta.getNumEtiqueta()- 1;
            if (index >= 0 && index < textAreas.length) {
                textAreas[index].append(etiqueta.toString()).append("\n");
            }
        }

        String[] textAreasText = new String[textAreas.length];
        for (int i = 0; i < textAreas.length; i++) {
            textAreasText[i] = textAreas[i].toString();
        }

        return textAreasText;
    }

    public void salvarNoArquivo(String pathFile) throws IOException {
        SerializadorCSVEtiquetas serializadorCSV = new SerializadorCSVEtiquetas();
        String csvData = serializadorCSV.toCSV(this.etiquetas);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(csvData, pathFile);
        System.out.println("Etiquetas salvas");
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String csvData = filePersistence.loadFromFile(pathFile);
        SerializadorCSVEtiquetas serializadorCSV = new SerializadorCSVEtiquetas();
        this.etiquetas = serializadorCSV.fromCSV(csvData);
        System.out.println("Etiquetas carregadas");
    }
}
