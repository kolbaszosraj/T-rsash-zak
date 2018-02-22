-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1:3306
-- Létrehozás ideje: 2018. Feb 22. 14:02
-- Kiszolgáló verziója: 5.7.19
-- PHP verzió: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `tarsashazkezelo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hazak`
--

DROP TABLE IF EXISTS `hazak`;
CREATE TABLE IF NOT EXISTS `hazak` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `kerulet` int(11) DEFAULT NULL,
  `varos` varchar(300) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `haz` varchar(300) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `utca` varchar(300) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `hazszam` int(10) DEFAULT NULL,
  `tk_ID` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tk_ID` (`tk_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `hazak`
--

INSERT INTO `hazak` (`id`, `kerulet`, `varos`, `haz`, `utca`, `hazszam`, `tk_ID`) VALUES
(1, 1133, 'Budapest', 'Kertes', 'Váci', 2, 1),
(2, 1140, 'Kerepes', 'Panel', 'Pázsit', 2, 2),
(3, 1456, 'Győr', 'Társas', 'Lujza', 22, 3),
(4, 1515, 'Kispest', 'közös', 'mindegy', 221, 4),
(5, 1183, 'Budapest', 'Kertes', 'Nap', 26, 5),
(6, 6811, 'Kairó', 'Tömb', 'cyka', 25, 6);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hazkezelok`
--

DROP TABLE IF EXISTS `hazkezelok`;
CREATE TABLE IF NOT EXISTS `hazkezelok` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nev` varchar(300) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `hazkezelok`
--

INSERT INTO `hazkezelok` (`id`, `nev`) VALUES
(1, 'Bádogos Krisztián'),
(2, 'Mész Elek'),
(3, 'Kiss János'),
(4, 'Vinczent Vangog'),
(5, 'Kecskés Eszter'),
(6, 'Kiss Éva');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `lakok`
--

DROP TABLE IF EXISTS `lakok`;
CREATE TABLE IF NOT EXISTS `lakok` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `neve` varchar(300) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `emelet` int(30) NOT NULL,
  `ajto` int(30) NOT NULL,
  `negyzetmeter` int(255) NOT NULL,
  `Hz_ID` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Hz_ID` (`Hz_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `lakok`
--

INSERT INTO `lakok` (`id`, `neve`, `emelet`, `ajto`, `negyzetmeter`, `Hz_ID`) VALUES
(1, 'Kis elemér', 5, 11, 20, 1),
(2, 'Kiss Méreg', 0, 0, 20, 1),
(3, 'Nagy timea', 0, 0, 100, 2);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `hazak`
--
ALTER TABLE `hazak`
  ADD CONSTRAINT `hazak_ibfk_1` FOREIGN KEY (`tk_ID`) REFERENCES `hazkezelok` (`id`);

--
-- Megkötések a táblához `lakok`
--
ALTER TABLE `lakok`
  ADD CONSTRAINT `lakok_ibfk_1` FOREIGN KEY (`Hz_ID`) REFERENCES `hazak` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
