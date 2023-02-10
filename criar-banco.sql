-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema aula_bd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aula_bd` ;

-- -----------------------------------------------------
-- Schema aula_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aula_bd` DEFAULT CHARACTER SET latin1 ;
USE `aula_bd` ;

-- -----------------------------------------------------
-- Table `aula_bd`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aula_bd`.`estado` ;

CREATE TABLE IF NOT EXISTS `aula_bd`.`estado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `sigla` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aula_bd`.`cidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aula_bd`.`cidade` ;

CREATE TABLE IF NOT EXISTS `aula_bd`.`cidade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `populacao` INT(11) NULL DEFAULT NULL,
  `area` INT(11) NULL DEFAULT NULL,
  `estado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estado` (`estado` ASC),
  CONSTRAINT `cidade_ibfk_1`
    FOREIGN KEY (`estado`)
    REFERENCES `aula_bd`.`estado` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aula_bd`.`aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aula_bd`.`aluno` ;

CREATE TABLE IF NOT EXISTS `aula_bd`.`aluno` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `celular` VARCHAR(11) NULL DEFAULT NULL,
  `nascimento` DATE NOT NULL,
  `cidade` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC),
  INDEX `fk_cidade` (`cidade` ASC),
  CONSTRAINT `aluno_ibfk_1`
    FOREIGN KEY (`cidade`)
    REFERENCES `aula_bd`.`cidade` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aula_bd`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aula_bd`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `aula_bd`.`pessoa` (
  `id` INT(11) NULL DEFAULT NULL,
  `nome` VARCHAR(50) NULL DEFAULT NULL,
  `cidade` VARCHAR(50) NULL DEFAULT NULL,
  `estado` VARCHAR(50) NULL DEFAULT NULL,
  `sigla` CHAR(2) NULL DEFAULT NULL,
  `salario` DOUBLE NULL DEFAULT '1100')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
