package com.practice.java.java_1_oops;

//default > protected > public || public == private (private method cannot overridden, public to other weakens the priviledge)
class A {
     private void print() {
        System.out.println("A");
    }
    static void show() {
        System.out.println("A");
    }
}

class B extends A {
      void print() {
        System.out.println("B");
    }
    static void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.print(); //B ///error if A->private B->default ===That’s an access error — NOT an inheritance error.
//        A obj = new A();
//        obj.print();///error if A->private B->default ===That’s an access error — NOT an inheritance error.
//        B b = new B();
//        b.print();  // This will call B's print() //if A->private B->default

        /*obj.show();//A
        A objA = new A();
        objA.show();//A
        B objB = new B();
        objB.show();//B*/
    }
}
