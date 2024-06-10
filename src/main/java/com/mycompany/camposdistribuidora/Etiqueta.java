/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.camposdistribuidora;

import java.time.LocalDate;

public class Etiqueta {
    private String codigoInterno;
    private LocalDate data;
    private int numEtiqueta;

    public Etiqueta(String codigoInterno, LocalDate data, int numEtiqueta) {
        this.codigoInterno = codigoInterno;
        this.data = data;
        this.numEtiqueta = numEtiqueta;
    }
    
    @Override
    public String toString() {
        return " Cod Interno: " + codigoInterno + "\n Data Validade: " + data + "\n Num Etiqueta: " + numEtiqueta + "\n ********************";
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumEtiqueta() {
        return numEtiqueta;
    }

    public void setNumEtiqueta(int numEtiqueta) {
        this.numEtiqueta = numEtiqueta;
    }
}

