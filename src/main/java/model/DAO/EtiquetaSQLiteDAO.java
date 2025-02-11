package model.DAO;

import factory.Persistencia;
import model.Etiqueta;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaSQLiteDAO implements IDAO<Etiqueta> {

    @Override
    public void save(Etiqueta etiqueta) {
        String sql = """
                INSERT INTO etiqueta (codigo_interno, data, num_etiqueta)
                VALUES (?, ?, ?);
                """;

        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etiqueta.getCodigoInterno());
            // Supondo que etiqueta.getData() retorne um LocalDate formatado em ISO (yyyy-MM-dd)
            pstmt.setString(2, etiqueta.getData().toString());
            pstmt.setInt(3, etiqueta.getNumEtiqueta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar etiqueta: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(String id, Etiqueta etiquetaAtualizada) {
        String sql = """
                UPDATE etiqueta
                SET codigo_interno = ?, data = ?
                WHERE num_etiqueta = ?;
                """;

        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, etiquetaAtualizada.getCodigoInterno());
            pstmt.setString(2, etiquetaAtualizada.getData().toString());
            pstmt.setInt(3, Integer.parseInt(id));
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Etiqueta com número " + id + " não encontrada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar etiqueta: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM etiqueta WHERE num_etiqueta = ?;";
        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new RuntimeException("Etiqueta com número " + id + " não encontrada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar etiqueta: " + e.getMessage(), e);
        }
    }

    @Override
    public Etiqueta findById(String id) {
        String sql = "SELECT * FROM etiqueta WHERE num_etiqueta = ?;";
        try (Connection conn = Persistencia.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return criarEtiquetaDeResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar etiqueta: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Etiqueta> findAll() {
        List<Etiqueta> etiquetas = new ArrayList<>();
        String sql = "SELECT * FROM etiqueta;";
        try (Connection conn = Persistencia.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                etiquetas.add(criarEtiquetaDeResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar etiquetas: " + e.getMessage(), e);
        }
        return etiquetas;
    }

    private Etiqueta criarEtiquetaDeResultSet(ResultSet rs) throws SQLException {
        String codigoInterno = rs.getString("codigo_interno");
        String dataStr = rs.getString("data");
        int numEtiqueta = rs.getInt("num_etiqueta");
        LocalDate data = LocalDate.parse(dataStr);
        return new Etiqueta(codigoInterno, data, numEtiqueta);
    }
}
