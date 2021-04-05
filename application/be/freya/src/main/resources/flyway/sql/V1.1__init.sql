
-- -----------------------------------------------------
-- Table `user_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_type` (
  `user_type_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`user_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(256) NOT NULL,
  `salt_password_hash` blob NOT NULL,
  `salt` blob NOT NULL,
  `user_type_id` INT NOT NULL,
  `first_name` VARCHAR(90) NULL,
  `last_name` VARCHAR(90) NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_type_id_fk`
    FOREIGN KEY (`user_type_id`)
    REFERENCES `user_type` (`user_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_type_id_fk` ON `user` (`user_type_id` ASC);


-- -----------------------------------------------------
-- Table `user_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_info_id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT(256) NOT NULL,
  `user_id` INT NOT NULL,
  `user_info_type` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`user_info_id`),
  CONSTRAINT `user_info_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `user_info` (`user_id` ASC);

-- -----------------------------------------------------
-- Table `user_education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_education` (
    `user_education_id` INT NOT NULL AUTO_INCREMENT,
    `school` TEXT(256) NOT NULL,
    `degree_type` TEXT(256) NOT NULL,
    `state` TEXT(256) NOT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`user_education_id`),
    CONSTRAINT `user_education_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `user_education` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `user_relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_relationship` (
  `user_relationship_id` INT NOT NULL AUTO_INCREMENT,
  `relationship_type` VARCHAR(45) NOT NULL,
  `user_follower_id` INT NOT NULL,
  `user_followee_id` INT NOT NULL,
  PRIMARY KEY (`user_relationship_id`),
  CONSTRAINT `user_relationship_user_follower_id_fk`
    FOREIGN KEY (`user_follower_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_relationship_user_followee_id_fk`
    FOREIGN KEY (`user_followee_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_follower_id_fk` ON `user_relationship` (`user_follower_id` ASC);

CREATE INDEX `user_followee_id_fk` ON `user_relationship` (`user_followee_id` ASC);



-- -----------------------------------------------------
-- Table `user_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_review` (
  `user_review_id` INT NOT NULL AUTO_INCREMENT,
  `review_data` TEXT NOT NULL,
  `reviewer_id` INT NOT NULL,
  `reviewee_id` INT NOT NULL,
  PRIMARY KEY (`user_review_id`),
  CONSTRAINT `user_review_reviewer_id_fk`
    FOREIGN KEY (`reviewer_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_review_reviewee_id_fk`
    FOREIGN KEY (`reviewee_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `reviewer_id_fk` ON `user_review` (`reviewer_id` ASC);

CREATE INDEX `reviewee_id_fk` ON `user_review` (`reviewee_id` ASC);


-- -----------------------------------------------------
-- Table `posting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `posting` (
  `posting_id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `employer_name` VARCHAR(45) NOT NULL,
  `salary_range_top` INT NULL,
  `salary_range_bottom` INT NULL,
  `experience_required` INT NOT NULL,
  `created_dt` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `job_title` VARCHAR(45) NOT NULL,
  `state` VARCHAR(2),
  `city` VARCHAR(256),
  `zip_code` INT,
  PRIMARY KEY (`posting_id`),
  CONSTRAINT `posting_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `posting` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `user_experience`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_experience` (
  `user_exeperince_id` INT NOT NULL AUTO_INCREMENT,
  `job_title` VARCHAR(45) NULL,
  `experience` VARCHAR(45) NULL,
  `date_start` DATE NULL,
  `date_end` DATE NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`user_exeperince_id`),
  CONSTRAINT `user_experience_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `user_experience` (`user_id` ASC);


-- -----------------------------------------------------
-- Table `user_posting_apply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_posting_apply` (
  `user_posting_apply_id` INT NOT NULL AUTO_INCREMENT,
  `applicant_id` INT NULL,
  `posting_id` INT NULL,
  `created_dt` DATETIME NULL,
  PRIMARY KEY (`user_posting_apply_id`),
  CONSTRAINT `user_posting_apply_user_id_fk`
    FOREIGN KEY (`applicant_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_posting_apply_posting_id_fk`
    FOREIGN KEY (`posting_id`)
    REFERENCES `posting` (`posting_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `user_posting_apply` (`applicant_id` ASC);

CREATE INDEX `posting_id_fk` ON `user_posting_apply` (`posting_id` ASC);


-- -----------------------------------------------------
-- Table `notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notification` (
  `notification_id` INT NOT NULL AUTO_INCREMENT,
  `sender_id` INT NOT NULL,
  `reciever_id` INT NOT NULL,
  `data` TEXT(256) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`notification_id`),
  CONSTRAINT `notification_sender_id_fk`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `notification_reciever_id_fk`
    FOREIGN KEY (`reciever_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `sender_id_fk` ON `notification` (`sender_id` ASC);

CREATE INDEX `reciever_id_fk` ON `notification` (`reciever_id` ASC);


-- -----------------------------------------------------
-- Table `posting_recommendation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `posting_recommendation` (
  `posting_recommendation_id` INT NOT NULL AUTO_INCREMENT,
  `recommender_id` INT NOT NULL,
  `recommendee_id` INT NOT NULL,
  `posting_id` INT NOT NULL,
  `text` TEXT(256) NOT NULL,
  `created_dt` DATETIME NULL,
  PRIMARY KEY (`posting_recommendation_id`),
  CONSTRAINT `posting_recommendation_recommender_id_fk`
    FOREIGN KEY (`recommender_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `posting_recommendation_recommendee_id_fk`
    FOREIGN KEY (`recommendee_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `posting_recommendation_posting_id_fk`
    FOREIGN KEY (`posting_id`)
    REFERENCES `posting` (`posting_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `posting_id_fk` ON `posting_recommendation` (`posting_id` ASC);

CREATE INDEX `recommendee_id_fk` ON `posting_recommendation` (`recommendee_id` ASC);

CREATE INDEX `recommender_id_fk` ON `posting_recommendation` (`recommender_id` ASC);


-- -----------------------------------------------------
-- Table `media`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `media` (
  `media_id` INT NOT NULL AUTO_INCREMENT,
  `encoding` VARCHAR(256) NOT NULL,
  `user_id` INT NOT NULL,
  `file` BLOB NOT NULL,
  `title` VARCHAR(256) NOT NULL,
  `created_dt` DATETIME NOT NULL,
  PRIMARY KEY (`media_id`),
  CONSTRAINT `media_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `user_id_fk` ON `media` (`user_id` ASC);
