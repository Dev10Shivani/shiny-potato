package com.practice.java.java_1_oops;

//both methods default
/*class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}

//with instance of B we can access method of A & B both
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent default - child public
/*class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    public void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent default - child protected
/*class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    protected void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent default - child private
//CT error: java: print(int,int) has private access in com.practice.java.java_1_oops.B_OL
/*class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    private void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//----------------------------------------------------------------------------------------------------
//parent protected - child default
/*class A_OL {
    protected void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent protected - child protected
/*class A_OL {
    protected void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    protected void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent protected - child public
/*class A_OL {
    protected void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    public void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent protected - child private
//CT error: java: print(int,int) has private access in com.practice.java.java_1_oops.B_OL
/*class A_OL {
    protected void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    private void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//----------------------------------------------------------------------------------------------------
//parent public - child default
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent public - child protected
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    protected void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent public - child public
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    public void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent public - child private
//CT error: java: print(int,int) has private access in com.practice.java.java_1_oops.B_OL
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    private void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//----------------------------------------------------------------------------------------------------
//parent private - child default
//Ct error: 'print(int)' has private access in 'com.practice.java.java_1_oops.A_OL' --> if want to call parent method
//if you want to access child method no error
/*class A_OL {
    private void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent private - child protected
//Ct error: 'print(int)' has private access in 'com.practice.java.java_1_oops.A_OL' --> if want to call parent method
//if you want to access child method no error
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    protected void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent private - child public
//Ct error: 'print(int)' has private access in 'com.practice.java.java_1_oops.A_OL' --> if want to call parent method
//if you want to access child method no error
/*class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    public void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent private - child private
//CT error: both methods are private so CT error and not accessible
/*
class A_OL {
    private void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    private void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//----------------------------------------------static-------------------------------------------------

//parent default - child static
/*class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    static void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent public - child static
/*
class A_OL {
    public void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    static void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent protected - child static
/*
class A_OL {
    void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    static void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent methods not accessible so CT error

//parent static - child static
/*class A_OL {
    static void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    static void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent final - child static
/*class A_OL {
    final void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    static void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}*/

//parent static - child finale
class A_OL {
    static void print(int a) {
        System.out.println("A_OL a:"+ a);
    }
}
class B_OL extends A_OL {
    final void print(int a, int b) {
        System.out.println("B_OL a & b" + a + b);
    }
}
public class InheritanceOverloading {
    public static void main(String[] args) {
        A_OL obj = new B_OL();
        obj.print(1); //A_OL a:1

        B_OL objb = new B_OL();
        objb.print(1); //A_OL a:1
        objb.print(1, 2); //B_OL a & b12

        A_OL obj1 = new A_OL();
        obj1.print(1);//A_OL a:1
    }
}
