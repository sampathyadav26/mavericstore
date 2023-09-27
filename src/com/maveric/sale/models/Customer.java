package com.maveric.sale.models;

import java.util.List;

public class Customer {
    private long customerId;
    private String firstName;
    private String lastName;
    private double balance;
    private List<Product> productsBought;

    public Customer(long customerId, String firstName, String lastName, double balance, List<Product> productsBought) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.productsBought = productsBought;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public List<Product> getProductsBought() {
        return productsBought;
    }

    public void setProductsBought(List<Product> productsBought) {
        this.productsBought = productsBought;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", productsBought=" + productsBought +
                '}';
    }
}
