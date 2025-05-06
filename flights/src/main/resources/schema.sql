CREATE TABLE IF NOT EXISTS `airline` (
  `airline_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `iato_code` varchar(100) NOT NULL,
  `icao_code` varchar(100) NOT NULL,
  `country` varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `flight` (
  `airline_id` int NOT NULL,
   `flight_id` int AUTO_INCREMENT  PRIMARY KEY,
  `origin` varchar(100) NOT NULL,
  `destination` varchar(200) NOT NULL,
  `departure_time` date NOT NULL,
  `arrival_time` date NOT NULL,
  `price` float NOT NULL,
   `created_at` date DEFAULT NULL,
   `updated_at` date DEFAULT NULL
);