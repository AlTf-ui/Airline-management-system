-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 05:05 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline_mangement_system_sql`
--

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `FLIGHTNUMBER` varchar(255) NOT NULL,
  `DEPARTURECITY` varchar(255) NOT NULL,
  `ARRIVALCITY` varchar(255) NOT NULL,
  `PSSN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`FLIGHTNUMBER`, `DEPARTURECITY`, `ARRIVALCITY`, `PSSN`) VALUES
('DA512', 'JEDDAH', 'DAMMAM', 6698),
('FA562', 'ROMA', 'BARCELONA', 2194),
('HA774', 'RIYAD', 'KHOBAR', 6698),
('PA443', 'DAMMAM', 'JEDDAH', 8794),
('SA112', 'ROMA', 'MALDIVES', 5568),
('YZ445', 'BEIRUT', 'DAMASCUS', 5568);

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE `passenger` (
  `passportnumber` int(11) NOT NULL,
  `AGE` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `GENDER` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passenger`
--

INSERT INTO `passenger` (`passportnumber`, `AGE`, `NAME`, `GENDER`) VALUES
(25984, 23, 'Mariam', 'female'),
(47932, 25, 'tony', 'male'),
(55743, 50, 'amal', 'female'),
(58946, 55, 'yazan', 'male'),
(100100, 25, 'Shady', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `pilots`
--

CREATE TABLE `pilots` (
  `SSN` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pilots`
--

INSERT INTO `pilots` (`SSN`, `NAME`, `age`) VALUES
(2194, 'MOHAMAD', 26),
(5498, 'FATIMA', 23),
(5568, 'ZEINAB', 55),
(6698, 'RIYAD', 48),
(8794, 'MALEK', 43);

--
-- Triggers `pilots`
--
DELIMITER $$
CREATE TRIGGER `check_age` BEFORE INSERT ON `pilots` FOR EACH ROW BEGIN
IF (new.age<0) THEN
UPDATE age set new.age=-new.age where SSN = new.ssn;
end if ;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reserves`
--

CREATE TABLE `reserves` (
  `FLIGHTNUMBER` varchar(255) DEFAULT NULL,
  `passportnumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reserves`
--

INSERT INTO `reserves` (`FLIGHTNUMBER`, `passportnumber`) VALUES
('FA562', 25984),
('PA443', 55743),
('HA774', 58946);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`FLIGHTNUMBER`),
  ADD KEY `PSSN` (`PSSN`);

--
-- Indexes for table `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`passportnumber`);

--
-- Indexes for table `pilots`
--
ALTER TABLE `pilots`
  ADD PRIMARY KEY (`SSN`);

--
-- Indexes for table `reserves`
--
ALTER TABLE `reserves`
  ADD KEY `fk_passenger` (`passportnumber`),
  ADD KEY `fk_flights` (`FLIGHTNUMBER`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`PSSN`) REFERENCES `pilots` (`SSN`);

--
-- Constraints for table `reserves`
--
ALTER TABLE `reserves`
  ADD CONSTRAINT `fk_flights` FOREIGN KEY (`FLIGHTNUMBER`) REFERENCES `flights` (`FLIGHTNUMBER`),
  ADD CONSTRAINT `fk_passenger` FOREIGN KEY (`passportnumber`) REFERENCES `passenger` (`passportnumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
