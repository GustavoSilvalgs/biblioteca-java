import biblioteca.model.Autor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorController{
    public List<Autor> listAutores() {
        List<Autor> autores = new ArrayList<>();
        String query = "SELECT * FROM autor";

        ConnectionFactory connection = new ConnectionFactory();
        
        try (Connection conn = connection.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");

                Autor autor = new Autor(id, nome, sobrenome);
                autores.add(autor);
            }
        } catch (SQLException e) {
        }finally{
            connection.closeConnection();
        }
        return autores;
    }
    // Detalha os dados de um Autor
    public Autor getAutorById(int id) {
        String query = "SELECT * FROM autor WHERE id = ?";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");

                return new Autor(id, nome, sobrenome);
            }
        } catch (SQLException e) {
        }finally{
            connection.closeConnection();
        }
        return null;
    }
    // Adiciona Autor
    public void addAutor(Autor autor) {
        String query = "INSERT INTO autor (id, nome, sobrenome) VALUES (?, ?,?)";
        ConnectionFactory connection = new ConnectionFactory();
        try (Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, autor.getId());
            statement.setString(2, autor.getNome());
            statement.setString(3, autor.getSobrenome());
            statement.executeUpdate();

            System.out.println("Autor cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }finally{
            connection.closeConnection();
        }
    }
    // Atualiza dados de um Autor
    public void updateAutor(Autor autor) {
        String query = "UPDATE autor SET nome = ?, sobrenome = ? WHERE id = ?";
        ConnectionFactory connection = new ConnectionFactory();
        
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getSobrenome());
            statement.setInt(3, autor.getId());
            statement.executeUpdate();

            System.out.println("Autor atualizado com sucesso.");
        } catch (SQLException e) {
        }finally{
            connection.closeConnection();
        }
    }
    // Remove Autor (desde que ele não seja utilizado como referência em um Livro
    public void deleteAutor(int id) {
        String query = "DELETE FROM autor WHERE id = ?";
        ConnectionFactory connection = new ConnectionFactory();
        
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Autor excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Autor não pode ser excluído: "+e);
        }finally{
            connection.closeConnection();
        }
    }
}
