package com.manom.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedString {
    public static void main(String[] args) {
        try {
//            System.out.println(repeatedString("a", 10000000000l));
            System.out.println("Jumping on clouds: " + jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0)));

            //Two Strings
            twoStrings("Hello", "World");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long repeatedString(String s, long n) {
        long numberOfRepeatation = n / s.length();
        long remainingString = n % s.length();

        long totalCountOfA = numberOfRepeatation * findCount(s) +
                (remainingString == 0L ? 0 : findCount(s.substring(0, (int) remainingString)));

        return totalCountOfA;
    }

    public static long findCount(String s) {
        long countOfA = 0l;
        for (char stringChar : s.toCharArray()) {
            if ('a' == stringChar)
                countOfA++;
        }

        return countOfA;
    }

    private static int jumpingOnClouds(List<Integer> c) {
        int numberOfClouds = c.size();
        int numberOfJumps = 0;
        if (numberOfClouds == 1)
            return numberOfJumps;
        int cloudNo = 0;
        while (cloudNo < numberOfClouds-1) {
            if(cloudNo + 2 == numberOfClouds) {
                numberOfJumps++;
                break;
            }
            if (c.get(cloudNo) + c.get(cloudNo + 2) == 0) {
                cloudNo = cloudNo + 2;
            } else {
                if (c.get(cloudNo) + c.get(cloudNo + 1) == 0) {
                    cloudNo++;
                }
            }
            numberOfJumps++;

        }
        return numberOfJumps;
    }


    public static String twoStrings(String s1, String s2) {

        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == (s2.charAt(j))){
                    return "Yes";
                }else {
                    return "No";
                }
            }
        }

        return "No";

    }
}

