package com.manom.interview.questions;

class Solution {
    public static String decodeString(String s) {
        String outputString = "";
        char[] charArry = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            int lastIndex = s.lastIndexOf('[');
            outputString = outputString + multiplyString(String.valueOf((charArry[lastIndex + 1])), Integer.parseInt(String.valueOf((charArry[lastIndex - 1]))));

        }

        return outputString;

    }

    private static String multiplyString(String s, int multiplier)
    {
        StringBuilder strbldroutput = new StringBuilder();
        for(int i = 1; i <= multiplier; i++) {
            strbldroutput = strbldroutput.append(s);
        }

        return strbldroutput.toString();
    }

    public static void main(String... args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
