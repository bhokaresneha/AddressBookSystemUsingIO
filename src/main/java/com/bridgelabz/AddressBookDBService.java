package com.bridgelabz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressBookDBService {
    List<Contacts> contactsList=new ArrayList<>();

    private List<Contacts> readData() {
        String sql = "select * from AddressBook; ";
        return getEmployeePayrollDataUsingDB(sql);
    }



    public List<Contacts> getContactData(ResultSet resultSet) {
        try{
            while (resultSet.next()){
                String First_Name=resultSet.getString("First_Name");
                String Last_Name=resultSet.getString("Last_Name");
                long Phone_Number=resultSet.getLong("Phone_Number");
                String Email=resultSet.getString("Email");
                String Address=resultSet.getString("Address");
                String City=resultSet.getString("City");
                String State=resultSet.getString("State");
                int Zip_Code=resultSet.getInt("Zip_Code");
                String Book_Name=resultSet.getString("Book_Name");
                String Type=resultSet.getString("Type");
                contactsList.add(new Contacts(First_Name,Last_Name,Phone_Number,Email,Address,City,State,Zip_Code,Book_Name,Type));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contactsList;
    }

    public List<Contacts> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO)) {
            this.contactsList = readData();
        }
        return this.contactsList;
    }
    private Contacts getContactsData(String namePresent) {
        return this.contactsList.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.getFirstName().equals(namePresent)).findFirst().orElse(null);
    }

    public int updateContactName(String namePresent, String nameChange) {
        int result = updateEmployeeData(namePresent, nameChange);
        if (result == 0) return result;
        Contacts contactsData = this.getContactsData(namePresent);
        if (contactsData != null) {
            contactsData.setFirstName(nameChange);
        }
        return result;
    }

    private int updateEmployeeData(String namePresent, String nameChange) {
        String sql = String.format("update AddressBook set First_Name = '%s' where First_Name = '%s';", nameChange, namePresent);
        try (Connection connection = JDBCConnection.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Contacts> readAddressBookDataForDateRange(IOService ioService, int ZipCodeStart, int ZipCodeEnd) {
        if (ioService.equals(IOService.DB_IO)) {
            return getEmployeePayrollForDateRange(ZipCodeStart, ZipCodeEnd);
                    }
        return null;
    }

    private List<Contacts> getEmployeePayrollForDateRange(int ZipCodeStart, int ZipCodeEnd) {
        String sql = String.format(" SELECT * FROM AddressBook WHERE Zip_Code BETWEEN %s AND %s;",ZipCodeStart,ZipCodeEnd);
        return this.getEmployeePayrollDataUsingDB(sql);
    }

    private List<Contacts> getEmployeePayrollDataUsingDB(String sql) {
       List<Contacts> contactDataList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            contactDataList = this.getContactData(result);
         //   System.out.println("GET DAtaa=>>>"+contactDataList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactDataList;
    }

}
