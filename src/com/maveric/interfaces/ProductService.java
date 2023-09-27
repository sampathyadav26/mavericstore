package com.maveric.interfaces;

import com.maveric.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void registerProducts(Products pro);

    public List<Products> allProduct();
    public void productbyid(long id);


}
