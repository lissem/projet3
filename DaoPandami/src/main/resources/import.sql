--Insert des disponibilités
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (1,'samedi',6,'18:00:00','17:00:00','2021/04/03','2021/03/03',1);
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (2,'dimanche',7,'12:00:00','10:00:00','2021/05/03','2021/04/03',1);
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (3,'lundi',1,'15:00:00','12:00:00','2021/03/03','2021/04/13',2);
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (4,'dimanche',7,'12:00:00','08:00:00','2021/03/23','2021/05/23',2);
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (5,'mercredi',3,'18:00:00','12:00:00','2021/03/03','2021/06/13',3);
INSERT INTO `availability`(id,day,dayOfTheWeek,endTime,startTime,validityEndDate,validityStartDate,user_id)VALUES (6,'jeudi',4,'18:00:00','10:00:00','2021/04/23','2021/08/23',3);
-- Insert des sexes
INSERT INTO `gender`(id,name) VALUES (1,'Homme');
INSERT INTO `gender`(id,name) VALUES (2,'Femme');
INSERT INTO `gender`(id,name) VALUES (3,'Non Binaire');

--Insert Categorie Service
INSERT INTO `service_category`(id,name) VALUES (1,'Intérieur');
INSERT INTO `service_category`(id,name) VALUES (2,'Extérieur');

--Insert equipement
INSERT INTO `equipment`(id,name) VALUES (1,'rateau');
INSERT INTO `equipment`(id,name) VALUES (2,'pelle');
INSERT INTO `equipment`(id,name) VALUES (3,'perceuse');
INSERT INTO `equipment`(id,name) VALUES (4,'voiture');
INSERT INTO `equipment`(id,name) VALUES (5,'ordinateur');
INSERT INTO `equipment`(id,name) VALUES (6,'balais');
INSERT INTO `equipment`(id,name) VALUES (7,'chariot');



