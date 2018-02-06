-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2018. Jan 22. 16:41
-- Kiszolgáló verziója: 5.7.14
-- PHP verzió: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `tarsas`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `adatok`
--

CREATE TABLE `adatok` (
  `id` int(11) NOT NULL,
  `nev` varchar(30) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `lakhely` varchar(50) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `emelet` int(50) COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `ev` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `adatok`
--

INSERT INTO `adatok` (`id`, `nev`, `lakhely`, `emelet`, `ev`) VALUES
(1, 'Kiss Ádám', 'Lujza utca', 'Foundation', 2000),
(2, 'Asimov Isaac', 'Alapítvány és Birodalom', 'Foundation and Empire', 1952),
(3, 'Asimov Isaac', 'Második Alapítvány', 'Second Foundation', 1953),
(4, 'Asimov Isaac', 'Alapítvány és Föld', 'Foundation and Earth', 1986),
(5, 'Asimov Isaac', 'Az Alapítvány pereme', 'Foundation\'s Edge', 1982),
(6, 'Asimov Isaac', 'A halhatatlanság halála', 'The End of Ethernity', 1955),
(7, 'Asimov Isaac', 'A mezítelen nap', 'The naked sun', 1964),
(8, 'Pohl e. - Kornbluth C.M', 'Dr. Gladiátor', 'Gladiator-at-law', 1955),
(9, 'Sheckley Robert', 'A státuscivilizáció', 'The Status Civilization', 1960),
(10, 'Herbert Frank', 'Dűne', 'Dune', 1965),
(11, 'Pohl Frederik', 'Az átjáró', 'Gateway', 1977),
(12, 'Pohl Frederik', 'Túl a kék eseményhorizonton', 'Beyond the Blue Event Horizon', 1980),
(13, 'Boulle Pierre', 'A majmok bolygója', 'La planetedes singes', 1963),
(14, 'Bradley Marion Zimmer', 'Darkover', 'Darkover Landfall', 1972),
(15, 'Srurgeon Theodore', 'Több mint emberi', 'More Than Human', 1953),
(16, 'Dick Philip K.', 'Ubik', 'Ubik', 1969),
(17, 'Roshwald M.', 'A hetedik szint', 'Level 7', 1959),
(18, 'Bester Alfred', 'Tigris! Tigris!', 'The Stars My Destination', 1956),
(19, 'Leiber Fritz', 'A vándor', 'The Wanderer', 1964),
(20, 'Huxley Aldous', 'Szép új világ', 'Brave New World', 1932),
(21, 'Duvic Patrice', 'Végállomás', 'Terminus', 1987),
(22, 'Simak Clifford D.', 'A város', 'City', 1952),
(23, 'Wyndham John', 'A Triffidek napja', 'The Day of Triffids', 1958),
(24, 'Holberg Ludvig', 'Klimius Miklós', '', 1773),
(25, 'Brunner John', 'Teljes napfogyatkozás', 'Total Eclipse', 1975),
(26, 'Bulicsov Kir.', 'Az utolsó háború', 'Pászlédnjájá vájná', 1970),
(27, 'Sztrugackij A. és B.', 'Válaszd az életet', 'Volnü gászjáty bétyer', 1985),
(28, 'Abbott Edwin A.', 'Síkföld', 'Flatland', 1962),
(29, 'Johannesson Olof', 'A nagy számítógép', 'Sagan om den Stora Datamaskin.', 1966),
(30, 'Clement Hal', 'Csillagfény', 'Star Light', 1971),
(31, 'Cherryh C. J.', 'Mélyállomás', 'Downbelow Station', 1981),
(32, 'Fialkowski Konrad', 'Homo divisus', '', 1979),
(33, 'Hollanek Adam', 'Még egy kicsit élni', 'Jeszce troche pozyc', 1980),
(34, 'Szakjo Komacu', 'A sárkány halála', 'Gibel Drákóná', 1977),
(35, 'Lucas Georges', 'Csillagok háborúja', 'Star Wars', 1976),
(36, 'Glut Donald F.', 'A Birodalom visszavág', 'The Empire Strikes Back', 1980),
(37, 'Simonetta Umberto', 'Éjszakai utazók', 'I viaggiatori della sera', 1976),
(38, 'Hoyle F. - Elliot J.', 'Androméda', 'A For Andromeda', 1964),
(39, 'Soucel Ludvik', 'A fekete bolygó testvérei', '', 1969),
(40, 'Sztrugackij A. és B.', 'Egymilliárd évvel a világvége előtt', 'Za milliárd let dá koncá szvétá', 1975),
(41, 'Szavcsenko Vlagyimir', 'Monomah sapkája', '', 1971),
(42, 'Konsztantyinovszkij David', 'Az idő fogva tart', '', 1985),
(43, 'Barber Pierre', 'Baphomet birodalma', 'L\'Empire du Baphomet', 1972),
(44, 'Bradbury Ray', 'A tetovált ember', 'The Illustrated Man', 1951),
(45, 'Resnick Mike', 'Agyarak', 'Ivory', 1988),
(46, 'Wisniewski-Snerg Adam', 'A robot', 'Robot', 1973),
(47, 'Adams Dougles', 'Galaxis utikalauz stopposoknak', 'The Hitch Hiker\'s Guide to the Gal.', 1979),
(48, 'Kotzwinkle William', 'E.T. A zöld bolygó könyve', 'E.T. The Book of the Green Planet', 1985),
(49, 'Vezsinyov Pavel', 'A sorompó - A fehér szalamandra', '', 1977),
(50, 'Jakubovszkij Aszkold', 'A galaktika kupolája', 'Kupol Galaktiki', 1976),
(51, 'Dick Philip K.', 'A halál útvesztője', 'A Maze of Death', 1970),
(52, 'Clarke Arthur C.', 'A távoli Föld dalai', 'The Songs of Distant Earth', 1986),
(53, 'Petecko Bohdan', 'Messier 13', 'Messier 13', 1977),
(54, 'Beljajev Alekszander', 'A levegőkereskedő', '', 1963),
(55, 'Anderson Poul', 'Majd ha az Orion felszáll', 'Orion shall rise', 1983),
(56, 'Kahn James', 'A Jedi visszatér', 'Return of the Jedi', 1983),
(57, 'Foster Alan Dean', 'Az utolsó csillagharcos', 'The Last Starfighter', 1984),
(58, 'Foster Alan Dean', 'A bolygó neve : Halál', 'Aliens', 1986),
(59, 'Foster Alan Dean', 'A nyolcadik utas a halál', 'Alien', 1979),
(60, 'Douglas Garry', 'Hegylakó', 'Highlander', 1986),
(61, 'Harrison Harry', 'Rozsdamentes Acélpatkány', 'The Stainless Steal Rat', 1961),
(62, 'Clarke A. C.', 'Randevú a Rámával', 'Randezvous with Rama', 1973),
(63, 'Hughes Ted', 'A Vasember', 'The Iron Man', 1968),
(64, 'Martinov Georgij', 'Az időspirál', 'Szpirál vrémeni', 1968),
(65, 'Spielberg Steven', 'Harmadik típusú találkozások', 'Close Encounters of the Third KInd', 1978),
(66, 'Menghini Luigi', 'A Felhőbirodalom', 'Il regno della nube', 1979),
(67, 'Hiltom James', 'A Kék Hold völgye', 'Lost Horizon', 1935),
(68, 'Vonnegut Kurt', 'A Titán szirénjei', 'The Sirens of Titan', 1959),
(69, 'Miller Walter M. Jr.', 'Hozsánna néked, Leibowitz!', 'A Canticle For Leibowitz', 1970),
(70, 'Braun Johanna - Braun G.', 'A nagy varázsló tévedése', 'Der Irrtum des Grossen Zauberers', 1979),
(71, 'Harrison Harry', 'A technicolor időgép', 'The Technicolor Time Machine', 1967),
(72, 'Kotzwinkle William', 'E.T. A földönkívüli kalandjai.', 'E.T. The Extra-Terrestial', 1982),
(73, 'Wells H. G.', 'Kőkori történet', 'A Story of the Stone Age', 1900),
(74, 'London Jack', 'Ádám előtt', '', 1965),
(75, 'Sznyegov Szergej', 'Istenemberek', 'Ljugyi kak bogi', 1982),
(76, 'Boye Karin', 'Kallocain', 'Kallocain', 1958),
(77, 'Clarke A. C.', '2010. Második űrodisszeia', '2010. Odyssey Two', 1982),
(78, 'Jeschke Wolfgang', 'A teremtés utolsó napja', 'Der letzte Tag der Schöpfung', 1981),
(79, 'Jefremov Ivan', 'A múlt árnyéka', '', 1975),
(80, 'Lem Stanislaw', 'Visszatérés', '', 1964),
(81, 'Fehér Klára', 'A földrengések szigete', '', 1957),
(82, 'Adams Douglas', 'Vendéglő a világ végén', 'The Restaurant at the End of the U.', 1980),
(83, 'Bradley Marion Zimmer', 'A világok háza', 'The House Between the Worlds', 1980),
(84, 'Lewis C. S.', 'A csendes bolygó', 'Out Of The Silent Planet', 1978),
(85, 'Beckman Thea', 'Keresztes hadjárat farmerban', 'Kruistocht in spijkerbroek', 1973),
(86, 'Ballard J. G.', 'Vízbe fúlt világ', 'The Drowned World', 1962);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `adatok`
--
ALTER TABLE `adatok`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `adatok`
--
ALTER TABLE `adatok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
