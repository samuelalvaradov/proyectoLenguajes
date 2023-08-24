
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public void insertPrestamo(Prestamo prestamo) {
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Prestamo (PrestamoID, UsuarioID, LibroID, FechaPrestamo, FechaDevolucion) "
                + "VALUES (PRESTAMO_SEQ.NEXTVAL, ?, ?, ?, ?)"
        )) {
            preparedStatement.setInt(1, prestamo.getUsuarioID());
            preparedStatement.setInt(2, prestamo.getLibroID());
            preparedStatement.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrestamo(Prestamo prestamo) {
        String query = "UPDATE Prestamo SET UsuarioID = ?, LibroID = ?, FechaPrestamo = ?, FechaDevolucion = ? WHERE PrestamoID = ?";
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, prestamo.getUsuarioID());
            preparedStatement.setInt(2, prestamo.getLibroID());
            preparedStatement.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            preparedStatement.setInt(5, prestamo.getPrestamoID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePrestamo(int prestamoID) {
        String query = "DELETE FROM Prestamo WHERE PrestamoID = ?";
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, prestamoID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prestamo> getAllPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT * FROM Prestamo";
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Prestamo prestamo = new Prestamo(
                        resultSet.getInt("PrestamoID"),
                        resultSet.getInt("UsuarioID"),
                        resultSet.getInt("LibroID"),
                        resultSet.getDate("FechaPrestamo"),
                        resultSet.getDate("FechaDevolucion")
                );
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    public Prestamo getPrestamoByID(int prestamoID) {
        String query = "SELECT * FROM Prestamo WHERE PrestamoID = ?";
        try (Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, prestamoID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Prestamo(
                            resultSet.getInt("PrestamoID"),
                            resultSet.getInt("UsuarioID"),
                            resultSet.getInt("LibroID"),
                            resultSet.getDate("FechaPrestamo"),
                            resultSet.getDate("FechaDevolucion")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
