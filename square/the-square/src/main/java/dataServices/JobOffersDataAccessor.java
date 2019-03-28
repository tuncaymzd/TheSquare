package dataServices;

import model.JobOffers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JobOffersDataAccessor implements IDataAccessor<JobOffers> {
    public JobOffersDataAccessor() {
    }

    @Override
    public void create(JobOffers obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getName() + "'," + "'" + obj.getDescription() + "'," + obj.getWage();
            statement.executeUpdate("INSERT into hobbies(name, description, wage) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an job offers");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<JobOffers> readAll() {
        ArrayList<JobOffers> jobList = new ArrayList<JobOffers>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From job_offers;");
            while (set.next()){
                JobOffers jobTmp = null;
                jobTmp = new JobOffers.Builder().Build();
                jobTmp.setId(set.getInt(1));
                jobTmp.setName(set.getString(2));
                jobTmp.setDescription(set.getString(3));
                jobTmp.setWage(set.getLong(4));
                jobList.add(jobTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this job offer");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return jobList;
    }

    @Override
    public JobOffers read(int id) {
        JobOffers job = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From job_offers WHERE id_job_offer = "+id+";");
            JobOffers bufferJob = new JobOffers.Builder().Build();
            while (set.next()){
                bufferJob.setId(set.getInt(1));
                bufferJob.setName(set.getString(2));
                bufferJob.setDescription(set.getString(3));
                bufferJob.setWage(set.getLong(4));
            }
            job = bufferJob;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this job");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return job;

    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM job_offers WHERE id_job_offer ="+index+";");
            System.out.println("This job has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this job");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(JobOffers obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE job_offers SET name='"+obj.getName() +"', description='"+obj.getDescription() +"', wage="+obj.getWage()+" WHERE id_job_offer="+obj.getId()+";");
            System.out.println("This job offer hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this job offer");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
