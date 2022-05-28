****************************************************************** UC1 **************************************************************************
                                    // UC-Ability to create a Address Book Service DB
                                        - Use SQL Client to create DB and DB Records
    
mysql> show databases;
+----------------------+
| Database             |
+----------------------+
| Address_Book_Service |
| information_schema   |
| mysql                |
| payroll_services     |
| performance_schema   |
| sys                  |
+----------------------+
6 rows in set (0.01 sec)

mysql> create database AddressBookService
    -> ;
Query OK, 1 row affected (0.02 sec)

mysql> show databases
    -> ;
+--------------------+
| Database           |
+--------------------+
| AddressBookService |
| Payroll_Service    |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
mysql> use AddressBookService
Database changed
mysql> select database();
+--------------------+
| database()         |
+--------------------+
| AddressBookService |
+--------------------+
1 row in set (0.00 sec)

****************************************************************** UC2 **************************************************************************
// UC-Ability to create a Address Book Table with first and last names, address, city, state, zip, phone number and email as its attributes.


mysql> CREATE TABLE AddressBook(First_Name VARCHAR(50) NOT NULL,Last_Name VARCHAR(50) NOT NULL,Phone_Number BIGINT NOT NULL,Email VARCHAR(50) NOT NULL,Address VARCHAR(50) NOT NULL,City VARCHAR(50) NOT NULL,State VARCHAR(50) NOT NULL,Zip_Code INT NOT NULL);
Query OK, 0 rows affected (0.04 sec)

mysql> desc AddressBook
    -> ;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| First_Name   | varchar(50) | NO   |     | NULL    |       |
| Last_Name    | varchar(50) | NO   |     | NULL    |       |
| Phone_Number | bigint      | NO   |     | NULL    |       |
| Email        | varchar(50) | NO   |     | NULL    |       |
| Address      | varchar(50) | NO   |     | NULL    |       |
| City         | varchar(50) | NO   |     | NULL    |       |
| State        | varchar(50) | NO   |     | NULL    |       |
| Zip_Code     | int         | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
8 rows in set (0.01 sec)


****************************************************************** UC3 **************************************************************************
                    //UC-Ability to insert new Contacts to Address Book

mysql> INSERT INTO AddressBook(First_Name,Last_Name,Phone_Number,Email,Address,City,State,Zip_Code) VALUES
    -> ('Sneha','Bhokare',"9762689841","sneha@gmail.com",'Sangvi','Pune','Maharashtra',444222),
    -> ('Sunil','Kanse',"9988689841","sunil@gmail.com",'Baramati','Pune','Maharashtra',413102),
    -> ('Saurabh','Kodam',"8888898765","saurabh@gmail.com",'Nagar','Pune','Maharashtra',413115);
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select * from AddressBook;
+------------+-----------+--------------+-------------------+----------+------+-------------+----------+
| First_Name | Last_Name | Phone_Number | Email             | Address  | City | State       | Zip_Code |
+------------+-----------+--------------+-------------------+----------+------+-------------+----------+
| Sneha      | Bhokare   |   9762689841 | sneha@gmail.com   | Sangvi   | Pune | Maharashtra |   444222 |
| Sunil      | Kanse     |   9988689841 | sunil@gmail.com   | Baramati | Pune | Maharashtra |   413102 |
| Saurabh    | Kodam     |   8888898765 | saurabh@gmail.com | Nagar    | Pune | Maharashtra |   413115 |
+------------+-----------+--------------+-------------------+----------+------+-------------+----------+
3 rows in set (0.01 sec)

****************************************************************** UC4 **************************************************************************
                          //UC -Ability to edit existing contact person using their name.

