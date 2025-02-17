package model.validation;

import java.time.LocalDate;
import java.util.List;
import model.Etiqueta;
import model.exception.EtiquetaException;

public class EtiquetaValidation {

    public static void validarCodigoInterno(String codigoInterno) {
        if (codigoInterno == null || codigoInterno.trim().isEmpty()) {
            throw EtiquetaException.codigoInternoInvalido();
        }
    }
    
    public static void validarData(LocalDate data) {
        if (data == null) {
            throw EtiquetaException.dataInvalida();
        }
    }
    
    public static void validarNumeroEtiqueta(int numero) {
        if (numero <= 0) {
            throw EtiquetaException.numeroEtiquetaInvalido();
        }
    }

    public static void validarUnicidade(int numEtiqueta, List<Etiqueta> etiquetas, int numeroAtual) {
        for (Etiqueta e : etiquetas) {
            if (e.getNumEtiqueta() == numEtiqueta && e.getNumEtiqueta() != numeroAtual) {
                throw EtiquetaException.etiquetaDuplicada(numEtiqueta);
            }
        }
    }
    
    public static void validarCamposObrigatorios(Etiqueta etiqueta, List<Etiqueta> etiquetas, int numeroAtual) {
        validarCodigoInterno(etiqueta.getCodigoInterno());
        validarData(etiqueta.getData());
        validarNumeroEtiqueta(etiqueta.getNumEtiqueta());
        validarUnicidade(etiqueta.getNumEtiqueta(), etiquetas, numeroAtual);
    }
}
