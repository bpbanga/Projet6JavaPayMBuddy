CREATE DATABASE  IF NOT EXISTS `projet6` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projet6`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: projet6
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friend` (
  `id_issuer` int NOT NULL,
  `id_recipient` int NOT NULL,
  KEY `FKn392ub9371b21brsinau1p2s2` (`id_recipient`),
  KEY `FK7otvefe4ugelcmtjyrxepsv7p` (`id_issuer`),
  CONSTRAINT `FK7otvefe4ugelcmtjyrxepsv7p` FOREIGN KEY (`id_issuer`) REFERENCES `user` (`id`),
  CONSTRAINT `FKn392ub9371b21brsinau1p2s2` FOREIGN KEY (`id_recipient`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` VALUES (1,2),(1,3),(1,4),(2,3),(2,4),(4,4),(4,5),(5,4),(5,1),(5,3),(52,3),(52,1),(52,5),(3,4),(3,5);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `amount_asked` float DEFAULT NULL,
  `amount_commission` float DEFAULT NULL,
  `issuer_id` int DEFAULT NULL,
  `recipient_id` int DEFAULT NULL,
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `type_transaction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FKeqn08pu015d3kixscqflmqh4f` (`issuer_id`),
  KEY `FKqnjjtp92qdclfkgp1qmi5nxm4` (`recipient_id`),
  CONSTRAINT `FKeqn08pu015d3kixscqflmqh4f` FOREIGN KEY (`issuer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqnjjtp92qdclfkgp1qmi5nxm4` FOREIGN KEY (`recipient_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (20,1,1,2,1,'Rstaurant bill share','payment'),(10,2,1,3,2,'Trip  money','payment'),(15,2,1,4,3,'Movie ticket ','payment'),(41,2.05,5,1,9,'Tickets restau','virement'),(10,0.5,5,3,11,'Tickets restau','virement'),(10,0.5,5,4,18,'Tickets restau','virement'),(0,0,5,1,39,'Tickets restau','virement'),(10,0.5,5,4,40,'Tickets restau','virement'),(10,0.5,5,3,41,'Transfert','virement');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account_balance` float DEFAULT NULL,
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rib` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1.65,1,'hayley@gmail.com','Hayley','$2a$10$SGZF5AgJBqVm/5Ck3gD3N.9ubsIsL55ubbwyz6MV2LHJMkM6aa9Yi','123456'),(420,2,'sam@gmail.com','Sam','$2a$10$v7QT2TKYfkLVd9rvxPAcEupDICBh/54BaZ.3oywm2PeiD9e4xD5au','026741'),(138,3,'clara@gmail.com','Clara','$2a$10$rQTHNMQe1rtA/cV5YQuI3O0HwRj0Szeoqm38OtBLgjmBbIYW7T14y','654321'),(330.25,4,'smith@gmail.com','Smith','$2a$10$l8bBb0i2HQ1p/YZr43q/buKcwkD9WhOdJ1U5ZqSnmGaGnDXaAu9Xi','987654'),(788.5,5,'nathan@gmail.com','Nathan','$2a$10$N..JwVroIl7jop5ED5NeLOuwMwdOV91r.f7KSpZzOIXdoV4gHbXR2','486248'),(56.5,52,'pages@tchana.com','pages','$2a$10$0LZkqhqxLVOFF/DP60gmE.IC8fhbHGfVOnf3xyO6BBVBg8gtuxIC2','654321');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (301);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-09 21:10:31
