package com.charlene.coffee.service;

import com.charlene.coffee.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoffeeShopServiceImpl implements CoffeeShopService {

    List<Product> discountedProduct = new ArrayList<>();

    @Override
    public Double getReceipt(List<Product> products) {
        int beverage = 0;
        int extra = 0;
        int snacks = 0;
        Product prod = null;
        Map<Product, Integer> totalProducts = new HashMap<Product, Integer>();
        List<Product> productDiscountable = new ArrayList<Product>();

        for (int i = 0; i < products.size(); i++) {
            prod = products.get(i);
            Item items = prod.getItem();

            if (items instanceof Beverage) {
                totalProducts.put(prod, beverage++);
                if (beverage == 5) {
                    productDiscountable.add(prod);
                }
            } else if (items instanceof Snacks) {
                totalProducts.put(prod, snacks++);
            } else if (items instanceof Extra) {
                productDiscountable.add(prod);
                totalProducts.put(prod, extra++);
            }
        }

        totalProducts = removeDiscoutedItem(snacks, beverage, extra, totalProducts, productDiscountable);
        Receipt receipt = new Receipt();
        return receipt.getTotalPrice(totalProducts, getDiscountedList());
    }


    private Map<Product, Integer> removeDiscoutedItem(int snacks, int beverage, int extra, Map<Product, Integer> totalProducts, List<Product> productDiscountable) {
        List<Product> discounted = new ArrayList<>();
        int minDiscoutable = Math.min(snacks, beverage);

        for (int i = 0; i < productDiscountable.size(); i++) {
            Product product = productDiscountable.get(i);
            if (product.getItem() instanceof Extra) {
                if (minDiscoutable <= extra && minDiscoutable != 0) {
                    totalProducts.remove(product);
                    extra--;
                    minDiscoutable--;
                    discounted.add(product);
                }
            } else if (product.getItem() instanceof Beverage && totalProducts.get(product) == 4) {
                totalProducts.remove(product);
                discounted.add(product);
            }
            setDiscountedProduct(discounted);
        }
        return totalProducts;
    }


    public List<Product> getDiscountedList() {
        return discountedProduct;
    }

    public void setDiscountedProduct(List<Product> discountedProduct) {
        this.discountedProduct = discountedProduct;
    }
}
