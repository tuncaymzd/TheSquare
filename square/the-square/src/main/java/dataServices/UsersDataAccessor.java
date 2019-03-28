package dataServices;

import model.Users;

import java.sql.Connection;
import java.sql.ResultSet;
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
        ArrayList<Users> usersList = new ArrayList<Users>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From users;");
            while (set.next()){
                Users usersTmp = null;
                usersTmp = new Users.Builder().Build();
                usersTmp.setId(set.getInt(1));
                usersTmp.setFirstname(set.getString(2));
                usersTmp.setLastname(set.getString(3));
                usersTmp.setBirthday(set.getString(4));
                usersTmp.setCity(set.getString(5));
                usersTmp.setMail(set.getString(6));
                usersTmp.setPhone(set.getString(7));
                usersTmp.setDescription(set.getString(8));
                usersList.add(usersTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this users");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return usersList;
    }

    @Override
    public Users read(int id) {
        Users user = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From users WHERE id_user = "+id+";");
            Users bufferUser = new Users.Builder().Build();
            while (set.next()){
                bufferUser.setId(set.getInt(1));
                bufferUser.setFirstname(set.getString(2));
                bufferUser.setLastname(set.getString(3));
                bufferUser.setBirthday(set.getString(4));
                bufferUser.setCity(set.getString(5));
                bufferUser.setMail(set.getString(6));
                bufferUser.setPhone(set.getString(7));
                bufferUser.setDescription(set.getString(8));
            }
            user = bufferUser;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this user");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return user;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM users WHERE id_user ="+index+";");
            System.out.println("This user has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this user");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(Users obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE users SET firstname='"+obj.getFirstname()+"', lastname='"+obj.getLastname()+"', birthday='"+obj.getBirthday() +"', city='"+obj.getCity() +"', mail='"+obj.getMail() +"', phone='"+obj.getPhone() +"', description='"+obj.getDescription() +"' WHERE id_user="+obj.getId()+";");
            System.out.println("This user hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this user");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
