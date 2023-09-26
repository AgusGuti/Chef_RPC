CREATE TABLE IF NOT EXISTS `chefencasa`.`comentario` (
  `id` INT NOT NULL AUTO_INCREMENT,  -- ID DEL COMENTARIO
  `idreceta` INT NULL DEFAULT NULL, -- ID DE LA RECETA COMENTADA
  `comentario` TEXT NULL DEFAULT NULL, -- COMENTARIO
  `fechacomentario` DATETIME NULL DEFAULT NULL, -- FECHA DEL COMENTARIO
  `comentado_iduser` INT NOT NULL DEFAULT NULL, -- usuario que recibe el comentario en su receta
  `comentador_iduser` INT NOT NULL DEFAULT NULL, -- usuario que realiza el comentario
  PRIMARY KEY (`id`),
  INDEX `fk_idreceta_idx` (`idreceta` ASC) VISIBLE,
  INDEX `fk_comentador_iduser` (`comentador_iduser` ASC) VISIBLE,
  INDEX `fk_comentado_iduser` (`comentado_iduser` ASC) VISIBLE,  
  CONSTRAINT `fk_comentador_iduser`
    FOREIGN KEY (`pujador_idusuario`)
    REFERENCES `chefencasa`.`user` (`id`))
    CONSTRAINT `fk_comentado_iduser`
    FOREIGN KEY (`comentado_iduser`)
    REFERENCES `chefencasa`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;