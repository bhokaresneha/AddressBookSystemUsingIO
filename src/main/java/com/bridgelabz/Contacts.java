package com.bridgelabz;

class Contacts {
    private String firstName, lastName, address, city, state, email,book_name,type;
    private long phone_number;
    private  int zip_code;

    public Contacts(String first_name, String last_name, long phone_number, String email, String address, String city, String state, int zip_code, String book_name, String type) {
        this.firstName=first_name;
        this.lastName=last_name;
        this.phone_number=phone_number;
        this.email=email;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip_code=zip_code;
        this.book_name=book_name;
        this.type=type;
    }

    public Contacts() {

    }


    //Getter methods =The get method returns the variable value

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public long getContactNo(){
        return phone_number;
    }
    public int getZipCode(){
        return zip_code;
    }
    public String getBookType(){
        return book_name;
    }

    public String getType(){
        return type;
    }


    //Setter method =>The set method sets the value.
    public  void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setContactNo(long phone_number){
        this.phone_number=phone_number;
    }
    public void setZipCode(int zip_code){
        this.zip_code = zip_code;
    }
    public  void setBookName(String book_name){this.book_name=book_name;}
    public  void setType(String type){this.type=type;}


    public String toString(){
        return ("FirstName IS " + firstName + " \n LastNAme Is " + lastName + " \n Email Is " + email +
                "\n Contact No Is " + phone_number + "\n Address Is " + address + " \n City Is " + city + "\n State Is " + state +
                "\n Zip Code Is " + zip_code+"\n Book Name " +book_name+"\n Type "+type);

    }


}