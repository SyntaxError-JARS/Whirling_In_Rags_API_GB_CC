package com.revature.restaurant_application.models;


import javax.persistence.*;



@Entity
@Table(name = "customer")
public class CustomerData {

   @Id


    private String username;
    private String fname;
    private String lname;

    private String password;

    private int balance;
    @Column(name = "is_admin")
    private boolean isAdmin;



    public CustomerData(String username, String fname, String lname, String password, int balance, boolean isAdmin) {
        super();
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    //public CustomerData(String password){
        //this.password = password;
   // }

    public CustomerData() {

    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }




    public String getFname() {
        return fname;
    }


    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", balance='" + balance + '\'' +
              //  ", isAdmin='" + isAdmin + '\'' +
                '}';
    }


}



