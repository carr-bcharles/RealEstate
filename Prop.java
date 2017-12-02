/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shdrealestate;

/**
 *
 * @author bchar
 */
class Prop {
    private int propertyID;
    private String streetAddress, city, state, zipCode, phoneNumber, numOfRooms, numberOfBaths, tennant_ssn, noOfTennants;
    private Boolean washer, dryer, deckOrPatio, basement;
    
    public Prop (int propertyID, String streetAddress, String city, String state, String zipCode, String phoneNumber, String numOfRooms, String numberOfBaths, String tennant_ssn, String noOfTennants, Boolean washer, Boolean dryer, Boolean deckOrPatio, Boolean basement) {
        this.propertyID=propertyID;
        this.streetAddress=streetAddress;
        this.city=city;
        this.state = state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
        this.numOfRooms=numOfRooms;
        this.numberOfBaths=numberOfBaths;
        this.washer=washer;
        this.dryer=dryer;
        this.deckOrPatio=deckOrPatio;
        this.basement=basement;
        this.tennant_ssn=tennant_ssn;
        this.noOfTennants=noOfTennants;
    }
    public int getpropertyID() {
        return propertyID ;
    }
    
    public String getstreetAddress() {
        return streetAddress;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getNumOfRooms() {
        return numOfRooms;
    }
    
    public String getNumberOfBaths() {
        return numberOfBaths;
    }
    
    public String getTennant_ssn() {
        return tennant_ssn;
    }  
    
    public String getNoOfTennants() {
        return noOfTennants;
    }
    
    public boolean getWasher() {
        return washer ;
    }
    
    public boolean getDryer() {
        return dryer;
    }
    
    public boolean getDeckOrPatio() {
        return deckOrPatio;
    }
        
    public boolean getBasement() {
        return basement;
    }
}
