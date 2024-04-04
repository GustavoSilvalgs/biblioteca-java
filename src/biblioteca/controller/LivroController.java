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
        String query = "INSERT INTO Livro (titulo, data_publicacao, autor_id, quantidade_estoque, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, new java.sql.Date(livro.getDataPublicacao().getTime()));
            statement.setInt(3, livro.getAutorId());
            statement.setInt(4, livro.getQuantidadeEstoque());
            statement.setString(5, livro.getStatus());
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
        String query = "SELECT * FROM Livro";
        try (Connection conn = connectionFactory.getConnection(); Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                Date dataPublicacao = resultSet.getDate("data_publicacao");
                int autorId = resultSet.getInt("autor_id");
                int quantidadeEstoque = resultSet.getInt("quantidade_estoque");
                String status = resultSet.getString("status");

                Livro livro = new Livro(id, titulo, dataPublicacao, autorId, quantidadeEstoque, status);
                livros.add(livro);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar livros", e);
        }

        return livros;
    }

    public Livro consultarLivroPorId(int livroId) {
        String query = "SELECT * FROM Livro WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String titulo = resultSet.getString("titulo");
                    Date dataPublicacao = resultSet.getDate("data_publicacao");
                    int autorId = resultSet.getInt("autor_id");
                    int quantidadeEstoque = resultSet.getInt("quantidade_estoque");
                    String status = resultSet.getString("status");

                    return new Livro(id, titulo, dataPublicacao, autorId, quantidadeEstoque, status);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao consultar livro por ID", e);
        }
        return null;
    }

    public void atualizarLivro(Livro livro) {
        String query = "UPDATE Livro SET titulo = ?, data_publicacao = ?, autor_id = ?, quantidade_estoque = ?, status = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, new java.sql.Date(livro.getDataPublicacao().getTime()));
            statement.setInt(3, livro.getAutorId());
            statement.setInt(4, livro.getQuantidadeEstoque());
            statement.setString(5, livro.getStatus());
            statement.setInt(6, livro.getId());

            statement.executeUpdate();

            System.out.println("Livro atualizado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar livro", e);
        }
    }

    public void excluirLivro(int id) {
        String query = "DELETE FROM Livro WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Livro excluído com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir livro", e);
        }
    }

    public boolean verificarDisponibilidadeLivro(int livroId) {
        String query = "SELECT status FROM Livro WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String statusLivro = resultSet.getString("status");
                    return "disponivel".equalsIgnoreCase(statusLivro);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar disponibilidade do livro", e);
        }

        return false;
    }

    public void atualizarStatusLivro(int livroId, String novoStatus) {
        String query = "UPDATE Livro SET status = ? WHERE id = ?";
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
        String query = "SELECT COUNT(*) AS quantidade FROM Reserva_Livro WHERE livro_id = ? AND usuario_id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, livroId);
            statement.setInt(2, usuarioId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int quantidade = resultSet.getInt("quantidade");
                    return quantidade > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar empréstimo do livro para o usuário atual", e);
        }
        return false;
    }
}
