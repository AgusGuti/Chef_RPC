
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

-- -----------------------------------------------------
-- Table chefencasa.categoria
-- -----------------------------------------------------

INSERT INTO chefencasa.`user` (`nombre`, `apellido`, `email`, `clave`)
VALUES
	('Juan', 'Gonzalez', 'User1234@volcanmail.com', '1234'),
	('Maria', 'Fernandez', 'ByteGeek@volcanmail.com', '1234'),
	('Carlos', 'Martinez', 'CodeNerd@volcanmail.com', '1234'),
	('Ana', 'Rodriguez', 'QuickFox@volcanmail.com', '1234'),
	('Luis', 'Perez', 'PixelArt@volcanmail.com', '1234'),
	('Laura', 'Diaz', 'DataGuru@volcanmail.com', '1234'),
	('Lucía', 'Lopez', 'TechWhiz@volcanmail.com', '1234'),
	('Diego', 'Sanchez', 'CodeHero@volcanmail.com', '1234'),
	('Silvia', 'Gomez', 'NeonStar@volcanmail.com', '1234'),
	('Mariano', 'Torres', 'ByteBoss@volcanmail.com', '1234'),
    ('Pablo', 'Gomez', 'pablo@volcanmail.com', '1234');


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
(3, 'Receta 01', 'Descripción de la Receta 01', 'Pasos de la Receta 01', 30, 3, STR_TO_DATE('2023-09-03 12:00:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(4, 'Receta 02', 'Descripción de la Receta 02', 'Pasos de la Receta 02', 45, 1, STR_TO_DATE('2022-07-01 15:30:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(5, 'Receta 03', 'Descripción de la Receta 03', 'Pasos de la Receta 03', 60, 2, STR_TO_DATE('2023-08-15 08:45:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(6, 'Receta 04', 'Descripción de la Receta 04', 'Pasos de la Receta 04', 40, 3, STR_TO_DATE('2022-11-20 19:15:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(7, 'Receta 05', 'Descripción de la Receta 05', 'Pasos de la Receta 05', 55, 4, STR_TO_DATE('2022-07-25 10:00:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(8, 'Receta 06', 'Descripción de la Receta 06', 'Pasos de la Receta 06', 25, 2, STR_TO_DATE('2023-06-05 14:20:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(9, 'Receta 07', 'Descripción de la Receta 07', 'Pasos de la Receta 07', 50, 3, STR_TO_DATE('2022-09-18 16:40:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(10, 'Receta 08', 'Descripción de la Receta 08', 'Pasos de la Receta 08', 35, 1, STR_TO_DATE('2023-01-10 09:55:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(1, 'Receta 09', 'Descripción de la Receta 09', 'Pasos de la Receta 09', 70, 5, STR_TO_DATE('2023-07-30 21:05:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(2, 'Receta 10', 'Descripción de la Receta 10', 'Pasos de la Receta 10', 45, 3, STR_TO_DATE('2022-12-15 18:30:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(3, 'Receta 11', 'Descripción de la Receta 11', 'Pasos de la Receta 11', 30, 3, STR_TO_DATE('2023-01-03 12:00:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(4, 'Receta 12', 'Descripción de la Receta 12', 'Pasos de la Receta 12', 45, 1, STR_TO_DATE('2022-02-01 15:30:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(5, 'Receta 13', 'Descripción de la Receta 13', 'Pasos de la Receta 13', 60, 2, STR_TO_DATE('2023-03-15 08:45:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(6, 'Receta 14', 'Descripción de la Receta 14', 'Pasos de la Receta 14', 40, 3, STR_TO_DATE('2022-02-20 19:15:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(7, 'Receta 15', 'Descripción de la Receta 15', 'Pasos de la Receta 15', 55, 4, STR_TO_DATE('2022-05-25 10:00:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(8, 'Receta 16', 'Descripción de la Receta 16', 'Pasos de la Receta 16', 25, 2, STR_TO_DATE('2023-07-05 14:20:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(9, 'Receta 17', 'Descripción de la Receta 17', 'Pasos de la Receta 17', 50, 3, STR_TO_DATE('2022-06-18 16:40:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(10, 'Receta 18', 'Descripción de la Receta 18', 'Pasos de la Receta 18', 35, 1, STR_TO_DATE('2023-08-10 09:55:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(1, 'Receta 19', 'Descripción de la Receta 19', 'Pasos de la Receta 19', 70, 5, STR_TO_DATE('2023-09-30 21:05:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", ""),
(2, 'Receta 20', 'Descripción de la Receta 20', 'Pasos de la Receta 20', 45, 3, STR_TO_DATE('2022-10-15 18:30:00', '%Y-%m-%d %H:%i:%s.%f'), "", "", "", "", "");
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
INSERT INTO chefencasa.seguidos (seguido_id,user_id)

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
TRUNCATE chefencasa.seguidos;
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
select * from chefencasa.seguidos;
