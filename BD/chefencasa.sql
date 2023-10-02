
-- -----------------------------------------------------
-- Table chefencasa.categoria
-- -----------------------------------------------------

INSERT INTO chefencasa.categoria (categoria)
VALUES 
	('Entrada'),
	('Plato principal'),
	('Postre'),
	('Brunch'),
	('Vegetariano'),
	('Vegano');

-- select * from chefencasa.categoria;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.categoria;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.categoria
-- -----------------------------------------------------

INSERT INTO chefencasa.`user` (`nombre`, `apellido`, `email`, `clave`, `foto_perfil`)
VALUES
	('Juan', 'Gonzalez', 'User1234@volcanmail.com', '1234', "https://static.pexels.com/photos/50855/pexels-photo-50855.jpeg"),
	('Maria', 'Fernandez', 'ByteGeek@volcanmail.com', '1234', "https://cdn.pixabay.com/photo/2016/11/19/11/43/woman-1838815_1280.jpg"),
	('Carlos', 'Martinez', 'CodeNerd@volcanmail.com', '1234', "https://media.istockphoto.com/photos/happy-laughing-man-picture-id544358212?k=6&m=544358212&s=612x612&w=0&h=odURMNz2hty8LIfpVahaaUKpGU4vd-UlZx4jy-OAnJA="),
	('Ana', 'Rodriguez', 'QuickFox@volcanmail.com', '1234', "https://get.pxhere.com/photo/person-hair-portrait-model-professional-profession-hairstyle-smile-long-hair-face-happy-head-beautiful-young-woman-brown-hair-portrait-photography-1323792.jpg"),
	('Luis', 'Perez', 'PixelArt@volcanmail.com', '1234', "https://st.depositphotos.com/2931363/3703/i/950/depositphotos_37034497-stock-photo-young-black-man-smiling-at.jpg"),
	('Laura', 'Diaz', 'DataGuru@volcanmail.com', '1234', "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.QGC51Bh2KlDlx_BS6eqYuwAAAA%26pid%3DApi&f=1&ipt=ed438dcb2e1dea73da704c21ddbc2a60ed93f036d1b14f0a61197b38c5541b2f&ipo=images"),
	('Lucía', 'Lopez', 'TechWhiz@volcanmail.com', '1234', "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.7oof7fD2X_cttzF0HOYP1gAAAA%26pid%3DApi&f=1&ipt=3171de7e99126d62ccfd0a78bf7445b36a9682d2c5e696fe9c0e7aef1867bdce&ipo=images"),
	('Diego', 'Sanchez', 'CodeHero@volcanmail.com', '1234', "https://media.gettyimages.com/photos/portrait-of-a-beautifull-smiling-man-picture-id499907722"),
	('Silvia', 'Gomez', 'NeonStar@volcanmail.com', '1234', "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Lg8CVwGTBXgsfADWHxIm4AAAAA%26pid%3DApi&f=1&ipt=a3a6934fd04d6c0373ec4c240e65279ef5ce2cc3b3005679a8b43d8010778070&ipo=images"),
	('Mariano', 'Torres', 'ByteBoss@volcanmail.com', '1234', "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.4SrW2iBR0v2kvj0RQ47c1QAAAA%26pid%3DApi&f=1&ipt=b93da1c5114e00fe237232bd05220c6df4069a5f6bbcbefc92a58b47842f2035&ipo=images"),
    ('Pablo', 'Gomez', 'pablo@volcanmail.com', '1234', "https://www.pngarts.com/files/3/Happy-Men-PNG-High-Quality-Image.png");


