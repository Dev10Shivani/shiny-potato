package com.practise.dsa.sorting;

public class BubbleSort {
    /*compare and swap the first largest element with adjacent elements till it move to last*/

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
