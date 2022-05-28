package com.revature.restaurant_application.models;


import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCardData {

    @Id
    @Column(name="cc_number")
    private String cardNumber;
    private String cardName;

    private int cvv;

    private String expDate;
    private  int zipCode;
    private int creditLimit;
    private String username;



    public CreditCardData(String cardNumber, String cardName, int cvv, String expDate, int zipCode, int creditLimit, String username) {
        super();
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cvv = cvv;
        this.expDate = expDate;
        this.zipCode = zipCode;
        this.creditLimit = creditLimit;
        this.username = username;
    }


    public CreditCardData() {

    }

    // Getters & Setters
    public String getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;

    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "CreditCardData{" +
                "cardnumber='" + cardNumber + '\'' +
                ", cardname='" + cardName + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expdate='" + expDate + '\'' +
                ", zipcode='" + zipCode + '\'' +
                ", creditlimit='" + creditLimit + '\'' +
                ", username='" + username + '\'' +
                '}';
    }


}
