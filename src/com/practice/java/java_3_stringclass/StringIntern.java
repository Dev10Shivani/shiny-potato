package com.practice.java.java_3_stringclass;

public class StringIntern {
    public static void main(String []arg){
        //Java 14, so the rules are Java 7+ behavior (SCP in Heap, intern reuses heap object).
       /*  `intern()` returns a reference from the String Constant Pool (SCP).
            * If the string already exists in SCP → returns existing reference
            * If not present → adds it to SCP and returns reference

        IMPORTANT (Java 14 rules to remember)
        ✔ String Constant Pool (SCP) is inside Heap
        ✔ intern() does NOT create a new object
        ✔ If SCP already has the string → returns SCP reference
        ✔ If not → heap object itself is placed into SCP */

        System.out.println("---------------intern()----------------");

        System.out.println("---------------Example 1----------------");
        String string1 = new String("A");
        String string2 = "A";
        System.out.println(string1.intern() == string2); //true
        //o/p : true //intern use the existing reference from SCP so because of intern reference is same
        System.out.println(string1 == string2); //false
        //o/p : false //== operator check references and here reference are different

//        Heap
//        ┌──────────────────────────────┐
//        │ String Constant Pool (SCP)   │
//        │  ┌──────────┐               │
//        │  │ "A"      │ ◄── string2   │
//        │  └──────────┘               │
//        │                              │
//        │  new String("A") ◄─ string1 │
//        └──────────────────────────────┘
//        Output reasoning
//        string1.intern() == string2 → ✅ same SCP reference → true
//        string1 == string2 → ❌ different objects → false

        System.out.println("---------------Example 2----------------");
        String ex1 = new String("Java");
        String ex2 = ex1.intern();
        System.out.println(ex1 == ex2); // false
        System.out.println(ex1.intern() == ex2); // true
        System.out.println(ex2.intern() == ex1); //false
        System.out.println(ex2.intern() == ex1.intern());//true

//        Heap
//        ┌──────────────────────────────┐
//        │ String Constant Pool (SCP)   │
//        │  ┌──────────┐               │
//        │  │ "Java"   │ ◄── ex2       │
//        │  └──────────┘               │
//        │                              │
//        │  new String("Java") ◄─ ex1  │
//        └──────────────────────────────┘
//        Output reasoning
//        Statement	                    Result	Reason
//        ex1 == ex2	                false	heap vs SCP
//        ex1.intern() == ex2	        true	SCP ref
//        ex2.intern() == ex1	        false	SCP vs heap
//        ex2.intern() == ex1.intern()  true	SCP ref

        System.out.println("---------------Example 3----------------");
        String exp1 = "Hello"; //SCP exp1 ref
        String exp2 = new String("Hello"); // new obj ref
        String exp3 = exp2.intern(); // point to same as exp1

        System.out.println(exp1 == exp3); // true
        System.out.println(exp1.intern() == exp3);//true
        System.out.println(exp3.intern() == exp1);//true
        System.out.println(exp3.intern() == exp3);//true

        System.out.println(exp2 == exp3); // false
        System.out.println(exp2.intern() == exp3);//true
        System.out.println(exp2 == exp3.intern());//false
        System.out.println(exp2.intern() == exp3.intern());//true

//        Heap
//        ┌──────────────────────────────┐
//        │ String Constant Pool (SCP)   │
//        │  ┌──────────┐               │
//        │  │ "Hello"  │ ◄─ exp1,exp3 │
//        │  └──────────┘               │
//        │                              │
//        │  new String("Hello") ◄─ exp2│
//        └──────────────────────────────┘
//        Output reasoning
//        exp1 == exp3 → ✅ same SCP object → true
//        exp2 == exp3 → ❌ heap vs SCP → false

        System.out.println("---------------Example 4----------------");
        String exmp1 = new String("Hel") + new String("lo");
        String exmp2 = exmp1.intern();
        String exmp3 = "Hello";
        System.out.println(exmp1 == exmp3); // false
        System.out.println(exmp2 == exmp3); // true

//        Step-by-step allocation (Java 14)
//        "Hel" → SCP
//        "lo" → SCP
//        new String("Hel") + new String("lo")
//
//        Runtime concatenation
//        Creates new heap object "Hello"
//        NOT added to SCP automatically
//
//        intern():
//        "Hello" NOT yet in SCP
//        Java 14 puts heap object itself into SCP
//
//        "Hello" literal → reuses SCP reference
//
//        Memory diagram
//        Heap
//    ┌────────────────────────────────────┐
//    │ String Constant Pool (SCP)         │
//    │  ┌──────────┐                     │
//    │  │ "Hel"    │                     │
//    │  └──────────┘                     │
//    │  ┌──────────┐                     │
//    │  │ "lo"     │                     │
//    │  └──────────┘                     │
//    │  ┌──────────┐                     │
//    │  │ "Hello"  │ ◄─ exmp2, exmp3    │
//    │  └──────────┘                     │
//    │                                    │
//    │  "Hello"(runtime concat) ◄─ exmp1 │
//    └────────────────────────────────────┘
//
//        Output reasoning
//        exmp1 == exmp3 → ❌ heap vs SCP → false
//        exmp2 == exmp3 → ✅ same SCP object → true

        System.out.println("---------------Example 5----------------");
        String sval = new String("A");
            /*JVM checks String Constant Pool (SCP)
            Literal "A" is created in SCP (if not already present)
            new String("A") creates a new heap object
            sval points to the heap object
            📌 Objects now:
            SCP → "A"
            Heap → new String("A")*/
        System.out.println(sval.intern() == "A");// true
            /*JVM checks SCP
            "A" already exists
            intern() returns reference to SCP object
            Literal "A" → always refers to SCP object*/

//                String Constant Pool (SCP)
//                --------------------------
//                | "A"        <------------+
//                --------------------------             |
//                |
//                Heap Memory                            |
//                --------------------------             |
//                | new String("A")         |            |
//                |        ↑                |            |
//                |       sval              |            |
//                --------------------------             |
//                |
//                sval.intern()  -----------------------+
//                "A" ----------------------------------+
//                Both point to SCP "A"

//                | Object          | Location      |
//                | --------------- | ------------- |
//                | "A" literal     | SCP           |
//                | new String("A") | Heap          |
//                | intern() result | SCP reference |


    }
}
