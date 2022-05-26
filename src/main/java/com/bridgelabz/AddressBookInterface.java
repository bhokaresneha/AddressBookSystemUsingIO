package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {


    void addAddressBook(AddressBookOperation addressBookOperation) throws IOException;
    ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails);
    void updateContactDetail(ArrayList<Contacts> contactDetails) ;
    void deleteContact(ArrayList<Contacts> contactDetails) ;
    void displayDetails(ArrayList<Contacts> contactDetails);
    void displayAddressBook()throws IOException;
    void searchInMultipleAddressBook(String name);
 //   void searchInMultipleAddressBook();
    void searchInSingleAddressBook(ArrayList<Contacts> contactDetails);
    void countPersonFromSameCityOrState(String name);
    void sortByName();
    void sortByCityStateOrZipCode();
    ArrayList<Contacts> displayActionMenu(ArrayList<Contacts> details) ;
    void addToTexrFile(HashMap<String, ArrayList<Contacts>> hashmap);
    void readFromTextFile();
    void addToCSVFile(HashMap<String, ArrayList<Contacts>> hashmap) throws IOException;
    void readFromCSVFile();
    }
