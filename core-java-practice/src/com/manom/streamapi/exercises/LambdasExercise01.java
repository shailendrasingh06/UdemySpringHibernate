/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package com.manom.streamapi.exercises;

import com.manom.streamapi.ExampleData;
import com.manom.streamapi.Product;

import java.util.List;

public class LambdasExercise01 {

    /**
     * Exercise 1: Sort a list of products by name using a lambda expression.
     *
     * @param products The list of products to sort.
     */
    public void sortProductsByName(List<Product> products) {
//        products.sort();
    }

    public static void main(String[] args) {
        var exercise01 = new LambdasExercise01();
        List<Product> productList = ExampleData.getProducts();
        exercise01.sortProductsByName(productList);
    }
}
