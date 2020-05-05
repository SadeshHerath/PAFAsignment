-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 05, 2020 at 06:05 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apphealthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `doctorID` int(11) NOT NULL AUTO_INCREMENT,
  `doctorName` varchar(30) NOT NULL,
  `specialization` varchar(30) NOT NULL,
  `doctorUsername` varchar(30) NOT NULL,
  `doctorPassword` varchar(39) NOT NULL,
  PRIMARY KEY (`doctorID`)
) ENGINE=MyISAM AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorID`, `doctorName`, `specialization`, `doctorUsername`, `doctorPassword`) VALUES
(62, 'Anuradha', 'Anesthesiology', 'Anuradha', 'herath'),
(61, 'sadesh', 'Cardiologist', 'sadesh5', 'sadesh345'),
(60, 'Herath', 'psychiatrist', 'herath123', 'herath124'),
(65, 'Prabuddhi', 'Anesthesiologist', 'Prabuddhi5', 'Prabu'),
(66, 'Thakshila', 'Cardiologist', 'Thakshila123', 'Thakshi123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
