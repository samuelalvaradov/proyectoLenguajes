
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertUsuario(Usuario usuario) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Usuario (UsuarioID, NombreUsuario, DireccionUsuario, IdentificacionUsuario) VALUES (USUARIO_SEQ.NEXTVAL, ?, ?, ?)"
        )) {
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getDireccionUsuario());
            preparedStatement.setString(3, usuario.getIdentificacionUsuario());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsuario(Usuario usuario) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "UPDATE Usuario SET NombreUsuario=?, DireccionUsuario=?, IdentificacionUsuario=? WHERE UsuarioID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getDireccionUsuario());
            preparedStatement.setString(3, usuario.getIdentificacionUsuario());
            preparedStatement.setInt(4, usuario.getUsuarioID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int usuarioID) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM Usuario WHERE UsuarioID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usuarioID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM Usuario";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("UsuarioID"),
                        resultSet.getString("NombreUsuario"),
                        resultSet.getString("DireccionUsuario"),
                        resultSet.getString("IdentificacionUsuario")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getUsuarioByID(int usuarioID) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM Usuario WHERE UsuarioID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usuarioID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("UsuarioID"),
                        resultSet.getString("NombreUsuario"),
                        resultSet.getString("DireccionUsuario"),
                        resultSet.getString("IdentificacionUsuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
