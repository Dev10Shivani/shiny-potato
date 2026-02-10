package com.practice.java.java_3_stringclass;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringWithProrams {
    static void printSubsequence(String s, int index, String current) {
        // base case
        if (index == s.length()) {
            if (!current.isEmpty()) {   // remove this if you want empty also
                System.out.println(current);
            }
            return;
        }

        // choice 1: include current character
        printSubsequence(s, index + 1, current + s.charAt(index));

        // choice 2: exclude current character
        printSubsequence(s, index + 1, current);

        /*In the exclude call we are not decreasing/removing anything from current.
        ✅ Why?
        Because in Java, String is immutable.
        So every recursive call gets its own copy of the current value.
        ✅ If you had used mutable object (StringBuilder)
        Then yes, you would need to remove last character during backtracking.
        But in this approach using String, no deletion is needed.
        If you want, I’ll give you the StringBuilder backtracking version also.*/
    }

    public static void main(String[] args) {
//        B) Strings Basics (15)
//        1. Reverse a string without using built-in reverse().
            String str = "String Programming";
            String revStr = "";
            for(int s = str.length()-1; s >= 0; s--){
                revStr += str.charAt(s);
            }
           System.out.println("Reverse a string : "+ revStr);

//        2. Check if a string is palindrome (ignore case).
            String strPal = "Madam";
            String revStrPal = "";

            strPal = strPal.toLowerCase();
            for(int s = strPal.length()-1; s >= 0; s--){
                revStrPal += strPal.charAt(s);
            }

            System.out.println("String :" + strPal + " & ReverseString :"+ revStrPal);
            if(strPal.equals(revStrPal))
                System.out.println("String is palindrome");
            else
                System.out.println("String is not palindrome");

            //approach 2 : 2 pointer
            boolean isStrPal = true;
            for(int i=0, j=strPal.length()-1; i<j; i++, j--){
                if(strPal.charAt(i) != strPal.charAt(j)){
                    isStrPal = false;
                    break;
                }
            }
            if(isStrPal)
                System.out.println("String is palindrome");
            else
                System.out.println("String is not palindrome");

//        3. Count vowels, consonants, digits, spaces.

            /*String strvcds = "Shivani 10 Deorukhakar";
            int vowel = 0, consonants =0, digits = 0, spaces = 0;
            strvcds = strvcds.toLowerCase();

            for(int i = 0; i < strvcds.length()-1; i++){
                if("aeiou".indexOf(String.valueOf(i)) == 0){
                    vowel ++;
                } else if (" ".equals(strvcds.charAt(i))) {
                    spaces++;
                } else if ((strvcds.charAt(i)).is digit) {
                    digits++;
                } else {
                    consonants++;
                }
                }
                System.out.println("Vowels :"+Vowels+ " Consonants :"+ consonants + " spaces :"+ spaces + " digits :"+ digits);
            }*/
            /*Mistakes in your code
            loop should go till < length() not length()-1
            you wrote:
            "aeiou".indexOf(String.valueOf(i)) == 0 ❌ (you are checking index number, not character)
            " ".equals(strvcds.charAt(i)) ❌ (char vs String)
            (strvcds.charAt(i)).is digit ❌ (wrong syntax)*/

            String strvcds = "Shivani 10 Deorukhakar";
            int vowel = 0, consonants = 0, digits = 0, spaces = 0;

            strvcds = strvcds.toLowerCase();

            for (int i = 0; i < strvcds.length(); i++) {
                char ch = strvcds.charAt(i);

                if ("aeiou".indexOf(ch) >= 0) {
                    vowel++;
                } else if (ch == ' ') {
                    spaces++;
                } else if (Character.isDigit(ch)) {
                    digits++;
                } else if (Character.isLetter(ch)) {
                    consonants++;
                }
            }

            System.out.println("Vowels: " + vowel +
                    " Consonants: " + consonants +
                    " Spaces: " + spaces +
                    " Digits: " + digits
            );

//        4. Find first non-repeating character.
            String dupStr = "aabbcdddefghh";
            Map<Character, Long> map =
                dupStr.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

            Character nonRepChar = map.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey).findFirst().orElse(null);

            System.out.println("First non-repeating character :"+ nonRepChar);

//        5. Find all duplicate characters with counts.
            dupStr.chars()
                    .mapToObj(c->(char)c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(e ->  e.getValue() > 1)
                    .forEach(e-> System.out.println(e.getKey() +" : "+ e.getValue()));

//        6. Check if two strings are anagrams.
            String str1 = "listen";
            String str2 = "silent";

            if(str1.length() != str2.length())
                System.out.printf("String is not anagram");

            char[] strChar1 = str1.toCharArray();
            char[] strChar2 = str2.toCharArray();

            Arrays.sort(strChar1);
            Arrays.sort(strChar2);

            //if(strChar1.equals(strChar2))  //<-- wrong
            if(Arrays.equals(strChar1, strChar2))
                System.out.println("String is anagram");
            else
                System.out.println("String is not anagram");

//        Best interview way (MapNotes / int[26])
//        This is faster than sorting:

        String s1 = "listen";
        String s2 = "silent";

        if (s1.length() != s2.length()) {
            System.out.println("Not anagram");
        } else {
            int[] freq = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i) - 'a']++;
                freq[s2.charAt(i) - 'a']--;
            }

            boolean isAnagram = true;
            for (int x : freq) {
                if (x != 0) {
                    isAnagram = false;
                    break;
                }
            }

            System.out.println(isAnagram ? "Anagram" : "Not anagram");
        }


