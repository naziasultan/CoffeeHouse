package com.charlene.coffee.domain;

public enum Snacks implements Item{

    BACONROLL(4.50);
    private Double price;

    Snacks(Double price) {
        this.setPrice(price);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
