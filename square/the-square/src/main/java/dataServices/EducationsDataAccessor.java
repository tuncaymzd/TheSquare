package dataServices;

import model.Educations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EducationsDataAccessor implements IDataAccessor<Educations> {
    public EducationsDataAccessor() {
    }

    @Override
    public void create(Educations obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getTitle() + "'," + "'" + obj.getDescription() + "'," + "'" + obj.getDate().toString() + "'";
            statement.executeUpdate("INSERT into educations(name, description, date) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an education");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<Educations> readAll() {
        ArrayList<Educations> educationsList = new ArrayList<Educations>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From educations;");
            while (set.next()){
                Educations educationsTmp = null;
                educationsTmp = new Educations.Builder().Build();
                educationsTmp.setId(set.getInt(1));
                educationsTmp.setTitle(set.getString(2));
                educationsTmp.setDescription(set.getString(3));
                educationsTmp.setDate(set.getDate(4));
                educationsList.add(educationsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this educations");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return educationsList;
    }

    @Override
    public Educations read(int id) {
        Educations education = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From educations WHERE id_education = "+id+";");
            Educations bufferEducation = new Educations.Builder().Build();
            while (set.next()){
                bufferEducation.setId(set.getInt(1));
                bufferEducation.setTitle(set.getString(2));
                bufferEducation.setDescription(set.getString(3));
                bufferEducation.setDate(set.getDate(4));
            }
            education = bufferEducation;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this education");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return education;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM educations WHERE id_education ="+index+";");
            System.out.println("This education has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this education");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(Educations obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE educations SET title='"+obj.getTitle() +"', description='"+obj.getDescription() +"', date='"+obj.getDate().toString() +"' WHERE id_education="+obj.getId()+";");
            System.out.println("This education hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this education");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
