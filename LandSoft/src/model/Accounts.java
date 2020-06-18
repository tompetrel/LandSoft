/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TAI
 */
public class Accounts {

    private int AccountID;
    private String AccountName;
    private String FirstName;
    private String LastName;
    private boolean Gender;
    private String BirthDay;
    private String Email;
    private String Phone;
    private String Address;
    private String AccountPassword;
    private byte[] Image;
    private String Description;

    public Accounts() {
    }

    public Accounts(int AccountID, String AccountName, String FirstName, String LastName, boolean Gender, String BirthDay, String Email, String Phone, String Address, String AccountPassword, byte[] Image, String Description) {
        this.AccountID = AccountID;
        this.AccountName = AccountName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.BirthDay = BirthDay;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.AccountPassword = AccountPassword;
        this.Image = Image;
        this.Description = Description;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String BirthDay) {
        this.BirthDay = BirthDay;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String AccountPassword) {
        this.AccountPassword = AccountPassword;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
