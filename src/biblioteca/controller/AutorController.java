package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;
import biblioteca.model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorController {
    private static final Logger LOGGER = Logger.getLogger(AutorController.class.getName());
    private final ConnectionFactory connectionFactory;

    public AutorController() {
        this.connectionFactory = new ConnectionFactory();
    }

    public List<Autor> listAutores() {
        List<Autor> autores = new ArrayList<>();
        String query = "SELECT * FROM autor";

        try (Connection conn = connectionFactory.getConnection();
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
            LOGGER.log(Level.SEVERE, "Erro ao listar autores", e);
        }

        return autores;
    }

    public Autor getAutorById(int id) {
        String query = "SELECT * FROM autor WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");

                return new Autor(id, nome, sobrenome);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao obter autor por ID", e);
        }

        return null;
    }

    public void addAutor(Autor autor) {
        String query = "INSERT INTO autor (nome, sobrenome) VALUES (?, ?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getSobrenome());
            statement.executeUpdate();

            System.out.println("Autor cadastrado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao adicionar autor", e);
        }
    }

    public void updateAutor(Autor autor) {
        String query = "UPDATE autor SET nome = ?, sobrenome = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getSobrenome());
            statement.setInt(3, autor.getId());
            statement.executeUpdate();

            System.out.println("Autor atualizado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar autor", e);
        }
    }

    public void deleteAutor(int id) {
        String query = "DELETE FROM autor WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Autor excluído com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir autor", e);
        }
    }
}
