package com.manom.interview.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianQueriesMySolution {
        public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

            // Write your code here
            median();
        }
        //for (iterarte)3 times
        //for(iterarte) through 1 6, 2 4 ,3 3
        //store sub array and sort assending.
        //now find median l/2
        //and peint median
        //2 4 5 3 1 6
        static void median() throws IOException {
            int[] mainArr;
            String[] stringArray;
            int len;
            int subArrayCount;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            len = Integer.parseInt(reader.readLine());
            mainArr = new int[len];
//        System.out.println("Enter array elements: ");
            stringArray = reader.readLine().split("\\s");
            mainArr = Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
//        System.out.println("Enter subArray count: ");
            subArrayCount = Integer.parseInt(reader.readLine());
//        indexArray = new int[subArrayCount][2];
//        System.out.println("Enter subArray elements: ");
            List<Pair> subArrays = new ArrayList<>(subArrayCount);
            while (subArrayCount > 0){
                subArrayCount--;
                String[] index = reader.readLine().split("\\s");
                subArrays.add(new Pair(Integer.parseInt(index[0]),Integer.parseInt(index[1])));
            }

            for(Pair pair: subArrays) {
                System.out.println(findMedian(pair.L, pair.R, mainArr));
            }

        }

        private static int findMedian(int l, int r, int[] arr) {
            int[] subArray = Arrays.copyOfRange(arr, l-1, r);
            Arrays.sort(subArray);
            int len = subArray.length;
            int midIndex = (int) Math.floor(len / 2);
            if (len % 2 == 0) {
                return ((subArray[midIndex] + subArray[midIndex + 1]) / 2);
            } else {
                return subArray[midIndex-1];
            }
        }

        private static class Pair{
            private int L;
            private int R;
            public Pair(int l, int r){
                L = l;
                R = r;
            }
        }
    }
