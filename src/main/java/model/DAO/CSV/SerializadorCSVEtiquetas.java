/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO.CSV;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Etiqueta;

public class SerializadorCSVEtiquetas {

    public String toCSV(List<Etiqueta> etiquetas) {
        String csv = "CodigoInterno;Data;Etiqueta";
        for (Etiqueta etiqueta : etiquetas) {
            csv += "\n";
            csv += etiqueta.getCodigoInterno() + ";"
                    + etiqueta.getData() + ";"
                    + etiqueta.getNumEtiqueta();
        }
        return csv;
    }

    public List<Etiqueta> fromCSV(String data) {
        List<Etiqueta> etiquetas = new ArrayList<>();
        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) { // Ignora cabeçalho
            String[] partes = linhas[i].split(";");
            if (partes.length >= 3) {
                String codigoInterno = partes[0];
                LocalDate dataEtiqueta = LocalDate.parse(partes[1]);
                int numEtiqueta = Integer.parseInt(partes[2]);
                Etiqueta etiqueta = new Etiqueta(codigoInterno, dataEtiqueta, numEtiqueta);
                etiquetas.add(etiqueta);
            }
        }
        return etiquetas;
    }
}


