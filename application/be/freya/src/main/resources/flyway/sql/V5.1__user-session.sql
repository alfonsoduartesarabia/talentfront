-- -----------------------------------------------------
-- Table `user_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_session` (
                                       `user_session_id` INT NOT NULL AUTO_INCREMENT,
                                       `user_id` INT NOT NULL,
                                       `verification` VARCHAR(36) NOT NULL,
                                       `created_dt` DATETIME NOT NULL,
                                       PRIMARY KEY (`user_session_id`),
                                       CONSTRAINT `user_session_user_id_fk`
                                           FOREIGN KEY (`user_id`)
                                               REFERENCES `user` (`user_id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;
