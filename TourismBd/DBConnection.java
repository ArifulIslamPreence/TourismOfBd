import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class DB {
    public static Connection getConnection(){
	
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travellers", "root", "");
            return con;

        } catch (Exception ex) {
            return null;
        }
    }
}