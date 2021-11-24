package com.charlene.coffee.domain;

public enum Beverage implements Item{

    SMALLCOFFEE(2.50),
    MEDIUMCOFFEE(3.00),
    LARGECOFFEE(3.50),
    ORANGEJUICE(3.95);


    private Double price;

    Beverage(Double price) {
        this.setPrice(price);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
