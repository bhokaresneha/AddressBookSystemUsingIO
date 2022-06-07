CREATE TABLE IF NOT EXISTS `Address_Book_DB`.`Address_Book` (
  `Book_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Book_ID`));
  
  
  
  CREATE TABLE IF NOT EXISTS `Address_Book_DB`.`Person_Detail` (
  `Person_ID` INT NOT NULL,
  `First_Name` VARCHAR(50) NOT NULL,
  `Last_Name` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Contact_Number` VARCHAR(50) NOT NULL,
  `Address` VARCHAR(50) NOT NULL,
  `City` VARCHAR(50) NOT NULL,
  `State` VARCHAR(50) NOT NULL,
  `Zip_Code` INT NOT NULL,
  `Book_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Person_ID`),
  UNIQUE INDEX `Person_ID_UNIQUE` (`Person_ID` ASC) VISIBLE,
  INDEX `Book_ID_id_idx` (`Book_ID` ASC) VISIBLE,
  CONSTRAINT `Book_ID`
    FOREIGN KEY (`Book_ID`)
    REFERENCES `Address_Book_DB`.`Address_Book` (`Book_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
  CREATE TABLE IF NOT EXISTS `Address_Book_DB`.`Conatct_Type` (
  `Contact_Type_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Contact_Type` VARCHAR(255) NOT NULL,
  `Person_ID` INT NOT NULL,
  PRIMARY KEY (`Contact_Type_ID`),
  INDEX `Person_Id_idx` (`Person_ID` ASC) VISIBLE,
  CONSTRAINT `Person_Id`
    FOREIGN KEY (`Person_ID`)
    REFERENCES `Address_Book_DB`.`Person_Detail` (`Person_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
   CREATE TABLE IF NOT EXISTS `Address_Book_DB`.`Conatct_Detail` (
  `category_id` INT NOT NULL,
  `Contact_Number` INT(50) NOT NULL,
  `Person_ID` INT NOT NULL,
  PRIMARY KEY (`category_id`),
  INDEX `Person_ID_idx` (`Person_ID` ASC) VISIBLE,
  CONSTRAINT `P_Id`
    FOREIGN KEY (`Person_ID`)
    REFERENCES `Address_Book_DB`.`Person_Detail` (`Person_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)