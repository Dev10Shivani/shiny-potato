package com.practice.java.java_1_oops;

//----Parent class final
//CT error : Cannot inherit from final class 'com.practice.java.java_1_oops.A'
//final class cannot be extends
/*final class A{
    public A(){}

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){}

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceFinal {
    public static void main(String[] args){
        A a = new B();
        a.print();
    }
}*/

//----Child class final
//child class final allow but final parent is not allowed
class A{
    public A(){}

    public void print(){
        System.out.println("Hello A");
    }
}
final class B extends A{
    public B(){}

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceFinal {
    public static void main(String[] args){
        A a = new B();
        a.print();//Hello B
    }
}

//--------------------------------final constructor----------------------------------------
//constructor never be final

//parent constructor final
//CT error : Modifier 'final' not allowed here
/*
class A{
    final public A(){}

    public void print(){
        System.out.println("Hello A");
    }
}
final class B extends A{
    public B(){}

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceFinal {
    public static void main(String[] args){
        A a = new B();
        a.print();
    }
}*/


//child constructor final
//CT error : Modifier 'final' not allowed here
/*
class A{
    public A(){}

    public void print(){
        System.out.println("Hello A");
    }
}
final class B extends A{
    final public B(){}

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceFinal {
    public static void main(String[] args){
        A a = new B();
        a.print();
    }
}*/
