-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: mysql
-- ------------------------------------------------------
-- Server version	5.7.25-google-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `legalaidcamp`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `legalaidcamp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `legalaidcamp`;

--
-- Table structure for table `areasoflaw`
--

DROP TABLE IF EXISTS `areasoflaw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areasoflaw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `areaOfLaw` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areasoflaw`
--

LOCK TABLES `areasoflaw` WRITE;
/*!40000 ALTER TABLE `areasoflaw` DISABLE KEYS */;
INSERT INTO `areasoflaw` VALUES (1,'Banking & Finance Laws'),(2,'Contract Laws'),(3,'Corporate and Commercial Laws'),(4,'Civil Laws'),(5,'Company Laws'),(6,'Consumer Protection Laws'),(7,'Criminal Laws'),(8,'Environmental  Laws'),(9,'Labor & Employment Laws'),(10,'Motor Vehicle Laws'),(11,'Family and Succession Laws'),(12,'Property Laws'),(13,'Insurance Laws'),(14,'Intellectual Property Laws'),(15,'Tax Laws'),(16,'Others');
/*!40000 ALTER TABLE `areasoflaw` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barcouncils`
--

DROP TABLE IF EXISTS `barcouncils`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barcouncils` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barCouncil` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barcouncils`
--

LOCK TABLES `barcouncils` WRITE;
/*!40000 ALTER TABLE `barcouncils` DISABLE KEYS */;
INSERT INTO `barcouncils` VALUES (1,'Bar Council of Andhra Pradesh'),(2,'Bar Council of Assam, Nagaland, Mizoram, Arunachal Pradesh & Sikkim'),(3,'Bar Council of Bihar'),(4,'Bar Council of Chhattisgarh'),(5,'Bar Council of Delhi'),(6,'Bar Council of Gujarat'),(7,'Bar Council of Himachal Pradesh'),(8,'Bar Council of Jharkhand'),(9,'Bar Council of Karnataka'),(10,'Bar Council of Kerala'),(11,'Bar Council of Madhya Pradesh'),(12,'Bar Council of Maharashtra & Goa'),(13,'Bar Council of Manipur'),(14,'Bar Council of Odhisa'),(15,'Bar Council of Punjab & Haryana'),(16,'Bar Council of Rajasthan'),(17,'Bar Council of Tamil Nadu'),(18,'Bar Council of Tripura'),(19,'Bar Council of Uttar Pradesh'),(20,'Bar Council of Uttarakhand'),(21,'Bar Council of West Bengal'),(22,'High Court of Jammu and Kashmir'),(23,'Meghalaya State Bar Council');
/*!40000 ALTER TABLE `barcouncils` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `languages`
--

DROP TABLE IF EXISTS `languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `languages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `language` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `languages`
--

LOCK TABLES `languages` WRITE;
/*!40000 ALTER TABLE `languages` DISABLE KEYS */;
INSERT INTO `languages` VALUES (1,'English'),(2,'Assamese'),(3,'Bengali'),(4,'Bodo'),(5,'Dogri'),(6,'Gujarati'),(7,'Hindi'),(8,'Kannada'),(9,'Kashmiri'),(10,'Konkani'),(11,'Maithili'),(12,'Malayalam'),(13,'Meitei'),(14,'Marathi'),(15,'Nepali'),(16,'Odia'),(17,'Punjabi'),(18,'Sanskrit'),(19,'Santali'),(20,'Sindhi'),(21,'Tamil'),(22,'Telugu'),(23,'Urdu'),(24,'Angika'),(25,'Banjara'),(26,'Bajjika'),(27,'Bishnupriya'),(28,'Bhojpuri'),(29,'Ladakhi'),(30,'Bhotia'),(31,'Bundelkhandi'),(32,'Chhattisgarhi'),(33,'Dhatki'),(34,'Indian English'),(35,'Indian French'),(36,'Garhwali (Pahari)'),(37,'Garo'),(38,'Gondi'),(39,'Gujjar/Gujjari'),(40,'Haryanvi'),(41,'Ho'),(42,'Kachchhi'),(43,'Kamtapuri'),(44,'Karbi'),(45,'Khasi'),(46,'Kodava (Coorgi)'),(47,'Kokborok'),(48,'Kumaoni (Pahari)'),(49,'Kurukh'),(50,'Kurmali'),(51,'Lepcha'),(52,'Limbu'),(53,'Magahi'),(54,'Mizo (Lushai)'),(55,'Mundari'),(56,'Nagpuri'),(57,'Nicobarese'),(58,'Himachali'),(59,'Pali'),(60,'Rajbanshi'),(61,'Rajasthani'),(62,'Sambalpuri/kosali'),(63,'Shauraseni (Prakrit)'),(64,'Siraiki'),(65,'Sylheti'),(66,'Tenyidie'),(67,'Tulu');
/*!40000 ALTER TABLE `languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(200) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Andaman and Nicobar Islands','UT'),(2,'Andhra Pradesh','State'),(3,'Arunachal Pradesh','State'),(4,'Assam','State'),(5,'Bihar','State'),(6,'Chandigarh','UT'),(7,'Chhattisgarh','State'),(8,'Dadar and Nagar Haveli','UT'),(9,'Daman and Diu','UT'),(10,'Delhi','UT'),(11,'Goa','State'),(12,'Gujarat','State'),(13,'Haryana','State'),(14,'Himachal Pradesh','State'),(15,'Jammu and Kashmir','UT'),(16,'Jharkhand','State'),(17,'Karnataka','State'),(18,'Kerala','State'),(19,'Ladakh','UT'),(20,'Lakshadweep','UT'),(21,'Madya Pradesh','State'),(22,'Maharashtra','State'),(23,'Manipur','State'),(24,'Meghalaya','State'),(25,'Mizoram','State'),(26,'Nagaland','State'),(27,'Orissa','State'),(28,'Puducherry','UT'),(29,'Punjab','State'),(30,'Rajasthan','State'),(31,'Sikkim','State'),(32,'Tamil Nadu','State'),(33,'Telangana','State'),(34,'Tripura','State'),(35,'Uttar Pradesh','State'),(36,'Uttaranchal','State'),(37,'West Bengal','State');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 20:54:40
