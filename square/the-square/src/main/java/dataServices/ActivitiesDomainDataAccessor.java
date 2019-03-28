package dataServices;

import model.ActivitiesDomain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ActivitiesDomainDataAccessor implements IDataAccessor<ActivitiesDomain> {

    public ActivitiesDomainDataAccessor() {
    }

    @Override
    public void create(ActivitiesDomain obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getName() + "'";
            statement.executeUpdate("INSERT into activities_domain(name) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an activitie domain");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<ActivitiesDomain> readAll() {
        ArrayList<ActivitiesDomain> domainsList = new ArrayList<ActivitiesDomain>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From activities_domain;");
            while (set.next()){
                ActivitiesDomain domainsTmp = null;
                domainsTmp = new ActivitiesDomain.Builder().Build();
                domainsTmp.setId(set.getInt(1));
                domainsTmp.setName(set.getString(2));
                domainsList.add(domainsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this activitie domain");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return domainsList;
    }

    @Override
    public ActivitiesDomain read(int id) {
        ActivitiesDomain domain = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From activities_domain WHERE id_activity_domain = "+id+";");
            ActivitiesDomain bufferDomain = new ActivitiesDomain.Builder().Build();
            while (set.next()){
                bufferDomain.setId(set.getInt(1));
                bufferDomain.setName(set.getString(2));
            }
            domain = bufferDomain;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this activities domain");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return domain;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM activities_domain WHERE id_activity_domain ="+index+";");
            System.out.println("This domain has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this domain");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(ActivitiesDomain obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE activities_domain SET name='"+obj.getName() +"' WHERE id_activitie_domain="+obj.getId()+";");
            System.out.println("This activity domain hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this activity domain");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
