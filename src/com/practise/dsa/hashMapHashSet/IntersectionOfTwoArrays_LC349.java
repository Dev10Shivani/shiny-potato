package com.practise.dsa.hashMapHashSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays_LC349 {
    public static void main(String[] args) {
        //retainAll work properly when there is no duplicates
        //retainAll() does NOT handle duplicates correctly.
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};

        List l1 = Arrays.stream(nums1).boxed().map(e -> e).collect(Collectors.toList());
        List l2 = Arrays.stream(nums2).boxed().map(e -> e).collect(Collectors.toList());
        l1.retainAll(l2);
        System.out.println(l1);
    }
}
