package com.practice.java.java_4_collection.arraysClass;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArrayWithPrograms {
//    Rule: Arrays problems → prefer loops first. Streams later.

//    public int [] reverse (int [] arr, int i, int n) {
//        int start =0, end = arr.length -1;
//        while(start < end)
//        {
//            int temp = arr[start];
//            arr[start] = arr [end];
//            arr[end] = temp;
//            start++;
//            end--;
//        }
//        retrun arr[];
//    }// here i can pass value to method directly instead of i,j & no nee to return int [] i can use static to avoid returning and do recursion

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static int removeDuplicates(int []sorted)
    {
        //int[] sorted = {1, 1, 2, 2, 3, 3, 4};
        int i =0;
        for(int j = 1; j < sorted.length; j++){
            if(sorted[j] !=  sorted[i]){
                i++;
                sorted[i] = sorted[j];
            }//equal then skip
        }
        return i + 1;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int [] arr = new int[num];

        int[] arr = {2, 1, 4, 5, 3, 0, 4};

//        1. Reverse an int array in-place (no extra array).
            /*  arr = Arrays.stream(arr).boxed().(Collections.reverseOrder());
            ❌ Your mistake: Arrays.stream(arr).boxed().(Collections.reverseOrder()) is invalid + it also creates new objects, not in-place.*/

        //✅ Best Approach : 2 pointers

//            int i = 0, j = arr.length-1;
//            if(i < j) //used if condition here, so loop did not continued. if checks only once. used while so loop will continued checking till the condition is true
//            {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//            }

        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println("Reverse: " + Arrays.toString(arr));


//        2. Find max and min in an array in one pass.
            /* OptionalInt min =Arrays.stream(arr).sorted().findFirst();
            OptionalInt max = Arrays.stream(arr).sorted().(Collections.reverseOrder()).findFirst();
            if(min.get() != null) System.out.println(min);
            if(max.get() != null)System.out.println(max);*/
        //❌ Your mistake: sorting is not one pass, and reverseOrder cannot be applied on IntStream.

        //✅ best approach: single loop
        //int [] arr = {2,1,4,5,3,0,4};
        int min = arr[0];
        int max = arr[0];
        for (int x : arr) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

//        3. Find the second largest element (handle duplicates).
        /*int secondLargest = Arrays.stream(arr).distinct().sorted(Comparator::reverseOrder).limit(1).findFirst();*/
        /*❌ Your mistake: stream part is wrong:
        Comparator::reverseOrder invalid like that
        return type mismatch (int vs OptionalInt)*/

        //✅ best approach: track largest & secondLargest
        //int [] arr = {2,1,4,5,3,0,4};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x > secondLargest && x != largest) {
                secondLargest = x;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest does not exist");
        } else {
            System.out.println("Second largest: " + secondLargest);
        }

        //stream
        int secondLargest1 = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("second largest not found"));

/*        Integer.MIN_VALUE is the smallest possible int value in Java.
        ✅ Value:
        Integer.MIN_VALUE = -2147483648
        ✅ Similarly:
        Integer.MAX_VALUE = 2147483647

        Why we use Integer.MIN_VALUE?
        When we want to find maximum / second maximum, we start with the smallest value so any number will be bigger.*/

//        4. Rotate array right by k steps (k may be > n).
        /*  int k= 2;
         List<Integer> l = Arrays.stream(arr).collect(Collectors.toList());
         Collections.rotate(l, 2);
         System.out.print(l);*/
        // Your approach using Collections.rotate() works only if you convert to List, but that is not array in-place.

        // ✅ best approach: reverse array (in-place)
        int[] arr1 = {2, 1, 4, 5, 3, 0, 4};
        // reverse method with 2 ponter reverse in -palce logic
        // static void reverse(int[] arr, int start, int end) {
        int k = 2;
        k = k % arr.length;
        System.out.println("k: " + k);
        reverse(arr1, 0, arr.length - 1);
        reverse(arr1, 0, k - 1);
        reverse(arr1, k, arr.length - 1);

        System.out.println("Rotated: " + Arrays.toString(arr1));


//        5. Move all zeros to end while maintaining relative order.

       /* int count = 0;
        int k = 0;
        int [] arr = {2, 0, 1, 0, 4, 0, 5};
        int [] arr1 = new int[arr.length];
          for(int i : arr ){
              if(i == 0)
                  count++;
              else {
                  arr1[k] = arr[i];
                  k++;
              }
          }
          for(int j= arr1.length; j <= arr.length-1; j--){
              arr1[j] = 0;
          }
          System.out.println(Arrays.toString(arr1));*/
           /* ❌ Your mistakes:
            arr1[k] = arr[i] wrong because i is value not index
            loop for(int j= arr1.length; ...) wrong start
            System.out.println(arr1.toString()) prints object reference, must use Arrays.toString(arr1)*/

        //✅ best approach: 2 pointer overwrite
        int[] arr2 = {2, 0, 1, 0, 4, 0, 5};
        int idx = 0;
        for (int x : arr2) {
            if (x != 0) {
                arr2[idx++] = x;
            }
        }
        while (idx < arr2.length) {//here we not mead arr2.length-1 so idx++ worked
            arr2[idx++] = 0;
        }
        System.out.println("Move zeros: " + Arrays.toString(arr2));

