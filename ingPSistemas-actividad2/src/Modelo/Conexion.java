
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String db;
    private String driver;
    private String url;
    private String user;
    private String pass;
    private static Connection conn = null;

    private Conexion() {
        db = "bdtren";
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/" + db;
        user = "root";
        pass = "";
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
        }
        
    }
    
    public static Connection getConnection() {
        if (conn == null) {
            Conexion conexion = new Conexion();
        }
        return conn;
    }
}
