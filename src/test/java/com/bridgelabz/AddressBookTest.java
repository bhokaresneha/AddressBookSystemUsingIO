package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    AddressBookDBService addressBookDBService=new AddressBookDBService();
    AddressBookOperation addressBookOperation=new AddressBookOperation();
   @Test
  public void givenAddressBook_WhenDataAddedInTextFile_ShouldReturnTrue(){
       Assertions.assertTrue(addressBookOperation.addToTexrFile(AddressBookOperation.hashmap));
    }
    @Test
    public void givenAddressBook_WhenReadTextFileData_ShouldReturnTrue (){
        Assertions.assertTrue(addressBookOperation.readFromTextFile());
    }

    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContactCount()  {
        List<Contacts> employeeData=addressBookDBService.readData();
        for(Contacts data:employeeData){
            System.out.println(data);
        }
        Assertions.assertEquals(4,employeeData.size());
    }


}