//        6. Remove duplicates from sorted array (return new length).
        /*int lengthOfArray = Arrays.stream(arr).distinct().sorted().toArray().length;*/
        //✅ Streams can do distinct, but LeetCode expects in-place.

        //✅ classic problem: modify array in-place
        int[] sorted = {1, 1, 2, 2, 3, 3, 4};
        int newLen = removeDuplicates(sorted);
        System.out.println("New array: " + Arrays.toString(sorted)); //New array: [1, 2, 3, 4, 3, 3, 4]
        // above in logic we check complete array but replace the duplicates with non-duplicate till specified i length so other remaining array stays as is
        System.out.println("Unique part: " + Arrays.toString(Arrays.copyOf(sorted, newLen)));//Unique part: [1, 2, 3, 4]
        //Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length

//        7. Check if array is palindrome (treat as sequence).
        /*String str1 = "mam";
        String str2 = str1.chars().mapToObj(c -> (char) c).(StringBuilder::reverse).Collect(Collectors.joining());
        if(str1.equals(str2))
            System.out.println("array is palindrome");
        else
            System.out.println("array is not palindrome");*/
        //❌ Your mistake: You checked string "mam" not array palindrome. your stream line is invalid.
        //palindrome -a word, phrase, or sequence that reads the same backwards as forwards

        int[] pal = {1, 2, 3, 2, 1};

        boolean isPal = true;
        for (int a = 0, b = pal.length - 1; a < b; a++, b--) {
            if (pal[a] != pal[b]) {
                isPal = false;
                break;
            }
        }
        System.out.println("Palindrome array? " + isPal);

        /*String str = "mam";
        String revstr = null;
        for(int s = 0; s <= str.length()-1; s--)
        {
            revstr += str.charAt(s);
        }
        System.out.println(revstr);
        revstr = null
        When you do revstr += ... it becomes "nullm..." or gives confusion.
        ✅ It should start as empty string
        String revstr = "";
        Loop condition is wrong
        You wrote:
        s <= str.length()-1
        This is always true for s=0, so loop keeps running forever.
        You are doing s-- starting from 0
        You start at 0 and decrease → -1, -2...
        Then str.charAt(-1) will crash (StringIndexOutOfBoundsException)*/

        String str = "mam";
        String revstr = "";
        for (int s = str.length() - 1; s >= 0; s--) {
            revstr += str.charAt(s);
        }
        System.out.println("Reverse: " + revstr);
        if (str.equals(revstr)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        /*String str = "mam";
        String rev = new StringBuilder(str).reverse().toString();
        System.out.println(rev);
        System.out.println(str.equals(rev) ? "Palindrome" : "Not Palindrome");*/

//        8. Find missing number from 1..n (array size n-1).
        int[] miss = {1, 2, 4, 5}; // missing 3
        int n = 5;

        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int x : miss) sum += x;

        System.out.println("Missing: " + (total - sum));

//        9. Find frequency of each element using MapNotes.
//        Map<Integer, Long> map =  Arrays.stream(arr)
//                .collect(Collectors.groupingBy(Function.identity()), Collectors.counting()))
//        .EntrySet.stream().forEach(entry -> entry.value >= 1 )
//                .forEach(System.out::print)
      /*  ❌ Your mistakes:
        wrong parenthesis placement,.EntrySet.stream() should be .entrySet().stream()
        entry.value should be entry.getValue()
        chaining .forEach() wrong*/

        int[] freqArr = {2, 1, 4, 5, 3, 0, 4};

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : freqArr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        System.out.println("Frequency Map: " + freq);

        Map<Integer, Long> freq2 = Arrays.stream(freqArr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Map (Stream): " + freq2);

//        10. Find first repeating element and its index.
        //✅ First repeating element means: element that repeats and whose first occurrence index is smallest

        //not able to use hashmap here as we want first repeating element and its index. as per insertion

        int[] rep = {10, 5, 3, 4, 3, 5, 6};
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int bestIndex = Integer.MAX_VALUE;
        int repeatingElement = -1;

        for (int idx2 = 0; idx2 < rep.length; idx2++) {
            int val = rep[idx2];
            if (!firstIndex.containsKey(val)) {
                firstIndex.put(val, idx2);
            } else {
                int first = firstIndex.get(val);
                System.out.println("First: " + first + ", val: " + val);
                if (first < bestIndex) {
                    bestIndex = first;
                    repeatingElement = val;
                }
            }
        }
        if (repeatingElement != -1) {
            System.out.println("First repeating element: " + repeatingElement + ", index: " + bestIndex);
        } else {
            System.out.println("No repeating element found");
        }
    }

}

