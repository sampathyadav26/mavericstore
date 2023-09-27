package com.maveric.sale.service.impl;

import com.maveric.sale.models.Product;
import com.maveric.sale.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {
    static List<Product> products=new ArrayList<>();
    static{
        products.add(new Product(1,"OnePlus",50000));
        products.add(new Product(2,"Hp",75000));
        products.add(new Product(3,"Benz",4500000));
    }
    public List<Product> getProducts(){
        return products;
    }
    public void registerProduct(String name, double price) {
        Product p=products.stream().filter(product->product.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
        if (p==null){
            products.add(new Product(getProductId(),name,price));
            System.out.println("*********Product Registration is Successfull*********");
        }else {
           System.out.println("*********Product Already Available*********");
        }
    }

    public Product findProductById(long productid){
        return products.stream()
                .filter(product->product.getProducId()==productid)
                .findFirst().orElse(null);
    }
    private long getProductId() {
       if(products.size()==0)
           return 1;
       else
           return products.get(products.size()-1).getProducId()+1;
    }
}
