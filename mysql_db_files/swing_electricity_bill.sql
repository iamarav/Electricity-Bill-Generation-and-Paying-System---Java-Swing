-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 15, 2018 at 10:50 AM
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
-- Database: `swing_electricity_bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `billdetails`
--

DROP TABLE IF EXISTS `billdetails`;
CREATE TABLE IF NOT EXISTS `billdetails` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `acno` varchar(1000) DEFAULT NULL,
  `billDate` varchar(1000) DEFAULT NULL,
  `paid` int(2) NOT NULL DEFAULT '0',
  `billAmt` varchar(1000) DEFAULT NULL,
  `custname` varchar(1000) DEFAULT NULL,
  `custaddr` varchar(10000) DEFAULT NULL,
  `custcity` varchar(1000) DEFAULT NULL,
  `custcontact` varchar(1000) DEFAULT NULL,
  `unitconsumed` varchar(1000) DEFAULT NULL,
  `unitprice` varchar(1000) DEFAULT NULL,
  `xyz` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetails`
--

DROP TABLE IF EXISTS `customerdetails`;
CREATE TABLE IF NOT EXISTS `customerdetails` (
  `id` int(100) DEFAULT NULL,
  `acno` varchar(1000) DEFAULT NULL,
  `custname` varchar(10000) DEFAULT NULL,
  `custContact` varchar(1000) DEFAULT NULL,
  `custaddr` varchar(1000) DEFAULT NULL,
  `custcity` varchar(10000) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `merchantfeedback`
--

DROP TABLE IF EXISTS `merchantfeedback`;
CREATE TABLE IF NOT EXISTS `merchantfeedback` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `uname` varchar(1000) DEFAULT NULL,
  `email` varchar(1000) DEFAULT NULL,
  `msg` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `uname` varchar(1000) DEFAULT NULL,
  `name` varchar(1000) NOT NULL DEFAULT '',
  `upass` varchar(1000) DEFAULT NULL,
  `confirmed` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
