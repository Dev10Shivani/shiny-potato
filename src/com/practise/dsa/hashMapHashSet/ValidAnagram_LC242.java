package com.practise.dsa.hashMapHashSet;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ValidAnagram_LC242
{
    public static void main(String[] args) {
        String s= "anagram";
        String t= "nagaram";

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        System.out.println(Arrays.toString(str1));
        Arrays.sort(str2);
        System.out.println(Arrays.toString(str2));

        if(Arrays.equals(str1, str2))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");

//        if(Arrays.toString(str1).equals(Arrays.toString(str2))){
//            System.out.println("Anagram");
//        }else {
//            System.out.println("Not Anagram");
//        }
    }
}
