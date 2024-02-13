package com.manom.interview.questions;

public class MaxHourGlass {

    private static int findMaxHourGlass(int[][] arr){
        System.out.println("Hello this is Pawan Singh.");
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int row = 5;
        int col = 5;
        boolean process = true;
        while(process){
            if(row < 3 && col < 3) {
                System.out.println("Not an Hourglass");
                System.exit(0);
                process = false;
            }
            for(int i =0 ; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(row !=0 && col !=0){
                        currentSum = arr[i][j] + arr[i][j] + arr[i][j]
                                    + arr[i][j] + arr[i][j] + arr[i][j]
                                    + arr[i][j] + arr[i][j] + arr[i][j];
                    }
                }
                row--;
                col--;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Calculating max hourglass..");
        findMaxHourGlass(new int[][]{
                {1,2,1,3,4},
                {2,3,46,6,7},
                {1,3,5,78,8},
                {2,3,5,6,7,6},
                {2,3,4,5,6,6}
        });
    }
}
