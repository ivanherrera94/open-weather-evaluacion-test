-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: bitacora
-- ------------------------------------------------------
-- Server version	8.0.26-google

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
-- Table structure for table `bitacora_weather`
--

DROP TABLE IF EXISTS `bitacora_weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacora_weather` (
  `id_bitacora` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  `temp` decimal(10,2) DEFAULT NULL,
  `temp_min` decimal(10,2) DEFAULT NULL,
  `temp_max` decimal(10,2) DEFAULT NULL,
  `pressure` bigint DEFAULT NULL,
  `humidity` bigint DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  PRIMARY KEY (`id_bitacora`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora_weather`
--

LOCK TABLES `bitacora_weather` WRITE;
/*!40000 ALTER TABLE `bitacora_weather` DISABLE KEYS */;
INSERT INTO `bitacora_weather` VALUES (1,'Aguascalientes',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Aguascalientes','MX',27.00,27.00,27.00,1007,23,'2022-05-19 23:58:09'),(3,'Guadalajara','MX',34.43,34.43,34.43,841,10,'2022-05-20 00:01:09'),(4,'Aguascalientes','MX',30.97,30.97,30.97,1016,11,'2022-05-20 00:06:28'),(5,'London','GB',14.19,12.25,15.64,1021,65,'2022-05-20 00:06:38'),(6,'Sydney','AU',12.82,10.69,14.79,1027,90,'2022-05-20 00:06:47'),(7,'Houston','US',29.33,27.72,31.30,1004,65,'2022-05-20 00:06:56'),(8,'Chicago','US',29.01,25.37,31.04,998,34,'2022-05-20 00:07:16'),(9,'Hawaii','US',28.80,28.25,30.59,1017,72,'2022-05-20 00:15:16'),(10,'London','GB',14.19,12.25,15.64,1021,65,'2022-05-20 00:15:26'),(11,'Italy','IT',11.84,8.85,12.63,1028,65,'2022-05-20 00:15:34'),(12,'Cancún','MX',27.96,27.81,27.96,1011,78,'2022-05-20 00:15:47'),(13,'Acapulco de Juárez','MX',28.90,28.90,28.90,1008,61,'2022-05-20 00:16:00'),(14,'Oaxaca City','MX',27.90,27.90,27.90,1017,21,'2022-05-20 00:16:59'),(15,'Cameroon','CM',18.96,18.96,18.96,1013,98,'2022-05-20 00:17:07'),(16,'Germany','DE',14.84,13.92,16.38,1021,98,'2022-05-20 00:17:19'),(17,'Bogota','CO',12.73,12.73,12.73,1028,94,'2022-05-20 00:17:33'),(18,'Cuba','CU',25.34,25.34,25.34,1015,83,'2022-05-20 00:17:39'),(19,'Aguascalientes','MX',28.97,28.97,28.97,1016,14,'2022-05-20 01:23:10'),(20,'Aguascalientes','MX',28.97,28.97,28.97,1016,14,'2022-05-20 01:38:56');
/*!40000 ALTER TABLE `bitacora_weather` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bitacora'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-19 20:51:54
