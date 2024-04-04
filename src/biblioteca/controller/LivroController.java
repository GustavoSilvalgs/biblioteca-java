import biblioteca.model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroController {

    public void cadastrarLivro(Livro livro) {
        String query = "INSERT INTO livro (titulo, data_publicacao, autor_id) VALUES (?, ?, ?)";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, livro.getDataPublicacao());
            statement.setInt(3, livro.getAutorId());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                livro.setId(generatedKeys.getInt(1));
            }

            System.out.println("Livro cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String query = "SELECT * FROM livro";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                Date dataPublicacao = resultSet.getDate("data_publicacao");
                int autorId = resultSet.getInt("autor_id");

                Livro livro = new Livro(id, titulo, dataPublicacao, autorId);
                livros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return livros;
    }

    public void atualizarLivro(Livro livro) {
        String query = "UPDATE livros SET titulo = ?, data_publicacao = ?, autor_id = ? WHERE id = ?";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, livro.getTitulo());
            statement.setDate(2, livro.getDataPublicacao());
            statement.setInt(3, livro.getAutorId());
            statement.setInt(4, livro.getId());
            statement.executeUpdate();

            System.out.println("Livro atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirLivro(int id) {
        String query = "DELETE FROM livros WHERE id = ?";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Livro excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
