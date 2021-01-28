-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : jeu. 28 jan. 2021 à 13:41
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `testunit`
--

-- --------------------------------------------------------

--
-- Structure de la table `clientsunit`
--

DROP TABLE IF EXISTS `clientsunit`;
CREATE TABLE IF NOT EXISTS `clientsunit` (
  `ID` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `PRENOM` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NOM` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ADRESSE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `clientsunit`
--

INSERT INTO `clientsunit` (`ID`, `PRENOM`, `NOM`, `ADRESSE`) VALUES
('01A', 'Arthur', 'DESMON', 'arthur@desmon@epsi.fr'),
('02E', 'Eve', 'WALTER', 'eve@walter@epsi.fr'),
('03F', 'Frederic', 'ROBERT', 'frederic@robert@epsi.fr'),
('06G', 'truc', 'BIDULE', 'truc.bidule@epsi.fr'),
('07M', 'petittest', 'TEST', 'petittest.test@epsi.fr');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
