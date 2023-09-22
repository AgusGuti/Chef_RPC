-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
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
AUTO_INCREMENT = 7
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
  `foto_perfil` VARCHAR(255) NOT NULL DEFAULT '',
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb3;

CREATE UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe` ON `chefencasa`.`user` (`email` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(1000) NOT NULL,
  `fecha_creacion` DATETIME(6) NULL DEFAULT NULL,
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
AUTO_INCREMENT = 21
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
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKsp6x16gw0bgmo4trgdc3xvc22` ON `chefencasa`.`favorito` (`receta_id` ASC) VISIBLE;

CREATE INDEX `FKfx7pcmnhqgt2rcppq978bclxv` ON `chefencasa`.`favorito` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `chefencasa`.`ingrediente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`ingrediente` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`ingrediente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `chefencasa`.`receta_ingredientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `chefencasa`.`receta_ingredientes` ;

CREATE TABLE IF NOT EXISTS `chefencasa`.`receta_ingredientes` (
  `receta_id` INT NOT NULL,
  `ingredientes_id` INT NOT NULL,
  PRIMARY KEY (`receta_id`, `ingredientes_id`),
  CONSTRAINT `FKbl8nm6s0d3hi6qb6wpx8qyrru`
    FOREIGN KEY (`receta_id`)
    REFERENCES `chefencasa`.`receta` (`id`),
  CONSTRAINT `FKqx3v38baha3exb2c5jbxl4ooc`
    FOREIGN KEY (`ingredientes_id`)
    REFERENCES `chefencasa`.`ingrediente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKqx3v38baha3exb2c5jbxl4ooc` ON `chefencasa`.`receta_ingredientes` (`ingredientes_id` ASC) VISIBLE;


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
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb3;

CREATE INDEX `FKocsdh6x45tlpkxceh692ublpn` ON `chefencasa`.`seguidos` (`seguido_id` ASC) VISIBLE;

CREATE INDEX `FKd4lgy1f0srr610f0ebq0p5fmq` ON `chefencasa`.`seguidos` (`user_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
