package dataServices;

import model.Hobbies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HobbiesDataAccessor implements IDataAccessor<Hobbies> {
    public HobbiesDataAccessor() {
    }

    @Override
    public void create(Hobbies obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getTitle() + "'," + "'" + obj.getDescription() + "'";
            statement.executeUpdate("INSERT into hobbies(title, description) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an hobbies");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<Hobbies> readAll() {
        ArrayList<Hobbies> hobbiesList = new ArrayList<Hobbies>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From hobbies;");
            while (set.next()){
                Hobbies hobbiesTmp = null;
                hobbiesTmp = new Hobbies.Builder().Build();
                hobbiesTmp.setId(set.getInt(1));
                hobbiesTmp.setTitle(set.getString(2));
                hobbiesTmp.setDescription(set.getString(3));
                hobbiesList.add(hobbiesTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this hobbie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return hobbiesList;
    }

    @Override
    public Hobbies read(int id) {
        Hobbies hobbie = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From hobbies WHERE id_hobbie = "+id+";");
            Hobbies bufferHobbie = new Hobbies.Builder().Build();
            while (set.next()){
                bufferHobbie.setId(set.getInt(1));
                bufferHobbie.setTitle(set.getString(2));
                bufferHobbie.setDescription(set.getString(3));
            }
            hobbie = bufferHobbie;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this hobbie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return hobbie;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM hobbies WHERE id_hobbie ="+index+";");
            System.out.println("This hobbie has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this hobbie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(Hobbies obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE hobbies SET title='"+obj.getTitle() +"', description='"+obj.getDescription() +"' WHERE id_hobbie="+obj.getId()+";");
            System.out.println("This hobbie hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this hobbie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
