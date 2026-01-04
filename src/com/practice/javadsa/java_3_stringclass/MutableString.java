package com.practice.javadsa.java_3_stringclass;

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

        //Reverse String
        String str = "Trilak";
        StringBuilder sb = new StringBuilder(str).reverse();
        System.out.println(sb);

        //Capacity
        System.out.println(sb.capacity());


    }


}
