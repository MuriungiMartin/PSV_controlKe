package psv;
import java.sql.*;

public class DB_Conn {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/PSV";
            con = DriverManager.getConnection(url,"root","");


        } catch (Exception e) {
            e.printStackTrace();
        }


        return con;
    }
}
