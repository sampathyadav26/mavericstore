package com.maveric.model;

public class Products {
    private long pro_id;
   private String name;
    private double price;

    public Products() {
    }

    public Products(long pro_id, String name, double price) {
        this.pro_id = pro_id;
        this.name = name;
        this.price = price;
    }

    public long getpro_id() {
        return pro_id;
    }

    public void setpro_id(long pro_id) {
        this.pro_id= pro_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + pro_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
