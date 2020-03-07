package psv;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Data_send {
    public static void main(String[] args) {
        try{
            int number, temp;
            Scanner sc=new Scanner(System.in);
            Socket s= new Socket("127.0.0.1", 1342);
            Scanner scn= new Scanner(s.getInputStream());
            System.out.println("What is your name?: ");
            number=sc.nextInt();
            PrintStream p=new PrintStream(s.getOutputStream());
            p.println(number);
            temp=scn.nextInt();
            System.out.println(temp);

        } catch (Exception e) {
            System.out.println("ERROR:"+e);
        }
    }

}
