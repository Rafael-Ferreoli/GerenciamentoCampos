package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.CadastroCSVDAO;
import model.DAO.CadastroSQLiteJPADAO;
import model.DAO.EtiquetaCSVDAO;
import model.DAO.EtiquetaSQLiteDAO;
import model.DAO.IDAO;
import model.DAO.ProdutoCSVDAO;
import model.DAO.ProdutoSQLiteDAO;
import model.Etiqueta;
import model.Funcionario;
import model.Produto;

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
                    // Habilita o modo WAL
                    connection.createStatement().execute("PRAGMA journal_mode=WAL;");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, "Erro ao abrir conexão", ex);
        }
    }

    public static Connection getConnection() {
        if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection(URL);
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("PRAGMA journal_mode=WAL;");
                    stmt.execute("PRAGMA busy_timeout = 5000;");
                }
                return conn;
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, "Erro ao abrir conexão", ex);
                return null;
            }
        } else {
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

    // Método fábrica para Produto
    public static IDAO<Produto> getProdutoDAO() {
        if (tipoPersistencia.equalsIgnoreCase("csv")) {
            return new ProdutoCSVDAO();
        } else if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            return new ProdutoSQLiteDAO();
        } else {
            throw new IllegalArgumentException("Tipo de persistência inválido: " + tipoPersistencia);
        }
    }

    // Método fábrica para Etiqueta
    public static IDAO<Etiqueta> getEtiquetaDAO() {
        if (tipoPersistencia.equalsIgnoreCase("csv")) {
            return new EtiquetaCSVDAO();
        } else if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            return new EtiquetaSQLiteDAO();
        } else {
            throw new IllegalArgumentException("Tipo de persistência inválido: " + tipoPersistencia);
        }
    }

    // Método fábrica para Cadastro (agora utilizando Funcionario)
    public static IDAO<Funcionario> getFuncionarioDAO() {
        if (tipoPersistencia.equalsIgnoreCase("csv")) {
            return new CadastroCSVDAO();
        } else if (tipoPersistencia.equalsIgnoreCase("sqlite")) {
            return new CadastroSQLiteJPADAO();
        } else {
            throw new IllegalArgumentException("Tipo de persistência inválido: " + tipoPersistencia);
        }
    }
}
