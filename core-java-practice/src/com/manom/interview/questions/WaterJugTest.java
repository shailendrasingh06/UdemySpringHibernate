package com.manom.interview.questions;


//Singleton Test
public class WaterJugTest {

    public static void main(String[] args) {
        WaterJug j1 = WaterJug.getInstance();
        WaterJug j2 = WaterJug.getInstance();

        System.out.println(j1.getWater(2));
        System.out.println(j2.getWater(2));
        System.out.println();
    }
}
