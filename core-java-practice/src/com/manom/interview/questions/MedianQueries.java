package com.manom.interview.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MedianQueries {
    public static void main(String args[]) throws Exception{

            median();
        }

        static void median() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //Scanner sc = new Scanner(System.in);
            int arrSize = Integer.parseInt(br.readLine());
            //sc.nextLine();
            String[] str = br.readLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            int query = Integer.parseInt(br.readLine());
            int query1=query;
            //sc.nextLine();
            List<Mapping> li = new ArrayList<Mapping>();
            int[] subarr = null;

            while (query > 0) {

                query--;
                String[] str1 = br.readLine().split(" ");
                li.add(new Mapping(Integer.parseInt(str1[0]), Integer.parseInt(str1[1])));
                str1 = null;

            }

            for (int i = 0; i < query1; i++) {
                int L=li.get(i).L;
                int R=li.get(i).R;
                subarr = Arrays.copyOfRange(arr, L-1, R);

                Arrays.sort(subarr);
                int subLen=subarr.length;
                int length = subLen % 2 == 0 ? subLen/ 2 : (subLen + 1) / 2;
                System.out.println(subarr[length-1]);
            }

        }

   static class Mapping{
        int L ;
        int R;
        public Mapping(int l, int r) {
            super();
            L = l;
            R = r;
        }


    }
}