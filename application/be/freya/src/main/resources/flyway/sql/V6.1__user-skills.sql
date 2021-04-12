-- -----------------------------------------------------
-- Table `user_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_skill` (
                                       `user_skill_id` INT NOT NULL AUTO_INCREMENT,
                                       `user_id` INT NOT NULL,
                                       `skill` VARCHAR(256) NOT NULL,
                                       PRIMARY KEY (`user_skill_id`),
                                       CONSTRAINT `user_skill_user_id_fk`
                                           FOREIGN KEY (`user_id`)
                                               REFERENCES `user` (`user_id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;
