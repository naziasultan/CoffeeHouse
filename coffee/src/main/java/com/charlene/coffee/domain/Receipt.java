package com.charlene.coffee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter @Setter
public class Receipt {
    private static final String CTE_CURRENCY = "CHF";



    public Double getTotalPrice(Map<Product, Integer> itemMap, List<Product> discountedProducts) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        Double total=0.00;
        sb.append("Id Receipt: ").append(UUID.randomUUID().toString()).append("\n");
        sb.append("Date      : ").append(date).append("\n");
        for (Map.Entry<Product, Integer> entry : itemMap.entrySet())
        {
            Double price=entry.getKey().getItem().getPrice();


            sb.append(entry.getKey().getItem())
                   .append("        ")
                    .append(price)
                    .append("\n");
            total= total+price;

        }

        for (Product discount:discountedProducts) {
            sb.append("Discounted " +discount + "  0.00" +"\n");
        }

        sb.append("Total     : ").append(String.format("%.2f", total)).append(" ").append(CTE_CURRENCY).append("\n");
        System.out.println(sb.toString());
        return total;
    }


}
