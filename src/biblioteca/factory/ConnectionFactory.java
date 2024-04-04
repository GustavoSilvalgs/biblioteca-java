package biblioteca.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234567";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer conexão com o banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}