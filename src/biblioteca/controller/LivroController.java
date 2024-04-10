package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;
import biblioteca.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroController {

    private static final Logger LOGGER = Logger.getLogger(LivroController.class.getName());
    private final ConnectionFactory connectionFactory;
    private final ReservaController reservaController;

    public LivroController() {
        this.connectionFactory = new ConnectionFactory();
        this.reservaController = new ReservaController();
    }

    public void cadastrarLivro(Livro livro) {
        String query = "INSERT INTO livro (titulo, data_publicacao, autor_id, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, livro.getDataPublicacao());
            statement.setInt(3, livro.getAutorId());
            statement.setString(4, "disponível"); 
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                livro.setId(generatedKeys.getInt(1));
            }

            System.out.println("Livro cadastrado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao cadastrar livro", e);
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String query = "SELECT * FROM livro";
        try (Connection conn = connectionFactory.getConnection(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                Date dataPublicacao = resultSet.getDate("data_publicacao");
                int autorId = resultSet.getInt("autor_id");
                String statusLivro = resultSet.getString("status");

                Livro livro = new Livro(id, titulo, dataPublicacao, autorId);
                livro.setStatus(statusLivro);
                livros.add(livro);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar livros", e);
        }

        return livros;
    }

    public void atualizarLivro(Livro livro) {
        String query = "UPDATE livro SET titulo = ?, data_publicacao = ?, autor_id = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, livro.getDataPublicacao());
            statement.setInt(3, livro.getAutorId());
            statement.setInt(4, livro.getId());
            statement.executeUpdate();

            System.out.println("Livro atualizado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar livro", e);
        }
    }

    public void excluirLivro(int id) {
        String query = "DELETE FROM livro WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Livro excluído com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir livro", e);
        }
    }

    public boolean verificarDisponibilidadeLivro(int livroId) {
        String query = "SELECT status FROM livro WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String statusLivro = resultSet.getString("status");
                return "disponível".equalsIgnoreCase(statusLivro);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar disponibilidade do livro", e);
        }

        return false;
    }

    public void atualizarStatusLivro(int livroId, String novoStatus) {
        String query = "UPDATE livro SET status = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, novoStatus);
            statement.setInt(2, livroId);
            statement.executeUpdate();

            System.out.println("Status do livro atualizado com sucesso para: " + novoStatus);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar status do livro", e);
        }
    }

    public boolean verificarLivroReservado(int livroId) {
        return reservaController.verificarLivroReservado(livroId);
    }

    public boolean verificarEmprestimoParaUsuarioAtual(int livroId, int usuarioId) {
        String query = "SELECT COUNT(*) AS quantidade FROM emprestimo_livro WHERE livro_id = ? AND usuario_id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            statement.setInt(2, usuarioId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int quantidade = resultSet.getInt("quantidade");
                return quantidade > 0; 
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar empréstimo do livro para o usuário atual", e);
        }
        return false; 
    }
}
