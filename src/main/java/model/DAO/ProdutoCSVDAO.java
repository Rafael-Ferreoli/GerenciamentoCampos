package model.DAO;

import java.io.FileNotFoundException;
import model.Produto;
import model.DAO.CSV.SerializadorCSVProdutos;
import model.DAO.CSV.FilePersistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCSVDAO implements IDAO<Produto> {

    private final String pathFile = "ListagemProdutos.csv";
    private final SerializadorCSVProdutos serializador;
    private final FilePersistence filePersistence;

    public ProdutoCSVDAO() {
        this.serializador = new SerializadorCSVProdutos();
        this.filePersistence = new FilePersistence();
    }

    @Override
    public void save(Produto produto) {
        List<Produto> produtos = findAll();
        produtos.add(produto);
        salvarLista(produtos);
    }

    @Override
    public void update(String codigoInterno, Produto produtoNovo) {
        List<Produto> produtos = findAll();
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigoInterno().equals(codigoInterno)) {
                produtos.set(i, produtoNovo);
                salvarLista(produtos);
                return;
            }
        }
    }

    @Override
    public void delete(String codigoInterno) {
        List<Produto> produtos = findAll();
        produtos.removeIf(produto -> produto.getCodigoInterno().equals(codigoInterno));
        salvarLista(produtos);
    }

    @Override
    public Produto findById(String codigoInterno) {
        return findAll().stream()
                .filter(produto -> produto.getCodigoInterno().equals(codigoInterno))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produto> findAll() {
        try {
            String csvData = filePersistence.loadFromFile(pathFile);
            return serializador.fromCSV(csvData);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void carregarDoArquivo(String pathFile) throws FileNotFoundException {
        try {
            String csvData = filePersistence.loadFromFile(pathFile);
            List<Produto> produtos = serializador.fromCSV(csvData);
        } catch (IOException e) {
            throw new FileNotFoundException("Erro ao carregar arquivo: " + pathFile);
        }
    }

    public void salvarLista(List<Produto> produtos) {
        try {
            String csvData = serializador.toCSV(produtos);
            filePersistence.saveToFile(csvData, pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar no arquivo CSV: " + e.getMessage(), e);
        }
    }
}