--Insert Type de service
INSERT INTO `service_type`(id,name,category_id) VALUES (1,'Jardinage',2);
INSERT INTO `service_type`(id,name,category_id) VALUES (2,'Course',2);
INSERT INTO `service_type`(id,name,category_id) VALUES (3,'Récupération de colis',2);
INSERT INTO `service_type`(id,name,category_id) VALUES (4,'Promenade des animaux',2);
INSERT INTO `service_type`(id,name,category_id) VALUES (5,'Déplacer une charge lourde',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (6,'Bricolage',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (7,'Aide pour se déplacer',2);
INSERT INTO `service_type`(id,name,category_id) VALUES (8,'Ménage',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (9,'Administratif',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (10,'Informatique',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (11,'Visite de courtoisie',1);
INSERT INTO `service_type`(id,name,category_id) VALUES (12,'Soutien scolaire',1);


-- Insert Type utilisateur
INSERT INTO `user_type` (id,name) VALUES (1,'Utilisateur');
INSERT INTO `user_type` (id,name) VALUES (2,'Administrateur');
INSERT INTO `user_type` (id,name) VALUES (3,'Super Administrateur');

--Insert adresse 
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (1,'Paris',48.862416,2.342432,'1','75001','Rue Adolphe Jullien');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (2,'Paris',48.863115,2.342175,'2','75001','Rue Adolphe Jullien');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (3,'Paris',48.864947,2.329439,'1','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (4,'Paris',48.865298,2.329852,'10','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (5,'Paris',48.865572,2.329904,'11','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (6,'Paris',48.865418,2.329942,'12','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (7,'Paris',48.865718,2.330012,'13','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (8,'Paris',48.865546,2.330037,'14','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (9,'Paris',48.865664,2.330124,'16','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (10,'Paris',48.864777,2.329465,'2','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (11,'Paris',48.865052,2.329517,'3','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (12,'Paris',48.864868,2.329532,'4','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (13,'Paris',48.865244,2.329611,'5','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (14,'Paris',48.865006,2.329635,'6','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (15,'Paris',48.865154,2.329744,'8','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (16,'Paris',48.865436,2.329803,'9','75001','Rue d''Alger');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (17,'Paris',48.860145,2.33955,'1','75001','Rue de l''Amiral de Coligny');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (18,'Paris',48.860202,2.339282,'1A','75001','Rue de l''Amiral de Coligny');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (19,'Paris',48.859242,2.340189,'2','75001','Rue de l''Amiral de Coligny');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (20,'Paris',48.860485,2.340832,'6','75001','Rue de l''Amiral de Coligny');
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (116611,'Paris',48.886243,2.340568,'4','75018','Rue du Calvaire')
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (92431,'Paris',48.846635,2.289717,'106','75015','Avenue émile Zola')
INSERT INTO `address`(id,city,latitude,longitude,number,postCode,streetName) VALUES (24794,'Paris',48.86037,2.309643,'27','75007','Rue Surcouf')


--insert User
INSERT INTO `user`(id,birthDate,email,firstName,lastName,password,phone,registrationDate,address_id,gender_id,userType_id) VALUES (1,'1990/08/25','toto@toto.com','Toto','de TOTO','azerty2+','0565479081','2021/03/04',116611,1,1);
INSERT INTO `user`(id,birthDate,email,firstName,lastName,password,phone,registrationDate,address_id,gender_id,userType_id) VALUES (2,'1992/05/23','tata@tata.com','Tata','de TATA','azerty2+','0698595432','2021/01/02',92431,2,1);
INSERT INTO `user`(id,birthDate,email,firstName,lastName,password,phone,registrationDate,address_id,gender_id,userType_id) VALUES (3,'1987/01/03','titi@titi.com','Titi','de TITI','azerty2+','0147845512','2021/01/08',24794,3,1);

--insert PrefService
INSERT INTO `preference_service`(id, serviceType_id, user_id) VALUES (1, 6, 1);

--insert service
INSERT INTO `service`  (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('1', '2021-03-17 12:43:18', '2021-03-20', '08:42:00', '2021-03-20', '11:42:00', '116611', '1', '1', '1');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('2', '2021-03-17 18:43:18', '2021-03-21', '09:42:00', '2021-03-21', '11:42:00', '116611', '1', '2', '2');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('3', '2021-03-17 19:43:18', '2021-03-22', '15:42:00', '2021-03-22', '11:42:00', '116611', '1', '3', '3');

INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('4', '2021-03-17 12:43:18', '2021-03-23', '08:42:00', '2021-03-23', '11:42:00', '92431', '2', '4', '4');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('5', '2021-03-17 18:43:18', '2021-03-24', '09:42:00', '2021-03-24', '11:42:00', '92431', '2', '5', '5');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('6', '2021-03-17 19:43:18', '2021-03-25', '15:42:00', '2021-03-25', '11:42:00', '92431', '2', '6', '6');

INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('7', '2021-03-17 12:43:18', '2021-03-26', '08:42:00', '2021-03-26', '11:42:00', '24794', '3', '1', '7');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('8', '2021-03-17 18:43:18', '2021-03-27', '09:42:00', '2021-03-27', '11:42:00', '24794', '3', '2', '8');
INSERT INTO `service` (`id`, `creationDate`, `endDate`, `endTime`, `startDate`, `startTime`, `address_id`, `creator_id`, `equipment_id`, `serviceType_id`) VALUES ('9', '2021-03-17 19:43:18', '2021-03-28', '15:42:00', '2021-03-28', '11:42:00', '24794', '3', '3', '9');

--Insert Causes annulation

INSERT INTO `pandami_db`.`cancellation_cause` (`id`, `name`) VALUES ('1', 'raison 1 ');
INSERT INTO `pandami_db`.`cancellation_cause` (`id`, `name`) VALUES ('2', 'raison 2');
INSERT INTO `pandami_db`.`cancellation_cause` (`id`, `name`) VALUES ('3', 'raison 3');
INSERT INTO `pandami_db`.`cancellation_cause` (`id`, `name`) VALUES ('4', 'raison 4');
