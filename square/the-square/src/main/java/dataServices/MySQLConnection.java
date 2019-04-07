package dataServices;

import java.sql.*;
import java.lang.*;

public class MySQLConnection {

    private Connection connection;

    private MySQLConnection(){}

    private static MySQLConnection INSTANCE = new MySQLConnection();

    public static MySQLConnection getInstance()
    {   return INSTANCE;
    }

    public Connection getConnection(){
        return this.connection;
    }

    public boolean Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/my_square?allowPublicKeyRetrieval=true&useSSL=false";
            String user = "tuncay";
            String passwd = "tuncay";
            this.connection = DriverManager.getConnection(url, user, passwd);
            return true;

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("mySQL connection failed");
            System.exit(1);
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("mySQL connection failed");
            System.exit(2);
            return false;
        }
    }

    public boolean disconnect() {
        try {
            this.connection.close();
            System.out.println("mySQl connection closed");
            return true;
        } catch (SQLException e) {
            System.out.println("mySQL Connection Could not be closed.");
            e.printStackTrace();
            return false;
        }
    }

}
