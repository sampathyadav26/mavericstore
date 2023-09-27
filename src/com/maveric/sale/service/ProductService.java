package com.maveric.sale.service;

import com.maveric.sale.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public void registerProduct(String name, double price);
    public Product findProductById(long productid);
}
