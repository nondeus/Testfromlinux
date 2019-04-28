CREATE DATABASE  IF NOT EXISTS `travelman` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `travelman`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: travelman
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `choferes`
--

DROP TABLE IF EXISTS `choferes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choferes` (
  `CPK_id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) DEFAULT NULL,
  `NumeroTelefonico` varchar(15) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Tipodelicencia` varchar(5) DEFAULT NULL,
  `Disponible` tinyint(4) NOT NULL,
  PRIMARY KEY (`CPK_id`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choferes`
--

LOCK TABLES `choferes` WRITE;
/*!40000 ALTER TABLE `choferes` DISABLE KEYS */;
INSERT INTO `choferes` VALUES (1,'No asignado','0000000','no@informacion.com',NULL,0),(2,'Franklin Leiton','8929-0606','null','null',1),(3,'Jason Jimenez ','7202-9597','null','null',1),(4,'Julio Aguilar','8930-4854','null','null',1),(5,'Rodolfo Mofdgdfg','7159-5997','null','null',1),(6,'Roger Calderon','6208-9277','null','null',1),(7,'Ronald Hernandez','8945-8304','null','null',1),(8,'Diego Fernandez','6282-1750','null','null',1),(9,'Juan Alberto ','7028-4565','null','null',1),(10,'Maynor Obando ','5009-5313','null',NULL,0),(11,'Orlando','83940606','noinfo@KWT.com',NULL,1);
/*!40000 ALTER TABLE `choferes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ClientePK` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) DEFAULT NULL,
  `Tipo` enum('Particular','Empresa') DEFAULT NULL,
  `Numero_telefonico` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`ClientePK`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'PUBLIMARK',NULL,NULL),(3,'ASSA Compañia de seguros S.A.',NULL,NULL),(4,'MONICA MALAVASSI',NULL,NULL),(12,'Jimmy Mora',NULL,NULL),(13,'Banco de Costa Rica',NULL,NULL),(14,'test',NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarios` (
  `id_comentario` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` text,
  `Fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `User_id` int(11) DEFAULT NULL,
  `Tiquete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_comentario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (1,'','2017-12-26 20:30:05',1,1),(2,'COBRO POR MES','2018-02-02 16:56:08',0,2),(3,'Seguir la ruta solicitada','2018-02-13 16:49:48',0,3),(4,'Numero de oficina 25032745','2018-02-17 11:12:18',1,3),(5,'Actualizacion','2018-02-17 11:18:01',0,3),(6,'','2018-02-17 11:49:45',0,4),(7,'','2018-02-17 11:51:29',0,4),(8,'Numero de oficina 25032745','2018-02-17 11:52:34',0,4),(9,'','2018-02-17 12:05:53',0,4),(10,'','2018-02-17 12:28:03',0,4),(11,'Solo Dejar en SJ','2018-02-17 12:42:26',0,5),(12,'','2018-02-17 12:49:32',0,5),(13,'TWETWETWEWETTWETWETWETWETWTETWETWETWETWET','2018-09-07 18:57:05',1,6),(14,'steststeetstt','2018-09-09 18:55:31',1,7),(15,'asdasd','2018-09-09 19:47:34',1,8),(16,'sdfsf','2018-09-09 20:28:37',1,9),(17,'Efectivo tiene dos encargados el secondo es juan 87874949','2018-09-23 08:04:01',1,10),(18,'tes','2018-10-27 11:41:15',1,11),(19,'tetsetsetsetset','2018-10-27 12:21:59',1,11),(20,'','2018-10-28 17:04:51',1,12);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encargado`
--

DROP TABLE IF EXISTS `encargado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encargado` (
  `EncargadoPK` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Empresa` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Numero_telefonico_uno` varchar(15) DEFAULT NULL,
  `Numero_telefonico_dos` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`EncargadoPK`),
  KEY `Cliente_Reference_idx` (`Id_Empresa`),
  CONSTRAINT `Cliente_Reference` FOREIGN KEY (`Id_Empresa`) REFERENCES `cliente` (`ClientePK`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encargado`
--

LOCK TABLES `encargado` WRITE;
/*!40000 ALTER TABLE `encargado` DISABLE KEYS */;
INSERT INTO `encargado` VALUES (1,1,'test','sdfsfdsfdfsdffdsfds','34343466',NULL),(2,2,'MELISSA HERRERA','mherrera@publimark.co.cr','2228-2038',NULL),(3,2,'MELISSA HERRERA','mherrera@publimark.co.cr','2228-2038',NULL),(4,3,'Tatiana Meza','noinfo@email.com','70139208',NULL),(5,6,'Josimar Castillo','test@gmail.com','22756572',NULL),(6,10,'njnjjnj','hgcfgc@nñkjn.com','1234556',NULL),(7,12,'Jimmy Mora','noinfo@KWT.com','83940606',NULL),(8,14,'df','n','5555555',NULL);
/*!40000 ALTER TABLE `encargado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encargado_contacto`
--

DROP TABLE IF EXISTS `encargado_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encargado_contacto` (
  `ID_encargadosdeviaje` int(11) NOT NULL AUTO_INCREMENT,
  `Creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ID_Empresa` int(11) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`ID_encargadosdeviaje`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encargado_contacto`
--

LOCK TABLES `encargado_contacto` WRITE;
/*!40000 ALTER TABLE `encargado_contacto` DISABLE KEYS */;
INSERT INTO `encargado_contacto` VALUES (1,'2018-01-16 17:47:00',2,'MELISSA HERRERA','2228-2038'),(2,'2018-09-08 00:55:46',3,'TESTSETST','45454545'),(3,'2018-10-27 17:37:55',14,'test','15151515');
/*!40000 ALTER TABLE `encargado_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `records` (
  `id_records` int(11) NOT NULL AUTO_INCREMENT,
  `id_role` int(11) NOT NULL,
  `Lugar_Destino` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Lugar_Salida` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Cantidad_Pasajeros` int(11) NOT NULL,
  `id_Cliente` int(11) DEFAULT NULL,
  `Hora_Salida` datetime DEFAULT NULL,
  `Hora_Destino` datetime DEFAULT NULL,
  `Unidad_ID` int(11) NOT NULL,
  `Notas` varchar(700) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Cobrar` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Regreso` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Estado` enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado') COLLATE utf8_spanish_ci DEFAULT NULL,
  `Fecha_Pendiente` date DEFAULT NULL,
  `moneda` int(11) DEFAULT NULL,
  `MPago` int(11) DEFAULT NULL,
  `Creado` datetime DEFAULT NULL,
  `Monto_Adelanto` double DEFAULT NULL,
  `Contacto_ID` int(11) DEFAULT NULL,
  `FechaMax` date DEFAULT NULL,
  `Chofer_ID` int(11) NOT NULL,
  `Recorrido_C` varchar(400) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id_records`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `Role_id` int(11) NOT NULL AUTO_INCREMENT,
  `Lugar_Destino` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Lugar_Salida` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Cantidad_Pasajeros` int(11) NOT NULL,
  `id_Cliente` int(11) DEFAULT NULL,
  `Hora_Salida` datetime DEFAULT NULL,
  `Hora_Destino` datetime DEFAULT NULL,
  `Unidad_ID` int(11) NOT NULL,
  `Notas` varchar(700) CHARACTER SET utf8 DEFAULT NULL,
  `Cobrar` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Regreso` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Estado` enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado') CHARACTER SET utf8 DEFAULT NULL,
  `Fecha_Pendiente` date DEFAULT NULL,
  `moneda` int(11) DEFAULT NULL,
  `MPago` int(11) DEFAULT NULL,
  `Creado` datetime DEFAULT NULL,
  `Monto_Adelanto` double DEFAULT NULL,
  `Contacto_ID` int(11) DEFAULT NULL,
  `FechaMax` date DEFAULT NULL,
  `Chofer_ID` int(11) NOT NULL,
  `Recorrido_C` varchar(400) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Role_id`),
  KEY `referencia encargado_idx` (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'PUBLIMARK PLAZA TEMPO','COSTADO SUR DEL PARQUE NACIONAL',45000,25,3,'2018-02-05 07:00:00','2018-02-05 17:15:00',5,'N/A','NO GRACIAS','5 30PM','P. de facturación','2018-02-02',0,1,'2018-02-02 16:56:08',0,1,'2018-03-09',6,'REALIZAR EL RECORRIDO CONOCIDO'),(3,'ASSA Compañia de seguros S.A. / Santa Ana Forum 1, edificio F - ','San Jose, De la farmacia fischel 25 Oeste frente entrada banco Nacional',50000,27,3,'2018-02-14 07:00:00','2018-02-14 17:15:00',11,'Seguir la ruta solicitada','No Cobra','5:15pm','P. de facturación','2018-02-14',0,1,'2018-02-13 16:49:48',10000,0,'2018-03-14',6,'Regreso Parada Sabana, Parque Cenral y la CCSS'),(4,'Santa Ana Forum 1 Edificio F - Regreso - Paradas Sabana - Parque Central  - CCSS','De la Faramacia Fischel 25 Oeste, Frente entrada Banco Nacional',50000,27,4,'2018-02-19 07:00:00','2018-02-19 17:15:00',5,'Seguir Ruta','No gracias','Espera y Regresa','P. de facturación','2018-02-17',0,1,'2018-02-17 11:49:45',0,0,'2018-03-16',6,'Paradas Sabana - Parque Central  - CCSS'),(5,'San Jose','Pavas Uribali',15000,14,7,'2018-02-12 22:00:00','2018-02-12 22:00:00',5,'Viaje añadido en la noche','No gracias','Dejar','P. de pago','2018-02-17',0,1,'2018-02-17 12:42:26',0,0,'2018-03-17',11,'Solo dejar'),(6,'SETSETSETST','SETSETSET',100000,5,4,'2018-09-07 01:00:00','2018-09-07 14:15:00',14,'SETSTESETTS','TEST','TESTSETSET','P. de facturación','2018-09-07',0,0,'2018-09-07 18:57:05',0,2,'2018-09-07',2,'TESTSETESTSETSETSETSETSETESETSETSTESTE'),(7,'dsd','sd',150000,20,2,'2018-09-09 01:00:00','2018-09-09 01:00:00',5,'sd','yrs','s','P. de facturación','2018-09-09',0,0,'2018-09-09 18:55:31',0,1,'2018-09-09',2,'test'),(8,'sdf','ds',150000,20,3,'2018-09-09 01:00:00','2018-09-11 01:00:00',5,'sd','s','s','P. de facturación','2018-09-09',0,0,'2018-09-09 19:47:34',0,1,'2018-09-14',3,'asda'),(9,'xbxcbfx','fcgxgfx',1500,10,4,'2018-09-16 01:00:00','2018-09-23 01:00:00',5,'xcvbxcb','cbxgb','xcfg','P. de facturación','2018-09-09',0,0,'2018-09-09 20:28:37',30000,2,'2018-09-09',2,'vb'),(10,'Guanacaste huacas','San jose',80000,10,4,'2018-09-24 04:00:00','2018-09-25 19:00:00',5,'cobrar si','si','No','P. de pago','2018-09-26',0,0,'2018-09-23 08:04:01',0,2,'2018-09-26',3,'una parada en puntarenas'),(11,'b','b',80000,19,8,'2018-10-27 08:00:00','2018-10-27 12:00:00',5,'b','b','b','Confirmado','2018-10-27',0,0,'2018-10-27 11:41:15',40000,3,'2018-11-30',4,'no'),(12,'hj','jh',40000,19,8,'2018-10-28 01:00:00','2018-11-09 01:00:00',5,'hj','h','h','P. de facturación','2018-10-28',0,0,'2018-10-28 17:04:51',20000,3,'2018-11-10',4,'test');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad` (
  `PK` int(11) NOT NULL AUTO_INCREMENT,
  `Unidad` varchar(5) DEFAULT NULL,
  `Marca` varchar(255) DEFAULT NULL,
  `Tipo` enum('Buseta','Autobus','Microbus') DEFAULT NULL,
  `Aire_a` enum('Si','No') DEFAULT NULL,
  `Estado` enum('Funcional','Taller') DEFAULT NULL,
  `Pasajeros` int(11) NOT NULL,
  `Dueno` enum('KWT','Proveedor') DEFAULT NULL,
  `Nombre_Proveedor` varchar(255) DEFAULT NULL,
  `bano` enum('Si','No') DEFAULT NULL,
  PRIMARY KEY (`PK`),
  UNIQUE KEY `Unidad_UNIQUE` (`Unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` VALUES (1,'K6','IRIZAR VM','Buseta','Si','Funcional',40,'KWT','KAWASMY','Si'),(2,'K7','VOLVO B7 R','Buseta','No','Funcional',40,'KWT','KAWASMY','No'),(3,'K8','SCANIA','Autobus','No','Funcional',59,'KWT','KAWASMY','No'),(4,'K9','SCANIA','Autobus','No','Funcional',59,'KWT','KAWASMY','No'),(5,'K11','COASTER','Microbus','Si','Funcional',27,'KWT','KAWASMY','No'),(6,'K12','HIACE','Microbus','Si','Funcional',14,'KWT','KAWASMY','No'),(7,'K13','GOLDEN DRAGON','Microbus','Si','Funcional',14,'KWT','KAWASMY','No'),(8,'K14','COASTER','Microbus','Si','Taller',27,'KWT','KAWASMY','No'),(9,'K15','HIACE','Microbus','Si','Funcional',14,'KWT','KAWASMY','No'),(10,'K16','SCANIA','Autobus','No','Funcional',59,'KWT','KAWASMY','No'),(11,'K17','COASTER','Microbus','Si','Funcional',27,'KWT','KAWASMY','No'),(12,'K18','SCANIA','Autobus','No','Funcional',59,'KWT','KAWASMY','No'),(13,'K20','SCANIA','Microbus','Si','Funcional',55,'KWT','KAWASMY','No'),(14,'K21','IRIZAR-VOLKSWAGEN','Microbus','Si','Funcional',50,'KWT','KAWASMY','Si'),(15,'K22','COAS','Microbus','Si','Funcional',25,'KWT','KAWASMY','No');
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`Testing`@`%`*/ /*!50003 TRIGGER `travelman`.`unidad_AFTER_INSERT` AFTER INSERT ON `unidad` FOR EACH ROW
BEGIN
if (select count(*) from choferes )=0
then 
call Insert_choferes('No asignado','0000000','no@informacion.com',0);
end if ;
Insert into Unidad_Choferes (ID_Unidad,ID_Chofer_1,ID_Chofer_2) values(new.PK,1,1);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

--
-- Table structure for table `unidad_choferes`
--

DROP TABLE IF EXISTS `unidad_choferes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_choferes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Unidad` int(11) NOT NULL,
  `ID_Chofer_1` int(11) DEFAULT NULL,
  `ID_Chofer_2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_choferes`
--

LOCK TABLES `unidad_choferes` WRITE;
/*!40000 ALTER TABLE `unidad_choferes` DISABLE KEYS */;
INSERT INTO `unidad_choferes` VALUES (1,11,1,1),(2,1,1,1),(3,2,1,1),(4,3,1,1),(5,4,1,1),(6,5,1,1),(7,6,1,1),(8,7,1,1),(9,8,1,1),(10,9,1,1),(11,10,1,1),(12,11,1,1),(13,12,1,1),(14,13,1,1),(15,14,1,1),(16,15,1,1),(17,1,1,1),(18,2,1,1),(19,3,1,1),(20,4,1,1),(21,5,1,1),(22,6,1,1),(23,7,1,1),(24,8,1,1),(25,9,1,1),(26,10,1,1),(27,11,1,1),(28,12,1,1),(29,13,1,1),(30,14,1,1),(31,15,1,1);
/*!40000 ALTER TABLE `unidad_choferes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Usuario` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `Contraseña` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `Correo` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Administrar_Usuarios` tinyint(1) DEFAULT NULL,
  `Cliente` tinyint(1) DEFAULT NULL,
  `Role` tinyint(1) DEFAULT NULL,
  `Unidad_Choferes` tinyint(1) DEFAULT NULL,
  `Active_account` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Administrador','Admin','Password1',NULL,1,1,1,1,1),(4,'Rocio','Rocio','Test123123','rocio.test@info.com',0,1,1,1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'travelman'
--

--
-- Dumping routines for database 'travelman'
--
/*!50003 DROP PROCEDURE IF EXISTS `buscaruser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `buscaruser`(in Nombreb varchar(255))
BEGIN
Select * from users where Nombre like concat('%',Nombreb,'%')COLLATE utf8_bin;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkuserpass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkuserpass`(in usuariob varchar(60),in Contraseñab varchar(16))
BEGIN
SELECT IF(count(Usuario)>0, 'true','false') as bol,Id_Usuario,Administrar_Usuarios,Cliente, Role, Unidad_Choferes,Active_account from users where  Usuario=usuariob COLLATE utf8_bin and Contraseña=Contraseñab COLLATE utf8_bin;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ConsumoXCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `ConsumoXCliente`(in Principio Date,in Final date)
BEGIN
select 
(select Nombre_Empresa.Nombre from encargado inner join Cliente as Nombre_Empresa
on encargado.Id_Empresa =Nombre_Empresa.ClientePK where id_Cliente=EncargadoPK) as Entidad,
Lugar_Destino,
Transporte.Unidad,
Cantidad_Pasajeros,
Nombre,
MPago as Forma_Pago,
Precio,
Moneda
 
 from role 
 
inner join encargado 
on encargado.EncargadoPK=role.id_Cliente
inner join Unidad as Transporte 
on Transporte.PK=role.Unidad_ID
where Hora_Salida between Principio and  (SELECT ADDTIME(Final ,'23:59:59'))
order by Entidad;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Consumo_Mensual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Consumo_Mensual`(in Principio Date,in Final date)
BEGIN
select 
Transporte.Unidad,
sum(Precio),moneda
from role
inner join Unidad as Transporte 
on Transporte.PK=role.Unidad_ID
where Hora_Salida between Principio and  (SELECT ADDTIME(Final ,'23:59:59'))
GROUP BY CONCAT(Unidad,Moneda);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Create_DefaultUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Create_DefaultUser`()
BEGIN
insert into users (Nombre,Usuario,Contraseña,Administrar_Usuarios,Cliente,Role,Unidad_Choferes,Active_account) values ('Administrador','Admin','Password1',1,1,1,1,1);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Create_User` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Create_User`(in NUsuario varchar(255),in Us varchar(60),in Contraseña varchar(16),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean,in accountlife boolean)
BEGIN

IF NOT EXISTS (SELECT distinct Usuario from Users where Usuario=Us) 
then 
INSERT INTO Users(Nombre,Usuario,Contraseña,Correo,Administrar_Usuarios,Role,Unidad_Choferes,Active_account) values (NUsuario,Us,Contraseña,Correo,Administrar_Usuarios1,Role1,Unidad_Choferes1,accountlife);

end If;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Create_User_JavaFx` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Create_User_JavaFx`(in NUsuario varchar(255),in Us varchar(60),in Contraseña varchar(16),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean,in Reportes boolean,in AccountLive boolean)
BEGIN

IF NOT EXISTS (SELECT distinct Usuario from Users where Usuario=Us collate utf8_general_ci) 
then 
INSERT INTO Users(Nombre,Usuario,Contraseña,Correo,Administrar_Usuarios,Role,Unidad_Choferes,Cliente,Active_account) values (NUsuario,Us,Contraseña,Correo,Administrar_Usuarios1,Role1,Unidad_Choferes1,Reportes,AccountLive);

end If;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Filterchoferes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Filterchoferes`(in NombreB varchar(255))
BEGIN
Select CPK_id,Nombre,Disponible from choferes
where Lower(Nombre) like concat('%',Lower(NombreB),'%') COLLATE utf8_bin and Disponible=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filterempresas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `filterempresas`(in NEmpresa varchar(255))
BEGIN

Select ClientePK,Nombre from cliente where nombre like concat('%',NEmpresa,'%') COLLATE utf8_bin ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Filter_Unidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Filter_Unidad`(in Aire_b enum('Si','No'),in Pasajerosmenor int,in Toilet enum('Si','No'))
BEGIN
select Unidad,PK,Tipo from unidad
where estado='Funcional'  COLLATE utf8_bin and   Pasajeros >= Pasajerosmenor  COLLATE utf8_bin and Aire_a=Aire_b  COLLATE utf8_bin and bano=Toilet collate utf8_bin
order by PK asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetEmpleado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `GetEmpleado`(in EmpresaiD int)
BEGIN
Select * from Encargado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Get_Empresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Get_Empresa`(in NEmpresa varchar(255))
BEGIN
Select * from cliente where lower(nombre)  like  concat('%',Lower(NEmpresa),'%') COLLATE utf8_bin ;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Get_Empresa_WebSite` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Get_Empresa_WebSite`(in NEmpresa varchar(255))
BEGIN
  Select Nombre,ClientePK from cliente where nombre like concat('%',NEmpresa,'%')COLLATE utf8_unicode_ci  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Get_Encargado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Get_Encargado`(in Encargado int)
BEGIN
Select * from encargado where Id_Empresa =Encargado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Get_Encargado_Contacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Get_Encargado_Contacto`(in Encargado int)
BEGIN
Select * from encargado_contacto where ID_Empresa=Encargado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar_Encargado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insertar_Encargado`(in Id_Empresa int,in Nombre varchar(255), in Email varchar(255),in Numero_telefonico_uno varchar(15),in Numero_telefonico_dos varchar(15))
BEGIN
insert into encargado (Id_Empresa,Nombre,Email,Numero_telefonico_uno,Numero_telefonico_dos) values (Id_Empresa,Nombre,Email,Numero_telefonico_uno,Numero_telefonico_dos);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar_Role` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insertar_Role`(in Encargado int,in Uni_chofer int)
BEGIN
insert into role (id_Cliente,Unidad_Chofer_id) values(id_Cliente=Encargado,Unidad_Chofer_id=Uni_chofer);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar_Unidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insertar_Unidad`(in Unidad Varchar(5),in Marca Varchar(255),in Tipo enum('Buseta','Autobus','Microbus'),in Aire_a enum('Si','No'), in Estado enum('Funcional','Taller'),in Pasajeros int,in Nombre_Proveedor varchar(255),in Toilet enum('Si','No'))
BEGIN 
insert into Unidad (Unidad,Marca,Tipo,Aire_a,Estado,Pasajeros,Dueno,Nombre_Proveedor,bano) values (Unidad,Marca,Tipo,Aire_a,Estado,Pasajeros,"KWT",Nombre_Proveedor,Toilet);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertChofers_Unidad` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `InsertChofers_Unidad`(in Unidad int,in CH1 int, in CH2 int)
BEGIN
update Unidad_choferes set ID_Chofer_1=CH1,ID_Chofer_2=CH2 where id=Unidad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_choferes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_choferes`(in Nombre varchar(255),in NumeroTelefonico varchar(9),in Email varchar(255),in Disponible boolean)
BEGIN

insert into Choferes (Nombre,NumeroTelefonico,Email,Disponible) values (Nombre,NumeroTelefonico,Email,Disponible);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_Empresa` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_Empresa`(in nombre varchar(255),in tipo enum('Particular','Empresa'),in numero varchar(9))
BEGIN
insert into Cliente(Nombre,Tipo,Numero_telefonico) values(nombre,tipo,numero);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_Empresa_Contacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_Empresa_Contacto`(in nombre_empresa varchar(255))
BEGIN

insert ignore into Cliente(Nombre) values(nombre_empresa);


/*insert into encargado(Id_Empresa,Nombre,Email,Numero_telefonico_uno) values((select ClientePK from cliente order by clientepK desc limit 1),Nombre_Contacto,Email,numero);*/


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_Encargado_Contacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_Encargado_Contacto`(in IDEmpresa int, in Nom Varchar(255),in Phone Varchar(15) )
BEGIN
	Insert into encargado_contacto(ID_Empresa,Nombre,Telefono) values (IDEmpresa,Nom,Phone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_Only_Encargado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_Only_Encargado`(in id_Empresa int,in Nombre_Contacto varchar(255),in numero varchar(9),in Email varchar(255))
BEGIN
insert into encargado(Id_Empresa,Nombre,Email,Numero_telefonico_uno) values(id_Empresa,Nombre_Contacto,Email,numero);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Insert_Role` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Insert_Role`(in lugar_destinob varchar(255),in lugar_Salidab varchar(255),in preciob double,in Cantidad_pasajerosb int,
in Cliente_idb int,in Inicial datetime,in Destino datetime,in Unidad_IDb int,in Notasb varchar(255), in Cobra varchar(255),in Dregreso varchar(255),
in Estado_Guardar enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado'),in Fecha_p varchar(10),in Money int,in Payment int,
in AdelantoMonto double,
in Contacto_IDb int,in Fecha_Max varchar(10),in Chofer_IDb int,in ComentarioV text,in User_Id int
,in Recorrido_Cb varchar(255))
BEGIN
insert into role (Lugar_Destino, Lugar_Salida, Precio, Cantidad_Pasajeros, id_Cliente,Hora_Salida,Hora_Destino,Unidad_ID,Notas,Cobrar,Regreso,Estado,Fecha_Pendiente
,moneda,MPago,Creado,Monto_Adelanto,Contacto_ID,FechaMax,Chofer_ID,Recorrido_C) 
		  values (lugar_destinob,lugar_Salidab,preciob,Cantidad_pasajerosb,Cliente_idb,Inicial,Destino,Unidad_IDb,Notasb,Cobra,Dregreso,Estado_Guardar,
          (select str_to_date(Fecha_p,"%d/%m/%Y")),Money,Payment,CURRENT_TIMESTAMP,AdelantoMonto,Contacto_IDb,(select str_to_date(Fecha_Max,"%d/%m/%Y")),
          Chofer_IDb,Recorrido_Cb);
insert into comentarios(Comentario,tiquete,User_id) values(ComentarioV,(SELECT Role_id FROM role ORDER BY Role_id DESC LIMIT 1),User_Id);
/*insert into encargadosdeviaje(Nombre,Telefono,role_id_encargados) values(Nombre1,Telefono1,(SELECT Role_id FROM role ORDER BY Role_id DESC LIMIT 1));*/

commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `new_procedure` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `new_procedure`(in Nombreb varchar(255))
BEGIN
Select * from users where Nombre like ('%',Nombreb,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Pendientes_Cobrar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Pendientes_Cobrar`(in Principio Date,in Final date)
BEGIN
select Hora_Salida as Fecha,
Role_id as Caso,
(select Nombre_Empresa.Nombre from encargado inner join Cliente as Nombre_Empresa
on encargado.Id_Empresa =Nombre_Empresa.ClientePK where id_Cliente=EncargadoPK) as Cliente,
Lugar_Destino as Destino,
Cantidad_Pasajeros as Pasajeros,
Nombre as Encargado,
MPago as Forma_Pago,
Precio as Monto_Total,
(Precio-Monto_Adelanto) as MontoXCobrar,
Fecha_Pendiente as FechaXCobrar,
FechaMax as FechaMaxima,
Moneda

from role
 
inner join encargado 
on encargado.EncargadoPK=role.id_Cliente

where Hora_Salida between Principio and  (SELECT ADDTIME(Final ,'23:59:59'));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Prueba` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Prueba`()
BEGIN
declare fecha varchar(10);
set fecha = 'null';
select str_to_date(fecha,"%d/%m/%Y");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `RevenueReport` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `RevenueReport`(in F_Inicial datetime, in F_Final datetime)
BEGIN
select 
(select ClientePK from cliente where ClientePK in (Enca.Id_Empresa)) as ID_de_Empresa,
(select Nombre from cliente where ClientePK in (Enca.Id_Empresa)) as Nombre_de_empresa,
COUNT(*) as Total_de_viajes,
(select sum(Precio)

from role 
inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where moneda='0' and enca.Id_Empresa=ID_de_Empresa
) as Colón,
(
select sum(Precio)

from role 

inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where moneda='1' and enca.Id_Empresa=ID_de_Empresa
) as Dolar,

(
select Count(*)

from role 

inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where  enca.Id_Empresa=ID_de_Empresa and Estado  not like '%Cerrado%' 
) as Total_Pendientes_Colones,

(
select sum(Precio)

from role 

inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where moneda='0' and enca.Id_Empresa=ID_de_Empresa and Estado  not like '%Cerrado%' 
) as Pendiente_Cobrar_Colones,
(
select sum(Precio)

from role 

inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where moneda='1' and enca.Id_Empresa=ID_de_Empresa and Estado  not like '%Cerrado%' 
) as Pendiente_Cobrar_Dolares



from role 

inner join encargado as Enca
on enca.EncargadoPk=Role.id_Cliente

where Creado between F_Inicial and  (SELECT ADDTIME(F_Final ,'23:59:59'))
group by Id_Empresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Search_case` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Search_case`(in Caso int)
BEGIN

Select Conductor.Nombre  as Chofer,
Bus.Unidad as Unidad,
Lugar_Destino,Lugar_Salida,Persona.Nombre,Persona.Numero_telefonico_uno,Hora_Salida,Hora_Destino,
Notas,Precio,Cantidad_Pasajeros,Cobrar,Regreso,
Bus.Aire_a as Aire,
Bus.Tipo as Tipo,
(select Nombre_Empresa.Nombre from encargado inner join Cliente as Nombre_Empresa
on encargado.Id_Empresa =Nombre_Empresa.ClientePK where id_Cliente=EncargadoPK) as Nombre_Empresa,
Persona.Numero_telefonico_uno,
Persona.Email,
Unidad_ID,
id_Cliente,
moneda,
MPago,
Role.Estado,
Fecha_Pendiente,
Monto_Adelanto,
Recorrido_C,
Persona2.Nombre,
Persona2.Telefono,
FechaMax,
Chofer_ID,
Contacto_ID,
bano

/*Prueba.Nombre as Nombre_Encargado,
Prueba.Telefono as Telefono_Encargado*/

 
/*(Select Nombre from encargadosdeviaje where role_id_encargados=Caso) as Nombre_Encargado*/
/*Encar_Viaje.Telefono*/


from role 

inner join encargado  as Persona
on Persona.EncargadoPK=role.id_Cliente
inner join Unidad  as Bus
on Bus.PK=role.Unidad_ID
inner join choferes  as Conductor
on Conductor.CPK_id=role.Chofer_ID
left join encargado_contacto  as Persona2
on Persona2.ID_encargadosdeviaje=role.Contacto_ID



where Role_id=Caso;






END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Search_Comentarios` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Search_Comentarios`(in caso int)
BEGIN
select Fecha,Nombre,Comentario from Comentarios
inner join users 
on users.Id_Usuario=Comentarios.User_id

Where Tiquete=caso;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `search_datescase` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `search_datescase`(in Principio Date,in Final date,in Nombreempresa1 int,in Filtro enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado'))
BEGIN
select Role_id,Nombre_Empresa.Nombre,Lugar_Destino,Fecha_Pendiente,Creado from role 

inner join encargado as persona
on persona.EncargadoPK = role.id_Cliente

inner join Cliente as Nombre_Empresa
on persona.Id_Empresa =Nombre_Empresa.ClientePK

where Nombre_Empresa.ClientePK=Nombreempresa1 and Estado=Filtro COLLATE utf8_bin
and Creado between Principio and  (SELECT ADDTIME(Final ,'23:59:59'))
order by Creado asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_datescaseNODATE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `search_datescaseNODATE`(in Nombreempresa1 int,in Filtro enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado'))
BEGIN
select Role_id,Nombre_Empresa.Nombre,Lugar_Destino,Fecha_Pendiente,Creado from role 

inner join encargado as persona
on persona.EncargadoPK = role.id_Cliente

inner join Cliente as Nombre_Empresa
on persona.Id_Empresa =Nombre_Empresa.ClientePK

where Nombre_Empresa.ClientePK=Nombreempresa1 and Estado=Filtro COLLATE utf8_bin
order by Creado asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Search_Pendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Search_Pendientes`()
BEGIN
select Fecha_Pendiente,Estado,Role_id,

(select Nombre_Empresa.Nombre from encargado 
inner join Cliente as Nombre_Empresa
on encargado.Id_Empresa =Nombre_Empresa.ClientePK where id_Cliente=EncargadoPK) as Nombre_Empresa

from role 

inner join encargado  as Persona
on Persona.EncargadoPK=role.id_Cliente
where estado not like '%Cerrado%' order by Fecha_Pendiente asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Search_RoleDateRange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Search_RoleDateRange`(in Principio Date,in Final date)
BEGIN
declare Estado varchar(20) DEFAULT 'Todos' ;



Select Conductor.Nombre,
Transporte.Unidad,
Lugar_Destino,Lugar_Salida,encargado.Nombre,encargado.Numero_telefonico_uno,Hora_Salida,Hora_Destino,

Notas,Precio,Cantidad_Pasajeros,Cobrar,Regreso
from role 

inner join encargado 
on encargado.EncargadoPK=role.id_Cliente
inner join Choferes as Conductor
on Conductor.CPK_id=role.Chofer_ID
inner join Unidad as Transporte 
on Transporte.PK=role.Unidad_ID

where Hora_Salida between Principio and  (SELECT ADDTIME(Final ,'23:59:59'))
or  Hora_Destino between Principio and (SELECT ADDTIME(Final ,'23:59:59'))
order by Transporte.PK
;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Search_Unidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Search_Unidad`(in tipo_b enum('Buseta','Autobus','Microbus'),in Aire_b enum('Si','No'),in Pasajerosmenor int)
BEGIN
Select unidad,Tipo from unidad where 'Funcional'=Estado and   Pasajeros >= Pasajerosmenor and Aire_b=Aire_a and tipo_b=Tipo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Select_allchoferes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Select_allchoferes`()
BEGIN
Select CPK_id,Nombre,Disponible from choferes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Select_Unidades` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Select_Unidades`()
BEGIN
select Unidad,Marca,Chofer_1.nombre,Chofer_2.nombre from Unidad_Choferes
inner join unidad
on unidad_choferes.ID_Unidad=Unidad.PK
inner join choferes as Chofer_1
on Chofer_1.CPK_id=Unidad_Choferes.ID_Chofer_1
inner join choferes as Chofer_2
on Chofer_2.CPK_id=Unidad_Choferes.ID_Chofer_2
order by id asc;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `test` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `test`(in lugar_destinob varchar(255),in lugar_Salidab varchar(255),in preciob double,in Cantidad_pasajerosb int,in Cliente_idb int,in Unidad_choferesb int,in Inicial datetime,in Destino datetime,in Notasb varchar(255), in Cobra varchar(255),in Dregreso varchar(255),in Estado_Guardar enum('Cerrado','P. de facturación','P. de pago','En tramite'),in Fecha_p varchar(10),in User_Id int,in ComentarioV text,in Money int,in Payment int)
BEGIN
insert into role (Lugar_Destino, Lugar_Salida, Precio, Cantidad_Pasajeros, id_Cliente, Unidad_Chofer_id,Hora_Salida,Hora_Destino,Notas,Cobrar,Regreso,Estado,Fecha_Pendiente,moneda,MPago) values (lugar_destinob,lugar_Salidab,preciob,Cantidad_pasajerosb,Cliente_idb,Unidad_choferesb,Inicial,Destino,Notasb,Cobra,Dregreso,Estado_Guardar,(select str_to_date(Fecha_p,"%d/%m/%Y")),Money,Payment);
insert into comentarios(Comentario,tiquete,User_id) values(ComentarioV,(SELECT Role_id FROM role ORDER BY Role_id DESC LIMIT 1),User_Id);
select roleid from role
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Unit_Usage_DateRange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Unit_Usage_DateRange`(in Principio Date,in Final date)
BEGIN
select Hora_Salida,
Transporte.Unidad,
Cantidad_Pasajeros,
Transporte.Dueno,
Transporte.Nombre_Proveedor,
Lugar_Destino,
Precio,
Transporte.Aire_a,
Conductor.Nombre
from role 

inner join Unidad as Transporte 
on Transporte.PK=role.Unidad_ID
inner join Choferes as Conductor
on Conductor.CPK_id=role.Chofer_ID

where Hora_Salida between Principio and   (SELECT ADDTIME(Final ,'23:59:59'))
order by Hora_Salida asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update Encargado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update Encargado`(in Encargado int,in Nombre varchar(255), in Email varchar(255),in Numero_telefonico_uno varchar(15),in Numero_telefonico_dos varchar(15))
BEGIN
update encargado set  Nombre=Nombre,Email=Email, Numero_telefonico_uno=Numero_telefonico_uno, Numero_telefonico_dos=Numero_telefonico_dos where EncargadoPK=Encargado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Choferes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Choferes`(in PkCH int,in Nombre1 varchar(255),in NumeroTelefonico1 varchar(15),in Email1 varchar(255),in Disponible1 boolean)
BEGIN
update Choferes set Nombre=Nombre1, NumeroTelefonico=NumeroTelefonico1,Email=Email1,Disponible=Disponible1 where CPK_id=PkCH;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Contacto_Encargado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Contacto_Encargado`(in ID int,in Nombre_Contacto varchar(255),in Numero varchar(9))
BEGIN
Update encargado_contacto
set
Nombre=Nombre_Contacto,
Telefono=Numero
where ID_encargadosdeviaje=ID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Contacto_Only` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Contacto_Only`(in id_Contacto int,in Nombre_Contacto varchar(255),in numero varchar(9),in Email varchar(255))
BEGIN
Update encargado 
set
Nombre=Nombre_Contacto,
Email=Email,
Numero_telefonico_uno=numero
where EncargadoPK=id_Contacto;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Empresa` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Empresa`(in Id_EM int, nombre varchar(255),in tipo enum('Particular','Empresa'),in numero varchar(9))
BEGIN

Update Cliente set Nombre=nombre,Tipo=tipo,Numero_telefonico=numero where ClientePK=Id_EM;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Empresa_Only` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Empresa_Only`(in Id_Emp int,in Nombre_EMpresa varchar(256))
BEGIN
update  Cliente set Nombre=Nombre_EMpresa where ClientePK=Id_Emp ;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Encargado` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Encargado`(in Encargado int,in Nombre varchar(255), in Email varchar(255),in Numero_telefonico_uno varchar(15),in Numero_telefonico_dos varchar(15))
BEGIN
update encargado set  Nombre=Nombre,Email=Email, Numero_telefonico_uno=Numero_telefonico_uno, Numero_telefonico_dos=Numero_telefonico_dos where EncargadoPK=Encargado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Role` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Role`(in lugar_destinob varchar(255),in lugar_Salidab varchar(255),in preciob double,in Cantidad_pasajerosb int,
in Cliente_idb int,in Unidad_choferesb int,in Inicial datetime,in Destino datetime,in Notasb varchar(255), in Cobra varchar(255),in Dregreso varchar(255),
in Estado_Guardar enum('Cerrado','P. de facturación','P. de pago','En trámite','Por avisar','Confirmado'),in Fecha_p varchar(10),in User_Id int,in NumeroDcaso int,
in ComentarioV text,in Money int,in Payment int,in AdelantoMonto double,in Recor Text,in Fecha_Max varchar(10),
in ChoferID int,in EncarContacto int)
BEGIN
Declare var double;
set var=AdelantoMonto+(select Monto_Adelanto from role where Role_id=NumeroDcaso);
 
update role set
Lugar_Destino=lugar_destinob,
Lugar_Salida=lugar_Salidab,
Precio=preciob,
Cantidad_Pasajeros=Cantidad_pasajerosb,
id_Cliente=Cliente_idb,
Unidad_ID=Unidad_choferesb,
Hora_Salida=Inicial,
Hora_Destino=Destino,
Notas=Notasb,
Cobrar=Cobra,
Regreso=Dregreso,
Estado=Estado_Guardar,
Fecha_Pendiente=(select str_to_date(Fecha_p,"%d/%m/%Y")),
moneda=Money,
MPago=Payment,
Monto_Adelanto=var,
Recorrido_C=Recor, 
FechaMax=(select str_to_date(Fecha_Max,"%d/%m/%Y")),
Chofer_ID=ChoferID,
Contacto_ID=EncarContacto
where Role_id=NumeroDcaso;

/*update role set 
Recorrido_C=Recor 
where Recor is not null and Recor !='' and Role_id=NumeroDcaso;*/

insert into comentarios(Comentario,tiquete,User_id) values(ComentarioV,NumeroDcaso,User_Id);
/*insert into encargadosdeviaje(Nombre,Telefono,role_id_encargados)values(Nombre1,Telefono1,NumeroDcaso);*/
commit;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_Unidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_Unidad`(in UnidadPk int,in Unidad Varchar(5),in Marca Varchar(255),in Tipo enum('Buseta','Autobus','Microbus'),in Aire_a enum('Si','No'), in Estado enum('Funcional','Taller'),in Pasajeros int,in NombreProveedor varchar(255),in bano1 enum('Si','No'))
BEGIN
Update Unidad set Unidad=Unidad,Marca=Marca,Tipo=Tipo,Aire_a=Aire_a,Estado=Estado,Pasajeros=Pasajeros,Nombre_Proveedor=NombreProveedor,bano=bano1 where PK=UnidadPK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_User` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_User`(in Lugar int,in NUsuario varchar(255),in Us varchar(60),in Contraseña varchar(16),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean)
BEGIN

update  Users SET Nombre=NUsuario,Usuario=Us,Contraseña=Contraseña, Correo=Correo ,Administrar_Usuarios=Administrar_Usuarios1,Role=Role1,
Unidad_Choferes=Unidad_Choferes1 where Id_Usuario=Lugar;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_UserNoPass` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_UserNoPass`(in Lugar int,in NUsuario varchar(255),in Us varchar(60),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean)
BEGIN

update  Users SET Nombre=NUsuario,Usuario=Us, Correo=Correo ,Administrar_Usuarios=Administrar_Usuarios1,Role=Role1,
Unidad_Choferes=Unidad_Choferes1 where Id_Usuario=Lugar;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_UserNoPass_JavaFx` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_UserNoPass_JavaFx`(in Lugar int,in NUsuario varchar(255),in Us varchar(60),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean,in Reportes boolean,in AccountLive boolean)
BEGIN

update  Users SET Nombre=NUsuario,Usuario=Us, Correo=Correo ,Administrar_Usuarios=Administrar_Usuarios1,Role=Role1,
Unidad_Choferes=Unidad_Choferes1,Cliente=Reportes,Active_account=AccountLive where Id_Usuario=Lugar;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Update_User_JavaFx` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `Update_User_JavaFx`(in Lugar int,in NUsuario varchar(255),in Us varchar(60),in Contraseña varchar(16),in Correo varchar(255),in Administrar_Usuarios1 boolean,in Role1 boolean,in Unidad_Choferes1 boolean,in Reportes boolean,in AccountLive boolean)
BEGIN

update  Users SET Nombre=NUsuario,Usuario=Us,Contraseña=Contraseña, Correo=Correo ,Administrar_Usuarios=Administrar_Usuarios1,Role=Role1,
Unidad_Choferes=Unidad_Choferes1,Cliente=Reportes,Active_account=AccountLive where Id_Usuario=Lugar;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `User_Position` */;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Testing`@`%` PROCEDURE `User_Position`(in User Varchar(60) )
BEGIN
select Id_Usuario from Users  where Usuario=User;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `travelman` CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-16 21:19:00
