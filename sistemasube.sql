CREATE DATABASE  IF NOT EXISTS `sistemasube` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistemasube`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemasube
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `beneficio`
--

DROP TABLE IF EXISTS `beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beneficio` (
  `idBeneficio` int(11) NOT NULL AUTO_INCREMENT,
  `beneficio` varchar(45) NOT NULL,
  PRIMARY KEY (`idBeneficio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficio`
--

LOCK TABLES `beneficio` WRITE;
/*!40000 ALTER TABLE `beneficio` DISABLE KEYS */;
INSERT INTO `beneficio` VALUES (1,'Plan 2'),(2,'Plan Estudiantes');
/*!40000 ALTER TABLE `beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleteria`
--

DROP TABLE IF EXISTS `boleteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boleteria` (
  `idBoleteria` int(11) NOT NULL AUTO_INCREMENT,
  `boleteria` varchar(45) NOT NULL,
  PRIMARY KEY (`idBoleteria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleteria`
--

LOCK TABLES `boleteria` WRITE;
/*!40000 ALTER TABLE `boleteria` DISABLE KEYS */;
INSERT INTO `boleteria` VALUES (1,'BURZACObol'),(2,'ADROGUEbol');
/*!40000 ALTER TABLE `boleteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boleto`
--

DROP TABLE IF EXISTS `boleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boleto` (
  `idBoleto` int(11) NOT NULL AUTO_INCREMENT,
  `monto` double NOT NULL,
  `montoConDescuentos` double NOT NULL,
  `fechaHoraBoleto` datetime NOT NULL,
  `idTarjeta` int(11) NOT NULL,
  `idLector` int(11) NOT NULL,
  PRIMARY KEY (`idBoleto`,`idLector`,`idTarjeta`),
  KEY `fk_boleto_tarjeta1_idx` (`idTarjeta`),
  KEY `fk_boleto_lector1_idx` (`idLector`),
  CONSTRAINT `fk_boleto_lector1` FOREIGN KEY (`idLector`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleto_tarjeta1` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idTarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boleto`
--

LOCK TABLES `boleto` WRITE;
/*!40000 ALTER TABLE `boleto` DISABLE KEYS */;
INSERT INTO `boleto` VALUES (1,10,4.5,'2018-06-24 11:40:50',2,7),(2,3.25,3.25,'2018-06-24 13:10:05',1,9),(3,6.5,6.5,'2018-06-24 13:38:52',1,9),(4,6.5,6.5,'2018-06-24 13:39:41',1,9),(5,6.5,6.5,'2018-06-24 13:47:38',1,9),(6,6.5,6.5,'2018-06-24 13:48:12',1,9),(7,6.5,6.5,'2018-06-24 13:48:59',1,10),(8,6.5,6.5,'2018-06-24 17:09:21',1,9),(9,6.5,6.5,'2018-06-24 17:10:49',1,10),(10,6.5,6.5,'2018-06-25 17:19:56',1,32),(11,6.5,2.9250000000000003,'2018-06-25 17:20:26',2,32),(12,6.5,2.9250000000000003,'2018-06-25 17:38:19',2,32),(13,6.5,2.9250000000000003,'2018-06-25 17:38:37',2,32),(14,6.5,2.9250000000000003,'2018-06-25 17:46:26',2,32),(15,6.5,2.9250000000000003,'2018-06-25 17:49:42',2,32),(16,6.5,6.5,'2018-06-25 17:54:41',3,32),(17,6.5,6.5,'2018-06-25 17:55:11',3,32),(18,6.5,6.5,'2018-06-25 17:55:31',3,32),(19,10,10,'2018-06-25 17:57:39',3,7),(20,10,10,'2018-06-25 17:57:55',3,7),(21,10,4.5,'2018-06-25 17:58:11',2,7),(22,10,4.5,'2018-06-25 17:58:35',2,7),(23,10,4.5,'2018-06-25 17:59:53',2,8),(24,6.5,3.25,'2018-06-25 18:00:13',3,32),(25,-1.5,-0.75,'2018-06-25 18:01:13',3,10),(26,10,10,'2018-06-25 18:10:41',1,1),(27,10,10,'2018-06-25 18:11:08',1,2),(28,10,2.5,'2018-06-25 18:11:51',3,2),(29,11,11,'2018-06-25 18:12:07',3,2),(30,11,11,'2018-06-25 18:21:45',3,2),(31,11,5.5,'2018-06-25 18:21:56',3,5),(32,11,2.75,'2018-06-25 18:22:02',3,2);
/*!40000 ALTER TABLE `boleto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletoestudiantil`
--

DROP TABLE IF EXISTS `boletoestudiantil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletoestudiantil` (
  `idBoletoEstudiantil` int(11) NOT NULL,
  `monto` double NOT NULL,
  PRIMARY KEY (`idBoletoEstudiantil`),
  KEY `fk_montofijo_beneficio1_idx` (`idBoletoEstudiantil`),
  CONSTRAINT `fk_montofijo_beneficio1` FOREIGN KEY (`idBoletoEstudiantil`) REFERENCES `beneficio` (`idBeneficio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletoestudiantil`
--

LOCK TABLES `boletoestudiantil` WRITE;
/*!40000 ALTER TABLE `boletoestudiantil` DISABLE KEYS */;
INSERT INTO `boletoestudiantil` VALUES (2,300);
/*!40000 ALTER TABLE `boletoestudiantil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `botoncolectivo`
--

