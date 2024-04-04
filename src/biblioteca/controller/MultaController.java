package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultaController {

    private static final Logger LOGGER = Logger.getLogger(MultaController.class.getName());
    private final ConnectionFactory connectionFactory;

    public MultaController() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void aplicarMulta(int usuarioId, double valorMulta) {
        String query = "INSERT INTO multa (usuario_id, valor) VALUES (?, ?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, usuarioId);
            statement.setDouble(2, valorMulta);
            statement.executeUpdate();

            System.out.println("Multa aplicada com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao aplicar multa", e);
        }
    }

    public double calcularTotalMultaPorUsuario(int usuarioId) {
        String query = "SELECT SUM(valor) AS total FROM multa WHERE usuario_id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, usuarioId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("total");
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao calcular total de multas por usuário", e);
        }
        return 0.0;
    }
}
