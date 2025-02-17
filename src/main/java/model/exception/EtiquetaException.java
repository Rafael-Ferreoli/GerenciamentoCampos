package model.exception;

public class EtiquetaException extends RuntimeException {

    public EtiquetaException(String message) {
        super(message);
    }
    
    public static EtiquetaException camposInvalidos(String campo) {
        return new EtiquetaException("Erro: " + campo + " não pode ser vazio.");
    }
    
    public static EtiquetaException codigoInternoInvalido() {
        return new EtiquetaException("Erro: Código interno da etiqueta é inválido.");
    }
    
    public static EtiquetaException dataInvalida() {
        return new EtiquetaException("Erro: Data da etiqueta é inválida.");
    }
    
    public static EtiquetaException numeroEtiquetaInvalido() {
        return new EtiquetaException("Erro: Número da etiqueta deve ser um valor positivo.");
    }
    
    public static EtiquetaException etiquetaDuplicada(int numero) {
        return new EtiquetaException("Erro: Já existe uma etiqueta com o número " + numero + ".");
    }
}
