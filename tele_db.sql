-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2016 at 03:59 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tele_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tele_chargecards`
--

CREATE TABLE `tele_chargecards` (
  `id` int(11) NOT NULL,
  `code` varchar(15) NOT NULL,
  `value` int(11) NOT NULL,
  `used` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_chargecards`
--

INSERT INTO `tele_chargecards` (`id`, `code`, `value`, `used`) VALUES
(1, '02582103245444', 10, 1),
(2, '45575603305841', 10, 1),
(3, '16702602642408', 10, 1),
(4, '23087801063382', 10, 1),
(5, '25244765775727', 10, 1),
(6, '68737612416815', 10, 0),
(7, '16501531380620', 10, 0),
(8, '16308722486570', 10, 0),
(9, '84028725612504', 10, 0),
(10, '36143726224288', 10, 0),
(11, '46660723703186', 20, 0),
(12, '56558045811626', 20, 0),
(13, '74552341546661', 20, 0),
(14, '75638746628885', 20, 0),
(15, '70328423507106', 20, 0),
(16, '21301570131665', 20, 0),
(17, '56677726822703', 20, 0),
(18, '15228780822323', 20, 0),
(19, '66858023115082', 20, 0),
(20, '11073668105361', 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tele_internetpackage`
--

CREATE TABLE `tele_internetpackage` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `fees` int(11) NOT NULL,
  `quota` int(11) NOT NULL,
  `des` varchar(254) NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_internetpackage`
--

INSERT INTO `tele_internetpackage` (`id`, `name`, `fees`, `quota`, `des`, `duration`) VALUES
(1, 'Online 20', 10, 1024, 'Enjoy 1024 MB', 30),
(16, 'Online 10', 10, 512, 'Enjoy 512 MB', 30);

-- --------------------------------------------------------

--
-- Table structure for table `tele_smscallpackage`
--

CREATE TABLE `tele_smscallpackage` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `fees` int(11) NOT NULL,
  `sms` int(11) NOT NULL,
  `call` int(11) NOT NULL,
  `des` varchar(254) NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_smscallpackage`
--

INSERT INTO `tele_smscallpackage` (`id`, `name`, `fees`, `sms`, `call`, `des`, `duration`) VALUES
(1, 'Hkawy 20', 20, 50, 100, 'Enjoy 100 minutes and 50 sms', 30),
(2, 'Hkawy 50', 50, 100, 300, 'Enjoy 300 minutes and 100 sms', 30),
(3, 'Flex', 15, 10, 10, 'This is description of flex', 25);

-- --------------------------------------------------------

--
-- Table structure for table `tele_user`
--

CREATE TABLE `tele_user` (
  `id` int(11) NOT NULL,
  `phone_id` varchar(30) NOT NULL,
  `password` varchar(254) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(254) NOT NULL,
  `type` varchar(10) NOT NULL,
  `reg_date` datetime NOT NULL,
  `credit` int(11) NOT NULL,
  `lostpassanswer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_user`
--

INSERT INTO `tele_user` (`id`, `phone_id`, `password`, `name`, `email`, `type`, `reg_date`, `credit`, `lostpassanswer`) VALUES
(1, '01220002323', '$2a$10$YLiWeqzbJzaiI6YF3h9elODsYBYlw/F0WZok6jF26b29JdvtT62fu', 'ahmed mansy', 'ahmed.mansy156@gmail.com', 'ADMIN', '2016-05-12 00:00:00', 0, ''),
(3, '123456', '$2a$10$.pwxjoiK5BDTCSAfodbdBO3dEEEkgO4C.EA6cetsRW0jSAvT5wqXW', 'Ahmed Mansy El Deeb', 'ahmed.mansy@msn.com', 'USER', '2016-05-13 06:44:36', 0, ''),
(4, '123456789', '$2a$10$1abk77Tm2ScJr3nikl15ne5zsnK2mWkjM/8RPSXhyxTsYYpgFHxxq', 'Mansk', 'test@test.com', 'USER', '2016-05-15 10:47:19', 10, 'nokia'),
(5, '012345678', '$2a$10$I4yYlSVQ1hu1wCjMORX6qu/Rc80kVyw5Wr6OeDxHsjGnefgxweXn2', 'Mansy', 'test@x.com', 'USER', '2016-05-15 15:23:45', 5, 'nokia');

-- --------------------------------------------------------

--
-- Table structure for table `tele_user_internetpackage`
--

CREATE TABLE `tele_user_internetpackage` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `internetpackage_id` int(11) NOT NULL,
  `activated` tinyint(1) NOT NULL,
  `registered_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_user_internetpackage`
--

INSERT INTO `tele_user_internetpackage` (`id`, `user_id`, `internetpackage_id`, `activated`, `registered_date`) VALUES
(1, 1, 16, 0, '2016-05-14 07:44:11'),
(8, 1, 1, 0, '2016-05-14 11:21:43'),
(9, 1, 16, 0, '2016-05-14 11:22:33'),
(10, 1, 1, 0, '2016-05-14 13:01:34');

-- --------------------------------------------------------

--
-- Table structure for table `tele_user_smscallpackage`
--

CREATE TABLE `tele_user_smscallpackage` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `smscallpackage_id` int(11) NOT NULL,
  `activated` tinyint(1) NOT NULL,
  `registered_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tele_user_smscallpackage`
--

INSERT INTO `tele_user_smscallpackage` (`id`, `user_id`, `smscallpackage_id`, `activated`, `registered_date`) VALUES
(1, 1, 1, 0, '2016-05-15 06:05:21'),
(2, 1, 1, 0, '2016-05-15 06:10:47'),
(3, 1, 1, 0, '2016-05-15 06:34:55'),
(4, 5, 3, 1, '2016-05-15 15:32:26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `tele_chargecards`
--
ALTER TABLE `tele_chargecards`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tele_internetpackage`
--
ALTER TABLE `tele_internetpackage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tele_smscallpackage`
--
ALTER TABLE `tele_smscallpackage`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tele_user`
--
ALTER TABLE `tele_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone_id` (`phone_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `tele_user_internetpackage`
--
ALTER TABLE `tele_user_internetpackage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`user_id`),
  ADD KEY `fk_internetpackage` (`internetpackage_id`);

--
-- Indexes for table `tele_user_smscallpackage`
--
ALTER TABLE `tele_user_smscallpackage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`user_id`),
  ADD KEY `fk_smscallpackage` (`smscallpackage_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tele_chargecards`
--
ALTER TABLE `tele_chargecards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `tele_internetpackage`
--
ALTER TABLE `tele_internetpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `tele_smscallpackage`
--
ALTER TABLE `tele_smscallpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tele_user`
--
ALTER TABLE `tele_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tele_user_internetpackage`
--
ALTER TABLE `tele_user_internetpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `tele_user_smscallpackage`
--
ALTER TABLE `tele_user_smscallpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tele_user_internetpackage`
--
ALTER TABLE `tele_user_internetpackage`
  ADD CONSTRAINT `fk_internetpackage` FOREIGN KEY (`internetpackage_id`) REFERENCES `tele_internetpackage` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `tele_user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
