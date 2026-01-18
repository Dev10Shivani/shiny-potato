package com.practise.dsa.hashMapHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum_LC1 {
    public static void main(String [] arg){
        int [] nums = {2,7,11,15};
        int target = 9;
       // Output: [0,1]

        //aproach with array
        for(int i = 0 ; i < nums.length-1; i++){
            for(int j =1; j < nums.length-1; j++){
                if(nums[i] + nums[j] == target)
                    System.out.println("[" + i + "," + j +"]");
            }
        }

        //with one loop - hashset
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(target - num))
                set.add(num);
        }
        System.out.println(set);


//        HashMap map = new HashMap();
//
//        for(int i = 0 ; i < nums.length-1; i++)
//        {
//            map.put(nums[i], i);
//        }
//
//        map.entryMa

    }
}
