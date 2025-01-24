package controller;

import model.Produto;
import model.DAO.CSV.SerializadorCSVProdutos;
import model.DAO.CSV.FilePersistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.validation.ValidacaoProduto;

public class GerenciadorProdutosANTIGO {

    private List<Produto> produtos;

    public GerenciadorProdutosANTIGO() {
        this.produtos = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto.toString()).append("\n"); // Adiciona cada produto ao StringBuilder
        }
        return sb.toString();
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        ValidacaoProduto.validarStringNaoVazia(produto.getNome(), "Nome do produto não pode ser vazio.");
        ValidacaoProduto.validarStringNaoVazia(produto.getCodigoInterno(), "Código interno do produto não pode ser vazio.");
        ValidacaoProduto.validarNumeroPositivo(produto.getPreco(), "Preço do produto deve ser maior ou igual a zero.");
        ValidacaoProduto.validarNumeroNaoNegativo(produto.getQuantidade(), "Quantidade do produto não pode ser negativa.");
        this.produtos.add(produto);
    }

    public boolean removerProduto(String codigoInterno) {
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        Produto produto = buscarProduto(codigoInterno);
        if (produto != null) {
            this.produtos.remove(produto);
            return true;
        }
        return false;
    }

    public Produto buscarProduto(String codigoInterno) {
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        return this.produtos.stream()
                .filter(produto -> produto.getCodigoInterno().equals(codigoInterno))
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarProduto(String codigoInterno, Produto produtoNovo) {
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        if (produtoNovo == null) {
            throw new IllegalArgumentException("Produto novo não pode ser nulo.");
        }
        Produto produtoExistente = buscarProduto(codigoInterno);
        if (produtoExistente != null) {
            int indice = produtos.indexOf(produtoExistente);
            this.produtos.set(indice, produtoNovo);
            return true;
        }
        return false;
    }

    public void salvarNoArquivo(String pathFile) throws IOException {
        ValidacaoProduto.validarStringNaoVazia(pathFile, "Caminho do arquivo não pode ser vazio.");
        SerializadorCSVProdutos serializador = new SerializadorCSVProdutos();
        FilePersistence filePersistence = new FilePersistence();

        String csvData = serializador.toCSV(this.produtos);
        filePersistence.saveToFile(csvData, pathFile);
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        ValidacaoProduto.validarStringNaoVazia(pathFile, "Caminho do arquivo não pode ser vazio.");
        FilePersistence filePersistence = new FilePersistence();
        SerializadorCSVProdutos serializador = new SerializadorCSVProdutos();

        String csvData = filePersistence.loadFromFile(pathFile);
        this.produtos = serializador.fromCSV(csvData);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(this.produtos);
    }
}
