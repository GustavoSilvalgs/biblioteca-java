package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;
import biblioteca.model.ReservaLivro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaController {

    private static final Logger LOGGER = Logger.getLogger(ReservaController.class.getName());
    private final ConnectionFactory connectionFactory;

    public ReservaController() {
        this.connectionFactory = new ConnectionFactory();
    }

    public List<ReservaLivro> listarReservas() {
        List<ReservaLivro> reservas = new ArrayList<>();
        String query = "SELECT * FROM reserva_livro";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int livroId = resultSet.getInt("livro_id");
                int usuarioId = resultSet.getInt("usuario_id");
                Date dataReserva = resultSet.getDate("data_reserva");
                Date dataDevolucao = resultSet.getDate("data_devolucao");

                ReservaLivro reserva = new ReservaLivro(id, livroId, usuarioId, dataReserva, dataDevolucao);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar reservas", e);
        }

        return reservas;
    }

    public void fazerReserva(int livroId, int usuarioId) {
        String query = "INSERT INTO reserva_livro (livro_id, usuario_id, data_reserva) VALUES (?, ?, NOW())";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            statement.setInt(2, usuarioId);
            statement.executeUpdate();

            System.out.println("Reserva realizada com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao fazer reserva", e);
        }
    }

    public void devolverLivro(int reservaId) {
        String query = "UPDATE reserva_livro SET data_devolucao = NOW() WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, reservaId);
            statement.executeUpdate();

            System.out.println("Livro devolvido com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao devolver livro", e);
        }
    }

    public boolean verificarLivroReservado(int livroId) {
        String query = "SELECT COUNT(*) AS quantidade FROM reserva_livro WHERE livro_id = ? AND data_devolucao IS NULL";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, livroId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int quantidade = resultSet.getInt("quantidade");
                    return quantidade > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar se o livro está reservado", e);
        }
        return false;
    }

    public void atualizarStatusLivro(int livroId, String novoStatus) {
        String query = "UPDATE livro SET status = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, novoStatus);
            statement.setInt(2, livroId);
            statement.executeUpdate();

            System.out.println("Status do livro atualizado para: " + novoStatus);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar status do livro", e);
        }
    }
}
