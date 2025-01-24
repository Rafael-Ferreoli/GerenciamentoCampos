package model.DAO;

import model.Produto;
import java.util.List;

public interface ProdutoPersistence {

    // Salva um produto
    void save(Produto produto);

    // Atualiza um produto existente
    void update(String codigoInterno, Produto produto);

    // Remove um produto pelo código interno
    void delete(String codigoInterno);

    // Encontra um produto pelo código interno
    Produto findByCodInterno(String codigoInterno);

    // Retorna todos os produtos
    List<Produto> findAll();
}
