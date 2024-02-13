package com.manom.interview.questions;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class FarthestFromZero {

    private static int findFarthestElement(int[] arr) {

        int farthestElement = 0;
        if(arr.length == 1)
            return arr[0];
        Arrays.sort(arr);
        int minElement = arr[0];
        int maxElement = arr[arr.length-1];

        farthestElement = Math.abs(maxElement) > Math.abs(minElement) ?  maxElement : minElement;


        return farthestElement;

    }

    private static int findFarthestElement1(int[] arr) {

        if(arr.length == 1)
            return arr[0];

        TreeSet<Integer> elementTS = new TreeSet<>();
        int minV, maxV;
        for(int arrayElement : arr) {
            elementTS.add(arrayElement);
        }
        maxV = elementTS.last();
        minV = elementTS.first();

        if(Math.abs(maxV) > Math.abs(minV))
            return maxV;

        return minV;
    }

    private static int youtubeMethod(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        int l =0;
        int r =0;
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            if(arr[i] > 0){
                r = Math.max(r, arr[i]);
            }else {
                l = Math.min(l, arr[i]);
            }
        }
        if (Math.abs(r) >= Math.abs(l))
            return r;
        else
            return l;
    }

    public static void main(String[] args) {
        int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(984234823) + 100).limit(100).toArray();
        long start = System.currentTimeMillis();
        System.out.println(youtubeMethod(new int[]{-7,-9,5,3,1,2,9}));
        System.out.println("Time took: " + (System.currentTimeMillis() - start));
    }
}

/*intputs*/

//-7,-9,5,3,1,2,9
//0,0,0,0,0