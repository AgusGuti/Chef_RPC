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
-- Table `chefencasa`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`user` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE UNIQUE INDEX `UK_le6e9ohs2inu3gbxbgg8e9dfa` ON `chefencasa`.`user` (`apellido` ASC) VISIBLE;

CREATE UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe` ON `chefencasa`.`user` (`email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(1000) NOT NULL,
  `fecha_creacion` DATETIME(6) NOT NULL,
  `foto1` VARCHAR(255) NULL DEFAULT NULL,
  `foto2` VARCHAR(255) NULL DEFAULT NULL,
  `foto3` VARCHAR(255) NULL DEFAULT NULL,
  `foto4` VARCHAR(255) NULL DEFAULT NULL,
  `foto5` VARCHAR(255) NULL DEFAULT NULL,
  `pasos` VARCHAR(255) NOT NULL,
  `tiempo_preparacion` INT NOT NULL,
  `titulo_receta` VARCHAR(100) NOT NULL,
  `categoria_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK43n2nquvmo9rvy6hrpya4142l`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`),
  CONSTRAINT `FKiietmot1luu7pnieopyxnj8ge`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `chefencasa`.`categoria` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKiietmot1luu7pnieopyxnj8ge` ON `chefencasa`.`receta` (`categoria_id` ASC) VISIBLE;

CREATE INDEX `FK43n2nquvmo9rvy6hrpya4142l` ON `chefencasa`.`receta` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`favorito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`favorito` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`favorito` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `receta_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKfx7pcmnhqgt2rcppq978bclxv`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`),
  CONSTRAINT `FKsp6x16gw0bgmo4trgdc3xvc22`
    FOREIGN KEY (`receta_id`)
    REFERENCES `chefencasa`.`receta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKsp6x16gw0bgmo4trgdc3xvc22` ON `chefencasa`.`favorito` (`receta_id` ASC) VISIBLE;

CREATE INDEX `FKfx7pcmnhqgt2rcppq978bclxv` ON `chefencasa`.`favorito` (`user_id` ASC) VISIBLE;


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
-- Table `chefencasa`.`seguidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`seguidos` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`seguidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `seguido_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKd4lgy1f0srr610f0ebq0p5fmq`
    FOREIGN KEY (`user_id`)
    REFERENCES `chefencasa`.`user` (`id`),
  CONSTRAINT `FKocsdh6x45tlpkxceh692ublpn`
    FOREIGN KEY (`seguido_id`)
    REFERENCES `chefencasa`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKocsdh6x45tlpkxceh692ublpn` ON `chefencasa`.`seguidos` (`seguido_id` ASC) VISIBLE;

CREATE INDEX `FKd4lgy1f0srr610f0ebq0p5fmq` ON `chefencasa`.`seguidos` (`user_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
