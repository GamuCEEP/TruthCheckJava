-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema truthchecksimplified
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `truthchecksimplified` ;

-- -----------------------------------------------------
-- Schema truthchecksimplified
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `truthchecksimplified` DEFAULT CHARACTER SET utf8mb4 ;
USE `truthchecksimplified` ;

-- -----------------------------------------------------
-- Table `truthchecksimplified`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`user` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`user` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`stage` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`stage` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_stage_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_stage_user1_idx` ON `truthchecksimplified`.`stage` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`actor` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`actor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `stage_id` INT(11) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_actor_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `truthchecksimplified`.`stage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_actor_stage1_idx` ON `truthchecksimplified`.`actor` (`stage_id` ASC) ;

CREATE INDEX `fk_actor_user1_idx` ON `truthchecksimplified`.`actor` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`effect`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`effect` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`effect` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(1000) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_effect_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_effect_user1_idx` ON `truthchecksimplified`.`effect` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`item` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `effect_id` INT(11) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_item_effect1`
    FOREIGN KEY (`effect_id`)
    REFERENCES `truthchecksimplified`.`effect` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_item_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_item_effect1_idx` ON `truthchecksimplified`.`item` (`effect_id` ASC) ;

CREATE INDEX `fk_item_user1_idx` ON `truthchecksimplified`.`item` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_equipment` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_equipment` (
  `actor_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  PRIMARY KEY (`actor_id`, `item_id`),
  CONSTRAINT `fk__equipment_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `truthchecksimplified`.`actor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk__equipment_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `truthchecksimplified`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk__equipment_actor1_idx` ON `truthchecksimplified`.`_equipment` (`actor_id` ASC) ;

CREATE INDEX `fk__equipment_item1_idx` ON `truthchecksimplified`.`_equipment` (`item_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_inventory` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_inventory` (
  `amount` FLOAT NOT NULL,
  `actor_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  PRIMARY KEY (`actor_id`, `item_id`),
  CONSTRAINT `fk__inventory_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `truthchecksimplified`.`actor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk__inventory_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `truthchecksimplified`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk__inventory_actor1_idx` ON `truthchecksimplified`.`_inventory` (`actor_id` ASC) ;

CREATE INDEX `fk__inventory_item1_idx` ON `truthchecksimplified`.`_inventory` (`item_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`interaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`interaction` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`interaction` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `effect_id` INT(11) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_interaction_effect1`
    FOREIGN KEY (`effect_id`)
    REFERENCES `truthchecksimplified`.`effect` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_interaction_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_interaction_effect1_idx` ON `truthchecksimplified`.`interaction` (`effect_id` ASC) ;

CREATE INDEX `fk_interaction_user1_idx` ON `truthchecksimplified`.`interaction` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_item_interaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_item_interaction` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_item_interaction` (
  `item_id` INT(11) NOT NULL,
  `interaction_id` INT(11) NOT NULL,
  PRIMARY KEY (`item_id`, `interaction_id`),
  CONSTRAINT `fk_item_interaction_interaction1`
    FOREIGN KEY (`interaction_id`)
    REFERENCES `truthchecksimplified`.`interaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_item_interaction_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `truthchecksimplified`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_item_interaction_item1_idx` ON `truthchecksimplified`.`_item_interaction` (`item_id` ASC) ;

CREATE INDEX `fk_item_interaction_interaction1_idx` ON `truthchecksimplified`.`_item_interaction` (`interaction_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`map` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`map` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(40) NULL DEFAULT NULL,
  `description` VARCHAR(400) NULL DEFAULT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_map_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_map_user1_idx` ON `truthchecksimplified`.`map` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_map_has_stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_map_has_stage` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_map_has_stage` (
  `map_id` INT(11) NOT NULL,
  `stage_id` INT(11) NOT NULL,
  PRIMARY KEY (`map_id`, `stage_id`),
  CONSTRAINT `fk_map_has_stage_map1`
    FOREIGN KEY (`map_id`)
    REFERENCES `truthchecksimplified`.`map` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_map_has_stage_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `truthchecksimplified`.`stage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_map_has_stage_stage1_idx` ON `truthchecksimplified`.`_map_has_stage` (`stage_id` ASC) ;

CREATE INDEX `fk_map_has_stage_map1_idx` ON `truthchecksimplified`.`_map_has_stage` (`map_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`event` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`event` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `effect_id` INT(11) NOT NULL,
  `author` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `author`),
  CONSTRAINT `fk_event_effect1`
    FOREIGN KEY (`effect_id`)
    REFERENCES `truthchecksimplified`.`effect` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`author`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_event_effect1_idx` ON `truthchecksimplified`.`event` (`effect_id` ASC) ;

CREATE INDEX `fk_event_user1_idx` ON `truthchecksimplified`.`event` (`author` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_stage_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_stage_event` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_stage_event` (
  `step` INT(11) NOT NULL,
  `layer` INT(11) NOT NULL,
  `odds` INT(11) NOT NULL,
  `stage_id` INT(11) NOT NULL,
  `event_id` INT(11) NOT NULL,
  PRIMARY KEY (`step`, `stage_id`, `event_id`),
  CONSTRAINT `fk_stage_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `truthchecksimplified`.`event` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_stage_event_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `truthchecksimplified`.`stage` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_stage_event_stage1_idx` ON `truthchecksimplified`.`_stage_event` (`stage_id` ASC) ;

CREATE INDEX `fk_stage_event_event1_idx` ON `truthchecksimplified`.`_stage_event` (`event_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_stats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_stats` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_stats` (
  `statkey` VARCHAR(40) NOT NULL,
  `value` VARCHAR(40) NOT NULL,
  `actor_id` INT(11) NOT NULL,
  PRIMARY KEY (`statkey`, `actor_id`),
  CONSTRAINT `fk__stats_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `truthchecksimplified`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk__stats_actor1_idx` ON `truthchecksimplified`.`_stats` (`actor_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_trigger`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_trigger` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_trigger` (
  `item_id` INT(11) NOT NULL,
  `interaction_id` INT(11) NOT NULL,
  PRIMARY KEY (`interaction_id`),
  CONSTRAINT `fk__trigger_interaction1`
    FOREIGN KEY (`interaction_id`)
    REFERENCES `truthchecksimplified`.`interaction` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk__trigger_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `truthchecksimplified`.`item` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk__trigger_item1_idx` ON `truthchecksimplified`.`_trigger` (`item_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_actor` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_actor` (
  `user_id` INT(11) NOT NULL,
  `actor_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `actor_id`),
  CONSTRAINT `fk_user_has_actor_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `truthchecksimplified`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_actor_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_actor_actor1_idx` ON `truthchecksimplified`.`_user_has_actor` (`actor_id` ASC) ;

CREATE INDEX `fk_user_has_actor_user1_idx` ON `truthchecksimplified`.`_user_has_actor` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_effect`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_effect` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_effect` (
  `user_id` INT(11) NOT NULL,
  `effect_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `effect_id`),
  CONSTRAINT `fk_user_has_effect_effect1`
    FOREIGN KEY (`effect_id`)
    REFERENCES `truthchecksimplified`.`effect` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_effect_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_effect_effect1_idx` ON `truthchecksimplified`.`_user_has_effect` (`effect_id` ASC) ;

CREATE INDEX `fk_user_has_effect_user1_idx` ON `truthchecksimplified`.`_user_has_effect` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_event` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_event` (
  `user_id` INT(11) NOT NULL,
  `event_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `event_id`),
  CONSTRAINT `fk_user_has_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `truthchecksimplified`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_event_event1_idx` ON `truthchecksimplified`.`_user_has_event` (`event_id` ASC) ;

CREATE INDEX `fk_user_has_event_user1_idx` ON `truthchecksimplified`.`_user_has_event` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_interaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_interaction` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_interaction` (
  `user_id` INT(11) NOT NULL,
  `interaction_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `interaction_id`),
  CONSTRAINT `fk_user_has_interaction_interaction1`
    FOREIGN KEY (`interaction_id`)
    REFERENCES `truthchecksimplified`.`interaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_interaction_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_interaction_interaction1_idx` ON `truthchecksimplified`.`_user_has_interaction` (`interaction_id` ASC) ;

CREATE INDEX `fk_user_has_interaction_user1_idx` ON `truthchecksimplified`.`_user_has_interaction` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_item` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_item` (
  `user_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `item_id`),
  CONSTRAINT `fk_user_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `truthchecksimplified`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_item_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_item_item1_idx` ON `truthchecksimplified`.`_user_has_item` (`item_id` ASC) ;

CREATE INDEX `fk_user_has_item_user1_idx` ON `truthchecksimplified`.`_user_has_item` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_map` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_map` (
  `user_id` INT(11) NOT NULL,
  `map_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `map_id`),
  CONSTRAINT `fk_user_has_map_map1`
    FOREIGN KEY (`map_id`)
    REFERENCES `truthchecksimplified`.`map` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_map_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_map_map1_idx` ON `truthchecksimplified`.`_user_has_map` (`map_id` ASC) ;

CREATE INDEX `fk_user_has_map_user1_idx` ON `truthchecksimplified`.`_user_has_map` (`user_id` ASC) ;


-- -----------------------------------------------------
-- Table `truthchecksimplified`.`_user_has_stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truthchecksimplified`.`_user_has_stage` ;

CREATE TABLE IF NOT EXISTS `truthchecksimplified`.`_user_has_stage` (
  `user_id` INT(11) NOT NULL,
  `stage_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `stage_id`),
  CONSTRAINT `fk_user_has_stage_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `truthchecksimplified`.`stage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_stage_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `truthchecksimplified`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE INDEX `fk_user_has_stage_stage1_idx` ON `truthchecksimplified`.`_user_has_stage` (`stage_id` ASC) ;

CREATE INDEX `fk_user_has_stage_user1_idx` ON `truthchecksimplified`.`_user_has_stage` (`user_id` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
