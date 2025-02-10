package model.DAO;

import factory.Persistencia;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoSQLiteDAO implements ProdutoPersistence {

    @Override
    public void save(Produto produto) {
        String sql = """
                INSERT INTO produtos (nome, codigo_interno, codigo_barra, preco, quantidade)
                VALUES (?, ?, ?, ?, ?);
                """;

        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getCodigoInterno());
            pstmt.setString(3, produto.getCodigoBarra());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setInt(5, produto.getQuantidade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(String codigoInterno, Produto produtoAtualizado) {
        String sql = """
                UPDATE produtos
                SET nome = ?, codigo_barra = ?, preco = ?, quantidade = ?
                WHERE codigo_interno = ?;
                """;

        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produtoAtualizado.getNome());
            pstmt.setString(2, produtoAtualizado.getCodigoBarra());
            pstmt.setDouble(3, produtoAtualizado.getPreco());
            pstmt.setInt(4, produtoAtualizado.getQuantidade());
            pstmt.setString(5, codigoInterno);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Produto com código interno não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(String codigoInterno) {
        String sql = "DELETE FROM produtos WHERE codigo_interno = ?;";
        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigoInterno);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Produto com código interno não encontrado.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }

    @Override
    public Produto findByCodInterno(String codigoInterno) {
        String sql = "SELECT * FROM produtos WHERE codigo_interno = ?;";
        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigoInterno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return criarProdutoDeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos;";
        try (Connection conn = Persistencia.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produtos.add(criarProdutoDeResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage(), e);
        }
        return produtos;
    }

    // Método auxiliar para criar um Produto a partir de um ResultSet
    private Produto criarProdutoDeResultSet(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setNome(rs.getString("nome"));
        produto.setCodigoInterno(rs.getString("codigo_interno"));
        produto.setCodigoBarra(rs.getString("codigo_barra"));
        produto.setPreco(rs.getDouble("preco"));
        produto.setQuantidade(rs.getInt("quantidade"));
        return produto;
    }
}
