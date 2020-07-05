-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bank_system
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Creating Database `bank_system`
--
DROP DATABASE IF EXISTS `bank_system`;
CREATE DATABASE `bank_system`;
USE `bank_system`;



--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `accountID` int NOT NULL AUTO_INCREMENT,
  `accountTypeID` int NOT NULL,
  PRIMARY KEY (`accountID`),
  KEY `Account_fk0` (`accountTypeID`),
  KEY `IDINDX` (`accountID`),
  CONSTRAINT `Account_fk0` FOREIGN KEY (`accountTypeID`) REFERENCES `accounttype` (`accountTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`accountID`, `accountTypeID`) VALUES (1,1);
INSERT INTO `account` (`accountID`, `accountTypeID`) VALUES (144,2);
INSERT INTO `account` (`accountID`, `accountTypeID`) VALUES (141,3);
INSERT INTO `account` (`accountID`, `accountTypeID`) VALUES (142,3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `account_BEFORE_DELETE` BEFORE DELETE ON `account` FOR EACH ROW BEGIN
	DELETE FROM feedbacks WHERE accountID = OLD.accountID;
    DELETE FROM loans WHERE accountID = OLD.accountID;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `accounttype`
--

DROP TABLE IF EXISTS `accounttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounttype` (
  `accountTypeID` int NOT NULL AUTO_INCREMENT,
  `accountTypeDescription` text NOT NULL,
  PRIMARY KEY (`accountTypeID`),
  KEY `pri` (`accountTypeID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounttype`
--

LOCK TABLES `accounttype` WRITE;
/*!40000 ALTER TABLE `accounttype` DISABLE KEYS */;
INSERT INTO `accounttype` (`accountTypeID`, `accountTypeDescription`) VALUES (1,'manager');
INSERT INTO `accounttype` (`accountTypeID`, `accountTypeDescription`) VALUES (2,'reception');
INSERT INTO `accounttype` (`accountTypeID`, `accountTypeDescription`) VALUES (3,'customer');
/*!40000 ALTER TABLE `accounttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `accountview`
--

DROP TABLE IF EXISTS `accountview`;
/*!50001 DROP VIEW IF EXISTS `accountview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `accountview` AS SELECT 
 1 AS `accountID`,
 1 AS `accountTypeID`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `allloans`
--

DROP TABLE IF EXISTS `allloans`;
/*!50001 DROP VIEW IF EXISTS `allloans`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `allloans` AS SELECT 
 1 AS `loanID`,
 1 AS `loanAmount`,
 1 AS `loanDescription`,
 1 AS `customerIncome`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `personID` int NOT NULL,
  `accountID` int NOT NULL,
  PRIMARY KEY (`customerID`),
  KEY `Customer_fk0` (`personID`),
  KEY `Customer_fk1` (`accountID`) /*!80000 INVISIBLE */,
  KEY `pri` (`customerID`) USING BTREE,
  CONSTRAINT `Customer_fk0` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  CONSTRAINT `Customer_fk1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerID`, `personID`, `accountID`) VALUES (28,43,141);
INSERT INTO `customer` (`customerID`, `personID`, `accountID`) VALUES (29,44,142);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `customer_BEFORE_DELETE` BEFORE DELETE ON `customer` FOR EACH ROW BEGIN
	DELETE FROM transactionlog WHERE customerID = OLD.customerID;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `customeraccount`
--

