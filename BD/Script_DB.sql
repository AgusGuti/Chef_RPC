-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema chefencasa
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `chefencasa` ;

-- -----------------------------------------------------
-- Schema chefencasa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chefencasa` DEFAULT CHARACTER SET utf8 ;
USE `chefencasa` ;

-- -----------------------------------------------------
-- Table `chefencasa`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`rol` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chefencasa`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`user` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nick` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`role`)
    REFERENCES `chefencasa`.`rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `chefencasa`.`user` (`email` ASC) VISIBLE;

CREATE UNIQUE INDEX `idUsuario_UNIQUE` ON `chefencasa`.`user` (`id` ASC) VISIBLE;

CREATE INDEX `fk_usuario_rol1_idx` ON `chefencasa`.`user` (`role` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`categoria` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta` (
  `idReceta` INT NOT NULL AUTO_INCREMENT,
  `usuario_idUsuario` INT NOT NULL,
  `tituloReceta` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(1000) NOT NULL,
  `categoria_idCategoria` INT NOT NULL,
  `pasos` VARCHAR(45) NOT NULL,
  `tiempoPreparacion` INT NOT NULL,
  `fechaCreacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `foto1` VARCHAR(256) NULL DEFAULT NULL,
  `foto2` VARCHAR(256) NULL DEFAULT NULL,
  `foto3` VARCHAR(256) NULL DEFAULT NULL,
  `foto4` VARCHAR(256) NULL DEFAULT NULL,
  `foto5` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`idReceta`),
  CONSTRAINT `fk_receta_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `chefencasa`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_categoria1`
    FOREIGN KEY (`categoria_idCategoria`)
    REFERENCES `chefencasa`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_receta_usuario1_idx` ON `chefencasa`.`receta` (`usuario_idUsuario` ASC) VISIBLE;

CREATE INDEX `fk_receta_categoria1_idx` ON `chefencasa`.`receta` (`categoria_idCategoria` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`ingrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`ingrediente` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`ingrediente` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `ingrediente` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idIngrediente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chefencasa`.`favoritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`favoritos` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`favoritos` (
  `user_id` INT NOT NULL,
  `receta_idReceta` INT NOT NULL,
  PRIMARY KEY (`user_id`, `receta_idReceta`),
  CONSTRAINT `fk_user_has_receta_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_receta_receta1`
    FOREIGN KEY (`receta_idReceta`)
    REFERENCES `chefencasa`.`receta` (`idReceta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_has_receta_receta1_idx` ON `chefencasa`.`favoritos` (`receta_idReceta` ASC) VISIBLE;

CREATE INDEX `fk_user_has_receta_user1_idx` ON `chefencasa`.`favoritos` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta_has_ingrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta_has_ingrediente` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta_has_ingrediente` (
  `receta_idReceta` INT NOT NULL,
  `ingrediente_idIngrediente` INT NOT NULL,
  PRIMARY KEY (`receta_idReceta`, `ingrediente_idIngrediente`),
  CONSTRAINT `fk_receta_has_ingrediente_receta1`
    FOREIGN KEY (`receta_idReceta`)
    REFERENCES `chefencasa`.`receta` (`idReceta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_has_ingrediente_ingrediente1`
    FOREIGN KEY (`ingrediente_idIngrediente`)
    REFERENCES `chefencasa`.`ingrediente` (`idIngrediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_receta_has_ingrediente_ingrediente1_idx` ON `chefencasa`.`receta_has_ingrediente` (`ingrediente_idIngrediente` ASC) VISIBLE;

CREATE INDEX `fk_receta_has_ingrediente_receta1_idx` ON `chefencasa`.`receta_has_ingrediente` (`receta_idReceta` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`seguido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`seguido` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`seguido` (
  `seguidor` INT NOT NULL,
  `seguido` INT NOT NULL,
  PRIMARY KEY (`seguidor`, `seguido`),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`seguidor`)
    REFERENCES `chefencasa`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`seguido`)
    REFERENCES `chefencasa`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';

CREATE INDEX `fk_user_has_user_user2_idx` ON `chefencasa`.`seguido` (`seguido` ASC) VISIBLE;

CREATE INDEX `fk_user_has_user_user1_idx` ON `chefencasa`.`seguido` (`seguidor` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
