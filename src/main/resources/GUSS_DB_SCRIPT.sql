-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema guss_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema guss_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `guss_db` DEFAULT CHARACTER SET utf8 ;
USE `guss_db` ;

-- -----------------------------------------------------
-- Table `guss_db`.`membership_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`membership_category` (
  `id` INT(11) NOT NULL,
  `category_name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`role` (
  `id` INT(11) NOT NULL,
  `role_name` VARCHAR(100) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC),
  UNIQUE INDEX `UKiubw515ff0ugtm28p8g3myt0h` (`role_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`user` (
  `id` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `middle_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(1) NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `date_created` TIMESTAMP(6) NULL DEFAULT NULL,
  `last_updated` TIMESTAMP(6) NULL DEFAULT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `UKob8kqyqqgmefl0aco34akdtpe` (`email` ASC),
  INDEX `fk_user_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `guss_db`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`guss_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`guss_member` (
  `id` INT(11) NOT NULL,
  `member_ssn` VARCHAR(25) NOT NULL,
  `policy_start_date` DATE NULL DEFAULT NULL,
  `maturity_date` DATE NULL DEFAULT NULL,
  `membership_status` VARCHAR(10) NULL DEFAULT NULL,
  `current_salary` DECIMAL(10,0) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `membership_category_id` INT(11) NOT NULL,
  `date_created` TIMESTAMP(6) NULL,
  `last_updated` TIMESTAMP(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_guss_member_user1_idx` (`user_id` ASC),
  INDEX `fk_guss_member_membership_category1_idx` (`membership_category_id` ASC),
  UNIQUE INDEX `member_ssn_UNIQUE` (`member_ssn` ASC),
  CONSTRAINT `fk_guss_member_membership_category1`
    FOREIGN KEY (`membership_category_id`)
    REFERENCES `guss_db`.`membership_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_guss_member_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `guss_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`guss_member_contribution`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`guss_member_contribution` (
  `id` INT(11) NOT NULL,
  `doc_id` VARCHAR(45) NOT NULL,
  `payment_date` DATE NULL DEFAULT NULL,
  `fiscal_month` VARCHAR(25) NULL DEFAULT NULL,
  `fiscal_year` VARCHAR(45) NULL DEFAULT NULL,
  `comments` VARCHAR(255) NULL DEFAULT NULL,
  `contribution_category` VARCHAR(45) NOT NULL,
  `guss_member_ssn` INT(11) NOT NULL,
  `date_created` TIMESTAMP(6) NULL,
  `last_updated` TIMESTAMP(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_guss_member_contribution_guss_member1_idx` (`guss_member_ssn` ASC),
  CONSTRAINT `fk_guss_member_contribution_guss_member1`
    FOREIGN KEY (`guss_member_ssn`)
    REFERENCES `guss_db`.`guss_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


ALTER TABLE `guss_db`.`guss_member_contribution` 
ADD CONSTRAINT doc-id_ssn_category UNIQUE (`doc_id` ASC, `guss_member_ssn` ASC, `contribution_category` ASC);

-- -----------------------------------------------------
-- Table `guss_db`.`spring_session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`spring_session` (
  `SESSION_ID` CHAR(36) NOT NULL,
  `CREATION_TIME` BIGINT(20) NOT NULL,
  `LAST_ACCESS_TIME` BIGINT(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` INT(11) NOT NULL,
  `PRINCIPAL_NAME` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`SESSION_ID`),
  INDEX `SPRING_SESSION_IX1` (`LAST_ACCESS_TIME` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`spring_session_attributes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`spring_session_attributes` (
  `SESSION_ID` CHAR(36) NOT NULL,
  `ATTRIBUTE_NAME` VARCHAR(200) NOT NULL,
  `ATTRIBUTE_BYTES` BLOB NOT NULL,
  PRIMARY KEY (`SESSION_ID`, `ATTRIBUTE_NAME`),
  INDEX `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_ID` ASC),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK`
    FOREIGN KEY (`SESSION_ID`)
    REFERENCES `guss_db`.`spring_session` (`SESSION_ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `guss_db`.`transaction_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guss_db`.`transaction_history` (
  `id` INT(11) NOT NULL,
  `date` DATE NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `last_updated` TIMESTAMP(6) NULL DEFAULT NULL,
  `guss_member_id` INT(11) NOT NULL,
  `approved_by` INT(11) NOT NULL,
  `date_created` TIMESTAMP(6) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transaction_history_guss_member1_idx` (`guss_member_id` ASC),
  INDEX `fk_transaction_history_user1_idx` (`approved_by` ASC),
  CONSTRAINT `fk_transaction_history_guss_member1`
    FOREIGN KEY (`guss_member_id`)
    REFERENCES `guss_db`.`guss_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_history_user1`
    FOREIGN KEY (`approved_by`)
    REFERENCES `guss_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