//        7. Remove all occurrences of a character from string.
            //String dupStr = "aabbcdddefghh";

            /*String removeOccChar = dupStr.chars().mapToObj(c -> (char)c).distinct().toString();
            System.out.println("Remove all occurrences of a character from string :"+ removeOccChar);
            This does NOT remove a specific character, it removes duplicates.
            Also .toString() here will print something like:
            java.util.stream.ReferencePipeline$... (not actual string)*/

            //Example: remove 'd'

            //✅ Approach 1 (Best simple using loop)
               // String dupStr = "aabbcdddefghh";
                char remove = 'd';
                String result = "";
                for (int i = 0; i < dupStr.length(); i++) {
                    if (dupStr.charAt(i) != remove) {
                        result += dupStr.charAt(i);
                    }
                }
                System.out.println(result);

                //✅ Approach 2 (Clean using replace)
                String result1 = dupStr.replace(String.valueOf(remove), "");
                System.out.println(result1);

                //✅ Approach 3 (Stream correct)
                String result2 = dupStr.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> ch != remove)
                .map(String::valueOf)
                .collect(Collectors.joining());
                System.out.println(result2);

//        8. Remove duplicate characters from a string (preserve order).
            /*Input: "aabbcdddefghh"
            Output: "abcdefgh"*/

        //Best approach (HashSet)
        // String dupStr = "aabbcdddefghh";

        Set<Character> seen = new HashSet<>();
        String resultDup = "";
        for (int i = 0; i < dupStr.length(); i++) {
            char ch = dupStr.charAt(i);
            if (!seen.contains(ch)) {
                seen.add(ch);
                resultDup += ch;
            }
        }
        System.out.println(resultDup);

        //✅ Stream version (preserves order)
        String remDupChar = dupStr.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(remDupChar);

//        9. Compress string: aabcccccaaa ® a2b1c5a3.
        /*String s = "aabcccccaaa";
        Map<Character, Long> m = s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.print("Shrink String : "+s+ " to ");
        m.entrySet().stream().forEach(e-> System.out.print(e.getKey()+""+e.getValue()));*/
        //above logic is good if we dont want to mentain position direct want count then
        /*❌ Problem in your approach
        You used groupingBy() which counts total frequency, but compression needs consecutive counts (order groups).
        Example:
        aa...aaa ✅ should become a2...a3 (two separate groups)
        But groupingBy will make a5 ❌ (wrong) So for compression, we must count runs.*/

        String s = "aabcccccaaa";
        String resultS = "";
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                resultS += s.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }

        }
        // last group
        resultS += s.charAt(s.length() - 1) + String.valueOf(count);
        System.out.println("Compressed: " + resultS);

