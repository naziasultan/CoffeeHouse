package com.charlene.coffee.domain;

public enum Extra implements Item{

    EXTRAMILK(0.30),
    FOAMEDMILK(0.50),
    ROASTCOFFEE(0.90);

    private Double price;

    Extra(Double price) {
        this.setPrice(price);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
