package com.the.square;

import dataServices.*;
import model.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class App 
{

    public static void main( String[] args ) throws SQLException, ParseException {
        /*
        Hobbies hobbie = new Hobbies.Builder().Build();
        hobbie.setTitle("football");
        hobbie.setDescription("le football est un sport avec plein de belle valeur");

        Hobbies hobbie2 = new Hobbies.Builder().Build();
        hobbie2.setTitle("musique");
        hobbie2.setDescription("la musique permet de se couper du monde");

        Hobbies hobbie3 = new Hobbies.Builder().Build();
        hobbie3.setTitle("voyage");
        hobbie3.setDescription("la découverte de nouveau lieu, de nouvelle valeur et personne, bref magique");

        Hobbies hobbie4 = new Hobbies.Builder().Build();
        hobbie4.setTitle("dance");
        hobbie4.setDescription("liberation des articulations");

        Hobbies hobbie5 = new Hobbies.Builder().Build();
        hobbie5.setTitle("lecture");
        hobbie5.setDescription("detente total");

        Hobbies hobbie6 = new Hobbies.Builder().Build();
        hobbie6.setId(5);
        hobbie6.setTitle("lecture");
        hobbie6.setDescription("detente total et evasion");

        HobbiesDataAccessor data = new HobbiesDataAccessor();
        data.update(hobbie6);

        data.create(hobbie);
        data.create(hobbie2);
        data.create(hobbie3);
        data.create(hobbie4);
        data.create(hobbie5);
        Hobbies h1 = data.read(5);
        System.out.println(h1.getTitle()+h1.getDescription());
        data.update(hobbie6);
        ArrayList<Hobbies> hs = data.readAll();
        for (Hobbies x: hs
             ) {
            System.out.println(x.getTitle()+x.getDescription());
        }

        Skills skills = new Skills.Builder().Build();
        skills.setName("java");
        Skills skills2 = new Skills.Builder().Build();
        skills2.setName("c");
        Skills skills3 = new Skills.Builder().Build();
        skills3.setName("objective c");
        Skills skills4 = new Skills.Builder().Build();
        skills4.setName("android");
        Skills skills5 = new Skills.Builder().Build();
        skills5.setName("architecture");
        Skills skills6 = new Skills.Builder().Build();
        skills6.setName("mathematique fondamentale");
        Skills skills7 = new Skills.Builder().Build();
        skills7.setName("haskell");
        Skills skills8 = new Skills.Builder().Build();
        skills8.setId(7);
        skills8.setName("social network");
        Skills skills9 = new Skills.Builder().Build();
        skills9.setName("haskell");

        SkillsDataAccessor data = new SkillsDataAccessor();

        Skills s = data.read(9);
        Skills skills8 = new Skills.Builder().Build();
        skills8.setId(9);
        skills8.setName("solidity");
        data.update(skills8);
        Skills s2 = data.read(9);
        System.out.println("before="+s.getName()+" and after="+s2.getName());

        data.delete(1);
        data.create(skills);
        data.create(skills2);
        data.create(skills3);
        data.create(skills4);
        data.create(skills5);
        data.create(skills6);
        data.create(skills7);
        data.update(skills8);
        data.create(skills9);

        data.read(1);
        data.read(8);

        ArrayList<Skills> skilles = data.readAll();
        for (Skills s : skilles
             ) {
            System.out.println(s.getName());
        }

        Users users = new Users.Builder().Build();
        Users users2 = new Users.Builder().Build();
        Users users3 = new Users.Builder().Build();
        Users users4 = new Users.Builder().Build();
        Users users5 = new Users.Builder().Build();

        UsersDataAccessor data = new UsersDataAccessor();

        users.setFirstname("david");
        users.setLastname("leau");
        users.setDescription("je suis passionné par les nouvelles technologies");
        users.setCity("bruxelles");
        users.setBirthday("12-10-1970");
        users.setMail("david.leau@gmail.com");
        users.setPhone("04-56-11-67-78");
        data.create(users);

        users2.setFirstname("yohannes");
        users2.setLastname("dies");
        users2.setDescription("je veux travailler sur un sujet innovant");
        users2.setCity("paris");
        users2.setBirthday("01-03-1993");
        users2.setMail("yohannes.dies@live.com");
        users2.setPhone("03-56-11-67-78");
        data.create(users2);

        users3.setFirstname("abdel");
        users3.setLastname("chilou");
        users3.setDescription("je recherche une mission en tant que business analyst.");
        users3.setCity("lille");
        users3.setBirthday("12-10-1994");
        users3.setMail("abdel.chilou.pro@gmail.com");
        users3.setPhone("06-28-15-67-71");
        data.create(users3);

        users4.setFirstname("xu");
        users4.setLastname("chian");
        users4.setDescription("je suis expert en finance");
        users4.setCity("paris");
        users4.setBirthday("12-10-1988");
        users4.setMail("chain.xu@icloud.com");
        users4.setPhone("06-59-11-67-38");
        data.create(users4);

        users5.setId(5);
        users5.setFirstname("antoine");
        users5.setLastname("fila");
        users5.setDescription("je suis expert en comptabilité");
        users5.setCity("paris");
        users5.setBirthday("12-10-1996");
        users5.setMail("antoine73200@outlook.com");
        users5.setPhone("06-30-10-17-28");
        data.update(users5);


        Users u = data.read(5);
        System.out.println(u.getFirstname());

        data.delete(5);

        ArrayList<Users> a = data.readAll();
        for (Users i : a) {
            String f = i.getFirstname();
            String l = i.getLastname();
            String d = i.getDescription();
            String b = i.getBirthday();
            String c = i.getCity();
            String m =i.getMail();
            String fo =i.getPhone();
            System.out.println(f);
            System.out.println(l);
            System.out.println(d);
            System.out.println(b);
            System.out.println(c);
            System.out.println(m);
            System.out.println(fo);
        }
        EducationsDataAccessor data = new EducationsDataAccessor();

        Educations e = new Educations.Builder().Build();
        e.setTitle("EPITECH");
        e.setDescription("Architecture Logiciel, devellopement d application");
        e.setDate(new Date());

        Educations e2 = new Educations.Builder().Build();
        e2.setTitle("EPITECH");
        e2.setDescription("Programme grande école");
        e2.setDate(new Date());

        Educations e3 = new Educations.Builder().Build();
        e3.setTitle("Lille 1");
        e3.setDescription("MIAGE");
        e3.setDate(new Date());

        Educations e4 = new Educations.Builder().Build();
        e4.setTitle("Lille 1");
        e4.setDescription("Mathematique fondamentale");
        e4.setDate(new Date());

        Educations e5 = new Educations.Builder().Build();
        e5.setTitle("MIT");
        e5.setDescription("Génie electrique");
        e5.setDate(new Date());

        Educations e6 = new Educations.Builder().Build();
        e6.setTitle("CG bachelor");
        e6.setDescription("Graphisme");
        e6.setDate(new Date());

        data.create(e);
        data.create(e2);
        data.create(e3);
        data.create(e4);
        data.create(e5);
        data.create(e6);

        Educations es = data.read(6);
        System.out.println(es.getTitle()+es.getDescription());

        Educations e7 = new Educations.Builder().Build();
        e7.setId(6);
        e7.setTitle("EFI graph");
        e7.setDescription("Graphisme");
        e7.setDate(new Date());

        data.update(e7);
        Educations ess = data.read(6);
        System.out.println(ess.getTitle()+ess.getDescription());


        ArrayList<Educations> eds = data.readAll();

        for (Educations x: eds
             ) {
            System.out.println(x.getTitle()+x.getDescription());
        }


        JobOffersDataAccessor data = new JobOffersDataAccessor();

        data.delete(3);
        data.delete(4);
        JobOffers j = new JobOffers.Builder().Build();
        j.setIdCompagny(2);
        j.setName("developpeur fullstack");
        j.setDescription("5 ans d experience, connaissance de docker et sql");
        j.setWage(35000);

        JobOffers j2 = new JobOffers.Builder().Build();
        j2.setIdCompagny(2);
        j2.setName("expert java/hibernate");
        j2.setDescription("15 ans d experience");
        j2.setWage(75000);

        JobOffers j3 = new JobOffers.Builder().Build();
        j3.setIdCompagny(3);
        j3.setName("graphiste");
        j3.setDescription("connaissance de photoshop, post en télétravail");
        j3.setWage(30000);

        JobOffers j4 = new JobOffers.Builder().Build();
        j4.setIdCompagny(3);
        j4.setName("chef de projet");
        j4.setDescription("etre capable de gerer une equipe de 12 personnes travaillant sur des sites differents");
        j4.setWage(55000);

        JobOffers j5 = new JobOffers.Builder().Build();
        j5.setIdCompagny(2);
        j5.setName("ingenieur big data");
        j5.setDescription("maitrise de techno big data, expert en mathematique");
        j5.setWage(105000);

        data.create(j);
        data.create(j2);
        data.create(j3);
        data.create(j4);
        data.create(j5);

        JobOffers e = data.read(5);
        JobOffers j6 = new JobOffers.Builder().Build();
        j6.setId(5);
        j6.setIdCompagny(2);
        j6.setName("ingenieur Big Data");
        j6.setDescription("maitrise de techno big data, expert en mathematique et creation de graphique");
        j6.setWage(105000);

        data.update(j6);

        ArrayList<JobOffers> js = data.readAll();

        for (JobOffers x: js
             ) {
            System.out.println(x.getName()+x.getWage()+x.getDescription());
        }



        ActivitiesDomainDataAccessor data = new ActivitiesDomainDataAccessor();

        ActivitiesDomain a = new ActivitiesDomain.Builder().Build();
        a.setName("service de l information");

        ActivitiesDomain a2 = new ActivitiesDomain.Builder().Build();
        a2.setName("hebergeur");

        ActivitiesDomain a3 = new ActivitiesDomain.Builder().Build();
        a3.setName("service d état");

        ActivitiesDomain a4 = new ActivitiesDomain.Builder().Build();
        a4.setName("SSII");

        data.create(a);
        data.create(a2);
        data.create(a3);
        data.create(a4);

        ActivitiesDomain r = data.read(4);
        System.out.println(r.getName());

        ActivitiesDomain a5 = new ActivitiesDomain.Builder().Build();
        a5.setName("ESN");

        data.update(a5);

        ArrayList<ActivitiesDomain> ac = data.readAll();
        for (ActivitiesDomain x : ac
             ) {
            System.out.println(x.getName());
        }


        CompaniesDataAccessor data = new CompaniesDataAccessor();

        Companies c = new Companies.Builder().Build();
        c.setIdActivitiy(1);
        c.setName("worldline");
        c.setDescription("leader europeen du e-payment");
        c.setSiret(1234566);
        c.setSiren(45694394);

        Companies c2 = new Companies.Builder().Build();
        c2.setIdActivitiy(1);
        c2.setName("microsoft");
        c2.setDescription("leader du logiciel");
        c2.setSiret(4545466);
        c2.setSiren(11114394);

        Companies c3 = new Companies.Builder().Build();
        c3.setIdActivitiy(2);
        c3.setName("alves");
        c3.setDescription("location de bateau");
        c3.setSiret(44334566);
        c3.setSiren(123394);

        data.create(c);
        data.create(c2);
        data.create(c3);

        Companies cr = data.read(1);

        ArrayList<Companies> cs = data.readAll();
        for (Companies x:cs
             ) {
            System.out.println(x.getDescription()+x.getName()+x.getSiren()+x.getIdActivitiy());
        }

    */
        getUsersAndTheirHobbies();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        getTheSkillsForEveryUser();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        getUsersWithSimilarSkills();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        findUsersWhoHaveTheSkillsNeededToApplyForAnyJobOfferMadeByASpecificCompany();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        findUsersWithSkillsThatMatchAParticularJob();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        getUsersWithAParticularEducationLevel();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        getUsersWithTheSameHobby();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        usersAndTheirEducationLevels();
    }

    public static void getUsersAndTheirHobbies() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select users.firstname, users.lastname, hobbies.title from hobbies inner join characterize on hobbies.id_hobbie = characterize.id_hobbie inner join users on users.id_user = characterize.id_user;");
            System.out.println("--- debut test getUsersAndTheirHobbies ---");
            System.out.println("firstname | lastname | title of hobbie");
            while (set.next()){
                System.out.println(set.getString(1)+"|"+set.getString(2)+"|"+set.getString(3));
            }
            System.out.println("--- fin test getUsersAndTheirHobbies ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test getUsersAndTheirHobbies");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void getTheSkillsForEveryUser() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select users.firstname, users.lastname, skills.name from users inner join have on have.id_user = users.id_user join skills on have.id_skill = skills.id_skill;");
            System.out.println("--- debut test getTheSkillsForEveryUser ---");
            System.out.println("firstname | lastname | name of skills");
            while (set.next()){
                System.out.println(set.getString(1)+"|"+set.getString(2)+"|"+set.getString(3));
            }
            System.out.println("--- fin test getUsersAndTheirHobbies ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test getTheSkillsForEveryUser");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void getUsersWithSimilarSkills() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select * from users inner join have on have.id_skill = 2 and users.id_user = have.id_user;");
            System.out.println("--- debut test getUsersWithSimilarSkills ---");
            System.out.println("id_user | firstname | lastname | birthday | city | mail | phone | description | id_skill | id_user");
            while (set.next()){
                System.out.println(set.getInt(1)+"|"+set.getString(2)+"|"+set.getString(3)+"|"+set.getString(4)+"|"+set.getString(5)+"|"+set.getString(6)+"|"+set.getString(7)+"|"+set.getString(8)+"|"+set.getInt(9)+"|"+set.getInt(10));
            }
            System.out.println("--- fin test getUsersWithSimilarSkills ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test getUsersWithSimilarSkills");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void findUsersWhoHaveTheSkillsNeededToApplyForAnyJobOfferMadeByASpecificCompany() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select users.firstname, skills.name from users inner join job_offers on job_offers.id_compagny = 2 inner join hold on \n" +
                    "hold.id_job_offer = job_offers.id_job_offer inner join skills on skills.id_skill = hold.id_skill inner join have on have.id_skill = skills.id_skill\n" +
                    "and have.id_user = users.id_user;");
            System.out.println("--- debut test findUsersWhoHaveTheSkillsNeededToApplyForAnyJobOfferMadeByASpecificCompany() ---");
            System.out.println("firstname | name");
            while (set.next()){
                System.out.println(set.getString(1)+"|"+set.getString(2));
            }
            System.out.println("--- fin test findUsersWhoHaveTheSkillsNeededToApplyForAnyJobOfferMadeByASpecificCompany() ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test findUsersWhoHaveTheSkillsNeededToApplyForAnyJobOfferMadeByASpecificCompany()");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void findUsersWithSkillsThatMatchAParticularJob() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select users.firstname, skills.name from users inner join job_offers on job_offers.id_job_offer = 7 inner join hold on \n" +
                    "hold.id_job_offer = job_offers.id_job_offer inner join skills on skills.id_skill = hold.id_skill inner join have on have.id_skill = skills.id_skill\n" +
                    "and have.id_user = users.id_user;");
            System.out.println("--- debut test findUsersWithSkillsThatMatchAParticularJob ---");
            System.out.println("firstname | name of skill ");
            while (set.next()){
                System.out.println(set.getString(1)+"|"+set.getString(2));
            }
            System.out.println("--- fin test findUsersWithSkillsThatMatchAParticularJob ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test findUsersWithSkillsThatMatchAParticularJob");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void getUsersWithAParticularEducationLevel() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery( "select * from users inner join receive on receive.id_education = 1 and users.id_user = receive.id_user;");
            System.out.println("--- debut test getUsersWithAParticularEducationLevel() throws SQLException {\n---");
            System.out.println("id_user | firstname | lastname | birthday | city | mail | phone | description | id_education | id_user");
            while (set.next()){
                System.out.println(set.getInt(1)+"|"+set.getString(2)+"|"+set.getString(3)+"|"+set.getString(4)+"|"+set.getString(5)+"|"+set.getString(6)+"|"+set.getString(7)+"|"+set.getString(8)+"|"+set.getInt(9)+"|"+set.getInt(10));
            }
            System.out.println("--- fin test getUsersWithAParticularEducationLevel ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test getUsersWithAParticularEducationLevel");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void getUsersWithTheSameHobby() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery( "select * from users inner join characterize on characterize.id_hobbie = 2 and characterize.id_user = users.id_user;");
            System.out.println("--- debut test getUsersWithTheSameHobby() throws SQLException {\n---");
            System.out.println("id_user | firstname | lastname | birthday | city | mail | phone | description | id_hobbie | id_user");
            while (set.next()){
                System.out.println(set.getInt(1)+"|"+set.getString(2)+"|"+set.getString(3)+"|"+set.getString(4)+"|"+set.getString(5)+"|"+set.getString(6)+"|"+set.getString(7)+"|"+set.getString(8)+"|"+set.getInt(9)+"|"+set.getInt(10));
            }
            System.out.println("--- fin test getUsersWithTheSameHobby ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test getUsersWithTheSameHobby");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }

    public static void usersAndTheirEducationLevels() throws SQLException {
        try{
            MySQLConnection.getInstance().Connection();
            Connection connection = MySQLConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select users.firstname, users.lastname, educations.title from users inner join receive on receive.id_user = users.id_user join educations on educations.id_education = receive.id_education;");
            System.out.println("--- debut test usersAndTheirEducationLevels ---");
            System.out.println("firstname | lastname | title");
            while (set.next()){
                System.out.println(set.getString(1)+"|"+set.getString(2)+"|"+set.getString(3));
            }
            System.out.println("--- fin test usersAndTheirEducationLevels ---");
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while test usersAndTheirEducationLevels");
            e.printStackTrace();
        } finally {
            MySQLConnection.getInstance().disconnect();
        }
    }
}