//        10. Expand string: a2b1c3 ® aabccc.
            String strS2 = "a2b1c3";
            String resS2 = "";

            /*for(int i =0; i < strS2.length()-1; i++){
                char ch = strS2.charAt(i);
                if(Character.isLetter(ch)){
                    resS2 += ch;
                }
                if(Character.isDigit(ch)){
                    for(int c = ch+0; c <= ch ; c++){
                        resS2 += strS2.charAt(i-1);
                    }
                }
            }
            System.out.printf("Expand string :"+ strS2 + " to "+ resS2);*/
            /*❌ Problems in your code
            Loop should go till i < length() not length()-1
            Digit conversion wrong: ch+0 gives ASCII, not number
            Inner loop condition wrong*/

            for (int i = 0; i < strS2.length(); i++) {
                char ch = strS2.charAt(i);
                if (Character.isLetter(ch)) {
                    char letter = ch;
                    int num = strS2.charAt(i + 1) - '0';  // convert digit char → number
                    for (int j = 1; j <= num; j++) {
                        resS2 += letter;
                    }
                    i++; // skip digit
                }
            }
            System.out.println("Expand: " + resS2);

            /*✅ Why - '0' ?
                Because digits in a string are characters, not numbers.
                Example:
                char ch = '3';
                This '3' is stored as an ASCII/Unicode value, not integer 3.
                So:
                '0' has value 48
                '3' has value 51
                When we do:
                '3' - '0' = 51 - 48 = 3
                ✅ That’s why:
                int num = strS2.charAt(i + 1) - '0';
                converts digit character → actual integer.*/

//        11. Count words in a sentence (multiple spaces).
         /*String sentence = "Hi how are you!";
         String [] words = sentence.split("/s");
         System.out.println(words.length);*/
        //✅ Correct regex for whitespace is: \\s+

        String sentence = "Hi   how   are you!";
        String[] words = sentence.split("\\s+");
       // String[] words = sentence.trim().split("\\s+");
        System.out.println(words.length);

//        12. Print all substrings of a string
        String substringsfromStr = "abc";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
        /*✅ Substring = continuous block of characters
        So from "abc" valid substrings are:
        ✅ Correct substrings
        "a"
        "ab"
        "abc"
        "b"
        "bc"
        "c"
        ❌ Not substring:
        "ac" ❌ (because it skips b, not continuous)
        So "ac" is a subsequence, not substring.*/

        //------------------------------- Print All Subsequences (a,b,c,ab,ac,bc,abc)
        //Subsequence = keep order but you can skip characters
        //So "ac" is valid because we skipped b.

        //✅ Logic (Best & Simple): Recursion
        String strSubsequence = "abc";
        printSubsequence(strSubsequence, 0, "");

        //✅ Output (order may vary):
        //abc
        //ab
        //ac
        //a
        //bc
        //b
        //c
        /*✅ Important Note
        If string length = n
        Total subsequences = 2^n
        So for "abc" → 2^3 = 8 (including empty)*/

//        13. Find longest common prefix among strings.
        /*Meaning: common starting part of all strings.
        Example:
            ["flower","flow","flight"]  -> "fl"
            ["dog","racecar","car"]     -> ""*/

        String[] strs = {"flower", "flow", "flight"};
        if (strs.length == 0) {
            System.out.println("");
        } else {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(prefix)) {
                    System.out.println("prefix: " + prefix + " & strs[i] : " +strs[i]);
                    prefix = prefix.substring(0, prefix.length() - 1);
                    System.out.println("prefix: " + prefix);
                    if (prefix.isEmpty()) break;
                }
            }
            System.out.println("Longest common prefix: " + prefix);
        }