mysql> UPDATE AddressBook SET Address='Malshej',Zip_Code=444000 WHERE First_Name='sunil';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> select * from AddressBook;
+------------+-----------+--------------+-------------------+---------+------+-------------+----------+
| First_Name | Last_Name | Phone_Number | Email             | Address | City | State       | Zip_Code |
+------------+-----------+--------------+-------------------+---------+------+-------------+----------+
| Sneha      | Bhokare   |   9762689841 | sneha@gmail.com   | Sangvi  | Pune | Maharashtra |   444222 |
| Sunil      | Kanse     |   9988689841 | sunil@gmail.com   | Malshej | Pune | Maharashtra |   444000 |
| Saurabh    | Kodam     |   8888898765 | saurabh@gmail.com | Nagar   | Pune | Maharashtra |   413115 |
+------------+-----------+--------------+-------------------+---------+------+-------------+----------+
3 rows in set (0.01 sec)

****************************************************************** UC5 **************************************************************************
                                    //UC-   Ability to delete a person using person's name

mysql> DELETE FROM AddressBook WHERE First_Name='Saurabh';
Query OK, 1 row affected (0.02 sec)

mysql> select * from AddressBook;
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
| First_Name | Last_Name | Phone_Number | Email           | Address | City | State       | Zip_Code |
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
| Sneha      | Bhokare   |   9762689841 | sneha@gmail.com | Sangvi  | Pune | Maharashtra |   444222 |
| Sunil      | Kanse     |   9988689841 | sunil@gmail.com | Malshej | Pune | Maharashtra |   444000 |
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
2 rows in set (0.00 sec)

****************************************************************** UC6 **************************************************************************
                         // UC-Ability to Retrieve Person belonging to a City or State from the Address Book.

mysql> SELECT * FROM AddressBook WHERE City='Pune' or State="Maharashtra";
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
| First_Name | Last_Name | Phone_Number | Email           | Address | City | State       | Zip_Code |
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
| Sneha      | Bhokare   |   9762689841 | sneha@gmail.com | Sangvi  | Pune | Maharashtra |   444222 |
| Sunil      | Kanse     |   9988689841 | sunil@gmail.com | Malshej | Pune | Maharashtra |   444000 |
+------------+-----------+--------------+-----------------+---------+------+-------------+----------+
2 rows in set (0.00 sec)

****************************************************************** UC7 **************************************************************************
                            //UC- Ability to understand the size of address book by City and State
                              - Here size indicates the count

mysql> SELECT COUNT(City),COUNT(State) FROM AddressBook WHERE City='Solapur'or State="Maharashtra";
+-------------+--------------+
| COUNT(City) | COUNT(State) |
+-------------+--------------+
|           2 |            2 |
+-------------+--------------+
1 row in set (0.00 sec)

mysql> SELECT COUNT(City),COUNT(State) FROM AddressBook WHERE City='Solapur';
+-------------+--------------+
| COUNT(City) | COUNT(State) |
+-------------+--------------+
|           0 |            0 |
+-------------+--------------+
1 row in set (0.00 sec)
****************************************************************** UC8 **************************************************************************
                        //UC- Ability to retrieve entries sorted alphabetically by Person’s name for a given city

mysql> SELECT First_Name FROM AddressBook ORDER BY Address ASC;
+------------+
| First_Name |
+------------+
| Sunil      |
| Sneha      |
+------------+
mysql> SELECT First_Name FROM AddressBook ORDER BY Address DESC;
+------------+
| First_Name |
+------------+
| Sneha      |
| Sunil      |
+------------+
2 rows in set (0.00 sec)



****************************************************************** UC9 **************************************************************************
                            //UC-Ability to identify each Address Book with name and Type.
                             - Here the type could Family, Friends,Profession, etc
                                 - Alter Address Book to add name and type

