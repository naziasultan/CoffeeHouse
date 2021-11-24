package com.charlene.coffee.service;

import com.charlene.coffee.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CoffeeShopServiceTest {

    @Autowired
    CoffeeShopService coffeeShopService;

    //large coffee with extra milk, small coffee with special roast, bacon roll, orange juice

    @DisplayName("Test Task In Coding Exercise")
    @Test
    void get_success_program_expected() {
        List<Product> productList = new ArrayList<Product>();
        Product prod1 = new Product(Beverage.LARGECOFFEE);
        Product prod2 = new Product(Beverage.SMALLCOFFEE);
        Product prod3 = new Product(Beverage.ORANGEJUICE);
        Product prod4 = new Product(Snacks.BACONROLL);
        Product prod5 = new Product(Extra.EXTRAMILK);
        Product prod6 = new Product(Extra.ROASTCOFFEE);

        List<Product> prodList = new ArrayList<>();
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);
        prodList.add(prod4);
        prodList.add(prod5);
        prodList.add(prod6);

        Double receipt = 0.00;

        receipt = coffeeShopService.getReceipt(prodList);

        DecimalFormat df = new DecimalFormat("####0.00");
        assertEquals(15.35, Double.valueOf(df.format(receipt)));

    }

    @DisplayName("Test 5th Beverage Free")
    @Test
    void get_success_5th_beverage_free() {
        List<Product> productList = new ArrayList<Product>();
        Product prod1 = new Product(Beverage.LARGECOFFEE);
        Product prod2 = new Product(Beverage.LARGECOFFEE);
        Product prod3 = new Product(Beverage.LARGECOFFEE);
        Product prod4 = new Product(Beverage.LARGECOFFEE);
        Product prod5 = new Product(Beverage.LARGECOFFEE);
        Product prod6 = new Product(Beverage.LARGECOFFEE);

        List<Product> prodList = new ArrayList<>();
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);
        prodList.add(prod4);
        prodList.add(prod5);
        prodList.add(prod6);

        Double receipt = coffeeShopService.getReceipt(prodList);

        //For 5 coffees price should be 17.5 without discount after discount it should be 14 or 6 coffee will cost 17.5 one coffee is discounted
        assertEquals(17.5, receipt);
    }

    @DisplayName("Test Extra Free")
    @Test
    void get_success_extra_free() {
        List<Product> productList = new ArrayList<Product>();
        Product prod1 = new Product(Beverage.LARGECOFFEE);
        Product prod2 = new Product(Snacks.BACONROLL);
        Product prod3 = new Product(Extra.EXTRAMILK);

        List<Product> prodList = new ArrayList<>();
        prodList.add(prod1);
        prodList.add(prod2);
        prodList.add(prod3);

        Double receipt = coffeeShopService.getReceipt(prodList);
        assertEquals(8.00, receipt);
        assertNotNull(receipt);

    }


}