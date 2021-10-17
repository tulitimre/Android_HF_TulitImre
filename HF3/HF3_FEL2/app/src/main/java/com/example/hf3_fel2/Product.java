package com.example.hf3_fel2;


import androidx.annotation.NonNull;

public class Product {

    private int code;
    private String name;
    private double price;

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @NonNull
    @Override
    public String toString() {
        return "Code: " + this.getCode() + " Name: " + this.getName() + " Price: " + this.getPrice() + "$\n";
    }

}