-- select * from chefencasa.user;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.user;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.receta
-- -----------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO chefencasa.receta (user_id, titulo_receta, descripcion, pasos, tiempo_preparacion, categoria_id, fecha_creacion, foto1, foto2, foto3, foto4, foto5)
VALUES
(3, 'Receta 01', 'Descripción de la Receta 01', 'Pasos de la Receta 01', 30, 3, STR_TO_DATE('2023-09-03 12:00:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.Ad4HZm92oN1nEou3S0KqxAAAAA%26pid%3DApi&f=1&ipt=811117bc929ce5feb5909b5d5b8af331b2919210debd1e8ba2725a2d6f7c8ae4&ipo=images", 
"", "", "", ""),
(4, 'Receta 02', 'Descripción de la Receta 02', 'Pasos de la Receta 02', 45, 1, STR_TO_DATE('2022-07-01 15:30:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.f0SToDYEicMKr4wqYmOJlQAAAA%26pid%3DApi&f=1&ipt=2d79db7cc8a5450acdad8606a1d917dcc52d5803cf4324672edcd6b89ad98338&ipo=images",
 "", "", "", ""),
(5, 'Receta 03', 'Descripción de la Receta 03', 'Pasos de la Receta 03', 60, 2, STR_TO_DATE('2023-08-15 08:45:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.E9T5sXUbxtm-LI3dn4kPqAAAAA%26pid%3DApi&f=1&ipt=1e3db7514c12b5d4339ab1cdd097c8e071de8bf423a2283db853e01dde84ff3d&ipo=images", 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.IFX18vOofJK8Qcsu6uWPNgAAAA%26pid%3DApi&f=1&ipt=79aaa1857a683e261abe490debf57dafd90806851b9b62e2c52d1a71cdf7b6d9&ipo=images", 
"", "", ""),
(6, 'Receta 04', 'Descripción de la Receta 04', 'Pasos de la Receta 04', 40, 3, STR_TO_DATE('2022-11-20 19:15:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.VtMbwCsH3lJ5saauOWn4iwAAAA%26pid%3DApi&f=1&ipt=144bf7154a68653456f9cc67e2222569bcd3194af2dec10a4911ab4228671fe0&ipo=images",
 "", "", "", ""),
(7, 'Receta 05', 'Descripción de la Receta 05', 'Pasos de la Receta 05', 55, 2, STR_TO_DATE('2022-07-25 10:00:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.wgoSij769wEgzfLyV6HVRQAAAA%26pid%3DApi&f=1&ipt=8ca5a985a21a71bbe14dd4298238333645d45f0ca26ee43e4cc16ca4a39227f5&ipo=images", 
"", "", "", ""),
(8, 'Receta 06', 'Descripción de la Receta 06', 'Pasos de la Receta 06', 25, 2, STR_TO_DATE('2023-06-05 14:20:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.n1uPnzMz2Gm3k9uh47qH0gAAAA%26pid%3DApi&f=1&ipt=17c7ab358f09bff3b10791c922135e0eae9498bc05d33c4060e4187cc06890e9&ipo=images",
 "", "", "", ""),
(9, 'Receta 07', 'Descripción de la Receta 07', 'Pasos de la Receta 07', 50, 2, STR_TO_DATE('2022-09-18 16:40:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.CW2cCb8X6RwggV1r-SXx0gAAAA%26pid%3DApi&f=1&ipt=709e1ca16bfaeade61b761d3197794a7c6a7a7b6cf1cc30235bb12201cbb8e61&ipo=images", 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.iE-s8VZ0rNtBYBtPr6OvjAAAAA%26pid%3DApi&f=1&ipt=69bdb4c147ba8e1a4c24ee0d124642b48edb059ea604542f33322aa3ae19490d&ipo=images", 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.VPWcjpyJaumlzWQwSWEQ0gHaEG%26pid%3DApi&f=1&ipt=bbbc84c4d78fadceee68c762c24124ccf6f046b0e602196e39abc2ff12acf685&ipo=images", 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.p4x_r_vJhHuKgx101N0qAwAAAA%26pid%3DApi&f=1&ipt=e1182a10dcb9c201307759d77ca7b9d402d240f407382ecb931a8e96a28f0079&ipo=images", 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.plFhS5iLeMkRB4Nxq8MGKQAAAA%26pid%3DApi&f=1&ipt=fa44cc599625b8094c391e4e50cae5a9acd9aa15478b8280e6ce7eb866416e72&ipo=images"),
(10, 'Receta 08', 'Descripción de la Receta 08', 'Pasos de la Receta 08', 35, 1, STR_TO_DATE('2023-01-10 09:55:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.qivdma5pdNcDaHfoYl_ALQAAAA%26pid%3DApi&f=1&ipt=f4a75084855f3435bf79eef219c8c90459c0c8f56b735f35e83fb8209d06f8d4&ipo=images", 
"", "", "", ""),
(1, 'Receta 09', 'Descripción de la Receta 09', 'Pasos de la Receta 09', 70, 5, STR_TO_DATE('2023-07-30 21:05:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.-QtizpQZeN-ZeJewKEiciwAAAA%26pid%3DApi&f=1&ipt=a90f3c7367e73b391502d1e2dfcdc14450befd9d2fe4f602e2f42c110bd1f53e&ipo=images", 
"", "", "", ""),
(2, 'Receta 10', 'Descripción de la Receta 10', 'Pasos de la Receta 10', 45, 3, STR_TO_DATE('2022-12-15 18:30:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.NOSkUdz3BeIp2-pMkH5W4AAAAA%26pid%3DApi&f=1&ipt=6e15da24fea0ac0a5baceb8bb36d49a5577943b8b4b1adfb8445da33cb02345d&ipo=images", 
"", "", "", ""),
(3, 'Receta 11', 'Descripción de la Receta 11', 'Pasos de la Receta 11', 30, 3, STR_TO_DATE('2023-01-03 12:00:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.NCp736BE1DB-FkKIjKRizQAAAA%26pid%3DApi&f=1&ipt=f2523b14eb79b96fdb219eacfb09002c226ffdc0e5e10774367346bc5be57a35&ipo=images", 
"", "", "", ""),
(4, 'Receta 12', 'Descripción de la Receta 12', 'Pasos de la Receta 12', 45, 1, STR_TO_DATE('2022-02-01 15:30:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.Orm5t6ckVRx5GYbGi2GpZwAAAA%26pid%3DApi&f=1&ipt=9817668210ffc6d74313a2e4ca61c89983ee7ee84bd40b66009abea4163da410&ipo=images", 
"", "", "", ""),
(5, 'Receta 13', 'Descripción de la Receta 13', 'Pasos de la Receta 13', 60, 2, STR_TO_DATE('2023-03-15 08:45:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.7PmAFq-V0UmdygBF4db8sAAAAA%26pid%3DApi&f=1&ipt=fca27cbe58bca546c92c59e698294908bc042ee1c2cc6e37470ad9cf91195929&ipo=images", 
"", "", "", ""),
(6, 'Receta 14', 'Descripción de la Receta 14', 'Pasos de la Receta 14', 40, 3, STR_TO_DATE('2022-02-20 19:15:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.OQkfetdn0GzrLVOXSa-gdQAAAA%26pid%3DApi&f=1&ipt=b7ef6b4878690567ce4aaa7ceb77658c7710f26dfb8549cf0b365306d7108915&ipo=images", 
"", "", "", ""),
(7, 'Receta 15', 'Descripción de la Receta 15', 'Pasos de la Receta 15', 55, 4, STR_TO_DATE('2022-05-25 10:00:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.8J4jLvGURBQ3H3WIfe_yrwHaEI%26pid%3DApi&f=1&ipt=2ddab1f8bbb121ebb4ee1942cbf3163a9f0d7f24c7859150d7a1b0aa3e8ce608&ipo=images", 
"", "", "", ""),
(8, 'Receta 16', 'Descripción de la Receta 16', 'Pasos de la Receta 16', 25, 2, STR_TO_DATE('2023-07-05 14:20:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.mF9tthgfIhzexRKLqHGA3gAAAA%26pid%3DApi&f=1&ipt=759f95a08acf1fbf729c3095a5a38b5c121d27f1d3ca6c40b86a93d5dc3d3a2e&ipo=images", 
"", "", "", ""),
(9, 'Receta 17', 'Descripción de la Receta 17', 'Pasos de la Receta 17', 50, 3, STR_TO_DATE('2022-06-18 16:40:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.MUlH3LnQ7R35OOolvkQt8gAAAA%26pid%3DApi&f=1&ipt=1cadb87c4298d1fcdf661e5a277685c01b02c82ee4293e3ed4982c2d2e28a87b&ipo=images",
 "", "", "", ""),
(10, 'Receta 18', 'Descripción de la Receta 18', 'Pasos de la Receta 18', 35, 1, STR_TO_DATE('2023-08-10 09:55:00', '%Y-%m-%d %H:%i:%s.%f'), 
"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.2B0JelodK4LZ5Swk6iorDwAAAA%26pid%3DApi&f=1&ipt=afe7ee320b49c5bf6f01fc5257b51bcf5ce29f0b2a74d0e5679d80b8914b55dc&ipo=images", 
"", "", "", "");
SET FOREIGN_KEY_CHECKS = 1;

-- select * from chefencasa.receta;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.receta;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.favoritos
-- -----------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO chefencasa.favorito (user_id, receta_id)
VALUES
  (1, 5),
  (1, 3),
  (2, 7),
  (4, 1),
  (5, 8),
  (10, 10),
  (1, 2),
  (8, 6),
  (9, 9),
  (10, 4),
  (10, 3);
SET FOREIGN_KEY_CHECKS = 1;

-- select * from chefencasa.favoritos;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.favorito;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.ingrediente
-- -----------------------------------------------------

INSERT INTO chefencasa.ingrediente (nombre)
VALUES
('Tomate'),
('Cebolla'),
('Ajo'),
('Pimiento'),
('Pasta'),
('Carne de res'),
('Pollo'),
('Aceite de oliva'),
('Sal'),
('Pimienta');

-- select * from chefencasa.ingrediente;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.ingrediente;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.receta_ingredientes
-- -----------------------------------------------------

INSERT INTO chefencasa.receta_ingredientes (receta_id, ingredientes_id)
VALUES
	 -- Receta 1 con ingredientes
	(1, 1), -- Receta 1 con Ingrediente 1
	(1, 2), -- Receta 1 con Ingrediente 2
	(1, 3), -- Receta 1 con Ingrediente 3
	(1, 4), -- Receta 1 con Ingrediente 4

	-- Receta 2 con ingredientes
	(2, 2), -- Receta 2 con Ingrediente 2
	(2, 4), -- Receta 2 con Ingrediente 4
	(2, 6), -- Receta 2 con Ingrediente 6

	-- Receta 3 con ingredientes
	(3, 3), -- Receta 3 con Ingrediente 3
	(3, 5), -- Receta 3 con Ingrediente 5

	-- Receta 4 con ingredientes
	(4, 1), -- Receta 4 con Ingrediente 1
	(4, 3), -- Receta 4 con Ingrediente 3
	(4, 5), -- Receta 4 con Ingrediente 5
	(4, 7), -- Receta 4 con Ingrediente 7

	-- Receta 5 con ingredientes
	(5, 2), -- Receta 5 con Ingrediente 2
	(5, 4), -- Receta 5 con Ingrediente 4

	-- Receta 6 con ingredientes
	(6, 3), -- Receta 6 con Ingrediente 3
	(6, 5),
	(6, 7),
	(6, 8),

	-- Receta 7 con ingredientes
	(7, 5),
	(7, 8),
	(7, 10),

	-- Receta 8 con ingredientes
	(8, 9),
	(8, 10),

	-- Receta 9 con ingredientes
	(9, 1),
	(9, 6),
	(9, 9),
	(9, 10),

	-- Receta 10 con ingredientes
	(10, 2),
	(10, 3),
	(10, 7),
	(10, 8),
	(10, 10);

-- select * from chefencasa.receta_ingredientes;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.receta_ingredientes;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- Table chefencasa.seguido
-- -----------------------------------------------------


SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO chefencasa.seguido (seguido_id,user_id)

VALUES
	(1, 2),
	(3, 4),
	(5, 6),
	(7, 8),
	(9, 10),
    (9, 5),
    (1, 5),
    (3, 5),
    (8, 5),
    (11,3),
    (11,5),
    (11,7);
SET FOREIGN_KEY_CHECKS = 1;

-- select * from chefencasa.seguido;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.seguido;
SET FOREIGN_KEY_CHECKS = 1;
*/

-- -----------------------------------------------------
-- CONSULTA ENTERA
-- -----------------------------------------------------

select * from chefencasa.user;
select * from chefencasa.receta;
select * from chefencasa.favorito;
select * from chefencasa.categoria;
select * from chefencasa.ingrediente;
select * from chefencasa.receta_ingredientes;
select * from chefencasa.seguido;