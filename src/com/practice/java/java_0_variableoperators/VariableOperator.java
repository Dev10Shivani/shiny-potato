package com.practice.java.java_0_variableoperators;

import java.util.List;

public class VariableOperator {
//    var x = 10;
//    var y;
//    var z = null;
//    var list = java.util.List.of(1,2,3);

//    static int x;
//    int y;

        public static void main(String[] args) {
            //int x = 10;
           // System.out.println(x = x++);//10

//            VariableOperator t = new VariableOperator();
//            System.out.println(x + " " + t.y);//0 0

//            List<Integer> l = java.util.List.of(1,2,3);

            int x = 5;
            System.out.println(++x + x++);

//            while(false){
//                System.out.println("Hello"); //not compiled
//            }

            do{
                System.out.println("Hello");
            }while(false); //compiled allow in do-while

            for(int i=0; i<5 ;i++);
            for (;;);
        }
}
