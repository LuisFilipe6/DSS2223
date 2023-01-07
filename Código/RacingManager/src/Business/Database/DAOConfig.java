package Business.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConfig {
    static final String USERNAME = "root";                       // Actualizar
    static final String PASSWORD = "";                       // Actualizar
    private static final String DATABASE = "racingmanager";          // Actualizar
    //private static final String DRIVER = "jdbc:mariadb";        // Usar para MariaDB
    private static final String DRIVER = "jdbc:mysql";        // Usar para MySQL
    static final String URL = DRIVER+"://localhost:3306/"+DATABASE;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
    }

    public static void endConnection(Connection con) throws SQLException {
        con.close();
    }

}
