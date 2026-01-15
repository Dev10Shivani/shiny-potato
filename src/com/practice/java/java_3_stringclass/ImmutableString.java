package com.practice.java.java_3_stringclass;

public class ImmutableString {
    public static void main(String[] args) {

        // Variables store references, not objects.
        // When you “change” a String, Java creates a new String object and updates the reference.

        //String variables str1 & str2 holds reference of object "Test" and the object "Test" store inside String Constant Pool & each string literal is final/constant
        //"Test" is stored in the String Constant Pool
        // str1 and str2 point to the same object
        // str 1 & str2 is string literal because they are created using " ";
        String str1 = "Test";
        String str2 = "Test";

        //String objects are store inside heap memory, Even though "Test" exists in pool, new keyword forces a separate object
        String str3 = new String ("Test");

        str1 = "Test1"; //Try to change string literal
        System.out.println("String literal str1 value :"+ str1);
        System.out.println("String literal str2 value :"+ str2);

        str3 = "Test3"; //Try to change string object
        System.out.println("String object str3 value :"+ str3);

        str3 = new String ("Test4");; //Try to change string object
        System.out.println("String object str3 value :"+ str3);

        /* o/p:
            String literal str1 value :Test1
            String literal str2 value :Test
            String object str3 value :Test3
            String object str3 value :Test4

        the String object did NOT change — the reference changed
        What “String is immutable” actually means
            Once a String object is created, its value can never be changed
            You cannot modify the existing object, but you can point the variable to a new object.

        str1 = "Test1";
        ❗ "Test" is not modified; Java creates a new String "Test1" & str1 now points to it
        String Pool:
        "Test"   ← str2
        "Test1"  ← str1
        Original "Test" remains unchanged → immutability preserved


        str3 = "Test3";
        "Test3" is created in String Pool
        str3 reference is changed
        String Pool:
        "Test3" ← str3
        The old new String("Test") object becomes eligible for garbage collection

        str3 = new String("Test4");
        New heap object created
        str3 now points to it
        Heap:
        new String("Test4") ← str3

        MOST IMPORTANT 🔥
        ❌ This did NOT happen
        "Test" → changed to "Test1"

        ✅ This happened
        str1 → "Test"     (old)
        str1 → "Test1"    (new object)
        */

        //--------------------------------------------------------------Concatination--------------------------------------------------------
        //Concatination with concat()
        //Proof: Immutability in code
        String s = "Hello";
        s.concat(" World");
        System.out.println(s);
        //O/p: Hello
        //concat() creates a new String, but you didn’t store it.


        //Concatination with + operator
        String s1 = "Hello";
        s1 = s1 + " World";
        System.out.println(s1);
        //O/p : Hello World
        //+ operator append string & creates a new String Object, stores a new reference.


        //---------------------------------------------------------------Comparison-------------------------------------------------------
        str1 = "Test";
        str3 = "Test";

        // equals()
        //equals method check the actual value present inside string constant pool or heap memory
        if (str1.equals(str2))
            System.out.println("same str1,str2 via equals method");
        else
            System.out.println("different");
        // o/p: same str1,str2 via equals method

        if (str1.equals(str3))
            System.out.println("same str1,str3 via equals method");
        else
            System.out.println("different");
        // o/p: same str1,str3 via equals method

        // == operator
        //== operator checks the memory reference(memory location)
        //When 2 string literal has same value assigned then both will point to same memory location in the string literal pool
        if (str1 == str2)
            System.out.println("same str1,str2 via == operator");
        else
            System.out.println("different");
        // o/p: same str1,str2 via == operator

        //str1 is string variable/literal & present in string literal pool
        //str3 is string object & present in heap memory
        if (str1 == str3) {
            System.out.println("same str1,str3 via == operator");
        } else {
            System.out.println("different");
        }
        // o/p: different


        // compareTo()
        // if (str1.compareTo(str2)) { System.out.println("same");} //------>error<--------------
        /* Explanation:
           String.compareTo() does not return a boolean, that’s why code gives an error.
           What compareTo() returns
                int result = str1.compareTo(str2);
           It returns an int:
                0 → strings are equal
              < 0 → str1 is lexicographically smaller
              > 0 → str1 is lexicographically greater

           But if condition expects a boolean, not an int
         */

        if (str1.compareTo(str2) == 0)
            System.out.println("str1 & str2 are same");
        else
            System.out.println("different");
        // o/p: str1 & str2 are same

        if (str1.compareTo(str3) == 0)
            System.out.println("str1 & str3 are same");
        else
            System.out.println("different");
        // o/p: str1 & str3 are same

        String str01 = "Apple";
        String str02 = "Banana";
        String str03 = "Apple";
        System.out.println(str01.compareTo(str02)); // Returns -1 ; a negative integer (e.g., -1, because 'A' < 'B')
        System.out.println(str01.compareTo(str03)); // Returns 0 ; (because they are equal)
        System.out.println(str02.compareTo(str01)); // Returns 1 ; a positive integer (e.g., 1, because 'B' > 'A
        // ')
        //----------------------------------------------------------------------------------------------------------------------



    }
}
