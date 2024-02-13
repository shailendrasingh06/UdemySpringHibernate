package com.manom.streamapi.examples;

import com.manom.streamapi.ExampleData;
import com.manom.streamapi.Product;

import java.math.BigDecimal;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        BigDecimal priceLimit = new BigDecimal("5.00");

        products.sort((p1, product) -> p1.getPrice().compareTo(priceLimit));
    }
}
