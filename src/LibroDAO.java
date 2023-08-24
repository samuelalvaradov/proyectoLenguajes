
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertLibro(Libro libro) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Libro (LibroID, AutorID, CateoriaID, Titulo, Año) VALUES (LIBRO_SEQ.NEXTVAL, ?, ?, ?, ?)"
        )) {
            preparedStatement.setInt(1, libro.getAutorID());
            preparedStatement.setInt(2, libro.getCategoriaID());
            preparedStatement.setString(3, libro.getTitulo());
            preparedStatement.setInt(4, libro.getAño());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLibro(Libro libro) {
        String updateQuery = "UPDATE Libro SET AutorID = ?, CategoriaID = ?, Titulo = ?, Año = ? WHERE LibroID = ?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, libro.getAutorID());
            preparedStatement.setInt(2, libro.getCategoriaID());
            preparedStatement.setString(3, libro.getTitulo());
            preparedStatement.setInt(4, libro.getAño());
            preparedStatement.setInt(5, libro.getLibroID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLibro(int libroID) {
        String deleteQuery = "DELETE FROM Libro WHERE LibroID = ?";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, libroID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> getAllLibros() {
        List<Libro> libros = new ArrayList<>();
        String selectQuery = "SELECT * FROM Libro";

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Libro libro = new Libro(
                        resultSet.getInt("LibroID"),
                        resultSet.getInt("AutorID"),
                        resultSet.getInt("CategoriaID"),
                        resultSet.getString("Titulo"),
                        resultSet.getInt("Año")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    public Libro getLibroByID(int libroID) {
        String selectQuery = "SELECT * FROM Libro WHERE LibroID = ?";
        Libro libro = null;

        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

            preparedStatement.setInt(1, libroID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    libro = new Libro(
                            resultSet.getInt("LibroID"),
                            resultSet.getInt("AutorID"),
                            resultSet.getInt("CategoriaID"),
                            resultSet.getString("Titulo"),
                            resultSet.getInt("Año")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }
}
