-- MySQL dump 10.13  Distrib 5.6.21, for Win64 (x86_64)
--
-- Host: localhost    Database: herbario
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `casillero`
--

DROP TABLE IF EXISTS `casillero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casillero` (
  `idcasillero` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_gabinete` bigint(20) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idcasillero`),
  KEY `fk_gabinete_casillero` (`id_gabinete`),
  CONSTRAINT `fk_gabinete_casillero` FOREIGN KEY (`id_gabinete`) REFERENCES `gabinete` (`idgabinete`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casillero`
--

LOCK TABLES `casillero` WRITE;
/*!40000 ALTER TABLE `casillero` DISABLE KEYS */;
INSERT INTO `casillero` VALUES (1,1,1,'familia fanerogamas',NULL),(2,2,1,'Opuntias',NULL);
/*!40000 ALTER TABLE `casillero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colecta`
--

DROP TABLE IF EXISTS `colecta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colecta` (
  `idcolecta` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_especie` bigint(20) NOT NULL,
  `id_ubigeo` bigint(20) NOT NULL,
  `localidad` varchar(40) DEFAULT NULL,
  `zona_utm` varchar(5) DEFAULT NULL,
  `coordenada1_utm` varchar(20) DEFAULT NULL,
  `coordenada2_utm` varchar(20) DEFAULT NULL,
  `latitud` point DEFAULT NULL,
  `longitud` point DEFAULT NULL,
  `altitud` int(5) DEFAULT NULL,
  `fecha_colecta` datetime DEFAULT NULL,
  `id_formacion_vegetal` bigint(20) DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `observacion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idcolecta`),
  KEY `fk_especie_colecta` (`id_especie`),
  KEY `fk_formacion_colecta` (`id_formacion_vegetal`),
  KEY `fk_ubigeo_colecta` (`id_ubigeo`),
  CONSTRAINT `fk_distrito_colecta` FOREIGN KEY (`id_ubigeo`) REFERENCES `distrito` (`iddistrito`),
  CONSTRAINT `fk_especie_colecta` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`idespecie`),
  CONSTRAINT `fk_formacion_colecta` FOREIGN KEY (`id_formacion_vegetal`) REFERENCES `formacion` (`idformacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colecta`
--

LOCK TABLES `colecta` WRITE;
/*!40000 ALTER TABLE `colecta` DISABLE KEYS */;
/*!40000 ALTER TABLE `colecta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colecta_persona`
--

DROP TABLE IF EXISTS `colecta_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colecta_persona` (
  `idcolectapersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_colecta` bigint(20) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `tipo` bigint(20) DEFAULT NULL COMMENT 'colector, determinador, registrador\r\n\r\n\r\n\r\n',
  `numero_colecta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcolectapersona`),
  KEY `fk_colecta` (`id_colecta`),
  KEY `fk_persona` (`id_persona`),
  CONSTRAINT `fk_colecta` FOREIGN KEY (`id_colecta`) REFERENCES `colecta` (`idcolecta`),
  CONSTRAINT `fk_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colecta_persona`
--

LOCK TABLES `colecta_persona` WRITE;
/*!40000 ALTER TABLE `colecta_persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `colecta_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `iddepartamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `cod_departamento` int(4) NOT NULL,
  `denominacion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`iddepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,0,'ayacucho'),(2,0,'lima');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `iddistrito` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_provincia` bigint(20) NOT NULL,
  `cod_distrito` int(4) DEFAULT NULL,
  `denominacion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`iddistrito`),
  KEY `fk_provincia_distrito` (`id_provincia`),
  CONSTRAINT `fk_provincia_distrito` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`idprovincia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,1,NULL,'ayacucho'),(2,1,NULL,'acocro'),(3,1,NULL,'jesús nazareno'),(4,1,NULL,'carmen alto'),(5,1,NULL,'san juan bautista');
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplar`
--

DROP TABLE IF EXISTS `ejemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejemplar` (
  `idejemplar` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_colecta` bigint(20) NOT NULL,
  `id_casillero` bigint(20) NOT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `numero_ejemplar` int(11) DEFAULT NULL,
  `observacion` varchar(500) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idejemplar`),
  KEY `fk_casillero_ejemplar` (`id_casillero`),
  KEY `fk_colecta_ejemplar` (`id_colecta`),
  CONSTRAINT `fk_casillero_ejemplar` FOREIGN KEY (`id_casillero`) REFERENCES `casillero` (`idcasillero`),
  CONSTRAINT `fk_colecta_ejemplar` FOREIGN KEY (`id_colecta`) REFERENCES `colecta` (`idcolecta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplar`
--

LOCK TABLES `ejemplar` WRITE;
/*!40000 ALTER TABLE `ejemplar` DISABLE KEYS */;
/*!40000 ALTER TABLE `ejemplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especie` (
  `idespecie` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_genero` bigint(20) NOT NULL,
  `denominacion` varchar(50) DEFAULT NULL,
  `autor` varchar(25) DEFAULT NULL,
  `nombre_vulgar1` varchar(30) DEFAULT NULL,
  `nombre_vulgar2` varchar(30) DEFAULT NULL,
  `nombre_vulgar3` varchar(30) DEFAULT NULL,
  `id_habito` bigint(20) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idespecie`),
  KEY `fk_genero_especie` (`id_genero`),
  KEY `fk_habito_especie` (`id_habito`),
  CONSTRAINT `fk_genero_especie` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`idgenero`),
  CONSTRAINT `fk_habito_especie` FOREIGN KEY (`id_habito`) REFERENCES `habito` (`idhabito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familia`
--

DROP TABLE IF EXISTS `familia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familia` (
  `idfamilia` bigint(20) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(20) DEFAULT NULL,
  `abreviatura` varchar(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idfamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familia`
--

LOCK TABLES `familia` WRITE;
/*!40000 ALTER TABLE `familia` DISABLE KEYS */;
INSERT INTO `familia` VALUES (1,'Cactaceae','CA',NULL),(2,'Amblystegiaceae','AM',NULL),(3,'Andreaeaceae','AN',NULL),(6,'Anomodontaceae','ANOM',NULL);
/*!40000 ALTER TABLE `familia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formacion`
--

DROP TABLE IF EXISTS `formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formacion` (
  `idformacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `formacionVegetal` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idformacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formacion`
--

LOCK TABLES `formacion` WRITE;
/*!40000 ALTER TABLE `formacion` DISABLE KEYS */;
INSERT INTO `formacion` VALUES (3,'matorral',NULL),(4,'bosques compactos',NULL),(5,'bosques suaves',NULL);
/*!40000 ALTER TABLE `formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotografia`
--

DROP TABLE IF EXISTS `fotografia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotografia` (
  `idfotografia` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_colecta` bigint(20) NOT NULL,
  `id_fotografo` bigint(20) DEFAULT NULL,
  `fotografia` longblob,
  `descripcion` varchar(200) DEFAULT NULL,
  `observacion` varchar(200) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idfotografia`),
  KEY `fk_colecta_fotografia` (`id_colecta`),
  KEY `fk_persona_fotografia` (`id_fotografo`),
  CONSTRAINT `fk_colecta_fotografia` FOREIGN KEY (`id_colecta`) REFERENCES `colecta` (`idcolecta`),
  CONSTRAINT `fk_persona_fotografia` FOREIGN KEY (`id_fotografo`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotografia`
--

LOCK TABLES `fotografia` WRITE;
/*!40000 ALTER TABLE `fotografia` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotografia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gabinete`
--

DROP TABLE IF EXISTS `gabinete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gabinete` (
  `idgabinete` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idgabinete`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gabinete`
--

LOCK TABLES `gabinete` WRITE;
/*!40000 ALTER TABLE `gabinete` DISABLE KEYS */;
INSERT INTO `gabinete` VALUES (1,'gabinete 1','01','contiene familia fanerogama',NULL),(2,'Gabinete 2','02','',NULL);
/*!40000 ALTER TABLE `gabinete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_familia` bigint(20) NOT NULL,
  `denominacion` varchar(20) DEFAULT NULL,
  `abreviatura` varchar(10) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idgenero`),
  KEY `fk_familia_genero` (`id_familia`),
  CONSTRAINT `fk_familia_genero` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`idfamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,1,'Pereskia','',NULL),(2,1,'Melocactu','',NULL),(3,2,'Amblystegium','',NULL),(9,3,'Andreaea','',NULL);
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habito`
--

DROP TABLE IF EXISTS `habito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habito` (
  `idhabito` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombrehabito` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idhabito`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habito`
--

LOCK TABLES `habito` WRITE;
/*!40000 ALTER TABLE `habito` DISABLE KEYS */;
INSERT INTO `habito` VALUES (1,'arbustiva',NULL),(2,'arbórea',NULL),(3,'herbácea',NULL),(5,'cespitosa',NULL);
/*!40000 ALTER TABLE `habito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagen` (
  `idimagen` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_ejemplar` bigint(20) NOT NULL,
  `imagen_original` longblob,
  `imagen_reducido` longblob,
  `descripcion` varchar(100) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idimagen`),
  KEY `fk_ejemplar_imagen` (`id_ejemplar`),
  CONSTRAINT `fk_ejemplar_imagen` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplar` (`idejemplar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `ap_paterno` varchar(50) DEFAULT NULL,
  `ap_materno` varchar(50) DEFAULT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `sexo` tinyint(1) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `celular1` varchar(12) DEFAULT NULL,
  `celular2` varchar(12) DEFAULT NULL,
  `correo` varchar(40) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'juvenal','galindo','ccallocunto','45943286',0,'','999177300','','juvenal.galindo@outlook.com',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `idprovincia` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_departamento` bigint(20) NOT NULL,
  `cod_provincia` int(4) DEFAULT NULL,
  `denominacion` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idprovincia`),
  KEY `fk_departamento_provincia` (`id_departamento`),
  CONSTRAINT `fk_departamento_provincia` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`iddepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,1,NULL,'huamanga'),(2,1,NULL,'cangallo'),(3,2,NULL,'canta'),(4,1,NULL,'huanta');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(20) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_persona` bigint(20) NOT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_persona_usuario` (`id_persona`),
  CONSTRAINT `fk_persona_usuario` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_rol` (
  `idusuariorol` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_usuario` bigint(20) NOT NULL,
  `id_rol` bigint(20) NOT NULL,
  PRIMARY KEY (`idusuariorol`),
  KEY `fk_rol` (`id_rol`),
  KEY `fk_usuario` (`id_usuario`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`idrol`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-23 10:52:13
