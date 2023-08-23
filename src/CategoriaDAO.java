
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void insertCategoria(Categoria categoria) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Categoria (CategoriaID, NombreCat) VALUES (CATEGORIA_SEQ.NEXTVAL, ?)"
        )) {
            preparedStatement.setString(1, categoria.getNombreCat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategoria(Categoria categoria) {
        String updateQuery = "UPDATE Categoria SET NombreCat = ? WHERE CategoriaID = ?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, categoria.getNombreCat());
            preparedStatement.setInt(2, categoria.getCategoriaID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    public void deleteCategoria(int categoriaID) {
        String deleteQuery = "DELETE FROM Categoria WHERE CategoriaID = ?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, categoriaID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }

    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String selectQuery = "SELECT * FROM Categoria";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int categoriaID = resultSet.getInt("CategoriaID");
                String nombreCat = resultSet.getString("NombreCat");
                Categoria categoria = new Categoria(categoriaID, nombreCat);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        return categorias;
    }

    public Categoria getCategoriaByID(int categoriaID) {
        String selectQuery = "SELECT * FROM Categoria WHERE CategoriaID = ?";
        Categoria categoria = null;

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, categoriaID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombreCat = resultSet.getString("NombreCat");
                    categoria = new Categoria(categoriaID, nombreCat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        return categoria;
    }
}
