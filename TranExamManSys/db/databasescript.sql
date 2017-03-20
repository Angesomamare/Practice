-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`gradesection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gradesection` (
  `grade_section_id` INT(11) NOT NULL AUTO_INCREMENT,
  `grade` INT(11) NOT NULL,
  `section` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`grade_section_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`gradesectionsubjectrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gradesectionsubjectrelation` (
  `grade_section_subject_id` INT(11) NOT NULL AUTO_INCREMENT,
  `grade_section_id` INT(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  PRIMARY KEY (`grade_section_subject_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`student` (
  `student_id_number` INT(11) NOT NULL,
  `given_name` VARCHAR(45) NOT NULL,
  `father_name` VARCHAR(45) NOT NULL,
  `grand_father_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `age` INT(11) NOT NULL,
  `grade_level` INT(11) NOT NULL,
  `section` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_id_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`studentcopy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`studentcopy` (
  `student_id` INT(11) NOT NULL AUTO_INCREMENT,
  `given_name` VARCHAR(45) NOT NULL,
  `father_name` VARCHAR(45) NOT NULL,
  `grand_father_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `age` INT(11) NOT NULL,
  `grade_level` INT(11) NOT NULL,
  `section` VARCHAR(45) NOT NULL,
  `student_id_number` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`studentgradesectionrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`studentgradesectionrelation` (
  `student_grade_section_id` INT(11) NOT NULL AUTO_INCREMENT,
  `student_id_number` INT(11) NOT NULL,
  `grade_section_id` INT(11) NOT NULL,
  PRIMARY KEY (`student_grade_section_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 46
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`studentsubjectrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`studentsubjectrelation` (
  `student_subject_id` INT(11) NOT NULL AUTO_INCREMENT,
  `student_id_number` INT(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  PRIMARY KEY (`student_subject_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`subject` (
  `subject_id` INT(11) NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`subject_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teacher` (
  `teacher_id` INT(11) NOT NULL AUTO_INCREMENT,
  `given_name` VARCHAR(45) NOT NULL,
  `father_name` VARCHAR(45) NOT NULL,
  `grand_father_name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `age` INT(11) NOT NULL,
  `grade_level_section_assigned` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`teachergradesectionrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teachergradesectionrelation` (
  `teacher_grade_section_id` INT(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` INT(11) NOT NULL,
  `grade_section_id` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_grade_section_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`teachergradesectionsubjectrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teachergradesectionsubjectrelation` (
  `teacher_gradesection_subject_id` INT(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` INT(11) NOT NULL,
  `grade_section_id` INT(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_gradesection_subject_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`teacherstudentrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teacherstudentrelation` (
  `teacher_student_id` INT(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` INT(11) NOT NULL,
  `student_id_number` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_student_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 86
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`teachersubjectrelation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`teachersubjectrelation` (
  `teacher_subject_id` INT(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` INT(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  PRIMARY KEY (`teacher_subject_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
