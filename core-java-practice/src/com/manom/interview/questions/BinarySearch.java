package com.manom.interview.questions;

public class BinarySearch {

    private static int binarySearch(int[] arr, int element) {
        int position = -1;
        int middleIndex = (arr.length - 1) / 2;
        int index = 0;
        long startTime = System.currentTimeMillis();
        //check at middle of the array
        while (index < arr.length - 1) {
            if (element == arr[middleIndex]) {
                return middleIndex;
            } else if (element > arr[middleIndex]) {
                    if (element == arr[index])
                        position = index;
            } else if (element < arr[middleIndex]) {
                    if (element == arr[index])
                        position = index;
            }
            index++;
        }
        System.out.println("Time took to search the element: " + (System.currentTimeMillis() - startTime));
        return position;
    }

    public static void main(String[] args) {
        System.out.println("Element is locate at : " + binarySearch(new int[] {1, 4, 5, 6, 10, 13, 19, 12, 232, 4432,4545, 4534,53453,45345,345345,34534,534534,534534,5345,34534,545,34534,5345,34534,5345,43534,534534,5345,345345,}, 43534) + " position.");
    }
}
