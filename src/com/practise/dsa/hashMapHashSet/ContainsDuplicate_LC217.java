package com.practise.dsa.hashMapHashSet;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_LC217 {

    public static void main(String arg[]){
        int [] nums = {1,2,3,1};
        Set<Integer> numSet =  new HashSet<>();
        for(int num: nums){
            if(!numSet.add(num))
                System.out.println(true) ;
        }
    }
}
