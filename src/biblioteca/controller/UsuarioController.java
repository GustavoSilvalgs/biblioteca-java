package biblioteca.controller;

import biblioteca.factory.ConnectionFactory;
import biblioteca.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioController {

    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class.getName());
    private final ConnectionFactory connectionFactory;

    public UsuarioController() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void cadastrarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (nome, senha, tipo) VALUES (?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getTipo());
            statement.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao cadastrar usuário", e);
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String tipo = resultSet.getString("tipo");

                Usuario usuario = new Usuario(id, nome, senha, tipo);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar usuários", e);
        }

        return usuarios;
    }

    public void atualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuario SET nome = ?, senha = ?, tipo = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getTipo());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();

            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar usuário", e);
        }
    }

    public void excluirUsuario(int id) {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir usuário", e);
        }
    }

    public boolean login(String usuario, String senha) {
        String query = "SELECT COUNT(*) AS count FROM usuarios WHERE usuario = ? AND senha = ?";

        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean senhaCorreta(String usuario, String senha) {
        String query = "SELECT COUNT(*) AS count FROM usuarios WHERE usuario = ? AND senha = ?";

        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean usuarioExiste(String usuario) {
        String query = "SELECT COUNT(*) AS count FROM usuario WHERE nome = ?";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, usuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao verificar se o usuário existe", e);
        }

        return false;
    }
}
