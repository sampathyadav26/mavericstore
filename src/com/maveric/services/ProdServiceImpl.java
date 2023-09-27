package com.maveric.services;

import com.maveric.model.Customer;
import com.maveric.model.Products;
import com.maveric.interfaces.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProdServiceImpl implements ProductService {

    static List<Products> productlist = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    @Override
    public void registerProducts(Products pr) {
        Products pro = new Products();
        System.out.println("enter product id");
        int id = sc.nextInt();
        pro.setpro_id(id);
        System.out.println("enter product name");
        String pro_name = sc.next();
        pro.setName(pro_name);
        System.out.println("enter product price");
        double price = sc.nextDouble();
        pro.setPrice(price);
        productlist.add(pro);
        System.out.println("product Registration successful");
    }

    @Override
    public List<Products> allProduct() {
//        productlist.stream().forEach(System.out::println);
        return productlist;
    }

    @Override
    public void productbyid(long id) {

        for (Products list : productlist) {
            if (list.getpro_id() == id) {
                System.out.println("Product id you search:" + list.getpro_id() + "  " + list.getName() + "   " + list.getPrice());
            } else {
                System.out.println("no id found :" + id);
            }
        }
    }

}