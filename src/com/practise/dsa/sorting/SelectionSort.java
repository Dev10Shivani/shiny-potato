package com.practise.dsa.sorting;

public class SelectionSort {
    /*
    keep first element as is, find smallest in remaining array then swap 1st and smallest. then pick 2nd and again find smallest then swap and repeat
     */

    public static void main (String[] args)
    {
        int[] arr = { 64, 25, 12, 22, 11 };

        for (int i = 0; i < arr.length - 1; i++){
            int min_idx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min_idx])
                {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
