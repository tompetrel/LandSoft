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
public class Property {

    private int propertyID, typeID;
    private String squareMeter, price;
    private int ownerID;
    private String address;
    private int floor, bedrooms, bathrooms;
    private boolean balcony, pool, garage;
    private String desciption;

    public Property() {
    }

    public Property(int propertyID, int typeID, String squareMeter, String price, int ownerID, String address, int floor, int bedrooms, int bathrooms, boolean balcony, boolean pool, boolean garage, String desciption) {
        this.propertyID = propertyID;
        this.typeID = typeID;
        this.squareMeter = squareMeter;
        this.price = price;
        this.ownerID = ownerID;
        this.address = address;
        this.floor = floor;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.balcony = balcony;
        this.pool = pool;
        this.garage = garage;
        this.desciption = desciption;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(String squareMeter) {
        this.squareMeter = squareMeter;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

}
