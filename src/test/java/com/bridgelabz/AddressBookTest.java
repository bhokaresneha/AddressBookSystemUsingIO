package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        List<Contacts> addressBookData = addressBookDBService.readAddressBookData(IOService.DB_IO);
        for(Contacts data:addressBookData){
            System.out.println(data);
        }
        Assertions.assertEquals(4,addressBookData.size());
    }


    @Test
    public void givenNewContactDetail_WhenUpdated_ShouldSync() {
       addressBookDBService.readAddressBookData(IOService.DB_IO);
        int changes = addressBookDBService.updateContactName("Sneha", "Snehal");
        Assertions.assertEquals(1, changes);
     //   boolean result = addressBookDBService.checkAddressBookInSyncWithDB("Elon");
      //  Assertions.assertTrue(result);
    }

@Test
    public void whenAskedNumberOfContacts_ByCityOrState_ShouldReturnExactCount() {
    addressBookDBService.readAddressBookData(IOService.DB_IO);
    int count = addressBookDBService.getCountOfContactsByCityOrState("Pune");
    //System.out.println(count);
    Assertions.assertEquals(4, count);
}
    @Test
    public void givenContactDetailRange_WhenRetrieved_ShouldMatchContactCount () {

        int ZipCodeStart = 41000;
        int ZipCodeEnd = 413115;
        List<Contacts> addressBookData = addressBookDBService.readAddressBookDataForDateRange(IOService.DB_IO, ZipCodeStart, ZipCodeEnd);
        for (Contacts data : addressBookData) {
            System.out.println(data);
        }
        Assertions.assertEquals(3, addressBookData.size());

    }
    @Test
    public void addNewContact_ShouldMatchContactCount(){

        addressBookDBService.addContact();
        List<Contacts> contactsList = addressBookDBService.readData();
      //  System.out.println(contactsList);
        Assertions.assertEquals(9, contactsList.size());
    }
}
