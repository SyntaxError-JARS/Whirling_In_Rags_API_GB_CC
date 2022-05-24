package com.revature.restaurant_application.services;

import com.revature.restaurant_application.daos.CreditCardDao;
import com.revature.restaurant_application.daos.MenuDao;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.models.CreditCardData;

import java.io.IOException;
import java.util.ArrayList;

public class CreditCardServices {

    /*private CreditCardDao creditCardDao;

    public CreditCardServices(CreditCardDao creditCardDao){
        this.creditCardDao = creditCardDao;
    }

    public CreditCardData CreateCreditCard(CreditCardData newCreditCardData){

        if(!validateCreditCard (newCreditCardData)) {
            throw new InvalidRequestException("Credit card input was not validated, either empty Strings or null values");
        }

        CreditCardData persistedCreditCard = creditCardDao.Create(newCreditCardData);
        if(persistedCreditCard == null) {
            throw new ResourcePersistenceException("Credit card was not persisted to the database");
        }
        return new CreditCardData;
    }

    public boolean validateCreditCard(CreditCardData newCreditCardData) {
    }

    public ArrayList<CreditCardData> readAll() throws IOException {
        ArrayList<CreditCardData> creditCard = creditCardDao.findAll();
        return creditCard;

        public CreditCardData readByID(string username){
            CreditCardData creditCard = creditCardDao.findByID(username);
            return creditCard;
        }

        public CreditCardData update(CreditCardData updatedCreditCard){
            if(!creditCardDao.update((updatedCreditCard))){
                return null;
            }
            return updatedCreditCard;
        }

        public boolean delete(String username){
            return creditCardDao.delete(username);
        }

        public boolean validateCreditCard(CreditCardData newCreditCardData){
            if(newCreditCardData == null) return false;
            if(newCreditCardData.getCardNumber() == null || newCreditCardData.getCardNumber().trim().equals((""))) return false;
            if(newCreditCardData.getCardName() == null || newCreditCardData.getCardName().trim().equals((""))) return false;
            if(newCreditCardData.getCvv() == null || newCreditCardData.getCvv().trim().equals((""))) return false;
            if(newCreditCardData.getExpDate() == null || newCreditCardData.getExpDate().trim().equals((""))) return false;
            if(newCreditCardData.getZipCode() == null || newCreditCardData.getZipCode().trim().equals((""))) return false;
            if(newCreditCardData.getCreditLimit() == null || newCreditCardData.getCreditLimit().trim().equals((""))) return false;
            if(newCreditCardData.getUsername() == null || newCreditCardData.getUsername().trim().equals((""))) return false;
        }
    }

     */
}

