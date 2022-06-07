package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBookMain  {
    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to Address Book Program!");
        AddressBookOperation addressBookOperation = new AddressBookOperation();
        System.out.println("*_*_*_*_*_*_*_*_*_*_Welcome to Address Book_*_*_*_*_*_*_*_*_*_*");
        addressBookOperation.AddressBook(addressBookOperation);
        createTable();
    }

    public static boolean createTable()
    {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement();) {
            System.out.println("Enter table name");
            String sql="CREATE TABLE Contact ( Person_ID INT NOT NULL,First_Name VARCHAR(50) NOT NULL,Last_Name VARCHAR(50) NOT NULL,Email VARCHAR(50) NOT NULL,Contact_Number VARCHAR(50) NOT NULL,Address VARCHAR(50) NOT NULL, City VARCHAR(50) NOT NULL,State VARCHAR(50) NOT NULL,Zip_Code INT NOT NULL,Book_ID INT UNSIGNED NOT NULL) ";
            statement.executeUpdate(sql);
           
            System.out.println("Created table in given database...");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}