mysql> ALTER TABLE AddressBook ADD(Book_Name VARCHAR(50) NOT NULL,Type VARCHAR(50) NOT NULL);
 Query OK, 0 rows affected (0.04 sec)
 Records: 0  Duplicates: 0  Warnings: 0

 mysql> SELECT * FROM AddressBook;
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+------+
 | First_Name | Last_Name | Phone_Number | Email           | Address | City | State       | Zip_Code | Book_Name | Type |
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+------+
 | Sneha      | Bhokare   |   9762689841 | sneha@gmail.com | Sangvi  | Pune | Maharashtra |   444222 |           |      |
 | Sunil      | Kanse     |   9988689841 | sunil@gmail.com | Malshej | Pune | Maharashtra |   444000 |           |      |
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+------+
 2 rows in set (0.01 sec)

 mysql> UPDATE AddressBook SET Book_Name="TCS",Type="Profesion" where First_Name="Sunil";
 Query OK, 1 row affected (0.02 sec)
 Rows matched: 1  Changed: 1  Warnings: 0

 mysql> SELECT * FROM AddressBook;
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+-----------+
 | First_Name | Last_Name | Phone_Number | Email           | Address | City | State       | Zip_Code | Book_Name | Type      |
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+-----------+
 | Sneha      | Bhokare   |   9762689841 | sneha@gmail.com | Sangvi  | Pune | Maharashtra |   444222 | Family    |           |
 | Sunil      | Kanse     |   9988689841 | sunil@gmail.com | Malshej | Pune | Maharashtra |   444000 | TCS       | Profesion |
 +------------+-----------+--------------+-----------------+---------+------+-------------+----------+-----------+-----------+
 2 rows in set (0.00 sec)



****************************************************************** UC10 **************************************************************************
                                    //Ability to get number of contact persons
                                               -i.e. count by type

mysql> SELECT COUNT(*) FROM AddressBook;
+----------+
| COUNT(*) |
+----------+
|        2 |
+----------+
1 row in set (0.00 sec)

****************************************************************** UC11 **************************************************************************
                                    //UC-Ability to add person to both Friend and Family

mysql> INSERT INTO AddressBook(First_Name,Last_Name,Phone_Number,Email,Address,City,State,Zip_Code,Book_Name,Type) VALUES
    ->      ('Sahil','Shinde',9762689841,"sneha@gmail.com",'Sangvi','Pune','Maharashtra',444222,'TCS','Profession'),
    ->      ('Sahil','Shinde',9762689841,"sneha@gmail.com",'Sangvi','Pune','Maharashtra',444222,'TCS','Family'),
    ->      ('Sohan','Kamble',"9988689841","Sohan@gmail.com",'Baramati','Pune','Maharashtra',413102,'Family','Family'),
    ->      ('Sahil','Shinde',9762689841,"sneha@gmail.com",'Sangvi','Pune','Maharashtra',444222,'TCS','Profession');
Query OK, 4 rows affected (0.01 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM AddressBook;
+------------+-----------+--------------+-----------------+----------+------+-------------+----------+-----------+------------+
| First_Name | Last_Name | Phone_Number | Email           | Address  | City | State       | Zip_Code | Book_Name | Type       |
+------------+-----------+--------------+-----------------+----------+------+-------------+----------+-----------+------------+
| Sneha      | Bhokare   |   9762689841 | sneha@gmail.com | Sangvi   | Pune | Maharashtra |   444222 | Wipro     | Family     |
| Sunil      | Kanse     |   9988689841 | sunil@gmail.com | Malshej  | Pune | Maharashtra |   444000 | TCS       | Profesion  |
| Sahil      | Shinde    |   9762689841 | sneha@gmail.com | Sangvi   | Pune | Maharashtra |   444222 | TCS       | Profession |
| Sahil      | Shinde    |   9762689841 | sneha@gmail.com | Sangvi   | Pune | Maharashtra |   444222 | TCS       | Family     |
| Sohan      | Kamble    |   9988689841 | Sohan@gmail.com | Baramati | Pune | Maharashtra |   413102 | Family    | Family     |
| Sahil      | Shinde    |   9762689841 | sneha@gmail.com | Sangvi   | Pune | Maharashtra |   444222 | TCS       | Profession |
+------------+-----------+--------------+-----------------+----------+------+-------------+----------+-----------+------------+
6 rows in set (0.00 sec)
