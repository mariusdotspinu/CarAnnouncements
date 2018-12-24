CREATE TABLE car_announcements.`user` (
  `id` mediumint(9) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`email`,`password`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE car_announcements.`announcements` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `fabrication_date` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE car_announcements.`announcement_images` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `image` longblob,
  `announcement_id` mediumint(8) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `announcement_id` (`announcement_id`),
  CONSTRAINT `announcements_ibfk_1` FOREIGN KEY (`announcement_id`) REFERENCES `announcements` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
