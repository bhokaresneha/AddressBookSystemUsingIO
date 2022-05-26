package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBookOperation implements AddressBookInterface {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contacts> contactDetails = new ArrayList<>();
    static char choice;
    // static AddressBookOperation contacts =new AddressBookOperation();
    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    static String AddressBookName;
    static final File TEXT_file = new File("//home//hp//IdeaProjects//AddressBookSystemUsingIO//src//Resources//AddressBookFile.txt");
    static final String CSV_FILE = "//home//hp//IdeaProjects//AddressBookSystemUsingIO//src//Resources//CSVAddressBook.csv";
    //  static final File JSON_File = new File("//home//hp//IdeaProjects//AddressBookSystemUsingIO//src//Resources//JSONFile.json");

    // Creating Multiple Address Books
    public static void AddressBook(AddressBookOperation addressBookOperation) throws IOException {
        do {
            System.out.println("Enter your choice \n1.Add New Address Book \n2.Display Address Books Names\n3.Search based on City or State" +
                    "\n4.Count Persons belonging from Same City or State \n5.Sort Contact using Name \n6.Sort Contact using City, StateOr Zip-Code " +
                    "\n7.Read From Text File\n8.Read From CSV File  ");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addressBookOperation.addAddressBook(addressBookOperation);
                    break;
                case 2:
                    addressBookOperation.displayAddressBook();
                    break;
                case 3:
                    System.out.println("Enter city name or state name to search records");
                    String name = scanner.next();
                    addressBookOperation.searchInMultipleAddressBook(name);
                    break;

                case 4:
                    System.out.println("Enter city name or state name to Count Persons belonging from same city or state");
                    String countname = scanner.next();
                    addressBookOperation.countPersonFromSameCityOrState(countname);
                    break;
                case 5:
                    addressBookOperation.sortByName();
                    break;
                case 6:
                    addressBookOperation.sortByCityStateOrZipCode();
                    break;
                case 7:
                    addressBookOperation.readFromTextFile();
                    break;
                case 8:
                    addressBookOperation.readFromCSVFile();
                    break;
                default:
                    System.out.println("Invalid Option Entered!!!!! Please Enter Valid Option to Add New Address Book");


            }
            System.out.println("\nPerform More operations on Multiple Books press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');


    }


    @Override
    public void addAddressBook(AddressBookOperation addressBookOperation) throws IOException {
        do {
            System.out.println("Enter Name For Address Book");
            AddressBookName = scanner.next();
            if (hashmap.containsKey(AddressBookName)) {
                System.out.println("The AddressBook already contains");
                break;
            } else {
                ArrayList<Contacts> details = new ArrayList<>();
                addressBookOperation.displayActionMenu(details);
                hashmap.put(AddressBookName, details);
            }
            addToTexrFile(hashmap);
            addToCSVFile(hashmap);
            System.out.println("AddressBook Added" + hashmap + " ");
            System.out.println("To Add or Perform More Operations on Address Books  press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');

    }

    // Adding Details in Address Book -to ensure there is no Duplicate Entry of the same Person in a particular Address Book - Duplicate Check is done
    public ArrayList<Contacts> addContactDetail(ArrayList<Contacts> contactDetails)  {
        Contacts contacts = new Contacts();
        if (contactDetails.size() == 0) {
            System.out.println("Enter First Name");
            contacts.setFirstName(scanner.next());
            System.out.println("Enter Last Name");
            contacts.setLastName(scanner.next());
            System.out.println("Enter contact Number:");
            contacts.setContactNo(scanner.next());
            System.out.println("Enter Email: ");
            contacts.setEmail(scanner.next());
            System.out.println("Enter Address: ");
            contacts.setAddress(scanner.next());
            System.out.println("Enter City Name: ");
            contacts.setCity(scanner.next());
            System.out.println("Enter State: ");
            contacts.setState(scanner.next());
            System.out.println("Enetr Zip Code:");
            contacts.setZipCode(scanner.next());
            contactDetails.add(contacts);
            System.out.println("Contact details added!");
            return contactDetails;

        } else {
            System.out.println("Enter First Name");
            String firstname = scanner.next();
            for (Contacts contact : contactDetails) {
                if (contact.getFirstName().equals(firstname)) {
                    System.out.print("Name already present");
                } else {
                    contacts.setFirstName(firstname);
                    System.out.println("Enter Last Name");
                    contacts.setLastName(scanner.next());
                    System.out.println("Enter contact Number:");
                    contacts.setContactNo(scanner.next());
                    System.out.println("Enter Email: ");
                    contacts.setEmail(scanner.next());
                    System.out.println("Enter Address: ");
                    contacts.setAddress(scanner.next());
                    System.out.println("Enter City Name: ");
                    contacts.setCity(scanner.next());
                    System.out.println("Enter State: ");
                    contacts.setState(scanner.next());
                    System.out.println("Enetr Zip Code:");
                    contacts.setZipCode(scanner.next());
                    contactDetails.add(contacts);
                    System.out.println("Contact details added!");
                    return contactDetails;
                }
            }
        }

        return contactDetails;
    }


    // Function for updating Contact Details
    public  void updateContactDetail(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter First Name for which you want to modify info: ");
        String firstName = scanner.next();

        /*  Iterate to search for first name */

        for (Contacts contact : contactDetails) {
            // System.out.println("First Name: " + contact.getFirstName());
            if (contact.getFirstName().equals(firstName)) {
                System.out.println("Enter your Choice to Update Detail\n1. Update First Name\t2.Update Last Name\t3.Update Email Address\t4. Update Contact \t5. Update Address" +
                        "\t6.Update City \t7. Update State \t8. Upadate Zip Code");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        String UpdatedFirstName = scanner.next();
                        contact.setFirstName(UpdatedFirstName);
                        break;
                    case 2:
                        String lastName = scanner.next();
                        contact.setLastName(lastName);
                        break;

                    case 3:
                        System.out.println("Enter E-Mail Address:");
                        String email = scanner.next();
                        contact.setEmail(email);
                        break;
                    case 4:
                        System.out.println("Enter contact Number:");
                        String contactno = scanner.next();
                        contact.setContactNo(contactno);
                        break;
                    case 5:
                        System.out.println("Enter Address:");
                        String address = scanner.next();
                        contact.setAddress(address);
                        break;
                    case 6:
                        System.out.println("Enter City :");
                        String city = scanner.next();
                        contact.setCity(city);
                        break;
                    case 7:
                        System.out.println("Enter State:");
                        String state = scanner.next();
                        contact.setState(state);
                        break;
                    case 8:
                        System.out.println("Enter Zipcode:");
                        String zipcode = scanner.next();
                        contact.setZipCode(zipcode);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                System.out.println("Details updated");
            } else
                System.out.println("No record found");
        }

    }

    // function for deleting Contact details
    public void deleteContact(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter First Name for which you want to delete contact: ");
        String firstname = scanner.next();

        Iterator<Contacts> removeContact = contactDetails.iterator();

        /*  Checking the next element where
         *   condition holds true till there is single element
         *   in the List using hasNext() method
         */

        while (removeContact.hasNext()) {

            /*  Move cursor to next element */

            Contacts nextElement = removeContact.next();
            if (nextElement.getFirstName().equals(firstname)) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                break;
            } else {
                System.out.println("Contact not found.");
            }
        }
    }


    // Displaying Details From ContactDetails Arraylist
    public void displayDetails(ArrayList<Contacts> contactDetails) {
        for (Contacts contact : contactDetails) {
            System.out.print(contact + " ");
        }
    }

    //Displaying All Address Books With records which present in it
    public void displayAddressBook() {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet())
            for (Contacts v : entry.getValue()) {
                System.out.println("\n Address Book=>" + entry.getKey());
                System.out.println("FirstName \t LastName \t Email \t Contact Number \t Address \t City \t State \t Zip Code ");
                System.out.println(v.getFirstName() + "\t" + v.getLastName() + "\t" + v.getEmail() + "\t" + v.getContactNo() + "\t" + v.getAddress() +
                        "\t" + v.getCity() + "\t" + v.getState() + "\t" + v.getZipCode());
            }
    }

    // Searching a record in a through the City name or state name in Multiple Address Book
    public  void searchInMultipleAddressBook(String name) {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            List<Contacts> search = entry.getValue()
                    .stream()
                    .filter(searchdata -> searchdata.getCity().equalsIgnoreCase(name) || searchdata.getState().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
            for (Contacts item : search) {
                System.out.println(item.toString() + " ");
            }
        }
    }


    // Searching a record in a through the City name or state name in single Address Book
    public void searchInSingleAddressBook(ArrayList<Contacts> contactDetails) {
        System.out.println("Enter City Name or State Name to search a particular person");
        String data = scanner.next();
        List<Contacts> search = contactDetails
                .stream()
                .filter(searchdata -> searchdata.getCity().equalsIgnoreCase(data) || searchdata.getState().equalsIgnoreCase(data))
                .collect(Collectors.toList());
        for (Contacts item : search) {
            System.out.println(item.toString() + " ");
        }
    }

    // Counting number of records through the City name or state name in Multiple Address Book

    public void countPersonFromSameCityOrState(String name) {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            List<Contacts> count = entry.getValue()
                    .stream()
                    .filter(searchdata -> searchdata.getCity().equalsIgnoreCase(name) || searchdata.getState().equalsIgnoreCase(name))
                    .collect(Collectors.toList());

            int perconCount = (int) count.stream().count();
            System.out.printf(perconCount + "\tPersons belonging From =>" + name + " in " + entry.getKey() + "\t  ");
        }
    }

    // Sorting Data / Records through the Person Name
    public void sortByName() {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            List<Contacts> sort = entry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contactInfo -> contactInfo.getFirstName()))
                    .collect(Collectors.toList());
            for (Contacts item : sort) {
                System.out.println(item.toString() + " ");
            }
        }
    }

    // Sorting Data / Records through the City , State or Zip-Code
    public void sortByCityStateOrZipCode() {
        for (Map.Entry<String, ArrayList<Contacts>> entry : hashmap.entrySet()) {
            List<Contacts> sort = entry.getValue()
                    .stream()
                    .sorted(Comparator.comparing(contactInfo -> contactInfo.getCity() + contactInfo.getState() + contactInfo.getZipCode()))
                    .collect(Collectors.toList());

            for (Contacts item : sort) {
                System.out.println(item.toString() + "");
            }
        }
    }


    //Function for operations which you want to perform on Address Book
    public ArrayList<Contacts> displayActionMenu(ArrayList<Contacts> details)  {
        do {
            System.out.println(" Enter your choice \n1.Add Detail\n2.Update Detail \n3.Delete Detail\n4.Display ALl Details\n5.Search Records based on city or state" +
                    "\n6.Read From File \n7.Exit");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    addContactDetail(details);
                    break;
                case 2:
                    updateContactDetail(details);
                    break;
                case 3:
                    deleteContact(details);
                    break;

                case 4:
                    displayDetails(details);
                    break;
                case 5:
                    searchInSingleAddressBook(details);
                    break;
                case 6:
                    readFromTextFile();
                    break;
                case 7:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Invalid Choice !! Please Enter Valid Choice ");
            }
            System.out.println("\n To perform more operations on Particular Address Book press Y otherwise press N");
            choice = scanner.next().charAt(0);
        } while (choice != 'n' && choice != 'N');
        return null;
    }

    //Adding records in AddressBookFile.txt File
    public void addToTexrFile(HashMap<String, ArrayList<Contacts>> hashmap) {
        for (Map.Entry<String, ArrayList<Contacts>> addressBookHashMap : hashmap.entrySet()) {
            ArrayList<Contacts> values = addressBookHashMap.getValue();
            for (Contacts p : values)
            /* writer reads the current line and the Java readLine function writer.readLine() returns a string.
             Hence, the loop will iterate until it’s not null.*/
                try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(TEXT_file, true))) {
                    writer1.write("\nAddress Book Name- "+addressBookHashMap.getKey()+"\tFirst Name- " + p.getFirstName() + "\tLast Name- " + p.getLastName()
                            + "\tContact Number- " + p.getContactNo() + "\tEmail- " + p.getEmail() + "\tAddress- " + p.getAddress() + "\tCity- " + p.getCity()
                            + "\tState-" + p.getState() + "\tZip Code- " + p.getZipCode());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    // Reading Records from AddressBookFile.txt file
    public void readFromTextFile() {
        try {
            // Creating a BufferedReader object (instance)
            // A Reader that reads creates an input
            // character stream
            // and reads characters from it

            BufferedReader reader = new BufferedReader(new FileReader(TEXT_file));
            String st;
            // readLine() method of BufferedReader returns a whole line at a time
            //   BufferedReader#readLine() method is called,
            //   characters of a line stored in the buffer,
            //   are returned as a String.
            while ((st = reader.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Writing the data into CSV File
    public  void addToCSVFile(HashMap<String, ArrayList<Contacts>> hashmap) throws IOException {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
             CSVWriter csvWriter = new CSVWriter(writer, ',');) {
            System.out.println("First Name\t\t Last Name \t Contact Number \t Email \t Address \t City \t State \t Zip Code");
            for (Map.Entry<String, ArrayList<Contacts>> addressBookMapEntry : hashmap.entrySet()) {
                ArrayList<Contacts> values = addressBookMapEntry.getValue();
                for (Contacts c : values) {
                    String[] s = {"AddressBook Name:" + addressBookMapEntry.getKey(), "First Name:" + c.getFirstName(), "Last Name:" + c.getLastName(), "Contact No:" + c.getContactNo(), "Email ID:" + c.getEmail(), "Address:" + c.getAddress(), "City:" + c.getCity()
                            , "State:" + c.getState(), "Zip Code:" + c.getZipCode()};
                    csvWriter.writeNext(s);
                }
            }

        /*for (Map.Entry<String, ArrayList<Contacts>> addressBookHashMap : hashmap.entrySet()) {
            ArrayList<Contacts> values = addressBookHashMap.getValue();
            for (Contacts p : values)
            *//* writer reads the current line and the Java readLine function writer.readLine() returns a string.
             Hence, the loop will iterate until it’s not null.*//*
                try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
                    writer1.write("\nAddress Book Name- " + addressBookHashMap.getKey() + "\tFirst Name- " + p.getFirstName() + "\tLast Name- " + p.getLastName()
                            + "\tContact Number- " + p.getContactNo() + "\tEmail- " + p.getEmail() + "\tAddress- " + p.getAddress() + "\tCity- " + p.getCity()
                            + "\tState-" + p.getState() + "\tZip Code- " + p.getZipCode());

                } catch (Exception e) {
                    System.out.println(e);
                }
        }*/
        }
    }
    // Reading CSV File
    public  void readFromCSVFile() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String nextLine[];
            while ((nextLine = csvReader.readNext()) != null) {
                for(String token : nextLine)
                {
                    System.out.print("\t");
                    System.out.print(token);
                }

            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}