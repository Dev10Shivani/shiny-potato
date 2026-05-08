package com.practice.java.java_1_oops;

//default > protected > public || public == private (private method cannot overridden, public to other weakens the priviledge)

//parent should be upper. if lower the access throws CT error
/*default
   ^
   |
protected
    ^
    |
public || private*/


//--------1--------
//-----------------default methods parent and child..simple inheritance.. parent reference type = child as object type. instance creation and method call.
//“In Java, overridden methods are resolved at runtime based on the actual object type, not the reference type.”
/*class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.print(); //B

        //Create A object (simple way)
//        A obj1 = new A();
//        obj1.print();//A

        //Typecasting (NOT useful here)
        A obj2 = new B();
        ((A)obj2).print();//B
        //Because:Method resolution depends on object type, not reference type

//        🧠 Key Concept (VERY IMPORTANT)
//        Type	                Decides
//        Reference type (A obj)	Which methods are accessible
//        Object type (new B())	Which method is executed
    }
}*/

//--------2--------
//-----------------default methods parent and child, but parent reference=child object -- want to call parent method. use super in child class method.
//Q: Can we force call parent method?
//Answer:Only using super inside child class
/*class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        super.print();//A
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //A B

        A obj2 = new B();
        //obj2.super.print(); //❌ super only used in child method. not in main method to call method.
        //error CT : cannot find symbol
        //  symbol:   class obj2
    }
}*/

//--------3--------default parent = protected child --executes child method
//-----------------
/*class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    protected void print() {
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //B
    }
}*/

//--------4--------default parent = public child --executes child method
//-----------------
/*class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    public void print() {
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //B
    }
}*/

//--------5--------default parent = private child --CT error weaker access privileges
//-----------------
/*class A {
    void print() {
        System.out.println("A");
    }
}
class B extends A {
    private void print() {
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // CT error: java: print() in com.practice.java.java_1_oops.B cannot override print() in com.practice.java.java_1_oops.A
                    //attempting to assign weaker access privileges; was package
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

//--------6--------protected parent = protected child ----executes child method
//-----------------
/*class A {
    protected void print() {
        System.out.println("A");
    }
}
class B extends A {
    protected void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // A B
    }
}*/

//--------7--------protected parent = default child --CT error weaker access privileges
//-----------------
/*class A {
    protected void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // CT error: java: print() in com.practice.java.java_1_oops.B cannot override print() in com.practice.java.java_1_oops.A
                    //attempting to assign weaker access privileges; was package
    }
}*/

//--------8--------protected parent = public child --executes child method
//-----------------
/*class A {
    protected void print() {
        System.out.println("A");
    }
}
class B extends A {
    public void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // A B
    }
}*/

//--------9--------protected parent = private child --CT error weaker access privileges
//-----------------
/*class A {
    protected void print() {
        System.out.println("A");
    }
}
class B extends A {
    private void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //CT error
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

//--------10--------public parent = public child ----executes child method
//-----------------
/*class A {
    public void print() {
        System.out.println("A");
    }
}
class B extends A {
    public void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // A B
    }
}*/

//--------11--------public parent = default child --CT error weaker access privileges
//-----------------
/*class A {
    public void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //CT error
    }
}*/

//--------12--------public parent = protected child --CT error weaker access privileges
//-----------------
/*class A {
    public void print() {
        System.out.println("A");
    }
}
class B extends A {
    protected void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();//CT error
    }
}*/

//--------13--------public parent = private child --CT error weaker access privileges
//-----------------
/*class A {
    public void print() {
        System.out.println("A");
    }
}
class B extends A {
    private void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //CT error
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

//--------14--------private parent = private child ----CT error: java: print() has private access in com.practice.java.java_1_oops.A
//-----------------
/*class A {
    private void print() {
        System.out.println("A");
    }
}
class B extends A {
    private void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); // CT error: java: print() has private access in com.practice.java.java_1_oops.A
    }
}*/

//--------15--------private parent = default child ----CT error: java: print() has private access in com.practice.java.java_1_oops.A
//        A obj = new B();
//        obj.print();//error if A->private B->default ===That’s an access error — NOT an inheritance error.

