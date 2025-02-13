package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.EtiquetaCSVDAO;
import model.DAO.IDAO;
import model.DAO.EtiquetaSQLiteDAO;
import model.Etiqueta;

public class Persistencia {

    private static Connection connection = null;
    private static final String URL = "jdbc:sqlite:dbCampos.sqlite";
    
    // sqlite ou csv
    private static String tipoPersistencia = "csv"; 

    public static void setTipoPersistencia(String tipo) {
        tipoPersistencia = tipo;
    }
    
    public static String getTipoPersistencia() {
        return tipoPersistencia;
    }

    private static void abrirConexao() {
        try {
            if (connection == null || connection.isClosed()) {
                if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
                    Class.forName("org.sqlite.JDBC");
                    connection = DriverManager.getConnection(URL);
                }
                // Se for CSV, não é necessário abrir conexão
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, "Erro ao abrir conexão", ex);
        }
    }

    public static Connection getConnection() {
        if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            abrirConexao();
            return connection;
        } else {
            // Para CSV, a conexão não é utilizada
            return null;
        }
    }

    public static void closeConnection() {
        if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão", ex);
            }
        }
    }
    
    // Método para obter a implementação de IDAO<Etiqueta> conforme o tipo de persistência
    public static IDAO<Etiqueta> getEtiquetaDAO() {
        if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            return new EtiquetaSQLiteDAO(); // Sua implementação para SQLite pode utilizar Persistencia.getConnection() internamente
        } else if (tipoPersistencia.equalsIgnoreCase("csv")) {
            // Supondo que o construtor do EtiquetaCSVDAO receba o caminho do arquivo
            return new EtiquetaCSVDAO("ListagemEtiquetas.csv");
        } else {
            throw new IllegalArgumentException("Tipo de persistência não suportado: " + tipoPersistencia);
        }
    }
}
