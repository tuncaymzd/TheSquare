#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: users
#------------------------------------------------------------

CREATE TABLE users(
        id_user     Int  Auto_increment  NOT NULL ,
        firstname   Varchar (50) NOT NULL ,
        lastname    Varchar (50) NOT NULL ,
        birthday    Varchar (12) NOT NULL ,
        city        Varchar (50) NOT NULL ,
        mail        Varchar (50) NOT NULL ,
        phone       Varchar (30) NOT NULL ,
        description Text NOT NULL
	,CONSTRAINT users_PK PRIMARY KEY (id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: compagnies
#------------------------------------------------------------

CREATE TABLE compagnies(
        id_compagny Int  Auto_increment  NOT NULL ,
        name        Varchar (100) NOT NULL ,
        siret       BigInt NOT NULL ,
        siren       BigInt NOT NULL ,
        description Text NOT NULL
	,CONSTRAINT compagnies_PK PRIMARY KEY (id_compagny)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: skills
#------------------------------------------------------------

CREATE TABLE skills(
        id_skill Int  Auto_increment  NOT NULL ,
        name     Varchar (1000) NOT NULL
	,CONSTRAINT skills_PK PRIMARY KEY (id_skill)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: hobbies
#------------------------------------------------------------

CREATE TABLE hobbies(
        id_hobbie   Int  Auto_increment  NOT NULL ,
        title       Varchar (50) NOT NULL ,
        description Text NOT NULL
	,CONSTRAINT hobbies_PK PRIMARY KEY (id_hobbie)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: educations
#------------------------------------------------------------

CREATE TABLE educations(
        id_education Int  Auto_increment  NOT NULL ,
        title        Varchar (50) NOT NULL ,
        description  Text NOT NULL ,
        date         Date NOT NULL
	,CONSTRAINT educations_PK PRIMARY KEY (id_education)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: activities_domain
#------------------------------------------------------------

CREATE TABLE activities_domain(
        id_activity_domain Int  Auto_increment  NOT NULL ,
        name               Varchar (50) NOT NULL ,
        id_compagny        Int NOT NULL
	,CONSTRAINT activities_domain_PK PRIMARY KEY (id_activity_domain)

	,CONSTRAINT activities_domain_compagnies_FK FOREIGN KEY (id_compagny) REFERENCES compagnies(id_compagny)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: job_offers
#------------------------------------------------------------

CREATE TABLE job_offers(
        id_job_offer Int  Auto_increment  NOT NULL ,
        name         Varchar (50) NOT NULL ,
        description  Text NOT NULL ,
        wage         BigInt NOT NULL ,
        id_compagny  Int
	,CONSTRAINT job_offers_PK PRIMARY KEY (id_job_offer)

	,CONSTRAINT job_offers_compagnies_FK FOREIGN KEY (id_compagny) REFERENCES compagnies(id_compagny)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: receive
#------------------------------------------------------------

CREATE TABLE receive(
        id_education Int NOT NULL ,
        id_user      Int NOT NULL
	,CONSTRAINT receive_PK PRIMARY KEY (id_education,id_user)

	,CONSTRAINT receive_educations_FK FOREIGN KEY (id_education) REFERENCES educations(id_education)
	,CONSTRAINT receive_users0_FK FOREIGN KEY (id_user) REFERENCES users(id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: have
#------------------------------------------------------------

CREATE TABLE have(
        id_skill Int NOT NULL ,
        id_user  Int NOT NULL
	,CONSTRAINT have_PK PRIMARY KEY (id_skill,id_user)

	,CONSTRAINT have_skills_FK FOREIGN KEY (id_skill) REFERENCES skills(id_skill)
	,CONSTRAINT have_users0_FK FOREIGN KEY (id_user) REFERENCES users(id_user)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: hold
#------------------------------------------------------------

CREATE TABLE hold(
        id_job_offer Int NOT NULL ,
        id_skill     Int NOT NULL
	,CONSTRAINT hold_PK PRIMARY KEY (id_job_offer,id_skill)

	,CONSTRAINT hold_job_offers_FK FOREIGN KEY (id_job_offer) REFERENCES job_offers(id_job_offer)
	,CONSTRAINT hold_skills0_FK FOREIGN KEY (id_skill) REFERENCES skills(id_skill)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: characterize
#------------------------------------------------------------

CREATE TABLE characterize(
        id_hobbie Int NOT NULL ,
        id_user   Int NOT NULL
	,CONSTRAINT characterize_PK PRIMARY KEY (id_hobbie,id_user)

	,CONSTRAINT characterize_hobbies_FK FOREIGN KEY (id_hobbie) REFERENCES hobbies(id_hobbie)
	,CONSTRAINT characterize_users0_FK FOREIGN KEY (id_user) REFERENCES users(id_user)
)ENGINE=InnoDB;

