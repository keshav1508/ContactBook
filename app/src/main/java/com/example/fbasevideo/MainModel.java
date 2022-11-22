package com.example.fbasevideo;

public class MainModel {

    String Email,Phoneno,turl,FirstName,LastName;
    MainModel(){
        
    }
    public MainModel(String email, String phoneno, String turl, String firstName, String lastName) {
        Email = email;
        Phoneno = phoneno;
        this.turl = turl;
        FirstName = firstName;
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String phoneno) {
        Phoneno = phoneno;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
