package model.validation;

import model.exception.ProdutoException;

public class ValidacaoProduto {

    public static void validarPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
    }

    public static void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
    }

    public static void validarStringNaoVazia(String valor, String mensagemErro) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensagemErro);
        }
    }

    public static void validarNumeroPositivo(double valor, String mensagemErro) {
        if (valor < 0) {
            throw new IllegalArgumentException(mensagemErro);
        }
    }

    public static void validarNumeroNaoNegativo(int valor, String mensagemErro) {
        if (valor < 0) {
            throw new IllegalArgumentException(mensagemErro);
        }
    }

    public static void validarCodBarra(String codBarra) {
        // Verifica se o código de barras está vazio ou com espaços
        if (codBarra.isEmpty() || codBarra.length() != 13 || !codBarra.matches("\\d{13}")) {
            throw new IllegalArgumentException("Código de barras deve conter exatamente 13 dígitos.");
        }
    }

    // Nova validação para CPF
    public static void validarCPF(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve ter 11 dígitos numéricos.");
        }
    }

    // Nova validação para E-mail
    public static void validarEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("O e-mail não é válido.");
        }
    }

    // Nova validação para Matrícula
    public static void validarMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("A matrícula não pode ser vazia.");
        }
    }

    public static void validarCodigoInterno(String codigoInterno) {
        if (codigoInterno == null || codigoInterno.trim().isEmpty()) {
            throw new IllegalArgumentException("Código interno não pode ser vazio");
        }
    }
}
