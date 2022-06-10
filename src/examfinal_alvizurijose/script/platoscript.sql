/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ggpo0
 * Created: 10 jun. 2022
 */

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbplato
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbplato
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbplato` DEFAULT CHARACTER SET utf8 ;
USE `dbplato` ;

-- -----------------------------------------------------
-- Table `dbplato`.`plato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbplato`.`plato` (
  `idplato` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(5,2) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `valoracion` INT NOT NULL,
  `estado` INT NOT NULL DEFAULT 1,
  `region` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idplato`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