DROP TABLE IF EXISTS `customeraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customeraccount` (
  `customerID` int NOT NULL,
  `accountID` int NOT NULL,
  `interestSavingRateID` int NOT NULL,
  `currentBalance` int NOT NULL,
  `customerIncome` int NOT NULL DEFAULT '500000',
  KEY `customerAccount_fk0` (`customerID`),
  KEY `customerAccount_fk1` (`accountID`),
  KEY `customerAccount_fk2` (`interestSavingRateID`),
  CONSTRAINT `customerAccount_fk0` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  CONSTRAINT `customerAccount_fk1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`),
  CONSTRAINT `customerAccount_fk2` FOREIGN KEY (`interestSavingRateID`) REFERENCES `savinginterestsrates` (`interestSavingRateID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customeraccount`
--

LOCK TABLES `customeraccount` WRITE;
/*!40000 ALTER TABLE `customeraccount` DISABLE KEYS */;
INSERT INTO `customeraccount` (`customerID`, `accountID`, `interestSavingRateID`, `currentBalance`, `customerIncome`) VALUES (28,141,1,94000,200000);
INSERT INTO `customeraccount` (`customerID`, `accountID`, `interestSavingRateID`, `currentBalance`, `customerIncome`) VALUES (29,142,1,2515000,100000);
/*!40000 ALTER TABLE `customeraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `customerfull`
--

DROP TABLE IF EXISTS `customerfull`;
/*!50001 DROP VIEW IF EXISTS `customerfull`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `customerfull` AS SELECT 
 1 AS `currentBalance`,
 1 AS `customerIncome`,
 1 AS `firstName`,
 1 AS `middleName`,
 1 AS `lastName`,
 1 AS `address1`,
 1 AS `city`,
 1 AS `country`,
 1 AS `homePhone`,
 1 AS `accountTypeDescription`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employeeID` int NOT NULL AUTO_INCREMENT,
  `personID` int NOT NULL,
  `accountID` int NOT NULL,
  PRIMARY KEY (`employeeID`),
  KEY `Employee_fk0` (`personID`),
  KEY `Employee_fk1` (`accountID`),
  KEY `pri` (`employeeID`) USING BTREE,
  CONSTRAINT `Employee_fk0` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  CONSTRAINT `Employee_fk1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`employeeID`, `personID`, `accountID`) VALUES (10,46,144);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedbacks` (
  `feedBackID` int NOT NULL AUTO_INCREMENT,
  `accountID` int NOT NULL,
  `feedBackDescription` varchar(500) NOT NULL,
  PRIMARY KEY (`feedBackID`),
  KEY `pri` (`feedBackID`),
  KEY `key_idx` (`accountID`),
  CONSTRAINT `feedbacks_fk()` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbacks`
--

LOCK TABLES `feedbacks` WRITE;
/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
INSERT INTO `feedbacks` (`feedBackID`, `accountID`, `feedBackDescription`) VALUES (1,141,'testing feedback system');
INSERT INTO `feedbacks` (`feedBackID`, `accountID`, `feedBackDescription`) VALUES (9,141,'TEST');
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `loanID` int NOT NULL AUTO_INCREMENT,
  `accountID` int NOT NULL,
  `loanAmount` int NOT NULL,
  `loanDescription` varchar(500) NOT NULL,
  `customerIncome` int NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`loanID`),
  KEY `customerIncome` (`customerIncome`),
  KEY `pri` (`loanID`) USING BTREE,
  KEY `loans_fk()_idx` (`accountID`),
  CONSTRAINT `loans_fk()` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` (`loanID`, `accountID`, `loanAmount`, `loanDescription`, `customerIncome`, `status`) VALUES (25,141,100000,'CAR LOAN',200000,'accepted');
INSERT INTO `loans` (`loanID`, `accountID`, `loanAmount`, `loanDescription`, `customerIncome`, `status`) VALUES (26,142,500000,'Car Loan',100000,'accepted');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `loans_BEFORE_INSERT` BEFORE INSERT ON `loans` FOR EACH ROW BEGIN
	set NEW.status = 'waiting';
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `accountID` int NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  UNIQUE KEY `username` (`username`),
  KEY `login_fk0` (`accountID`),
  KEY `pri` (`accountID`) USING BTREE,
  CONSTRAINT `login_fk0` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`accountID`, `username`, `password`) VALUES (1,'admin','admin');
INSERT INTO `login` (`accountID`, `username`, `password`) VALUES (144,'doctor','doctor');
INSERT INTO `login` (`accountID`, `username`, `password`) VALUES (141,'hadi','hadi');
INSERT INTO `login` (`accountID`, `username`, `password`) VALUES (142,'zahwe','zahwe');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `managerID` int NOT NULL AUTO_INCREMENT,
  `personID` int NOT NULL,
  `accountId` int NOT NULL,
  PRIMARY KEY (`managerID`),
  KEY `Manager_fk0` (`personID`),
  KEY `Manager_fk1` (`accountId`),
  KEY `pri` (`managerID`) USING BTREE,
  CONSTRAINT `Manager_fk0` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  CONSTRAINT `Manager_fk1` FOREIGN KEY (`accountId`) REFERENCES `account` (`accountID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`managerID`, `personID`, `accountId`) VALUES (1,1,1);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `personID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `middleName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `emailAddres` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `homePhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `workPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`personID`),
  KEY `pri` (`personID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`personID`, `firstName`, `middleName`, `lastName`, `address1`, `address2`, `city`, `country`, `emailAddres`, `homePhone`, `workPhone`) VALUES (1,'ADMIN','ADMIN','ADMIN','','','','','ADMIN@BANK.COM','','');
INSERT INTO `person` (`personID`, `firstName`, `middleName`, `lastName`, `address1`, `address2`, `city`, `country`, `emailAddres`, `homePhone`, `workPhone`) VALUES (43,'Hadi','Hassan','Hasan','Address1','Address2','Beirut','Lebanon','Hadihassan09@gmail.com','76404595','76404595');
INSERT INTO `person` (`personID`, `firstName`, `middleName`, `lastName`, `address1`, `address2`, `city`, `country`, `emailAddres`, `homePhone`, `workPhone`) VALUES (44,'Mohammad','zahwe','s','Address1','Address2','Beirut','Lebanon','zahwe@gmail.com','1234567','1234567');
INSERT INTO `person` (`personID`, `firstName`, `middleName`, `lastName`, `address1`, `address2`, `city`, `country`, `emailAddres`, `homePhone`, `workPhone`) VALUES (46,'Doctor','Dbok','Mohammad','Address1','Address2','Beirut','Lebanon','unknown@gmail.com','123456789','123456789');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savinginterestsrates`
--

DROP TABLE IF EXISTS `savinginterestsrates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savinginterestsrates` (
  `interestSavingRateID` int NOT NULL AUTO_INCREMENT,
  `interestRateValue` int NOT NULL,
  `interestRateDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`interestSavingRateID`),
  KEY `pri` (`interestSavingRateID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savinginterestsrates`
--

LOCK TABLES `savinginterestsrates` WRITE;
/*!40000 ALTER TABLE `savinginterestsrates` DISABLE KEYS */;
INSERT INTO `savinginterestsrates` (`interestSavingRateID`, `interestRateValue`, `interestRateDescription`) VALUES (1,0,'No InterestRate');
INSERT INTO `savinginterestsrates` (`interestSavingRateID`, `interestRateValue`, `interestRateDescription`) VALUES (2,500,'Rate per month is 500$');
/*!40000 ALTER TABLE `savinginterestsrates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionlog`
--

DROP TABLE IF EXISTS `transactionlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactionlog` (
  `transactionID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `accountID` int NOT NULL,
  `transactionTypeID` int NOT NULL,
  `transactionDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `transactionAmount` int NOT NULL,
  `newBalance` int NOT NULL,
  PRIMARY KEY (`transactionID`),
  KEY `transactionLog_fk0` (`customerID`),
  KEY `transactionLog_fk1` (`accountID`),
  KEY `transactionLog_fk2` (`transactionTypeID`),
  KEY `pri` (`transactionID`) USING BTREE,
  CONSTRAINT `transactionLog_fk0` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  CONSTRAINT `transactionLog_fk1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`),
  CONSTRAINT `transactionLog_fk2` FOREIGN KEY (`transactionTypeID`) REFERENCES `transactiontype` (`transactionTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionlog`
--

LOCK TABLES `transactionlog` WRITE;
/*!40000 ALTER TABLE `transactionlog` DISABLE KEYS */;
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (56,28,141,3,'2020-03-28 21:06:12',15000,515000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (57,28,141,5,'2020-03-28 21:06:29',15000,497000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (58,29,142,7,'2020-03-28 21:06:29',15000,1515000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (59,28,141,9,'2020-03-28 21:09:52',100000,597000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (60,28,141,5,'2020-03-28 21:10:38',500000,94000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (61,29,142,7,'2020-03-28 21:10:38',500000,2015000);
INSERT INTO `transactionlog` (`transactionID`, `customerID`, `accountID`, `transactionTypeID`, `transactionDate`, `transactionAmount`, `newBalance`) VALUES (62,29,142,9,'2020-03-28 21:29:40',500000,2515000);
/*!40000 ALTER TABLE `transactionlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactiontype` (
  `transactionTypeID` int NOT NULL AUTO_INCREMENT,
  `transactionTypeName` varchar(25) NOT NULL,
  `transactionTypeDescription` varchar(25) NOT NULL,
  `transactionFeeAmount` varchar(25) NOT NULL,
  PRIMARY KEY (`transactionTypeID`),
  KEY `pri` (`transactionTypeID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontype`
--

LOCK TABLES `transactiontype` WRITE;
/*!40000 ALTER TABLE `transactiontype` DISABLE KEYS */;
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (1,'DollarTransaction','Withdrawing Currency in D','1');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (2,'LebaneseTransaction','Withdrawing Currency in L','500');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (3,'lebaneseDeposit','Deposit in Lebanese','0');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (4,'dollarDeposit','Deposit in Dollar','0');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (5,'LebaneseTransfer','Transfer in Lebanese','3000');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (6,'DollarTransfer','Transfer in Dollar','2');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (7,'receivedLebanese','Receiving in Lebanese','0');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (8,'receivedDollar','Receiving in Dollar','0');
INSERT INTO `transactiontype` (`transactionTypeID`, `transactionTypeName`, `transactionTypeDescription`, `transactionFeeAmount`) VALUES (9,'Loan','Requesting Loan','0');
/*!40000 ALTER TABLE `transactiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `users`
--

DROP TABLE IF EXISTS `users`;
/*!50001 DROP VIEW IF EXISTS `users`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `users` AS SELECT 
 1 AS `username`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'bank_system'
--

--
-- Dumping routines for database 'bank_system'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_person` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_person`(
IN fname varchar(255),
IN lname varchar(255),
IN mname varchar(255),
IN add1 varchar(255),
IN add2 varchar(255),
IN city varchar(255),
IN country varchar(255),
IN email varchar(255),
IN hphone varchar(255),
IN wphone varchar(255),
IN intrestid int,
IN currbalance int,
IN income int,
IN username varchar(255),
IN pass varchar(255)
)
BEGIN
	declare accountid int;
    declare personid int;
    declare customerid int;
    START TRANSACTION;
		insert into person (firstname,middlename,lastname,address1,address2,city,country,emailAddres,homePhone,workPhone) VALUES (fname,mname,lname,add1,add2,city,country,email,hphone,wphone);
		set personid = last_insert_id();
		
		insert into `account` (accountTypeID) values (3);
		set accountid = last_insert_id();
		
		insert into customer (personID,accountID) values (personid,accountid);
		set customerid = last_insert_id();
	   
	   insert into customerAccount (customerID,accountID,interestSavingRateID,currentBalance,customerIncome) values (customerid,accountid,intrestid,currbalance,income);
	   insert into  login values (accountid,username,pass);
    COMMIT;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_reception` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_reception`(
IN fname varchar(255),
IN lname varchar(255),
IN mname varchar(255),
IN add1 varchar(255),
IN add2 varchar(255),
IN city varchar(255),
IN country varchar(255),
IN email varchar(255),
IN hphone varchar(255),
IN wphone varchar(255),
IN user varchar(255),
IN pass varchar(255)
)
BEGIN
	declare accountid int;
    declare personid int;
    
    START TRANSACTION;
		IF NOT EXISTS(SELECT firstname FROM person WHERE emailAddres = email) THEN
			IF NOT EXISTS(SELECT accountID FROM login WHERE username = user) THEN
				insert into person (firstname,middlename,lastname,address1,address2,city,country,emailAddres,homePhone,workPhone) VALUES (fname,mname,lname,add1,add2,city,country,email,hphone,wphone);
				set personid = last_insert_id();
				
				insert into `account` (accountTypeID) values (2);
				set accountid = last_insert_id();
				
				insert into employee (personID,accountID) values (personid,accountid);
				
			   insert into  login values (accountid,user,pass);
			END IF;
		END IF;
	COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkExistCustomer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkExistCustomer`(
IN id int,
OUT flag int
)
BEGIN
	set flag = 0;
    IF(SELECT personID FROM Customer WHERE accountID=id) THEN
		set flag = 1;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkExistEmployee` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkExistEmployee`(
IN id int,
OUT flag int
)
BEGIN
	set flag = 0;
    IF (SELECT personID FROM Employee WHERE employeeID=id) THEN
		set flag = 1;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkExistUser` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkExistUser`(
IN nameuser varchar(200),
OUT flag int
)
BEGIN
	set flag = 0;
    IF (SELECT accountID FROM login WHERE username=nameuser) THEN
		set flag = 1;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `depositMoney` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `depositMoney`(
IN accID int,
IN amount int,
OUT flag int
)
BEGIN
    declare custID int;
    declare balance int;
    set flag = 0;
    START TRANSACTION;
		IF(SELECT customerID FROM customerAccount where accountID=accID) THEN
			SELECT customerID,currentBalance INTO custID,balance FROM customerAccount where accountID=accID;
            set balance = balance + amount;
			UPDATE customerAccount Set currentBalance=Balance WHERE accountID=accID;
			INSERT INTO `transactionLog` (`customerID`,`accountID`,`transactionTypeID`,`transactionAmount`,`newBalance`) VALUES (custID,accID,3,amount,Balance);
			set flag = 1;
		END IF;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getCurrentBalance` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCurrentBalance`(
IN id int,
OUT balance double,
OUT flag int
)
BEGIN
	set flag = 0;
    set balance = 0;
    IF(SELECT currentBalance FROM customeraccount where customerID=id) THEN
		SELECT currentBalance INTO balance FROM customeraccount where customerID=id;
		set flag = 1;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeCustomer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeCustomer`(
IN id int,
OUT flag int
)
BEGIN
	declare accID int;
    declare perID int;
	set flag = 0;

		IF(SELECT accountID FROM Customer WHERE customerID=id) THEN
            START TRANSACTION;
				SELECT accountID,personID INTO accID,perID FROM Customer WHERE customerID=id;
				DELETE FROM customerAccount WHERE customerID=id;
				DELETE FROM Customer WHERE customerID=id;
				DELETE FROM Person WHERE personID=perID;
				DELETE FROM login WHERE accountID=accID;
				DELETE FROM Account WHERE accountID=accID;
				set flag = 1;
			COMMIT;
		END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeReception` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeReception`(
IN id int,
OUT flag int
)
BEGIN
	declare accID int;
    declare perID int;
	set flag = 0;
    START TRANSACTION;
		IF(SELECT accountID FROM employee WHERE employeeID=id) THEN
			SELECT accountID,personID INTO accID,perID FROM employee WHERE employeeID=id;
			DELETE FROM Employee WHERE employeeID=id;
			DELETE FROM Person WHERE personID=perID;
			DELETE FROM login WHERE accountID=accID;
			DELETE FROM Account WHERE accountID=accID;
			set flag = 1;
		END IF;
	COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `requestLoan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `requestLoan`(
IN amount int,
IN descript varchar(500),
IN custID int
)
BEGIN
	declare accID int;
    declare custIncome int;
    IF(SELECT accountID FROM customerAccount where customerID=custID) THEN
		SELECT accountID,customerIncome INTO accID,custIncome FROM customerAccount where customerID=custID;
		INSERT INTO loans (`accountID`,`loanAmount`,`loanDescription`,`customerIncome`) VALUES (accID,amount,descript,custIncome);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sendFeedBack` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sendFeedBack`(
IN text varchar(500),
IN id int,
OUT flag int
)
BEGIN
	declare accID int;
    set flag = 0;
    IF(SELECT accountID from Customer WHERE customerID=id) THEN
		set flag = 1;
		SELECT accountID INTO accID from Customer WHERE customerID=id;
		INSERT INTO Feedbacks (`accountID`,`feedBackDescription`) VALUES (accID,text);
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `submit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `submit`(
IN LID int,
IN status int,
OUT flag int 
)
BEGIN
    declare accID int;
    declare amount int;
    declare balance int;
    declare custID int;
	set flag = 0;
    START TRANSACTION;
		IF status = 1 THEN
			IF(SELECT accountID FROM loans WHERE loanID=LID) THEN
				SELECT accountID,loanAmount INTO accID,amount FROM loans WHERE loanID=LID;
				SELECT currentBalance,customerID INTO balance,custID FROM customerAccount WHERE accountID=accID;
				set balance = balance + amount;
				UPDATE customerAccount SET currentBalance= balance WHERE accountID=accID;
				UPDATE loans SET status='accepted' WHERE loanID=LID;
				INSERT INTO `transactionLog` (`customerID`,`accountID`,`transactionTypeID`,`transactionAmount`,`newBalance`) VALUES (custID,accID,9,amount,balance);
				set flag = 1;
			END IF;
		ELSE IF status = 0 THEN
			UPDATE loans SET status='rejected' WHERE loanID=LID;
			set flag = 1;
			END IF;
		END IF;
	COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `transferMoney` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `transferMoney`(
IN senderID int,
IN receiverID int,
IN amount double,
OUT flag int
)
BEGIN
    declare fee int;
	declare custID int;
    declare recID int;
    declare Balance double;
    declare curBalance double;
    declare totalpay double;

    START TRANSACTION;
    SELECT transactionFeeAmount INTO fee FROM transactionType WHERE transactionTypeID=5;
	SELECT customerID INTO custID FROM Customer WHERE accountID=senderID;
    SELECT currentBalance INTO Balance FROM customerAccount WHERE customerID=custID;
    set totalpay = fee+amount;
    IF Balance >= totalpay THEN
		set flag = 1;
        set Balance = Balance -totalpay;
		UPDATE customerAccount SET currentBalance=Balance WHERE customerID=custID;
        
        SELECT customerID INTO recID FROM Customer WHERE accountID=receiverID;
        SELECT currentBalance INTO curBalance FROM customerAccount WHERE customerID=recID;
		set curBalance = curBalance + amount;
        UPDATE customerAccount SET currentBalance=curBalance WHERE customerID=recID;
        
        INSERT INTO transactionLog (`customerID`,`accountID`,`transactionTypeID`,`transactionAmount`,`newBalance`) VALUES (custID,senderID,5,amount,Balance);
        INSERT INTO transactionLog (`customerID`,`accountID`,`transactionTypeID`,`transactionAmount`,`newBalance`) VALUES (recID,receiverID,7,amount,curBalance);
	ELSE
		set flag = 0;
    END IF;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `withdraw` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `withdraw`(
IN custID int,
IN accID int,
IN amount double,
IN balance double,
IN typetrans int,
OUT flag int
)
BEGIN
    declare fee int;
    declare totalpay double;

    START TRANSACTION;
		SELECT transactionFeeAmount INTO fee FROM transactionType WHERE transactionTypeID=typetrans;
		IF typetrans=1 THEN
			set amount = amount*1515;
			set totalpay = fee+amount;
		ELSE
			set totalpay = fee+amount;
		END IF;

		IF balance > totalpay THEN
			set flag = 1;
			set balance = balance-totalpay;
			UPDATE customeraccount SET currentBalance=balance WHERE customerID=custID;
			INSERT INTO transactionLog (`customerID`,`accountID`,`transactionTypeID`,`transactionAmount`,`newBalance`) VALUES (custID,accID,typetrans,amount,balance);
		ELSE
			set flag = 0;
		END IF;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `accountview`
--

/*!50001 DROP VIEW IF EXISTS `accountview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `accountview` AS select `account`.`accountID` AS `accountID`,`account`.`accountTypeID` AS `accountTypeID` from `account` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `allloans`
--

/*!50001 DROP VIEW IF EXISTS `allloans`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `allloans` AS select `loans`.`loanID` AS `loanID`,`loans`.`loanAmount` AS `loanAmount`,`loans`.`loanDescription` AS `loanDescription`,`loans`.`customerIncome` AS `customerIncome`,`loans`.`status` AS `status` from `loans` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customerfull`
--

/*!50001 DROP VIEW IF EXISTS `customerfull`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customerfull` AS select `ca`.`currentBalance` AS `currentBalance`,`ca`.`customerIncome` AS `customerIncome`,`p`.`firstName` AS `firstName`,`p`.`middleName` AS `middleName`,`p`.`lastName` AS `lastName`,`p`.`address1` AS `address1`,`p`.`city` AS `city`,`p`.`country` AS `country`,`p`.`homePhone` AS `homePhone`,`act`.`accountTypeDescription` AS `accountTypeDescription` from ((((`customeraccount` `ca` join `customer` `c`) join `person` `p`) join `account` `a`) join `accounttype` `act`) where ((`ca`.`customerID` = `c`.`customerID`) and (`p`.`personID` = `c`.`personID`) and (`a`.`accountID` = `c`.`accountID`) and (`act`.`accountTypeID` = `a`.`accountTypeID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `users`
--

/*!50001 DROP VIEW IF EXISTS `users`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `users` AS select `login`.`username` AS `username` from `login` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-28 23:31:11
