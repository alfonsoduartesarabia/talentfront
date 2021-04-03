-- -----------------------------------------------------
-- Table `user_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_image` (
                                       `user_image_id` INT NOT NULL AUTO_INCREMENT,
                                       `user_id` INT NOT NULL,
                                       `img` LONGBLOB NOT NULL,
                                       `title` VARCHAR(256) NOT NULL,
                                       `created_dt` DATETIME NOT NULL,
                                       PRIMARY KEY (`user_image_id`),
                                       CONSTRAINT `user_image_user_id_fk`
                                           FOREIGN KEY (`user_id`)
                                               REFERENCES `user` (`user_id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;
