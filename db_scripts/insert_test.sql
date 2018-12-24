-- ANNOUNCEMENTS -- 
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("BMW", "X1", 15.10, current_timestamp(), "Lorem impsum this is my description.", "MyTitle");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("BMW", "X3", 34.100, current_timestamp(), "Lorem impsum this is my description.", "Title 2");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("BMW", "X5", 47.540, '2011-11-11 10:10:10', "Lorem impsum this is my description.", "Title 3");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("BMW", "M2", 347.300, current_timestamp(), "Lorem impsum this is my description.", "Title 4");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("BMW", "M2", 62.200, '2018-11-11 10:10:10', "Lorem impsum this is my description.", "Title 5");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("MERCEDES", "CLS", 7.5770, '2018-11-20 10:10:10', "Lorem impsum this is my description.", "Title 6");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("VOLVO", "XC90", 457.500, '2018-11-19 10:10:10', "Lorem impsum this is my description.", "Title 7");
INSERT INTO car_announcements.announcements(brand, model, price, fabrication_date, description, title) VALUES("VOLVO", "XC60", 17.900, current_timestamp(), "Lorem impsum this is my description.", "Title 8");

-- IMAGES --
 -- BMW PICTURES -- 
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\1.png'), 1);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\2.png'), 1);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\3.png'), 1);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\1.png'), 2);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\2.png'), 2);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\3.png'), 2);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\1.png'), 3);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\2.png'), 3);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\3.png'), 3);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\1.png'), 4);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\2.png'), 4);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\3.png'), 4);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\1.png'), 5);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\2.png'), 5);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\3.png'), 5);

  -- MERCEDES PICTURES --
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\4.png'), 6);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\5.png'), 6);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\6.png'), 6);
  -- VOLVO PICTURES --
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\7.png'), 7);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\8.png'), 7);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\9.png'), 7);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\7.png'), 8);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\8.png'), 8);
INSERT INTO car_announcements.announcement_images(image, announcement_id) VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\test_pictures\\9.png'), 8);


-- USER--
INSERT INTO car_announcements.user(email, password) VALUES("marius@gmail.com", "12345678");