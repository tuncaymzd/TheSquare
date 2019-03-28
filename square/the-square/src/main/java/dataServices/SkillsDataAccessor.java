package dataServices;

import model.Skills;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SkillsDataAccessor implements IDataAccessor<Skills> {
    public SkillsDataAccessor() {
    }

    @Override
    public void create(Skills obj) {
        MySQLConnection.getInstance().Connection();
        Connection connection = MySQLConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            //ne pas insérer de donnée contenant le symbole '
            String query = "'" + obj.getName() + "'";
            statement.executeUpdate("INSERT into hobbies(name) VALUES ("+ query+");");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an hobbie");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public ArrayList<Skills> readAll() {
        ArrayList<Skills> skillsList = new ArrayList<Skills>();
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From skills;");
            while (set.next()){
                Skills skillsTmp = null;
                skillsTmp = new Skills.Builder().Build();
                skillsTmp.setId(set.getInt(1));
                skillsTmp.setName(set.getString(2));
                skillsList.add(skillsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this skills");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return skillsList;
    }

    @Override
    public Skills read(int id) {
        Skills skill = null;
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From skills WHERE id_skill = "+id+";");
            Skills bufferSkill = new Skills.Builder().Build();
            while (set.next()){
                bufferSkill.setId(set.getInt(1));
                bufferSkill.setName(set.getString(2));
            }
            skill = bufferSkill;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this skill");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
        return skill;
    }

    @Override
    public void delete(int index) {
        try {
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM skills WHERE id_skill ="+index+";");
            System.out.println("This skill has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this skill");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    @Override
    public void update(Skills obj) {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE skills SET name='"+obj.getName() +"' WHERE id_skill="+obj.getId()+";");
            System.out.println("This skill hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this skill");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
