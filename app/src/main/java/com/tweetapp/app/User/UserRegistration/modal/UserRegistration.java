package com.tweetapp.app.User.UserRegistration.modal;

import java.util.Date;


public class UserRegistration{

    private String firstName;
    private String lastName;
    private String gender;
    private Date   dateOfBirth;
    private String eMail;
    private String password;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender2) {
        this.gender = gender2;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth="
                + dateOfBirth + ", eMail=" + eMail + ", password=" + password + "]";
    }


}
