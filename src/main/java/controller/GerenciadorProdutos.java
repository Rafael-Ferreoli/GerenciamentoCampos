package controller;

import model.Produto;
import model.validation.ValidacaoProduto;

import javax.swing.table.AbstractTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.ProdutoCSVDAO;
import model.DAO.ProdutoPersistence;
import model.DAO.ProdutoSQLiteDAO;
import model.exception.ProdutoException;

public class GerenciadorProdutos extends AbstractTableModel {

    private List<Produto> produtos;
    private ProdutoPersistence produtoPersistence;

    private final int COL_NOME = 0;
    private final int COL_CODINT = 1;
    private final int COL_CODBARRA = 2;
    private final int COL_PRECO = 3;
    private final int COL_QTD = 4;

    // Construtor que recebe o tipo de persistência
    public GerenciadorProdutos(String tipoPersistencia) {
        this.produtos = new ArrayList<>();
        if ("csv".equals(tipoPersistencia)) {
            this.produtoPersistence = new ProdutoCSVDAO();
        } else if ("sqlite".equals(tipoPersistencia)) {
            this.produtoPersistence = new ProdutoSQLiteDAO();
        } else {
            throw new IllegalArgumentException("Tipo de persistência inválido.");
        }
    }

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw ProdutoException.camposInvalidos("Produto");
        }

        // Validações de campos obrigatórios
        ValidacaoProduto.validarStringNaoVazia(produto.getNome(), "Nome do produto não pode ser vazio.");
        ValidacaoProduto.validarStringNaoVazia(produto.getCodigoInterno(), "Código interno do produto não pode ser vazio.");
        ValidacaoProduto.validarCodBarra(produto.getCodigoBarra());
        ValidacaoProduto.validarNumeroPositivo(produto.getPreco(), "Preço do produto deve ser maior ou igual a zero.");
        ValidacaoProduto.validarNumeroNaoNegativo(produto.getQuantidade(), "Quantidade do produto não pode ser negativa.");

        // Verificar duplicidade
        if (isProdutoDuplicado(produto, null)) { // Passa null porque é um novo produto
            throw ProdutoException.produtoDuplicado(produto.getCodigoInterno());
        }

        // Salva o produto
        this.produtoPersistence.save(produto);

        // Recarrega a lista de produtos e atualiza a tabela
        this.produtos = this.produtoPersistence.findAll();
        fireTableDataChanged();
    }

    public boolean isProdutoDuplicado(Produto produto, String codigoAtual) {
        for (Produto p : this.produtoPersistence.findAll()) {
            // Ignorar o produto atual ao editar
            if (codigoAtual != null && p.getCodigoInterno().equals(codigoAtual)) {
                continue;
            }
            if (p.getCodigoInterno().equals(produto.getCodigoInterno())
                    || p.getCodigoBarra().equals(produto.getCodigoBarra())) {
                return true;
            }
        }
        return false;
    }

    public boolean removerProduto(String codigoInterno) {
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        Produto produto = buscarProduto(codigoInterno);
        if (produto == null) {
            throw ProdutoException.produtoNaoEncontrado(codigoInterno);
        }
        this.produtoPersistence.delete(codigoInterno);
        this.produtos = this.produtoPersistence.findAll();  // Recarrega a lista
        fireTableDataChanged(); // Atualiza a tabela
        return true;
    }

    public Produto buscarProduto(String codigoInterno) {
        ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
        Produto produto = this.produtoPersistence.findByCodInterno(codigoInterno);
        if (produto == null) {
            throw ProdutoException.produtoNaoEncontrado(codigoInterno);
        }
        return produto;
    }

    public boolean atualizarProduto(String codigoInterno, Produto produtoNovo) {
    ValidacaoProduto.validarStringNaoVazia(codigoInterno, "Código interno não pode ser vazio.");
    
    if (produtoNovo == null) {
        throw ProdutoException.camposInvalidos("Produto novo");
    }

    ValidacaoProduto.validarCodBarra(produtoNovo.getCodigoBarra());

    Produto produtoExistente = buscarProduto(codigoInterno);
    if (produtoExistente == null) {
        throw ProdutoException.produtoNaoEncontrado(codigoInterno);
    }

    // Atualiza o produto
    this.produtoPersistence.update(codigoInterno, produtoNovo);
    this.produtos = this.produtoPersistence.findAll();  // Recarrega a lista
    fireTableDataChanged(); // Atualiza a tabela
    return true;
}


    public List<Produto> listarProdutos() {
        return this.produtoPersistence.findAll();
    }

    public void carregarProdutos() throws FileNotFoundException {
    this.produtos = this.produtoPersistence.findAll();
    fireTableDataChanged();
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
