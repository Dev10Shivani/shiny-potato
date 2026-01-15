package com.practice.java.java_3_stringclass;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MutableString {
    /* Use of StringBuilder & StringBuffer to make string mutable,
    implements Serializable, charSequence,
    not comparable(compareTo) Natural sorting order support- use comparator(compare) for custom sorting,
    StringBuffer - synchronized, Thread-safe, performance slow
    StringBuilder - non-synchronized, not Thread-safe, performance fast

    own methods (same methods for StringBuilder & StringBuffer):
    append(str), insert(offset, str), replace(SI, EI, str),delete(SI, EI),
    reverse(), capacity() - default 16, ensureCapacity(minCapacity),
    charAt(index), length(), substring(SI) or (SI, EI)

    formula - (oldCapacity * 2)+2

    offest of A - 65 & a - 97
     */

    public static void main(String [] args) {

        //Append String
        String str = "Tri";
        System.out.println(new StringBuilder(str).append("lak"));

        //Reverse String
        String str1 = "Trilak";
//        StringBuilder sb = new StringBuilder(str1).reverse();
        System.out.println(new StringBuilder(str1).reverse().toString());

        //Capacity
        System.out.println(new StringBuilder().capacity());//16 default 16
        System.out.println(new StringBuilder(str).capacity());//19 str -> Tri --> 16+3 =19
        System.out.println(new StringBuilder(str1).capacity());//22 str1 -> Trilak --> 16+6 =22

        //Palindrome
        String s = "Madam";
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s).reverse();
        if(s.equals(sb))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
        //o/p : Not Palindrome as string comparing with immutable string

        String s1 = new StringBuilder(s).reverse().toString();
        if(s.equals(s1))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
        //o/p : Palindrome as used toString() to convert mutable string into immutable string, then compared

        //Count Characters in String
        String sc = "banana";
        Map<Character, Long> mapCount = sc.chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapCount.entrySet().forEach(System.out::println);

        String scase = "BanAna";
        Map<Character, Long> mapCountCase = scase.chars()
                .map(Character::toLowerCase)
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        mapCountCase.entrySet().forEach(System.out::println);

        //Count Vowels and Consonants
        //String sc = "banana";
        int v=0, c=0;
        for(char ch: sc.toLowerCase().toCharArray()){
            if("aeiou".indexOf(ch)>=0) v++; //→ character is a vowel
            else if(Character.isLetter(ch)) c++; //→ character is a consonant
        }
//        Output:
//        v = 3 (a a a)
//        c = 3 (b n n)

//        How "aeiou".indexOf(ch) works
//        Method signature
//        int indexOf(int ch)
//        It:
//        Searches the string from left to right
//        Returns the index (position) of the character if found
//        Returns -1 if the character is not found
//
//        Step-by-step example
//        "aeiou".indexOf('a')  // 0
//        "aeiou".indexOf('e')  // 1
//        "aeiou".indexOf('i')  // 2
//        "aeiou".indexOf('o')  // 3
//        "aeiou".indexOf('u')  // 4
//
//        If character is NOT present:
//        "aeiou".indexOf('b')  // -1
//        "x".indexOf('x')      // 0
//
//        Why >= 0 is used
//        if ("aeiou".indexOf(ch) >= 0)
//        Any valid index is 0 or more
//        -1 means not found
//        So:
//        >= 0 → vowel
//        -1 → not a vowel

//        What actually happens internally (simple view)
//        "aeiou"
//        01234
//
//        Java checks:
//        Is ch == 'a'? no → next
//        Is ch == 'e'? no → next
//        Is ch == 'i'? yes → return 2
//
//        Why this is efficient & clean
//        Instead of writing:
//        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
//        We use:
//        "aeiou".indexOf(ch) >= 0

        //Check Anagram
        String word1 = "listen";
        String word2 = "silent";
        char[]w1 = word1.toCharArray();
        char[]w2 = word1.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        if(Arrays.equals(w1,w2))
            System.out.println("Anagram");

//        char[] a = "listen".toCharArray();
//        char[] b = "silent".toCharArray();
//        Arrays.sort(a); Arrays.sort(b);
//        System.out.println(Arrays.equals(a,b));






    }


}
