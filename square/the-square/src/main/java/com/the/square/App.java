package com.the.square;

import model.MySQLConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MySQLConnection c = MySQLConnection.getInstance();
        try {
            c.test();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
