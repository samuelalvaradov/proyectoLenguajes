
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    public void insertAutor(Autor autor) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Autor (AutorID, NombreAutor, PaisAutor) VALUES (AUTOR_SEQ.NEXTVAL, ?, ?)"
        )) {
            preparedStatement.setString(1, autor.getNombreAutor());
            preparedStatement.setString(2, autor.getPaisAutor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAutor(Autor autor) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "UPDATE Autor SET NombreAutor = ?, PaisAutor = ? WHERE AutorID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, autor.getNombreAutor());
            statement.setString(2, autor.getPaisAutor());
            statement.setInt(3, autor.getAutorID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAutor(int autorID) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "DELETE FROM Autor WHERE AutorID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, autorID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> getAllAutores() {
        List<Autor> autores = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM Autor";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int autorID = resultSet.getInt("AutorID");
                String nombreAutor = resultSet.getString("NombreAutor");
                String paisAutor = resultSet.getString("PaisAutor");
                autores.add(new Autor(autorID, nombreAutor, paisAutor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }

    public Autor getAutorByID(int autorID) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String query = "SELECT * FROM Autor WHERE AutorID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, autorID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombreAutor = resultSet.getString("NombreAutor");
                String paisAutor = resultSet.getString("PaisAutor");
                return new Autor(autorID, nombreAutor, paisAutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
