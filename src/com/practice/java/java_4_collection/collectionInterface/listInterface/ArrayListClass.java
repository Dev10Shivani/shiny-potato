package com.practice.java.java_4_collection.collectionInterface.listInterface;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListClass {

    /*methods
    add()
    addAll()
    remove()
    removeAll()
    indexOf(o)
    lastIndexOf(o)
    toArray()
    size()
     */
    public static void main(String [] arg){
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(4);
        arrayList2.add(5);
        arrayList2.add(6);

        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(7);
        arrayList3.add(8);
        arrayList3.add(9);

        System.out.println("ArrayList1 :" + arrayList1);
        System.out.println("ArrayList2 :" + arrayList2);
        System.out.println("ArrayList3 :" + arrayList3);

        arrayList2.addAll(0, arrayList1);
        System.out.println("ArrayList2 with ArrayList1 :" + arrayList2);
        System.out.println("ArrayList2 length:" + arrayList2.size());

        arrayList2.addAll(arrayList3);
        System.out.println("ArrayList2 with ArrayList3 :" + arrayList2);

        arrayList2.remove(8);
        System.out.println("ArrayList2 after removing index 8 :" + arrayList2);

        arrayList2.removeAll(arrayList3);
        System.out.println("ArrayList2 after removing Arraylist3 :" + arrayList2);

        System.out.println("index 4 of Arraylist2 :" + arrayList2.indexOf(4));

        System.out.println("index 4 of Arraylist2 :" + arrayList2.lastIndexOf(4));

        //convert list into array of Object
        Object[] listToArray = arrayList3.toArray();
        System.out.println("Object listToArray:" + Arrays.toString(listToArray));
        // hashcode so use toString

        //Integer[] listToArray1 = arrayList3.toArray();
        //System.out.println("Integer typecast listToArray:" + Arrays.toString(listToArray1));
            //toArray() always returns Object[]
            //Java cannot cast Object[] → Integer[]
            //Hence the error:
            //class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.Integer; so use toString

        Integer[] listToArray1 = arrayList3.toArray(new Integer[0]);
        System.out.println("Integer typecast listToArray:" + Arrays.toString(listToArray1));

        int a[] = {7,8,9};
//        List<Integer> integerList = (List<Integer>) Arrays.stream(a)
//                .mapToObj(i->(Integer) i);
//        arrayList2.addAll(integerList);
//        | Thing              | Type              |
//        | ------------------ | ----------------- |
//        | `Arrays.stream(a)` | `IntStream`       |
//        | `.mapToObj(...)`   | `Stream<Integer>` |
//        | `List<Integer>`    | ❌ different type  |

        List<Integer> integerList = Arrays.stream(a)
                .boxed()                     // int → Integer
                .collect(Collectors.toList());
//        List<Integer> integerList = Arrays.stream(a).boxed().toList();// java 16
        arrayList2.addAll(integerList);
        System.out.println("Int array to List: " + arrayList2);

        List<Integer> sychArrayList = Collections.synchronizedList(arrayList2);
        System.out.println("Synchronized List: " + arrayList2);

        System.out.println("arraylist is empty: " + arrayList2.isEmpty());

        System.out.println("arraylist contains 8: " + arrayList2.contains(8));
        System.out.println("arraylist2 containsAll arraylist1: " + arrayList2.containsAll(arrayList1));

        System.out.println("arrayList2 List: " + arrayList2);


        System.out.println("arrayList1 List: " + arrayList1);
        arrayList1.clear();
        System.out.println("arrayList1 after clear: " + arrayList1);

        //-----
        System.out.println("arraylist2 retainAll arraylist3 true/false: " + arrayList2.retainAll(arrayList3));
        arrayList2.retainAll(arrayList3); // elements are from arraylist 3 present in arraylist 2
        System.out.println("arraylist2 retainAll arraylist3: " + arrayList2);

        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> list2 = List.of(3, 4, 5);
        list1.retainAll(list2);
        System.out.println(list1);//[3, 4]

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        list.replaceAll(n -> n * 10);
        System.out.println(list);//[10, 20, 30]

//        | Feature                  | retainAll()          | replaceAll()       |
//        | ------------------------ | -------------------- | ------------------ |
//        | Purpose                  | Keep common elements | Transform elements |
//        | Needs another collection | ✅ Yes               | ❌ No               |
//        | Java version             | Since Java 1.2       | Since Java 8       |
//        | Modifies list            | ✅ Yes               | ✅ Yes              |

        List<Integer> listtoItr = new ArrayList<>(List.of(1, 2, 3));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val == 2) {
                it.remove();   // allowed
            }
        }
        System.out.println(list); // [1, 3]

        List<Integer> listlt = new ArrayList<>(List.of(1, 2, 3));
        ListIterator<Integer> li = list.listIterator();
        while (li.hasNext()) {
            if (li.next() == 2) {
                li.set(20);     // replace
                li.add(25);     // add
            }
        }
        System.out.println(list); // [1, 20, 25, 3]









    }
}
