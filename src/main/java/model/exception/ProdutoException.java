package model.exception;

public class ProdutoException extends RuntimeException {

    // Construtor padrão com mensagem
    public ProdutoException(String message) {
        super(message);
    }

    // Construtor com mensagem e causa
    public ProdutoException(String message, Throwable cause) {
        super(message, cause);
    }

    // Métodos estáticos para mensagens específicas
    public static ProdutoException produtoDuplicado(String identificador) {
        return new ProdutoException("Produto com identificador '" + identificador + "' já existe no sistema.");
    }

    public static ProdutoException produtoNaoEncontrado(String codigoInterno) {
        return new ProdutoException("Produto com código interno '" + codigoInterno + "' não foi encontrado.");
    }

    public static ProdutoException camposInvalidos(String campo) {
        return new ProdutoException("O campo '" + campo + "' é inválido ou está vazio.");
    }
}
