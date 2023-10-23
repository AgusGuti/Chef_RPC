
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `mod-denuncias`.motivo;

TRUNCATE `mod-denuncias`.denuncia;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `mod-denuncias`.motivo (motivo) VALUES
    ('Contenido inapropiado'),
    ('Ingredientes prohibidos'),
    ('Peligroso para la salud');
    
select * from `mod-denuncias`.motivo;

INSERT INTO `mod-denuncias`.`denuncia` (`receta_id`, `resuelta`, `user_id`, `motivo_id`) VALUES
(1, 1, 1, 1),
(2, 0, 2, 2),
(3, 1, 3, 3),
(4, 0, 4, 1),
(5, 1, 5, 2),
(6, 0, 6, 3),
(7, 1, 7, 1),
(8, 0, 8, 2),
(9, 1, 9, 3),
(10, 0, 11, 1);

select * from `mod-denuncias`.denuncia;

