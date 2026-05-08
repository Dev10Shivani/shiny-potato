package com.practice.java.java_1_oops;

/*public class FinalVariable {
    public static void main(String[] args){
        final int a;
        a = 1;
        System.out.println("a :"+a); //a :1
    }
}*/

//CT error: java: variable a might already have been assigned
/*public class FinalVariable {
    public static void main(String[] args){
        final int a;
        a = 1;
        System.out.println("a :"+a);
        a = 2; //CT error
    }
}*/

//CT error: java: variable a might already have been assigned
/*public class FinalVariable {
    public static void main(String[] args){
        final int a = 0;
        a = 1; //CT error
        System.out.println("a :"+a);
    }
}*/

import java.util.ArrayList;
import java.util.List;

//CT error :Field 'list' might not have been initialized
/*public class FinalVariable {
    final List<Integer> list; //CT error

    public void assign(){
        list = new ArrayList<>();
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();//List :[1, 97]
    }
}*/

//allowed
public class FinalVariable {
    final List<Integer> list = new ArrayList<>();

    public void assign(){
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();//List :[1, 97]
    }
}

//Cannot assign a value to final variable 'list'
/*public class FinalVariable {
    final List<Integer> list = new ArrayList<>();

    public void assign(){
        list = new ArrayList<>();//CT error
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();
    }
}*/

//CT error : Cannot assign a value to final variable 'list'
/*public class FinalVariable {
    final List<Integer> list;//CT error

    public void assign(){
        list = new ArrayList<>();
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }

    public void reset(){
        list = new ArrayList<>();
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();//List :[1, 97]
        f.reset();//List :[]
    }
}*/

//CT error :Cannot assign a value to final variable 'list'
/*public class FinalVariable {
    final List<Integer> list = new ArrayList<>();

    public void assign(){
        list = new ArrayList<>();//CT error
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }

    public void reset(){
        list = new ArrayList<>();
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();
        f.reset();
    }
}*/

//CT error :Cannot assign a value to final variable 'list'
/*public class FinalVariable {
    final List<Integer> list = new ArrayList<>();

    public void assign(){
        list.add(1);
        list.add((int) 'a');
        System.out.println("List :"+ list);
    }

    public void reset(){
        list = new ArrayList<>();//CT error
        System.out.println("List :"+ list);
    }
    public static void main(String[] args){
        FinalVariable f = new FinalVariable();
        f.assign();
        f.reset();
    }
}*/



