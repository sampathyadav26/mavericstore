package com.maveric.interfaces;

import com.maveric.model.Customer;
import com.maveric.model.Products;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public void registerCustomer(Customer cust);

    public void customerbyid(long id);

    public List<Customer> allCustomers();

    public List<Products> customerBought(long Cust_id);

    public void buyProduct(long Cust_id,long pro_id);
}
