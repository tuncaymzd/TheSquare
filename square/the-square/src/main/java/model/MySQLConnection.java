package model;

import java.sql.*;
import java.lang.*;

public class MySQLConnection {

    private MySQLConnection(){}

    private static MySQLConnection INSTANCE = new MySQLConnection();

    public static MySQLConnection getInstance()
    {   return INSTANCE;
    }

    public Connection Connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/the_square";
            String user = "tuncay";
            String passwd = "tuncay";
            connection = DriverManager.getConnection(url, user, passwd);

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return connection;
    }

    public void test() throws SQLException {
        Connection con = Connection();
        Statement stmt = null;
        ResultSet rset = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rset = stmt.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while ( rset.next() ) {
            Integer id = rset.getInt(1);
            String surname = rset.getString(2);
            System.out.println(id + ": " + surname);
        }

    }
}
