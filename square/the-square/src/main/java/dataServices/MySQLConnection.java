package model;

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

            String url = "jdbc:mysql://127.0.0.1:3306/the_square";
            String user = "tuncay";
            String passwd = "tuncay";
            this.connection = DriverManager.getConnection(url, user, passwd);
            return true;

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("SQLite connection failed");
            System.exit(1);
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLite connection failed");
            System.exit(2);
            return false;
        }
    }

    public void disconnect() {

    }

}
