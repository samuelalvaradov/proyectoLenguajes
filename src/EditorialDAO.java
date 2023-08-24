
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditorialDAO {

    public void insertEditorial(Editorial editorial) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Editorial (EditorialID, LibroID, DireccionEditorial, CiudadEditorial, PaisEditorial) VALUES (EDITORIAL_SEQ.NEXTVAL, ?, ?, ?, ?)"
        )) {
            preparedStatement.setInt(1, editorial.getLibroID());
            preparedStatement.setString(2, editorial.getDireccionEditorial());
            preparedStatement.setString(3, editorial.getCiudadEditorial());
            preparedStatement.setString(4, editorial.getPaisEditorial());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEditorial(Editorial editorial) {
        String updateQuery = "UPDATE Editorial SET LibroID=?, DireccionEditorial=?, CiudadEditorial=?, PaisEditorial=? WHERE EditorialID=?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, editorial.getLibroID());
            preparedStatement.setString(2, editorial.getDireccionEditorial());
            preparedStatement.setString(3, editorial.getCiudadEditorial());
            preparedStatement.setString(4, editorial.getPaisEditorial());
            preparedStatement.setInt(5, editorial.getEditorialID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEditorial(int editorialID) {
        String deleteQuery = "DELETE FROM Editorial WHERE EditorialID=?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, editorialID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Editorial> getAllEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        String selectQuery = "SELECT * FROM Editorial";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Editorial editorial = new Editorial(
                        resultSet.getInt("EditorialID"),
                        resultSet.getInt("LibroID"),
                        resultSet.getString("DireccionEditorial"),
                        resultSet.getString("CiudadEditorial"),
                        resultSet.getString("PaisEditorial")
                );
                editoriales.add(editorial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editoriales;
    }

    public Editorial getEditorialByID(int editorialID) {
        String selectQuery = "SELECT * FROM Editorial WHERE EditorialID=?";
        Editorial editorial = null;

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, editorialID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    editorial = new Editorial(
                            resultSet.getInt("EditorialID"),
                            resultSet.getInt("LibroID"),
                            resultSet.getString("DireccionEditorial"),
                            resultSet.getString("CiudadEditorial"),
                            resultSet.getString("PaisEditorial")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editorial;
    }
}
