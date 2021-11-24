package com.charlene.coffee.domain;

import lombok.Getter;

import java.util.EnumSet;
@Getter
public class Product {
    Item item;
    public Product(Item item)
    {
        this.item=item;
    }

   public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Item  " + item.toString());
        return sb.toString();
    }

}
