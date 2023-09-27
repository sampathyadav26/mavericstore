package com.maveric.services;

import com.maveric.interfaces.ProductService;
import com.maveric.model.Customer;
import com.maveric.model.Products;
import com.maveric.interfaces.CustomerService;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerServiceimpl implements CustomerService {

    List<Customer> customerslist=new ArrayList<>();
    List<Products> productsList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    //ProdServiceImpl productsobj=new ProdServiceImpl();
    ProductService productService=new ProdServiceImpl();
    public void getcustid(){

    }
    @Override
    public void registerCustomer(Customer cust) {

        System.out.print("enter your Customer id :");
        int id= sc.nextInt();
        cust.setCust_id(id);
        System.out.println("enter your customer First Name :");
        String firstname= sc.next();
        cust.setFirstName(firstname);
        System.out.println("enter your customer Last Name");
        String  lastname= sc.next();
        cust.setLastName(lastname);
        System.out.println("enter your balance");
        double balance= sc.nextDouble();
        cust.setBalance(balance);
        customerslist.add(cust);
    }

    @Override
    public void customerbyid(long id) {
        for(Customer list:customerslist){
               if(list.getCust_id()==id){
                   System.out.println("Customer id you search:"+list.getCust_id());
               }else{
                   System.out.println("no id found"+id);
               }
           }

    }

    @Override
    public  List<Customer> allCustomers() {

        List<Customer> list=customerslist.stream().collect(Collectors.toList());
//        list.stream().forEach(i->System.out.println(i));
        return list;
    }

    @Override
    public List<Products> customerBought(long Cust_id) {
    List<Products> prolist=null;
        Customer cust=null;
        for(Customer cust1 : customerslist){
            if(cust1.getCust_id()==Cust_id){
             prolist=  cust1.getProductBought();
            prolist.stream().forEach(System.out::println);
            }else{
                System.out.println("customer id id not available:"+Cust_id);
            }
            }
        return prolist;
    }

    @Override
    public void buyProduct(long Cust_id, long pro_id) {
        Products pro1 = null;
        
        for (Products proobj : productService.allProduct()) {
           // System.out.println("In CustomerserviceImpl productService.allProduct()");
         //   productService.allProduct().stream().forEach(System.out::println);
            if (proobj.getpro_id() == pro_id) {
                pro1 = proobj;
            }
        }
        if (pro1!= null) {
            for (Customer obj : customerslist) {
                if (obj.getCust_id() == Cust_id) {
                    obj.setProductBought(Arrays.asList(pro1));
                    System.out.println(obj);
                }
            }
        }else{
            System.out.println("product is not available:"+pro_id);
        }
    }
}
