package psv;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class Server {
    public static void main(String[] args){
        try{
            int number, temp;
            ServerSocket S1 = new ServerSocket(1342);
            Socket ss = S1.accept();
            Scanner sc = new Scanner (ss.getInputStream());
            number = sc.nextInt();
            temp = number *2;
            PrintStream p = new PrintStream(ss.getOutputStream());
            p.println(temp);

            try {
                Connection con;
                PreparedStatement ps;
                con = DB_Conn.getConnection();
                ps = con.prepareStatement("INSERT INTO  Car_info (plate_no) VALUES(?)");
                ps.setInt(1, temp);
                int i=ps.executeUpdate();

                if (i>0){
                    System.out.println("Inserted successifully");
                }
                else{
                    System.out.println("Not inserted");
                }

            } catch (Exception e) {
                System.out.println("ERROR" +e);
            }


        } catch (Exception ex) {
            System.out.println("ERR"+ex);
        }
    }
}
