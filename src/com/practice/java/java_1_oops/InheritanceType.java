package com.practice.java.java_1_oops;

//------------------------------Simple inheritance-------------------------------------------------------------
//-- constructor can be empty. by default the internal first line is super in default constructor
//constructor chaining with super() and this()

//------------default super() from child.. parent & child with default constructor
/*class A{
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
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print();//Hello B
    }
}*/

//------------with manual super() in child constructor and method.. parent & child with default constructor
/*class A{
    public A(){
        System.out.println("Class A");
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){
        super();
        System.out.println("Class B");
    }

    public void print(){
        super.print();
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print();
//        output:
//        Class A
//        Class B
//        Hello A
//        Hello B

    }
}*/

//------------default and parametrise constructor in parent & child with default constructor to call param constructor of parent
//-- default constructor is optional (without default workin- check next code)
/*class A{
    int a;

    public A(){}

    public A(int a){
        this.a = a;
        System.out.println("a :"+a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){
        super(5);
    }

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print();

//        output:
//        a :5
//        Hello B
    }
}*/

//------------ parametrise constructor in parent & child with default constructor to call param constructor of parent
// -- allow
/*class A{
    int a;

    public A(int a){
        this.a = a;
        System.out.println("a :"+a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){
        super(5);
    }

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print();

//        output:
//        a :5
//        Hello B
    }
}*/

//-------------parametrise constructor in parent - child with default & param constructor = CT error
// CT error : There is no no-arg constructor available in 'com.practice.java.java_1_oops.A'
// if child has default/param constructor & parent with param constructor then parent should have default constructor
/*class A{
    int a;

    public A(int a){
        this.a = a;
        System.out.println("a :"+a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    int b;
    public B(){}

    public B(int b){
        this.b = b;
        System.out.println("b :"+b);
    }

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B(4);
        a.print();
    }
}*/

//------------parametrise constructor in parent - child with parametrise constructor = CT error
// CT error : There is no no-arg constructor available in 'com.practice.java.java_1_oops.A'
/*class A{
    int a;

    public A(int a){
        this.a = a;
        System.out.println("a :"+a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    int b;

    public B(int b){
        this.b = b;
        System.out.println("b :"+b);
    }

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B(4);
        a.print();
    }
}*/

//------------default constructor in parent - child with parametrise constructor and super
/*class A{
    int a=5;

    public A(){
        System.out.println("a :"+a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    int b;

    public B(int b){
        super();
        this.b = b;
        System.out.println("b :"+b);
    }

    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B(4);
        a.print();

//        output:
//        a :5
//        b :4
//        Hello B
    }
}*/

//-----------constructor chaining with super
/*class A{
    public A(){
        System.out.println("Class A");
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){
        super();
        System.out.println("Class B");
    }

    public void print(){
        super.print();
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print();
//        output:
//        Class A
//        Class B
//        Hello A
//        Hello B

    }
}*/

//-----------constructor chaining with this
//example 1
/*class A{
    public A(){
        System.out.println("Class A");
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){
        //super(); default so Class A -1
        this.print(); //object type is of class B so Hello B -2
        System.out.println("Class B"); // The Class B -3
    }

    public void print(){
        System.out.println("Hello B"); //--4
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B();
        a.print(); //call to B default constructor
//        output:
//        Class A
//        Hello B
//        Class B
//        Hello B
    }
}*/

//example 2
/*class A{
    int a;
    public A(int a){
        this.a = a;
        System.out.println("Class A a:" + a);
    }

    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    int b;
    public B(int a, int b){
        super(a);
        this.b = b;
        System.out.println("Class B b:"+b); // The Class B -3
    }

    public void print(){
        System.out.println("Hello B"); //--4
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new B(1, 2);
        a.print(); //call to B default constructor
//        output:
//        Class A a:1
//        Class B b:2
//        Hello B
    }
}*/

//----------------------------------------------------------------------------------------------------------------
//------------------------------multilevel inheritance-------------------------------------------------------------
//super in constructor and method
/*class A{
    public A(){System.out.println("Class A");}
    public void print(){
        System.out.println("Hello A");
    }
}
class B extends A{
    public B(){System.out.println("Class B");}
    public void print(){
        super.print();
        System.out.println("Hello B");
    }
}
class C extends B{
    public C(){System.out.println("Class C");}
    public void print(){
        super.print();
        System.out.println("Hello C");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new C();
        a.print();

//        output:
//        Class A
//        Class B
//        Class C
//        Hello A
//        Hello B
//        Hello C
    }
}*/

//----------------------------------------------------------------------------------------------------------------
//------------------------------multiple inheritance-------------------------------------------------------------
//CT error : Class cannot extend multiple
/*class A{
    public A(){System.out.println("Class A");}
    public void print(){
        System.out.println("Hello A");
    }
}
class B{
    public B(){System.out.println("Class B");}
    public void print(){
        System.out.println("Hello B");
    }
}
class C extends A, B{
    public C(){System.out.println("Class C");}
    public void print(){
        System.out.println("Hello C");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new C();
        a.print();
    }
}*/

//----------solution with interface
/*interface A{
//    public A(){} --> no constructor in interface

//    public void print(){
//        System.out.println("Hello A"); --> no method implementation only signature
//    }

     public static final int a = 0; //need to initialize
     public abstract void print(); //--> methods are public abstract by default
}
interface B{
//    public B(){} --> no constructor in interface

//    public void print(){
//        System.out.println("Hello B"); --> no method implementation only signature
//    }

    public static final int b = 0; //need to initialize
    public abstract void print();
}
class C implements A, B{
    public C(){
        System.out.println("Class C");
    }

    public void print(){
        System.out.println("Hello C - AB");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new C();
        a.print();

        B b = new C();
        b.print();

//        output:
//        Class C
//        Hello C - AB
//        Class C
//        Hello C - AB
    }
}*/


//----------------------------------------------------------------------------------------------------------------
//------------------------------Hybrid inheritance-------------------------------------------------------------
//example 1
/*class Parent{
    public Parent(){System.out.println("Class Parent");}
    public void print(){
        System.out.println("Hello Parent");
    }
}
class A extends Parent{
    public A(){System.out.println("Class A");}
    public void print(){
        System.out.println("Hello A");
    }
}
class B extends Parent{
    public B(){System.out.println("Class B");}
    public void print(){
        System.out.println("Hello B");
    }
}
//CT error: Class cannot extend multiple classes
class C extends A, B{
    public C(){System.out.println("Class C");}
    public void print(){
        System.out.println("Hello C");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        A a = new C();
        a.print();
    }
}*/

//example 2
class Parent{
    public Parent(){System.out.println("Class Parent");}
    public void print(){
        System.out.println("Hello Parent");
    }
}
class A2 extends Parent{
    public A2(){System.out.println("Class A");}
    public void print(){
        System.out.println("Hello A");
    }
}
class B2 extends Parent{
    public B2(){System.out.println("Class B");}
    public void print(){
        System.out.println("Hello B");
    }
}
public class InheritanceType {
    public static void main(String[] args){
        Parent a = new A2();
        a.print();

        Parent b = new B2();
        b.print();

//        output:
//        Class Parent
//        Class A
//        Hello A
//        Class Parent
//        Class B
//        Hello B
    }
}