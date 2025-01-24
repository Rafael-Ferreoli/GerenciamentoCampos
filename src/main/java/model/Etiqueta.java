package model;

import model.validation.ValidacaoProduto;
import java.time.LocalDate;

public class Etiqueta {
    private String codigoInterno;
    private LocalDate data;
    private int numEtiqueta;

    public Etiqueta(String codigoInterno, LocalDate data, int numEtiqueta) {
        // Validação dos dados de entrada
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio");
        ValidacaoProduto.validarNumeroNaoNegativo(numEtiqueta, "Número da etiqueta não pode ser negativo");

        this.codigoInterno = codigoInterno;
        this.data = data;
        this.numEtiqueta = numEtiqueta;
    }

    @Override
    public String toString() {
        return " Cod Interno: " + codigoInterno + "\n Data Validade: " + data + "\n Num Etiqueta: " + numEtiqueta + "\n ********************";
    }

    // Getters e setters

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
        ValidacaoProduto.validarNumeroNaoNegativo(numEtiqueta, "Número da etiqueta não pode ser negativo");
        this.numEtiqueta = numEtiqueta;
    }
}
