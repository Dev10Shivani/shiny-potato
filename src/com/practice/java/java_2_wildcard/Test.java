package com.practice.java.java_2_wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {







































        /*String s ="i am staying in pune and i would like to stay in pune";

        String [] strArray = s.split("\\s+");

        Map<String, Long> wordMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+ " : "+entry.getValue()));*/

       // List<Number> list = new ArrayList<Integer>() ;// error



//        String s = "Java";
//        s.concat("17");
//        System.out.println(s);

//        List<?> list = new ArrayList<String>();
//        list.add("Hello"); //java: incompatible types: java.lang.String cannot be converted to capture#1 of ?

//        List raw = new ArrayList<String>();
//        raw.add(10);
//        String s = (String) raw.get(0);//class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.St

//        System.out.println(Stream.of(1,2,3).count());
//
//        int[] arr = {1,2,3};
//        for(int i : arr) {
//            i = i * 2;
//        }
//        System.out.println(arr[0]);
    }
}