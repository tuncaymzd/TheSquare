package dataServices;

import model.Companies;
import model.JobOffers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompaniesDataAccessor implements IDataAccessor<Companies> {
    public CompaniesDataAccessor() {
    }

    @Override
    public void create(Companies obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getName() + "'," + obj.getSiret() + "," + obj.getSiren() + ",'" + obj.getDescription() + "'," + obj.getIdActivitiy();
            statement.executeUpdate("INSERT into compagnies(name, siret, siren, description,id_activity_domain) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an companie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }


    @Override
    public ArrayList<Companies> readAll() {
        ArrayList<Companies> companiesList = new ArrayList<Companies>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From compagnies;");
            while (set.next()){
                Companies companiesTmp = null;
                companiesTmp = new Companies.Builder().Build();
                companiesTmp.setId(set.getInt(1));
                companiesTmp.setName(set.getString(2));
                companiesTmp.setSiret(set.getLong(3));
                companiesTmp.setSiren(set.getLong(4));
                companiesTmp.setDescription(set.getString(5));

                companiesList.add(companiesTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this companie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return companiesList;
    }

    @Override
    public Companies read(int id) {
        Companies companie = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From compagnies WHERE id_compagny = "+id+";");
            Companies bufferCompanie = new Companies.Builder().Build();
            while (set.next()){
                bufferCompanie.setId(set.getInt(1));
                bufferCompanie.setName(set.getString(2));
                bufferCompanie.setSiret(set.getLong(3));
                bufferCompanie.setSiren(set.getLong(4));
                bufferCompanie.setDescription(set.getString(5));
                bufferCompanie.setIdActivitiy(set.getInt(6));
            }
            companie = bufferCompanie;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this companie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return companie;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM compagnies WHERE id_compagny ="+index+";");
            System.out.println("This company has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this company");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(Companies obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE compagnies SET name='"+obj.getName() +"', siret=obj.getSiret(), siren=obj.getSiren(), description='"+obj.getDescription() +"' WHERE id_compagny="+obj.getId()+";");
            System.out.println("This companie hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this companie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
