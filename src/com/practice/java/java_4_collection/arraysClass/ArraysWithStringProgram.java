package com.practice.java.java_4_collection.arraysClass;

import java.util.HashMap;
import java.util.Map;

public class ArraysWithStringProgram {
    public static void main(String[] args) {
        //Reverse words order in sentence Input: "i love java" -> "java love i". Split by \s+, loop from end to start, join
        String s = "i love java";
        String[] w = s.trim().split("\\s+");
        String rs="";
        for(int i = w.length-1; i >= 0; i--)
            rs += w[i] + " ";
        System.out.println(rs.trim());

        /*2) Longest substring without repeating characters (LC 3)
        ✅ Sliding window + MapNotes last index*/
        String s1 = "abcabcbb";

        Map<Character, Integer> last = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        int start = 0;   // to store starting index of longest substring

        for (int right = 0; right < s1.length(); right++) {
            char ch = s1.charAt(right);

            if (last.containsKey(ch) && last.get(ch) >= left) {
                left = last.get(ch) + 1;
            }

            last.put(ch, right);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }

        System.out.println("Length: " + maxLen);
        System.out.println("Substring: " + s.substring(start, start + maxLen));


    }
}
