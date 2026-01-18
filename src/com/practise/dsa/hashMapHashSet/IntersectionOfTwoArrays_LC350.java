package com.practise.dsa.hashMapHashSet;

import java.util.*;

public class IntersectionOfTwoArrays_LC350 {

        public int[] intersect(int[] nums1, int[] nums2) {

            // Always build map for smaller array (saves memory)
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }

            //Create HashMap for counting
            Map<Integer, Integer> map = new HashMap<>();

            // Count frequency of nums1
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            /*What does getOrDefault do?
            map.getOrDefault(num, 0)
            If num is present → return its count
            If num not present → return 0
            Then we +1 to increase count.

            Example:
            nums1 = [1,2,2,1]
            Counts become:
            1 → 2 times
            2 → 2 times
            So map becomes:
            {1=2, 2=2}*/

            //Create result list
            List<Integer> result = new ArrayList<>();

            // Check nums2 and reduce count
            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    result.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
            /*For every element in nums2:
            If it exists in nums1 map and count > 0
            → then it is common, add to result
            → then decrease count by 1 (very important)

            Example:
            nums2 = [2,2]
            map initially = {1=2, 2=2}
            num = 2
            map contains 2 ✅
            map.get(2)=2 > 0 ✅
            ➡ add 2 to result → result = [2]
            ➡ decrease count → map becomes {1=2, 2=1}

            num = 2 (again)
            map.get(2)=1 > 0 ✅
            ➡ add 2 → result = [2,2]
            ➡ decrease count → map becomes {1=2, 2=0}*/

            // Convert List<Integer> to int[]
           return result.stream().mapToInt(Integer::intValue).toArray();

        }

    public static void main(String[] args) {
        IntersectionOfTwoArrays_LC350 l = new IntersectionOfTwoArrays_LC350();
        //retainAll() does NOT handle duplicates correctly. so not able to use retainALL here use other approach
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int [] r = l.intersect(nums2, nums1);
        System.out.println(Arrays.toString(r));
    }
}