DROP TABLE IF EXISTS `botoncolectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `botoncolectivo` (
  `idBotonColectivo` int(11) NOT NULL AUTO_INCREMENT,
  `precioSeccionColectivo` double NOT NULL,
  PRIMARY KEY (`idBotonColectivo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `botoncolectivo`
--

LOCK TABLES `botoncolectivo` WRITE;
/*!40000 ALTER TABLE `botoncolectivo` DISABLE KEYS */;
INSERT INTO `botoncolectivo` VALUES (1,10),(2,10.5),(3,10.75),(4,11);
/*!40000 ALTER TABLE `botoncolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carga`
--

DROP TABLE IF EXISTS `carga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carga` (
  `idCarga` int(11) NOT NULL AUTO_INCREMENT,
  `idTarjeta` int(11) NOT NULL,
  `idBoleteria` int(11) NOT NULL,
  `fechaHoraCarga` datetime NOT NULL,
  `monto` double NOT NULL,
  `boletoEstudiantil` tinyint(4) NOT NULL,
  PRIMARY KEY (`idCarga`,`idTarjeta`,`idBoleteria`),
  KEY `fk_tarjeta_has_boleteria_boleteria1_idx` (`idBoleteria`),
  KEY `fk_tarjeta_has_boleteria_tarjeta1_idx` (`idTarjeta`),
  CONSTRAINT `fk_tarjeta_has_boleteria_boleteria1` FOREIGN KEY (`idBoleteria`) REFERENCES `boleteria` (`idBoleteria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarjeta_has_boleteria_tarjeta1` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idTarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carga`
--

LOCK TABLES `carga` WRITE;
/*!40000 ALTER TABLE `carga` DISABLE KEYS */;
INSERT INTO `carga` VALUES (36,5,1,'2018-06-25 20:12:02',300,1),(37,5,1,'2018-06-25 20:12:47',10,0),(38,1,1,'2018-06-25 20:13:07',10,0),(39,2,1,'2018-06-25 20:13:12',10,0);
/*!40000 ALTER TABLE `carga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacion`
--

DROP TABLE IF EXISTS `estacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacion` (
  `idEstacion` int(11) NOT NULL AUTO_INCREMENT,
  `estacion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstacion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion`
--

LOCK TABLES `estacion` WRITE;
/*!40000 ALTER TABLE `estacion` DISABLE KEYS */;
INSERT INTO `estacion` VALUES (1,'Glew'),(2,'Longchamps'),(3,'Burzaco'),(4,'Adrogue'),(5,'Temperley'),(6,'Lomas'),(7,'Banfield'),(8,'Escalada'),(9,'Lanus'),(10,'Gerli'),(11,'Avellaneda'),(12,'Irigoyen'),(13,'Consti');
/*!40000 ALTER TABLE `estacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector`
--

DROP TABLE IF EXISTS `lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lector` (
  `idLector` int(11) NOT NULL AUTO_INCREMENT,
  `idSaldoMinimo` int(11) NOT NULL,
  `idLinea` int(11) NOT NULL,
  PRIMARY KEY (`idLector`,`idSaldoMinimo`,`idLinea`),
  KEY `fk_lector_linea1_idx` (`idLinea`),
  KEY `fk_lector_saldoMinimo1_idx` (`idSaldoMinimo`),
  CONSTRAINT `fk_lector_linea1` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lector_saldoMinimo1` FOREIGN KEY (`idSaldoMinimo`) REFERENCES `saldominimo` (`idSaldoMinimo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (1,1,1),(2,1,1),(3,1,2),(4,1,2),(5,1,3),(6,1,3),(7,1,4),(8,1,4),(9,1,5),(10,1,5),(11,1,5),(12,1,5),(13,1,5),(14,1,5),(15,1,5),(16,1,5),(17,1,5),(18,1,5),(19,1,5),(20,1,5),(21,1,5),(22,1,5),(23,1,5),(24,1,5),(25,1,5),(26,1,5),(27,1,5),(28,1,5),(29,1,5),(30,1,5),(31,1,5),(32,1,5),(33,1,5),(34,1,5);
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector_boton`
--

DROP TABLE IF EXISTS `lector_boton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lector_boton` (
  `idLectorColectivo` int(11) NOT NULL,
  `idBotonColectivo` int(11) NOT NULL,
  PRIMARY KEY (`idLectorColectivo`,`idBotonColectivo`),
  KEY `fk_tramoColectivo_seccionColectivo1_idx` (`idBotonColectivo`),
  CONSTRAINT `fk_botoneraChofer_lectorcolectivo1` FOREIGN KEY (`idLectorColectivo`) REFERENCES `lectorcolectivo` (`idLectorColectivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramoColectivo_seccionColectivo1` FOREIGN KEY (`idBotonColectivo`) REFERENCES `botoncolectivo` (`idBotonColectivo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector_boton`
--

LOCK TABLES `lector_boton` WRITE;
/*!40000 ALTER TABLE `lector_boton` DISABLE KEYS */;
INSERT INTO `lector_boton` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4);
/*!40000 ALTER TABLE `lector_boton` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lectorcolectivo`
--

DROP TABLE IF EXISTS `lectorcolectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectorcolectivo` (
  `idLectorColectivo` int(11) NOT NULL,
  `interno` varchar(45) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`idLectorColectivo`),
  KEY `fk_lectorcolectivo_lector1_idx` (`idLectorColectivo`),
  CONSTRAINT `fk_lectorcolectivo_lector1` FOREIGN KEY (`idLectorColectivo`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectorcolectivo`
--

LOCK TABLES `lectorcolectivo` WRITE;
/*!40000 ALTER TABLE `lectorcolectivo` DISABLE KEYS */;
INSERT INTO `lectorcolectivo` VALUES (1,'SV-74-1',0),(2,'SV-74-2',0),(3,'SV-79-1',0),(4,'SV-79-2',0),(5,'160-1',0),(6,'160-2',0);
/*!40000 ALTER TABLE `lectorcolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lectorsubte`
--

DROP TABLE IF EXISTS `lectorsubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectorsubte` (
  `idLectorSubte` int(11) NOT NULL,
  `estacionSubte` varchar(45) NOT NULL,
  `idPrecioSubte` int(11) NOT NULL,
  PRIMARY KEY (`idLectorSubte`,`idPrecioSubte`),
  KEY `fk_lectorsubte_lector1_idx` (`idLectorSubte`),
  KEY `fk_lectorsubte_preciosubte1_idx` (`idPrecioSubte`),
  CONSTRAINT `fk_lectorsubte_lector1` FOREIGN KEY (`idLectorSubte`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lectorsubte_preciosubte1` FOREIGN KEY (`idPrecioSubte`) REFERENCES `preciosubte` (`idPrecioSubte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectorsubte`
--

LOCK TABLES `lectorsubte` WRITE;
/*!40000 ALTER TABLE `lectorsubte` DISABLE KEYS */;
INSERT INTO `lectorsubte` VALUES (7,'Constitucion',1),(8,'Belgrano',1);
/*!40000 ALTER TABLE `lectorsubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lectortren`
--

DROP TABLE IF EXISTS `lectortren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectortren` (
  `idLectorTren` int(11) NOT NULL,
  `salida` tinyint(1) NOT NULL,
  `idEstacion` int(11) NOT NULL,
  PRIMARY KEY (`idLectorTren`,`idEstacion`),
  KEY `fk_lectortren_lector1_idx` (`idLectorTren`),
  KEY `fk_lectortren_estacion1_idx` (`idEstacion`),
  CONSTRAINT `fk_lectortren_estacion1` FOREIGN KEY (`idEstacion`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lectortren_lector1` FOREIGN KEY (`idLectorTren`) REFERENCES `lector` (`idLector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectortren`
--

LOCK TABLES `lectortren` WRITE;
/*!40000 ALTER TABLE `lectortren` DISABLE KEYS */;
INSERT INTO `lectortren` VALUES (9,0,1),(10,1,1),(11,0,2),(12,0,2),(13,0,3),(14,0,3),(15,0,4),(16,0,4),(17,0,5),(18,0,5),(19,0,6),(20,0,6),(21,0,7),(22,0,7),(23,0,8),(24,0,8),(25,0,9),(26,0,9),(27,0,10),(28,0,10),(29,0,11),(30,0,11),(31,0,12),(32,0,12),(33,0,13),(34,0,13);
/*!40000 ALTER TABLE `lectortren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linea`
--

DROP TABLE IF EXISTS `linea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea` (
  `idLinea` int(11) NOT NULL AUTO_INCREMENT,
  `linea` varchar(45) NOT NULL,
  PRIMARY KEY (`idLinea`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linea`
--

LOCK TABLES `linea` WRITE;
/*!40000 ALTER TABLE `linea` DISABLE KEYS */;
INSERT INTO `linea` VALUES (1,'SV-79'),(2,'SV-74'),(3,'160'),(4,'SUBTE'),(5,'LG.ROCA');
/*!40000 ALTER TABLE `linea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preciosubte`
--

DROP TABLE IF EXISTS `preciosubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preciosubte` (
  `idPrecioSubte` int(11) NOT NULL AUTO_INCREMENT,
  `precio` varchar(45) NOT NULL,
  PRIMARY KEY (`idPrecioSubte`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preciosubte`
--

LOCK TABLES `preciosubte` WRITE;
/*!40000 ALTER TABLE `preciosubte` DISABLE KEYS */;
INSERT INTO `preciosubte` VALUES (1,'10.0');
/*!40000 ALTER TABLE `preciosubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldominimo`
--

DROP TABLE IF EXISTS `saldominimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldominimo` (
  `idSaldoMinimo` int(11) NOT NULL AUTO_INCREMENT,
  `saldoMinimo` double NOT NULL,
  PRIMARY KEY (`idSaldoMinimo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldominimo`
--

LOCK TABLES `saldominimo` WRITE;
/*!40000 ALTER TABLE `saldominimo` DISABLE KEYS */;
INSERT INTO `saldominimo` VALUES (1,-20);
/*!40000 ALTER TABLE `saldominimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secciontren`
--

DROP TABLE IF EXISTS `secciontren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secciontren` (
  `idSeccionTren` int(11) NOT NULL AUTO_INCREMENT,
  `seccion` char(1) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idSeccionTren`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secciontren`
--

LOCK TABLES `secciontren` WRITE;
/*!40000 ALTER TABLE `secciontren` DISABLE KEYS */;
INSERT INTO `secciontren` VALUES (1,'A',3.25),(2,'B',5),(3,'C',6.5);
/*!40000 ALTER TABLE `secciontren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifasocial`
--

DROP TABLE IF EXISTS `tarifasocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarifasocial` (
  `idTarifaSocial` int(11) NOT NULL,
  `porcentajeDescuento` double NOT NULL,
  PRIMARY KEY (`idTarifaSocial`),
  KEY `fk_descuento_beneficio1_idx` (`idTarifaSocial`),
  CONSTRAINT `fk_descuento_beneficio1` FOREIGN KEY (`idTarifaSocial`) REFERENCES `beneficio` (`idBeneficio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifasocial`
--

LOCK TABLES `tarifasocial` WRITE;
/*!40000 ALTER TABLE `tarifasocial` DISABLE KEYS */;
INSERT INTO `tarifasocial` VALUES (1,0.45);
/*!40000 ALTER TABLE `tarifasocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `idTarjeta` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` double NOT NULL,
  `nivelRS` int(11) NOT NULL,
  `inicioRS` datetime NOT NULL,
  `baja` tinyint(4) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTarjeta`),
  KEY `fk_tarjeta_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_tarjeta_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (1,283.45,1,'2018-06-25 18:11:08',0,NULL),(2,375.07499999999993,1,'2018-06-25 17:59:53',0,1),(3,229.95,3,'2018-06-25 18:21:45',0,2),(4,284.7,0,'2018-06-24 11:27:46',1,NULL),(5,3927,0,'2018-06-24 11:27:46',0,3);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramotren`
--

DROP TABLE IF EXISTS `tramotren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tramotren` (
  `idTramoTren` int(11) NOT NULL AUTO_INCREMENT,
  `idEstacion1` int(11) NOT NULL,
  `idEstacion2` int(11) NOT NULL,
  `idSeccionTren` int(11) NOT NULL,
  PRIMARY KEY (`idTramoTren`,`idEstacion1`,`idEstacion2`,`idSeccionTren`),
  KEY `fk_tramo_estacion1_idx` (`idEstacion1`),
  KEY `fk_tramo_estacion2_idx` (`idEstacion2`),
  KEY `fk_tramo_secciontarifa1_idx` (`idSeccionTren`),
  CONSTRAINT `fk_tramo_estacion1` FOREIGN KEY (`idEstacion1`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramo_estacion2` FOREIGN KEY (`idEstacion2`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tramo_secciontarifa1` FOREIGN KEY (`idSeccionTren`) REFERENCES `secciontren` (`idSeccionTren`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramotren`
--

LOCK TABLES `tramotren` WRITE;
/*!40000 ALTER TABLE `tramotren` DISABLE KEYS */;
INSERT INTO `tramotren` VALUES (1,1,2,1),(2,1,3,1),(3,1,4,1),(4,1,5,1),(5,1,6,2),(6,1,7,2),(7,1,8,2),(8,1,9,2),(9,1,10,2),(10,1,11,2),(11,1,12,2),(12,1,13,3),(13,2,3,1),(14,2,4,1),(15,2,5,1),(16,2,6,1),(17,2,7,2),(18,2,8,2),(19,2,9,2),(20,2,10,2),(21,2,11,2),(22,2,12,2),(23,2,13,2),(24,3,4,1),(25,3,5,1),(26,3,6,1),(27,3,7,1),(28,3,8,1),(29,3,9,2),(30,3,10,2),(31,3,11,2),(32,3,12,2),(33,3,13,2),(34,4,5,1),(35,4,6,1),(36,4,7,1),(37,4,8,1),(38,4,9,1),(39,4,10,2),(40,4,11,2),(41,4,12,2),(42,4,13,2),(43,5,6,1),(44,5,7,1),(45,5,8,1),(46,5,9,1),(47,5,10,1),(48,5,11,2),(49,5,12,2),(50,5,13,2),(51,6,7,1),(52,6,8,1),(53,6,9,1),(54,6,10,1),(55,6,11,1),(56,6,12,1),(57,6,13,2),(58,7,8,1),(59,7,9,1),(60,7,10,1),(61,7,11,1),(62,7,12,1),(63,7,13,2),(64,8,9,1),(65,8,10,1),(66,8,11,1),(67,8,12,1),(68,8,13,1),(69,9,10,1),(70,9,11,1),(71,9,12,1),(72,9,13,1),(73,10,11,1),(74,10,12,1),(75,10,13,1),(76,11,12,1),(77,11,13,1),(78,12,13,1);
/*!40000 ALTER TABLE `tramotren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `idBeneficio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_beneficio1_idx` (`idBeneficio`),
  CONSTRAINT `fk_usuario_beneficio1` FOREIGN KEY (`idBeneficio`) REFERENCES `beneficio` (`idBeneficio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Saave','Darío',33311111,1),(2,'Rios','Leandro',10555777,NULL),(3,'Lionel','Messi',27777777,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-25 20:19:06
