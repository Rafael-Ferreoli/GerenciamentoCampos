package model.exception;

public class ProdutoException extends RuntimeException {

    public ProdutoException(String mensagem) {
        super(mensagem);
    }

    public static ProdutoException camposInvalidos(String campo) {
        return new ProdutoException("Erro: " + campo + " não pode ser vazio.");
    }

    public static ProdutoException produtoDuplicado(String codigo) {
        return new ProdutoException("Erro: Já existe um produto com o código interno ou código de barras informado: " + codigo);
    }

    public static ProdutoException produtoNaoEncontrado(String codigo) {
        return new ProdutoException("Erro: Produto com código interno " + codigo + " não encontrado.");
    }

    public static ProdutoException valorInvalido(String campo) {
        return new ProdutoException("Erro: " + campo + " deve ser um valor positivo.");
    }

    public static ProdutoException codigoBarrasInvalido() {
        return new ProdutoException("Erro: Código de barras deve ter exatamente 13 dígitos numéricos.");
    }

    public static ProdutoException formatoInvalido(String campo) {
        return new ProdutoException("Erro: " + campo + " contém caracteres inválidos. Apenas números são permitidos.");
    }
}
