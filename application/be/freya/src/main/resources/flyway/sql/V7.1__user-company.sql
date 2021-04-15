-- -----------------------------------------------------
-- Table `user_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_company` (
                                       `user_company_id` INT NOT NULL AUTO_INCREMENT,
                                       `user_id` INT NOT NULL,
                                       `company_name` VARCHAR(256) NOT NULL,
                                       PRIMARY KEY (`user_company_id`),
                                       CONSTRAINT `user_company_user_id_fk`
                                           FOREIGN KEY (`user_id`)
                                               REFERENCES `user` (`user_id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `user_company_user_id_fk` ON `user_company` (`user_id` ASC);
