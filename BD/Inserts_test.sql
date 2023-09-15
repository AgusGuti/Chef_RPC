
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

INSERT INTO chefencasa.`user` (`nombre`, `apellido`, `email`, `clave`)
VALUES
	('Juan', 'Gonzalez', 'User1234@volcanmail.com', 'cl4ve01'),
	('Maria', 'Fernandez', 'ByteGeek@volcanmail.com', 'cl4ve02'),
	('Carlos', 'Martinez', 'CodeNerd@volcanmail.com', 'cl4ve03'),
	('Ana', 'Rodriguez', 'QuickFox@volcanmail.com', 'cl4ve04'),
	('Luis', 'Perez', 'PixelArt@volcanmail.com', 'cl4ve05'),
	('Laura', 'Diaz', 'DataGuru@volcanmail.com', 'cl4ve06'),
	('Lucía', 'Lopez', 'TechWhiz@volcanmail.com', 'cl4ve07'),
	('Diego', 'Sanchez', 'CodeHero@volcanmail.com', 'cl4ve08'),
	('Silvia', 'Gomez', 'NeonStar@volcanmail.com', 'cl4ve09'),
	('Mariano', 'Torres', 'ByteBoss@volcanmail.com', 'cl4ve010');


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
INSERT INTO chefencasa.receta (user_id, titulo_receta, descripcion, pasos, tiempo_preparacion, categoria_id, fecha_creacion)
VALUES
(1, 'Receta 1', 'Descripción de la Receta 1', 'Pasos de la Receta 1', 30, 3, '2023-09-03 12:00:00'),
(3, 'Receta 2', 'Descripción de la Receta 2', 'Pasos de la Receta 2', 45, 1, '2022-07-01 15:30:00'),
(2, 'Receta 3', 'Descripción de la Receta 3', 'Pasos de la Receta 3', 60, 2, '2023-08-15 08:45:00'),
(3, 'Receta 4', 'Descripción de la Receta 4', 'Pasos de la Receta 4', 40, 3, '2022-11-20 19:15:00'),
(4, 'Receta 5', 'Descripción de la Receta 5', 'Pasos de la Receta 5', 55, 4, '2022-07-25 10:00:00'),
(1, 'Receta 6', 'Descripción de la Receta 6', 'Pasos de la Receta 6', 25, 2, '2023-06-05 14:20:00'),
(3, 'Receta 7', 'Descripción de la Receta 7', 'Pasos de la Receta 7', 50, 3, '2022-09-18 16:40:00'),
(7, 'Receta 8', 'Descripción de la Receta 8', 'Pasos de la Receta 8', 35, 1, '2023-01-10 09:55:00'),
(8, 'Receta 9', 'Descripción de la Receta 9', 'Pasos de la Receta 9', 70, 5, '2023-07-30 21:05:00'),
(7, 'Receta 10', 'Descripción de la Receta 10', 'Pasos de la Receta 10', 45, 3, '2022-12-15 18:30:00');
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
  (10, 4);

-- select * from chefencasa.favoritos;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE chefencasa.favoritos;
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

INSERT INTO chefencasa.seguidos (user_id, seguido_id)
VALUES
	(1, 2),
	(3, 4),
	(5, 6),
	(7, 8),
	(9, 10);

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
select * from chefencasa.seguidos;
