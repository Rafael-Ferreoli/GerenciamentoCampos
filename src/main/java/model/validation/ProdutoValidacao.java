package model.validation;

import model.Produto;
import model.exception.ProdutoException;
import java.util.List;

public class ProdutoValidacao {

    public static void validarStringNaoVazia(String valor, String mensagemErro) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ProdutoException(mensagemErro);
        }
    }

    public static void validarNumeroPositivo(double valor, String mensagemErro) {
        if (valor <= 0) {
            throw new ProdutoException(mensagemErro);
        }
    }

    public static void validarNumeroNaoNegativo(int valor, String mensagemErro) {
        if (valor < 0) {
            throw new ProdutoException(mensagemErro);
        }
    }

    public static void validarCodBarra(String codigoBarra) {
        if (codigoBarra == null || !codigoBarra.matches("\\d{13}")) {
            throw ProdutoException.codigoBarrasInvalido();
        }
    }

    public static void validarNumeroInteiro(String valor, String mensagemErro) {
        if (valor == null || !valor.matches("\\d+")) {
            throw ProdutoException.formatoInvalido(mensagemErro);
        }
    }

    public static void validarPreco(String precoStr) {
        if (precoStr == null || !precoStr.matches("\\d+(\\.\\d{1,2})?")) {
            throw ProdutoException.formatoInvalido("Preço");
        }

        double preco = Double.parseDouble(precoStr);
        if (preco <= 0) {
            throw ProdutoException.valorInvalido("Preço");
        }
    }

    public static void validarUnicidade(String codigoInterno, String codigoBarra, List<Produto> produtos, String codigoAtual) {
        for (Produto p : produtos) {
            if (p.getCodigoInterno().equals(codigoAtual)) {
                continue;
            }
            if (p.getCodigoInterno().equals(codigoInterno) || p.getCodigoBarra().equals(codigoBarra)) {
                throw ProdutoException.produtoDuplicado(codigoInterno);
            }
        }
    }

    public static void validarCamposObrigatorios(Produto produto, List<Produto> produtos, String codigoAtual) {
        validarStringNaoVazia(produto.getNome(), "Nome do produto não pode ser vazio.");
        validarStringNaoVazia(produto.getCodigoInterno(), "Código interno do produto não pode ser vazio.");
        validarCodBarra(produto.getCodigoBarra());
        validarNumeroInteiro(produto.getCodigoInterno(), "Código Interno");
        validarPreco(String.valueOf(produto.getPreco()));
        validarNumeroInteiro(String.valueOf(produto.getQuantidade()), "Quantidade");
        validarNumeroNaoNegativo(produto.getQuantidade(), "Quantidade do produto não pode ser negativa.");
        validarUnicidade(produto.getCodigoInterno(), produto.getCodigoBarra(), produtos, codigoAtual);
    }

}
