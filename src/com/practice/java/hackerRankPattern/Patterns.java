package com.practice.java.hackerRankPattern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Patterns {
    public static void main(String[] args) {

    /*  1. Frequency Map Pattern (Most Common)
    Used for:
    word count
    duplicate characters
    anagram problems
    majority element*/

        /*Count word frequency*/
        String s = "i am staying in pune and i stay in pune";
        String[] words = s.split("\\s+");
//        for(String w : words)
//            System.out.println(w + ", ");

        Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " : " + value));

        /*duplicate word*/
        System.out.println("Duplicate word");
        Map<String, Long> mWord = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mWord.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        /*duplicate characters*/
        Map<Character, Long> dupChar = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        dupChar.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        /*second max characters*/
        /*Key idea:
        Count frequency
        Sort by frequency descending
        Skip the first (max)
        Take the next one*/
        System.out.println("Second max characters");
        String s1 = "i am staying in pune and i stay in pune";
        Map<Character, Long> dupChar1 = s1.chars().mapToObj(c -> (char) c)
                .filter(c -> c != ' ' && c != 'n' && c != 'i' && c != 'a')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        dupChar1.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .ifPresent(e -> System.out.println(e.getKey() + " : " + e.getValue()));


//                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
//        Second max characters
//        p : 2
//        s : 2
//        t : 2
//        e : 2
//        u : 2
//        y : 2
//        d : 1
//        g : 1
//        m : 1

        /*anagram problems*/
        String str1 = "listen";
        String str2 = "silent";

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if (Arrays.equals(ch1, ch2)) {
            System.out.println("its anagram");
        }

        /*missing element*/
        int[] a = {1, 3, 4, 5};
        /*int n = a.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(a).sum();
        System.out.println("Missing number: " + (expectedSum - actualSum));*/

        /*int n = a.length + 1;
        int missing = (n * (n + 1) / 2) - Arrays.stream(a).sum();
        System.out.println("Missing number: " + missing);*/

        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i <= a.length + 1; i++) {
            System.out.println("xor1: " + xor1 + " ^ " + i + " = " + (xor1 ^ i));
            xor1 ^= i;
        }

        System.out.println("________________");
        for (int num : a) {
            System.out.println("xor2: " + xor2 + " ^ " + num + " = " + (xor2 ^ num));
            xor2 ^= num;
        }

        System.out.println("Missing number: " + xor1 + " ^ " + xor2 + " = " + (xor1 ^ xor2));

//        Why XOR works
//        A ^ A = 0
//        A ^ 0 = A
//        Duplicates cancel out.


        /*Two Pointer Pattern*/

//        1. Pair Sum (Two Pointer + Stream)
        int[] arr = {4, 1, 6, 3, 8};
        int target = 7;

        int[] sorted = Arrays.stream(arr).sorted().toArray();

        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {

            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                System.out.println(sorted[left] + " , " + sorted[right]);
                break;
            } else if (sum < target)
                left++;
            else
                right--;
        }

//    Removing Duplicates Using Streams

    int[] arr1 = {1, 1, 2, 2, 3, 4, 4};
    int[] uniqueArr = Arrays.stream(arr1)
            .distinct()
            .toArray();
      System.out.println(Arrays.toString(uniqueArr));
  }

////    Sorted Array Pair Sum Using Stream
////    We can use IntStream.range() to simulate two pointers.
//
//    int[] arr = {1,3,4,6,8};
//    int target = 7;
//
//    IntStream.range(0, arr.length)
//            .forEach(i -> {
//
//        int left = i;
//        int right = arr.length - 1;
//
//        while(left < right){
//            if(arr[left] + arr[right] == target){
//                System.out.println(arr[left] + " " + arr[right]);
//                return;
//            }
//            right--;
//        }
//    });
}
