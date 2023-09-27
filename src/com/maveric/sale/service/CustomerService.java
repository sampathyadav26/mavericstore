package com.maveric.sale.service;

import com.maveric.sale.models.Customer;
import com.maveric.sale.models.Product;

import java.util.List;

public interface CustomerService {
    public List<Customer> getustomers();
    public void registerCustomer(String fname,String lname, double balance);
    public void buyProduct(long customerId, long productid);
    public Customer findCustomerById(long id);
    public List<Product> getProductsBoughtByCustomer(long id);
}
