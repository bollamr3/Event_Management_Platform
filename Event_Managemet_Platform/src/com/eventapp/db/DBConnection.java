
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Updated JDBC URL
            String url =  "jdbc:mysql://localhost:3306/event_db";

            String username = "root";
            String password = "20122001@DOBpass";

            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conn;
    }
}
