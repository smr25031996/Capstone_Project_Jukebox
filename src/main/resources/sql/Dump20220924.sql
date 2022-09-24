-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kgf`
--

drop table IF EXISTS `kgf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `kgf` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(50) DEFAULT NULL,
  `artist_name` varchar(50) DEFAULT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `song_genre` varchar(50) DEFAULT NULL,
  `song_duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kgf`
--

lock TABLES `kgf` WRITE;
/*!40000 ALTER TABLE `kgf` DISABLE KEYS */;
insert into `kgf` VALUES (4,'Dil_Se_Re','A_R_Rehman','Dil_Se','Golden_Era','0:30'),(6,'Airanichya_deva','Lata_Didi','Marathi_Hits','Marathi','3:25');
/*!40000 ALTER TABLE `kgf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songslist`
--

drop table IF EXISTS `songslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `songslist` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(50) DEFAULT NULL,
  `artist_name` varchar(50) DEFAULT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `song_genre` varchar(50) DEFAULT NULL,
  `song_duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songslist`
--

lock TABLES `songslist` WRITE;
/*!40000 ALTER TABLE `songslist` DISABLE KEYS */;
insert into `songslist` VALUES (1,'Ajeeb_Dasta','Lata','Shankar_Music','OldSongs','0:30'),(2,'Matargashti','Mohit_Chauhan','Tamasha','Party','0:30'),(3,'Mere_Sapnon','Kishore_Kumar','Aradhana','Retro','0:30'),(4,'Dil_Se_Re','A_R_Rehman','Dil_Se','Golden_Era','0:30'),(5,'Agar_Tum_Saath_Ho','Arijit_Singh','Tamasha','Modern','0:30'),(6,'Airanichya_deva','Lata_Didi','Marathi_Hits','Marathi','3:25'),(7,'Yeh_Kya_Hua','Rajesh_Khanna','Amar_Prem','Hindi_Retro','0:30'),(8,'Jai_Ho','Sukhvindar','Slumdog','Hits','0:30'),(9,'Yeh_Jo_Mohabbat','Kishore ','Kati_Patang','Retro','0:30'),(10,'Kabhi_Neem_Neem','Madhushree','Yuva','Bollywood','0:30');
/*!40000 ALTER TABLE `songslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ygujs`
--

drop table IF EXISTS `ygujs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `ygujs` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(50) DEFAULT NULL,
  `artist_name` varchar(50) DEFAULT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `song_genre` varchar(50) DEFAULT NULL,
  `song_duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ygujs`
--

lock TABLES `ygujs` WRITE;
/*!40000 ALTER TABLE `ygujs` DISABLE KEYS */;
insert into `ygujs` VALUES (3,'Mere_Sapnon','Kishore_Kumar','Aradhana','Retro','0:30');
/*!40000 ALTER TABLE `ygujs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yut`
--

drop table IF EXISTS `yut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
create TABLE `yut` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(50) DEFAULT NULL,
  `artist_name` varchar(50) DEFAULT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `song_genre` varchar(50) DEFAULT NULL,
  `song_duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yut`
--

lock TABLES `yut` WRITE;
/*!40000 ALTER TABLE `yut` DISABLE KEYS */;
insert into `yut` VALUES (6,'Airanichya_deva','Lata_Didi','Marathi_Hits','Marathi','3:25'),(7,'Yeh_Kya_Hua','Rajesh_Khanna','Amar_Prem','Hindi_Retro','0:30');
/*!40000 ALTER TABLE `yut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'jukebox'
--

--
-- Dumping routines for database 'jukebox'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-24 16:48:58