//        14. Find the longest word in a sentence.
        /* String sentence1 = "Hi   how   are you!";
         String [] words1 =sentence1.split("\\s+");
         String Maxword = "";
         for(int w = 1; w < words1.length; w++)
         {
            if(words1[w].length() >= words1[w-1].length()){
                Maxword = words1[w];
            }else{
                Maxword = words1[w-1];
            }
         }
         System.out.println(Maxword);*/
        //Your logic works, but it can fail in some edge cases because you compare w with w-1 every time.

        String sentence1 = "Hi   how   are you!";
        String[] words1 = sentence1.trim().split("\\s+");
        String maxWord = words1[0];
        for (int i = 1; i < words1.length; i++) {
            if (words1[i].length() > maxWord.length()) {
                maxWord = words1[i];
            }
        }
        System.out.println("Longest word: " + maxWord);
//
//        15. Replace multiple spaces with single space.
        String[] removedExtraSpace = sentence1.trim().split("\\s+");
        String sentenceSS = "";
        for (String sr : removedExtraSpace) {
            sentenceSS += sr + " ";
        }
        System.out.println(sentenceSS.trim());

        String sentence11 = "Hi   how   are you!";
        String clean = sentence11.trim().replaceAll("\\s+", " ");
        System.out.println(clean);

//-------------------------------------------------------------------------------------------------------
//        C) StringBuilder / String variations (5)
//        1. Demonstrate immutability: modify String vs StringBuilder and compare references/output.
            /*String string = "immutability";
            //System.out.println(string);

            StringBuilder stringBuilder = new StringBuilder(string);
            //System.out.println(stringBuilder);

            System.out.println(string.equals(stringBuilder.toString())); // true (content)
            System.out.println(string == stringBuilder.toString()); */     // false (different objects)

            String string = "immutability";
            string.concat(" test");            // String will NOT change
            System.out.println(s);        // immutability

            StringBuilder stringBuilder = new StringBuilder("immutability");
            stringBuilder.append(" test");           // StringBuilder WILL change
            System.out.println(stringBuilder);


//        2. Build a large string using StringBuilder (append in loop) and print final length.
            String string1 = "Shivani";
            String string2 = " Deorukhakar";
            StringBuilder sb = new StringBuilder(string1);

            for(int st=0; st < string2.length(); st++){
                char ch = string2.charAt(st);
                sb.append(ch);
            }
            System.out.println(sb.toString());//Shivani Deorukhakar
            System.out.println(sb.length());

//        3. Insert a substring at given index using StringBuilder.
            /*sb.replace(7,7, " Bandu"); //i->7 space ->8 but i want space so i used 7 as start and end
            System.out.println(sb.toString()); //Shivani Bandu Deorukhakar*/

            sb.insert(7, " Bandu");
            System.out.println(sb.toString());
            /*Why insert is better:
            It does not delete anything
            It directly inserts at index*/

//        4. Delete a range of characters from StringBuilder.
             /*sb.replace(7, 13, "\\s+");//That is not deleting. You are literally inserting the text \s+.
             System.out.println(sb.toString());//Shivani\s+ Deorukhakar*/

             sb.replace(7, 11, " ");
             System.out.println(sb.toString()); //Shivani Deorukhakar

             sb.delete(7, 13); // removes "Bandu "
             System.out.println(sb.toString());

//        5. Reverse words in a sentence (keep words, reverse order).
             /*String strwords = "Reverse words in a sentence";
             String []strArray = strwords.split("\\s+");
             String revWordInSentence = "";

             for(String w: strArray){
                 StringBuilder sbw = new StringBuilder(w).reverse();
                 revWordInSentence += sbw.toString() + " ";
             }
             System.out.println("Reverse words in a sentence :" + revWordInSentence); // esreveR sdrow ni a ecnetnes */

            /*Your code currently does this:
            ✅ "Reverse words in a sentence"
            → "esreveR sdrow ni a ecnetnes"
            That means each word is reversed, but sentence word order stays same.
            But the problem statement says:
            ✅ "Reverse words in a sentence (keep words, reverse order)"
            This means:
            "Reverse words in a sentence"
            → "sentence a in words Reverse"*/

            String strwords = "Reverse words in a sentence";
            String[] strArray = strwords.trim().split("\\s+");
            String revWordInSentence = "";

            for (int i = strArray.length - 1; i >= 0; i--) {
                revWordInSentence += strArray[i] + " ";
            }
            System.out.println(revWordInSentence.trim());
            //sentence a in words Reverse

    }
}