package com.maveric.sale.service.impl;

import com.maveric.sale.models.Customer;
import com.maveric.sale.models.Product;
import com.maveric.sale.service.CustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customers=new ArrayList<>();
    static {
        customers.add(new Customer(getCustId(),"Karthik","Kante",10000,new ArrayList<>()));
        customers.add(new Customer(getCustId(),"Sampath","Kondapuram",11000,new ArrayList<>()));
        customers.add(new Customer(getCustId(),"Mahesh","Karri",12000,new ArrayList<>()));
        customers.add(new Customer(getCustId(),"Asish","Gopan",13000,new ArrayList<>()));
        customers.add(new Customer(getCustId(),"Amaresh","Giri",14000,new ArrayList<>()));
    }
    public List<Customer> getustomers(){
        return customers;
    }
    public void registerCustomer(String fname,String lname, double balance){
        customers.add(new Customer(getCustId(),fname,lname,balance,new ArrayList<>()));
        System.out.println("Registered Successfully...");
    }
    public void buyProduct(long customerId, long productid){
        ProductServiceImpl service=new ProductServiceImpl();
        if(authenticateCustomerId(customerId)==true){
            Optional<Product> res=service.getProducts().stream().filter(pro->pro.getProducId()==productid)
                    .findFirst();
            if (!res.isPresent())
                System.out.println("*******Sorry... The product you want to buy is not available.*******");
            else{
                List<Product> pross=new ArrayList<>();
                pross.addAll(customers.stream()
                        .filter(cust->cust.getCustomerId()==customerId)
                        .findFirst().get().getProductsBought());
                pross.add(res.get());
                customers.stream()
                        .filter(cust->cust.getCustomerId()==customerId)
                        .findFirst().get()
                        .setProductsBought(pross);
                System.out.println("*******Your product details********");
                System.out.println(res.get());
            }
        }else{
            System.out.println("*****You are Not a authorized customer... please Register first*****");
        }

    }
    public Customer findCustomerById(long id){
        return customers.stream().filter(cust->cust.getCustomerId()==id).findFirst().orElse(null);
    }
    public List<Product> getProductsBoughtByCustomer(long id){
            return customers.stream().filter(customer -> customer.getCustomerId() == id)
                    .findFirst().get().getProductsBought();
    }

    public static boolean authenticateCustomerId(long custId){
        Customer customer=customers.stream().filter(cust->cust.getCustomerId()==custId)
                .findFirst().orElse(null);
        if(customer==null)
            return false;
        else
            return true;
    }

    private static long getCustId() {
        if(customers.size()==0)
            return 1;
        else
            return customers.get(customers.size()-1).getCustomerId()+1;
    }
}
