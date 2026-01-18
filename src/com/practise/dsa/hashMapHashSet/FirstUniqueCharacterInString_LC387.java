package com.practise.dsa.hashMapHashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class FirstUniqueCharacterInString_LC387 {

    public static void main(String[] args) {
        String s = "leetcode";
        Character firstUnique = s.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if(firstUnique == null)
            System.out.println(-1);
        else
            System.out.println(s.indexOf(firstUnique));



//        class Solution {
//            public int firstUniqChar(String s) {
//                int[] count = new int[26];
//
//                for (char ch : s.toCharArray()) {
//                    count[ch - 'a']++;
//                }
//
//                for (int i = 0; i < s.length(); i++) {
//                    if (count[s.charAt(i) - 'a'] == 1) return i;
//                }
//
//                return -1;
//            }
//        }

    }

}
