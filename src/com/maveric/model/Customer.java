package com.maveric.model;

import java.util.List;

public class Customer {

    private long Cust_id;


    private String firstName;
    private String lastName;
    private double balance;

   private List<Products> ProductBought;

    public Customer() {
    }

    public Customer(long cust_id, String firstName, String lastName, double balance, List<Products> productBought) {
        Cust_id = cust_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        ProductBought = productBought;
    }

    public long getCust_id() {
        return Cust_id;
    }

    public void setCust_id(long cust_id) {
        Cust_id = cust_id;
    }

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Products> getProductBought() {
        return ProductBought;
    }

    public void setProductBought(List<Products> productBought) {
        ProductBought = productBought;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Cust_id=" + Cust_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", ProductBought=" + ProductBought +
                '}';
    }
}
