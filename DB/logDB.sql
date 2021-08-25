-- MySQL Script generated by MySQL Workbench
-- Wed Aug 25 03:19:38 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Log
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Log
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Log` DEFAULT CHARACTER SET utf8 ;
USE `Log` ;

-- -----------------------------------------------------
-- Table `Log`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Log`.`role` (
  `roleID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleID`),
  UNIQUE INDEX `roleID_UNIQUE` (`roleID` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Log`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Log`.`User` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `roleID` INT NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `id_UNIQUE` (`UserID` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  INDEX `roleID_idx` (`roleID` ASC) VISIBLE,
  CONSTRAINT `roleID`
    FOREIGN KEY (`roleID`)
    REFERENCES `Log`.`role` (`roleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Log`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Log`.`log` (
  `LogID` INT NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `action` ENUM('LOGIN', 'LEAVE', 'SAVE') NOT NULL,
  `entity` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`LogID`),
  UNIQUE INDEX `id_UNIQUE` (`LogID` ASC) VISIBLE,
  UNIQUE INDEX `user_UNIQUE` (`UserID` ASC) VISIBLE,
  CONSTRAINT `UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `Log`.`User` (`UserID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Log`.`permissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Log`.`permissions` (
  `permissionID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `roleID` INT NOT NULL,
  PRIMARY KEY (`permissionID`),
  UNIQUE INDEX `permissionID_UNIQUE` (`permissionID` ASC) VISIBLE,
  UNIQUE INDEX `permissions_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `roleID_idx` (`roleID` ASC) VISIBLE,
  CONSTRAINT `role`
    FOREIGN KEY (`roleID`)
    REFERENCES `Log`.`role` (`roleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER 'Admin' IDENTIFIED BY '1234567';

GRANT ALL ON `Log`.* TO 'Admin';
GRANT SELECT ON TABLE `Log`.* TO 'Admin';
GRANT SELECT, INSERT, TRIGGER ON TABLE `Log`.* TO 'Admin';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `Log`.* TO 'Admin';
GRANT EXECUTE ON ROUTINE `Log`.* TO 'Admin';
CREATE USER 'Manager' IDENTIFIED BY '123456';

GRANT SELECT ON TABLE `Log`.* TO 'Manager';
GRANT EXECUTE ON ROUTINE `Log`.* TO 'Manager';
GRANT SELECT, INSERT, TRIGGER ON TABLE `Log`.* TO 'Manager';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `Log`.* TO 'Manager';
CREATE USER 'Default' IDENTIFIED BY '12345';

GRANT SELECT ON TABLE `Log`.* TO 'Default';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
