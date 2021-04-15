-- -----------------------------------------------------
-- Table `posting_requirement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `posting_requirement` (
                                       `posting_requirement_id` INT NOT NULL AUTO_INCREMENT,
                                       `posting_id` INT NOT NULL,
                                       `requirement` VARCHAR(256) NOT NULL,
                                       PRIMARY KEY (`posting_requirement_id`),
                                       CONSTRAINT `posting_requirement_posting_id_fk`
                                           FOREIGN KEY (`posting_id`)
                                               REFERENCES `posting` (`posting_id`)
                                               ON DELETE NO ACTION
                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `posting_requirement_posting_id_fk` ON `posting_requirement` (`posting_id` ASC);