//        A obj = new A();
//        obj.print();///error if A->private B->default ===That’s an access error — NOT an inheritance error.

//-----------------
/*class A {
    private void print() {
        System.out.println("A");
    }
}
class B extends A {
    void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print(); //CT error
    }
}*/

//--------16--------private parent = protected child ----CT error: java: print() has private access in com.practice.java.java_1_oops.A
//-----------------
/*class A {
    private void print() {
        System.out.println("A");
    }
}
class B extends A {
    protected void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();//CT error
    }
}*/

//--------17--------private parent = public child ----CT error: java: print() has private access in com.practice.java.java_1_oops.A
//-----------------
/*class A {
    private void print() {
        System.out.println("A");
    }
}
class B extends A {
    public void print() {
        super.print();
        System.out.println("B");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();//CT error
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

//--------18--------private parent = default child ---- create and call child instance only
//B b = new B();
//b.print();  // This will call B's print() //if A->private B->default
//------------------
/*class A {
     private void print() {
        System.out.println("A");
    }
}

class B extends A {
      void print() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        B b = new B();
        b.print();  // This will call B's print() //if A->private B->default
    }
}*/



//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
// Parent static methods - child default (CT error: can not override static method)
/*class A {
    static void show() {
        System.out.println("A");
    }
}

class B extends A {
    void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show(); //CT error

//        A objA = new A();
//        objA.show();//CT error

//        B objB = new B();
//        objB.show();//CT error

//        java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        overridden method is static
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
// Parent default/public/protected methods - child static (CT error: can not override static method)
/*
class A {
    protected void show() {
        System.out.println("A");
    }
}

class B extends A {
    static void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.show(); //CT error

        A objA = new A();
        objA.show();//CT error

        B objB = new B();
        objB.show();//CT error

//        java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        overriding method is static
    }
}*/


//-----------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
// Parent private methods - child static
//both method consider as 2 different methods. but instance with B object reference and object of A gives CT error as method is private.
//but with instance of child class B able to call static method
/*class A {
    private void show() {
        System.out.println("A");
    }
}

class B extends A {
    static void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show(); //CT error : java: show() has private access in com.practice.java.java_1_oops.A

//        A objA = new A();
//        objA.show();//CT error :java: show() has private access in com.practice.java.java_1_oops.A

//        B objB = new B();
//        objB.show();//B
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------Final----------------------------------------------------------------
// Parent final methods - child static/default/public
//cannot override final method of class A
/*class A {
    final void show() {
        System.out.println("A");
    }
}

class B extends A {
    //static/default/public
    void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show(); //CT error : static or default B method

//        A objA = new A();
//        objA.show();//CT error :CT error : static or default B method

        B objB = new B();
        objB.show();//CT error :CT error : static or default B method

//        java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        overridden method is final
    }
}*/


//-----------------------------------------------------------------------------------------------------------------------------------------

// Parent default methods - child final
//moth method consider as different --not overriden method
/*class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
    final void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        A obj = new B();
        obj.show(); //B

        A objA = new A();
        objA.show();//A

        B objB = new B();
        objB.show();//B
    }
}*/

//-----------------------------------------------------------------------------------------------------------------------------------------

// Parent public/protecte methods - child final
//CT error : attempting to assign weaker access privileges; was protected/public
/*
class A {
    protected/public void show() {
        System.out.println("A");
    }
}

class B extends A {
    final void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show(); //java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
        //attempting to assign weaker access privileges; was public

//        A objA = new A();
//        objA.show();//java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        attempting to assign weaker access privileges; was public

//        B objB = new B();
//        objB.show();//java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        attempting to assign weaker access privileges; was public
    }
}*/


//-----------------------------------------------------------------------------------------------------------------------------------------

// Parent static methods - child final
//CT error : cannot override static method
/*
class A {
    static void show() {
        System.out.println("A");
    }
}

class B extends A {
    final void show() {
        System.out.println("B");
    }
}

public class Inheritance {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show();//CT error

//        A objA = new A();
//        objA.show();//CT error

//        B objB = new B();
//        objB.show();//CT error

//        java: show() in com.practice.java.java_1_oops.B cannot override show() in com.practice.java.java_1_oops.A
//        overridden method is static
    }
}*/
