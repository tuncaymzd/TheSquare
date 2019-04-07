-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: my_square
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activities_domain`
--

DROP TABLE IF EXISTS `activities_domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activities_domain` (
  `id_activity_domain` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_activity_domain`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities_domain`
--

LOCK TABLES `activities_domain` WRITE;
/*!40000 ALTER TABLE `activities_domain` DISABLE KEYS */;
INSERT INTO `activities_domain` VALUES (1,'service de l information'),(2,'hebergeur'),(3,'service d état'),(4,'SSII');
/*!40000 ALTER TABLE `activities_domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `characterize`
--

DROP TABLE IF EXISTS `characterize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `characterize` (
  `id_hobbie` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_hobbie`,`id_user`),
  KEY `characterize_users0_FK` (`id_user`),
  CONSTRAINT `characterize_hobbies_FK` FOREIGN KEY (`id_hobbie`) REFERENCES `hobbies` (`id_hobbie`),
  CONSTRAINT `characterize_users0_FK` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `characterize`
--

LOCK TABLES `characterize` WRITE;
/*!40000 ALTER TABLE `characterize` DISABLE KEYS */;
/*!40000 ALTER TABLE `characterize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compagnies`
--

DROP TABLE IF EXISTS `compagnies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `compagnies` (
  `id_compagny` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `siret` bigint(20) NOT NULL,
  `siren` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `id_activity_domain` int(11) NOT NULL,
  PRIMARY KEY (`id_compagny`),
  KEY `compagnies_activities_domain_FK` (`id_activity_domain`),
  CONSTRAINT `compagnies_activities_domain_FK` FOREIGN KEY (`id_activity_domain`) REFERENCES `activities_domain` (`id_activity_domain`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compagnies`
--

LOCK TABLES `compagnies` WRITE;
/*!40000 ALTER TABLE `compagnies` DISABLE KEYS */;
INSERT INTO `compagnies` VALUES (2,'worldline',1234566,45694394,'leader europeen du e-payment',1),(3,'microsoft',4545466,11114394,'leader du logiciel',1),(4,'alves',44334566,123394,'location de bateau',2);
/*!40000 ALTER TABLE `compagnies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educations`
--

DROP TABLE IF EXISTS `educations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `educations` (
  `id_education` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `date` text NOT NULL,
  PRIMARY KEY (`id_education`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
INSERT INTO `educations` VALUES (1,'EPITECH','Architecture Logiciel, devellopement d application','Sun Apr 07 14:54:41 CEST 2019'),(2,'EPITECH','Programme grande école','Sun Apr 07 14:54:41 CEST 2019'),(3,'Lille 1','MIAGE','Sun Apr 07 14:54:41 CEST 2019'),(4,'Lille 1','Mathematique fondamentale','Sun Apr 07 14:54:41 CEST 2019'),(5,'MIT','Génie electrique','Sun Apr 07 14:54:41 CEST 2019'),(6,'EFI graph','Graphisme','Sun Apr 07 14:58:07 CEST 2019');
/*!40000 ALTER TABLE `educations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `have`
--

DROP TABLE IF EXISTS `have`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `have` (
  `id_skill` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_skill`,`id_user`),
  KEY `have_users0_FK` (`id_user`),
  CONSTRAINT `have_skills_FK` FOREIGN KEY (`id_skill`) REFERENCES `skills` (`id_skill`),
  CONSTRAINT `have_users0_FK` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `have`
--

LOCK TABLES `have` WRITE;
/*!40000 ALTER TABLE `have` DISABLE KEYS */;
/*!40000 ALTER TABLE `have` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobbies`
--

DROP TABLE IF EXISTS `hobbies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hobbies` (
  `id_hobbie` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_hobbie`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobbies`
--

LOCK TABLES `hobbies` WRITE;
/*!40000 ALTER TABLE `hobbies` DISABLE KEYS */;
INSERT INTO `hobbies` VALUES (1,'football','le football est un sport avec plein de belle valeur'),(2,'musique','la musique permet de se couper du monde'),(3,'voyage','la découverte de nouveau lieu, de nouvelle valeur et personne, bref magique'),(4,'dance','liberation des articulations'),(5,'lecture','detente total et evasion');
/*!40000 ALTER TABLE `hobbies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hold`
--

DROP TABLE IF EXISTS `hold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hold` (
  `id_job_offer` int(11) NOT NULL,
  `id_skill` int(11) NOT NULL,
  PRIMARY KEY (`id_job_offer`,`id_skill`),
  KEY `hold_skills0_FK` (`id_skill`),
  CONSTRAINT `hold_job_offers_FK` FOREIGN KEY (`id_job_offer`) REFERENCES `job_offers` (`id_job_offer`),
  CONSTRAINT `hold_skills0_FK` FOREIGN KEY (`id_skill`) REFERENCES `skills` (`id_skill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hold`
--

LOCK TABLES `hold` WRITE;
/*!40000 ALTER TABLE `hold` DISABLE KEYS */;
/*!40000 ALTER TABLE `hold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_offers`
--

DROP TABLE IF EXISTS `job_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job_offers` (
  `id_job_offer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `wage` bigint(20) NOT NULL,
  `id_compagny` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_job_offer`),
  KEY `job_offers_compagnies_FK` (`id_compagny`),
  CONSTRAINT `job_offers_compagnies_FK` FOREIGN KEY (`id_compagny`) REFERENCES `compagnies` (`id_compagny`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_offers`
--

LOCK TABLES `job_offers` WRITE;
/*!40000 ALTER TABLE `job_offers` DISABLE KEYS */;
INSERT INTO `job_offers` VALUES (6,'developpeur fullstack','5 ans d experience, connaissance de docker et sql',35000,2),(7,'expert java/hibernate','15 ans d experience',75000,2),(8,'graphiste','connaissance de photoshop, post en télétravail',30000,3),(9,'chef de projet','etre capable de gerer une equipe de 12 personnes travaillant sur des sites differents',55000,3),(10,'ingenieur big data','maitrise de techno big data, expert en mathematique',105000,2);
/*!40000 ALTER TABLE `job_offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receive`
--

DROP TABLE IF EXISTS `receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receive` (
  `id_education` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_education`,`id_user`),
  KEY `receive_users0_FK` (`id_user`),
  CONSTRAINT `receive_educations_FK` FOREIGN KEY (`id_education`) REFERENCES `educations` (`id_education`),
  CONSTRAINT `receive_users0_FK` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receive`
--

LOCK TABLES `receive` WRITE;
/*!40000 ALTER TABLE `receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `skills` (
  `id_skill` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  PRIMARY KEY (`id_skill`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (2,'java'),(3,'c'),(4,'objective c'),(5,'android'),(6,'architecture'),(7,'social network'),(8,'haskell'),(9,'solidity');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `birthday` varchar(12) NOT NULL,
  `city` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'david','leau','12-10-1970','bruxelles','david.leau@gmail.com','04-56-11-67-78','je suis passionné par les nouvelles technologies'),(2,'yohannes','dies','01-03-1993','paris','yohannes.dies@live.com','03-56-11-67-78','je veux travailler sur un sujet innovant'),(3,'abdel','chilou','12-10-1994','lille','abdel.chilou.pro@gmail.com','06-28-15-67-71','je recherche une mission en tant que business analyst.'),(4,'xu','chian','12-10-1988','paris','chain.xu@icloud.com','06-59-11-67-38','je suis expert en finance');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 17:22:40
