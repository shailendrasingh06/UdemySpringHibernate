package com.manom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
//
//    void display(Object obj) {
//        System.out.println(obj);
//    }
//
//    void display(String str) {
//        System.out.println(str);
//    }

    public static void main(String[] args) {
//        new Main().display(null);
//        xyz('1');
        rotLeft(Arrays.asList(1,2,3,4,5), 2);
    }

    private static int xyz( int a) {
    return a;
    }

    private static char xyz(char c){
        return c;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        if(d == 0)
            return a;

        int length = a.size();
        List<Integer> newArray = new ArrayList<>();

        for(int i = 0; i < a.size(); i++) {
            int currentElement = a.get(i);
            int newIndex = i + d;
            int updatedIndex = newIndex > length ? newIndex % length : newIndex;
            newArray.set(updatedIndex, currentElement);

        }

        return newArray;
    }

}
