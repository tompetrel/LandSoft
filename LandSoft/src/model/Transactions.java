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
public class Transactions {

    private int transactionID, propertyID, customerID;
    private String date, finalPrice;

    public Transactions() {
    }

    public Transactions(int transactionID, int propertyID, int customerID, String date, String finalPrice) {
        this.transactionID = transactionID;
        this.propertyID = propertyID;
        this.customerID = customerID;
        this.date = date;
        this.finalPrice = finalPrice;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

}
