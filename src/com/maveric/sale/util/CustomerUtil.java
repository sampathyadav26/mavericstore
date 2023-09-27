package com.maveric.sale.util;

import com.maveric.sale.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerUtil {
    static List<Customer> customers=new ArrayList<>();
    public static List<Customer> getCustomers(){
        customers.add(new Customer(getCustId(),"Karthik","Kante",10000,null));
        customers.add(new Customer(getCustId(),"Sampath","Kondapuram",11000,null));
        customers.add(new Customer(getCustId(),"Mahesh","Karri",12000,null));
        customers.add(new Customer(getCustId(),"Asish","Gopan",13000,null));
        return customers;
    }

    private static long getCustId() {
        if(customers.size()==0)
            return 1;
        else
            return customers.get(customers.size()).getCustomerId()+1;
    }
}
