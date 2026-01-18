package com.practise.dsa.hashMapHashSet;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement_LC169 {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        int num = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
        System.out.println(num);

//                int count = 0;
//                int candidate = 0;
//                for (int num : nums) {
//                    if (count == 0) candidate = num;
//
//                    count += (num == candidate) ? 1 : -1;
//                }
//
//                return candidate;

        /*num	count==0?	candidate set to	num==candidate?	count
        2	✅ yes	        2	                ✅ yes	        1
        2	no	            2	                ✅ yes	        2
        1	no	            2	                ❌ no	        1
        1	no	            2	                ❌ no	        0
        1	✅ yes	        1	                ✅ yes	        1
        2	no	            1	                ❌ no	        0
        2	✅ yes	        2	                ✅ yes	        1*/


    }
}
