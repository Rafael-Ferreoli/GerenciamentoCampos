package controller;

import model.Produto;
import model.SerializadorCSVProdutos;
import model.FilePersistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.validation.Validacao;

public class GerenciadorProdutos extends AbstractTableModel {

    private List<Produto> produtos;

    private final int COL_NOME = 0;
    private final int COL_CODINT = 1;
    private final int COL_CODBARRA = 2;
    private final int COL_PRECO = 3;
    private final int COL_QTD = 4;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
    }

    // Métodos de gerenciamento
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        Validacao.validarStringNaoVazia(produto.getNome(), "Nome do produto não pode ser vazio.");
        Validacao.validarStringNaoVazia(produto.getCodigoInterno(), "Código interno do produto não pode ser vazio.");
        Validacao.validarNumeroPositivo(produto.getPreco(), "Preço do produto deve ser maior ou igual a zero.");
        Validacao.validarNumeroNaoNegativo(produto.getQuantidade(), "Quantidade do produto não pode ser negativa.");
        this.produtos.add(produto);
        fireTableDataChanged(); // Atualiza a tabela
    }

    public boolean removerProduto(String codigoInterno) {
    Validacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
    Produto produto = buscarProduto(codigoInterno);
    if (produto != null) {
        this.produtos.remove(produto);
        fireTableDataChanged(); // Atualiza a tabela
        try {
            salvarNoArquivo("ListagemProdutos.csv"); // Salva automaticamente
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao salvar arquivo: " + ex.getMessage(), ex);
        }
        return true;
    }
    return false;
}


    public Produto buscarProduto(String codigoInterno) {
        Validacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        return this.produtos.stream()
                .filter(produto -> produto.getCodigoInterno().equals(codigoInterno))
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarProduto(String codigoInterno, Produto produtoNovo) {
        Validacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        if (produtoNovo == null) {
            throw new IllegalArgumentException("Produto novo não pode ser nulo.");
        }
        Produto produtoExistente = buscarProduto(codigoInterno);
        if (produtoExistente != null) {
            int indice = produtos.indexOf(produtoExistente);
            this.produtos.set(indice, produtoNovo);
            fireTableDataChanged(); // Atualiza a tabela
            return true;
        }
        return false;
    }

    public void salvarNoArquivo(String pathFile) throws IOException {
        Validacao.validarStringNaoVazia(pathFile, "Caminho do arquivo não pode ser vazio.");
        SerializadorCSVProdutos serializador = new SerializadorCSVProdutos();
        FilePersistence filePersistence = new FilePersistence();

        String csvData = serializador.toCSV(this.produtos);
        filePersistence.saveToFile(csvData, pathFile);
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        Validacao.validarStringNaoVazia(pathFile, "Caminho do arquivo não pode ser vazio.");
        FilePersistence filePersistence = new FilePersistence();
        SerializadorCSVProdutos serializador = new SerializadorCSVProdutos();

        String csvData = filePersistence.loadFromFile(pathFile);
        this.produtos = serializador.fromCSV(csvData);
        fireTableDataChanged(); // Atualiza a tabela
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(this.produtos);
    }

    // Métodos de AbstractTableModel
    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // Nome, Código Interno, Código Barra, Preço, Quantidade
    }

    @Override
    public Object getValueAt(int row, int col) {
        Produto produto = this.produtos.get(row);
        switch (col) {
            case COL_NOME:
                return produto.getNome();
            case COL_CODINT:
                return produto.getCodigoInterno();
            case COL_CODBARRA:
                return produto.getCodigoBarra();
            case COL_PRECO:
                return produto.getPreco();
            case COL_QTD:
                return produto.getQuantidade();
            default:
                return "-";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_CODINT:
                return "Cod Interno";
            case COL_CODBARRA:
                return "Cod Barra";
            case COL_PRECO:
                return "Preço";
            case COL_QTD:
                return "Quantidade";
            default:
                return "";
        }
    }

    public Produto getProdutoAt(int row) {
        return this.produtos.get(row);
    }
}
