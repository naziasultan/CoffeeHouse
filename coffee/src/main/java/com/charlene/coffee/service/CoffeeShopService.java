package com.charlene.coffee.service;

import com.charlene.coffee.domain.Product;
import com.charlene.coffee.domain.Receipt;

import java.util.List;

public interface CoffeeShopService {
    Double getReceipt(List<Product> products);
}
