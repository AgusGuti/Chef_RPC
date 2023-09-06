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
CREATE SCHEMA IF NOT EXISTS `chefencasa` DEFAULT CHARACTER SET utf8mb3 ;
USE `chefencasa` ;

-- -----------------------------------------------------
-- Table `chefencasa`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`categoria` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `chefencasa`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`rol` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `chefencasa`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`user` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `rol` INT NULL DEFAULT 3,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`rol`)
    REFERENCES `chefencasa`.`rol` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE UNIQUE INDEX `email_UNIQUE` ON `chefencasa`.`user` (`email` ASC) VISIBLE;

CREATE UNIQUE INDEX `idUsuario_UNIQUE` ON `chefencasa`.`user` (`id` ASC) VISIBLE;

CREATE INDEX `fk_usuario_rol1_idx` ON `chefencasa`.`user` (`rol` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `titulo_receta` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `categoria_id` INT NOT NULL,
  `pasos` VARCHAR(45) NOT NULL,
  `tiempo_preparacion` INT NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `foto1` VARCHAR(255) NULL DEFAULT NULL,
  `foto2` VARCHAR(255) NULL DEFAULT NULL,
  `foto3` VARCHAR(255) NULL DEFAULT NULL,
  `foto4` VARCHAR(255) NULL DEFAULT NULL,
  `foto5` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_receta_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `chefencasa`.`categoria` (`id`),
  CONSTRAINT `fk_receta_usuario1`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_receta_usuario1_idx` ON `chefencasa`.`receta` (`user_id` ASC) VISIBLE;

CREATE INDEX `fk_receta_categoria1_idx` ON `chefencasa`.`receta` (`categoria_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`favoritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`favoritos` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`favoritos` (
  `user_id` INT NOT NULL,
  `receta_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `receta_id`),
  CONSTRAINT `fk_user_has_receta_receta1`
    FOREIGN KEY (`receta_id`)
    REFERENCES `chefencasa`.`receta` (`id`),
  CONSTRAINT `fk_user_has_receta_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_user_has_receta_receta1_idx` ON `chefencasa`.`favoritos` (`receta_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_receta_user1_idx` ON `chefencasa`.`favoritos` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`ingrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`ingrediente` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`ingrediente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingrediente` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `chefencasa`.`ingrediente_receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`ingrediente_receta` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`ingrediente_receta` (
  `ingrediente_id` INT NOT NULL,
  `receta_id` INT NOT NULL,
  PRIMARY KEY (`ingrediente_id`, `receta_id`),
  CONSTRAINT `FKa85r4c59407tw88pqv7ndn478`
    FOREIGN KEY (`ingrediente_id`)
    REFERENCES `chefencasa`.`ingrediente` (`id`),
  CONSTRAINT `FKd789xl9q0ljewdsu5r8ualqr5`
    FOREIGN KEY (`receta_id`)
    REFERENCES `chefencasa`.`receta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKd789xl9q0ljewdsu5r8ualqr5` ON `chefencasa`.`ingrediente_receta` (`receta_id` ASC) VISIBLE;


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
    REFERENCES `chefencasa`.`user` (`id`),
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`seguido`)
    REFERENCES `chefencasa`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `fk_user_has_user_user2_idx` ON `chefencasa`.`seguido` (`seguido` ASC) VISIBLE;

CREATE INDEX `fk_user_has_user_user1_idx` ON `chefencasa`.`seguido` (`seguidor` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
