package com.practice.java.java_4_collection.collectionInterface.mapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapClass {
    public static void main(String[] args) {
         /*HashMap = Key → Value storage
            store something like:
            number → index OR character → frequency(count)
            Fast lookup because it uses hashing*/

            /*map.put(key, value);
            map.get(key);
            map.containsKey(key);
            map.getOrDefault(key, 0);
            map.remove(key);*/

            /*Use HashMap when:
            You want frequency/count
            You want fast search
            You want to store mapping like name → marks, value → index*/

        //===============================================
        //Hashmap is unorder map (not follow insertion order)
        //Insertion
        Map<String, Integer> countryInfoMap = new HashMap<>();
        //key-country, value-poulation
        countryInfoMap.put("India", 120);
        countryInfoMap.put("China", 150);
        countryInfoMap.put("Uk", 100);
        System.out.println(countryInfoMap); //{China=150, Uk=100, India=120}

        countryInfoMap.put("China", 180);
        System.out.println(countryInfoMap); //{China=180, Uk=100, India=120} key present then update the value

        //check key present or not
        if(countryInfoMap.containsKey("India"))
            System.out.println("Key present in map");
        else
            System.out.println("Key is not present in map");

        //fetch value for key
        System.out.println(countryInfoMap.get("India")); //120
        System.out.println(countryInfoMap.get("Indonesia")); //null

        //check value present or not
        if(countryInfoMap.containsValue(150)) //previously china was 150 so i tried to check after update values is present in map or not so its not present
            System.out.println("Value present in map");
        else
            System.out.println("Value is not present in map");

        //Iteration
        //for (int val :array)
       for(Map.Entry<String, Integer> e : countryInfoMap.entrySet()){
           System.out.println(e.getKey() +" : "+ e.getValue());
       }

       //create key set
        Set<String> keys = countryInfoMap.keySet();
       for(String key: keys){
           System.out.println(key +" : "+ countryInfoMap.get(key));
       }//print key value pair using keySet

        //Remove
        countryInfoMap.remove("China");
        System.out.println(countryInfoMap); //{Uk=100, India=120}

        //map.getOrDefault(key, 0) --Key present then return value, if not present return O
        System.out.println(countryInfoMap.getOrDefault("India", 0));
        System.out.println(countryInfoMap.getOrDefault("China", 0));

        //two sum
        int[] num = {2,7,8,9};
        int target = 9;

        for (int i = 0; i < num.length; i++) {
            for (int k = i + 1; k < num.length; k++) {
                if (num[i] + num[k] == target) {
                    System.out.println("Index: " + i + ", " + k);
                    System.out.println("Values: " + num[i] + ", " + num[k]);
                }
            }
        }
//----------------------
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int diff = target - num[i];

            if (map.containsKey(diff)) {
                System.out.println("Index: " + map.get(diff) + ", " + i);
                break;
            }

            map.put(num[i], i);
        }


    }



}
