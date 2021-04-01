package com.nykaa.marketplace.dto;

public class Data {

    private String sku;
    private double price;

    public void setSku(String sku){
        this.sku = sku;
    }
    public String getSku(){
        return this.sku;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }

}
