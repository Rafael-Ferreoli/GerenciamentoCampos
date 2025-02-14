package controller;

import factory.Persistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DAO.IDAO;
import model.Produto;
import model.exception.ProdutoException;
import model.validation.ProdutoValidacao;

public class GerenciadorProdutos extends AbstractTableModel {

    private List<Produto> produtos;
    private IDAO<Produto> produtoDAO;

    private final int COL_NOME = 0;
    private final int COL_CODINT = 1;
    private final int COL_CODBARRA = 2;
    private final int COL_PRECO = 3;
    private final int COL_QTD = 4;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
        this.produtoDAO = Persistencia.getProdutoDAO();
        carregarProdutos();
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw ProdutoException.camposInvalidos("Produto");
        }
        ProdutoValidacao.validarCamposObrigatorios(produto, this.produtos, null); // código atual é null na adição
        this.produtoDAO.save(produto);
        this.produtos = this.produtoDAO.findAll();
        fireTableDataChanged();
    }

    public boolean removerProduto(String codigoInterno) {
        ProdutoValidacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        Produto produto = buscarProduto(codigoInterno);

        if (produto != null) {
            this.produtoDAO.delete(codigoInterno);
            this.produtos = this.produtoDAO.findAll();
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    public Produto buscarProduto(String codigoInterno) {
        ProdutoValidacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        Produto produto = this.produtoDAO.findById(codigoInterno);
        if (produto == null) {
            throw ProdutoException.produtoNaoEncontrado(codigoInterno);
        }
        return produto;
    }

    public boolean atualizarProduto(String codigoInterno, Produto produtoNovo) {
        ProdutoValidacao.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");

        if (produtoNovo == null) {
            throw ProdutoException.camposInvalidos("Produto novo");
        }

        ProdutoValidacao.validarCodBarra(produtoNovo.getCodigoBarra());
        Produto produtoExistente = buscarProduto(codigoInterno);
        if (produtoExistente == null) {
            throw ProdutoException.produtoNaoEncontrado(codigoInterno);
        }

        // lista temporaria pra ignorar o produto que esta sendo editado
        List<Produto> listaSemAtual = new ArrayList<>(this.produtos);
        listaSemAtual.remove(produtoExistente);

        ProdutoValidacao.validarCamposObrigatorios(produtoNovo, listaSemAtual, produtoExistente.getCodigoInterno());

        // Atualiza o produto
        this.produtoDAO.update(codigoInterno, produtoNovo);
        this.produtos = this.produtoDAO.findAll();  
        fireTableDataChanged(); 
        return true;
    }

    public List<Produto> listarProdutos() {
        return this.produtoDAO.findAll();
    }

    public void carregarProdutos() {
        this.produtos = this.produtoDAO.findAll();
        fireTableDataChanged();
    }

    // Métodos do AbstractTableModel
    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Produto produto = this.produtos.get(row);
        return switch (col) {
            case COL_NOME ->
                produto.getNome();
            case COL_CODINT ->
                produto.getCodigoInterno();
            case COL_CODBARRA ->
                produto.getCodigoBarra();
            case COL_PRECO ->
                produto.getPreco();
            case COL_QTD ->
                produto.getQuantidade();
            default ->
                "-";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_NOME ->
                "Nome";
            case COL_CODINT ->
                "Cod Interno";
            case COL_CODBARRA ->
                "Cod Barra";
            case COL_PRECO ->
                "Preço";
            case COL_QTD ->
                "Quantidade";
            default ->
                "";
        };
    }

    public Produto getProdutoAt(int row) {
        return this.produtos.get(row);
    }
}
