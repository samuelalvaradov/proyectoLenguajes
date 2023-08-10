
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/NOMBRE_BD";
    private static final String USER = "USUARIO";
    private static final String PASSWORD = "CONTRASEÑA";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
