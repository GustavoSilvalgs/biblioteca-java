package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;
import biblioteca.model.Multa;
import java.math.BigDecimal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultaController {

    private static final Logger LOGGER = Logger.getLogger(MultaController.class.getName());
    private final ConnectionFactory connectionFactory;

    public MultaController() {
        this.connectionFactory = new ConnectionFactory();
    }

    public List<Multa> listarMultas() {
        List<Multa> multas = new ArrayList<>();
        String query = "SELECT * FROM Multa";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int reservaId = resultSet.getInt("reserva_id");
                BigDecimal valor = resultSet.getBigDecimal("valor");
                Timestamp dataAplicacao = resultSet.getTimestamp("data_aplicacao");

                Multa multa = new Multa(id, reservaId, valor, dataAplicacao);
                multas.add(multa);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar multas", e);
        }

        return multas;
    }

    public void aplicarMulta(int usuarioId, double valorMulta) {
        String query = "INSERT INTO multa (usuario_id, valor) VALUES (?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

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
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

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

    public void deletarMulta(int multaId) {
        String query = "DELETE FROM multa WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, multaId);
            statement.executeUpdate();

            System.out.println("Multa deletada com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar multa", e);
        }
    }

    public void pagarMulta(int multaId) {
        deletarMulta(multaId);
    }
}
