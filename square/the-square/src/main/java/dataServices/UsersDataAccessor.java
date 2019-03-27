package dataServices;

import model.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDataAccessor implements IDataAccessor<Users> {

    public UsersDataAccessor() { }

    @Override
    public void create(Users obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getFirstname() + "'," + "'" + obj.getLastname() + "'," + "'" + obj.getBirthday() + "'" + ",'" + obj.getCity() + "'" + ",'" + obj.getMail() + "'" + ",'" + obj.getPhone() + "'" + ",'" + obj.getDescription() + "'";
            statement.executeUpdate("INSERT into users(firstname,lastname,birthday, city, mail, phone, description) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an user");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<Users> readAll() {
        return null;
    }

    @Override
    public Users read(int id) {
        return null;
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(Users obj) {

    }
}
