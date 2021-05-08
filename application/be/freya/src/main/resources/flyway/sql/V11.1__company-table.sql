-- -----------------------------------------------------
-- Table `posting_requirement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `company` (
                                                     `company_id` INT NOT NULL AUTO_INCREMENT,
                                                     `company_name` VARCHAR(512) NOT NULL,
                                                     `mission` TEXT NOT NULL,
                                                     `product` TEXT NOT NULL,
                                                     `number_employees` INT NOT NULL,
                                                     PRIMARY KEY (`company_id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `company_image` (
                                            `company_image_id` INT NOT NULL AUTO_INCREMENT,
                                            `company_id` INT NOT NULL,
                                            `content_type` VARCHAR(256) NOT NULL,
                                            `img` LONGBLOB NOT NULL,
                                            `title` VARCHAR(256) NOT NULL,
                                            `created_dt` DATETIME NOT NULL,
                                            PRIMARY KEY (`company_image_id`),
                                            CONSTRAINT `company_image_company_id_fk`
                                                FOREIGN KEY (`company_id`)
                                                    REFERENCES `company` (`company_id`)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `company_image_company_id_fk` ON `company_image` (`company_id` ASC);

CREATE TABLE IF NOT EXISTS `company_location` (
                                               `company_location_id` INT NOT NULL AUTO_INCREMENT,
                                               `company_id` INT NOT NULL,
                                               `location` VARCHAR(512) NOT NULL,
                                               PRIMARY KEY (`company_location_id`),
                                               CONSTRAINT `company_location_company_id_fk`
                                                   FOREIGN KEY (`company_id`)
                                                       REFERENCES `company` (`company_id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `company_location_company_id_fk` ON `company_location` (`company_id` ASC);
