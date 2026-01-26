package com.practice.java.java_4_collection.collectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsClassMethods {
   /* sort(), swap(), binarySearch(), reverse(), reverseOrder(), rotate(), shuffle(), copy(), fill(), frequency(), disjoint(),
    addAll(), replaceAll(), min(), max(), indexOfSubList(), LastIndexOfSubList(),
    emptyEnumeration(), emptyIterator(), emptyListIterator(), emptyList(), emptySet(),emptyMap(),
    singleton(), singletonList(),singletonMap(), unmodifiableCollection()
    synchronizedCollection(), synchronizedList(), synchronizedSet(), synchronizedMap()*/
    public static void main(String[] args) {

        /*-------------sort)-------------*/
        List<Integer> list1 = new ArrayList<>(List.of(4,1,4,6,9,7));
        list1.stream().sorted().forEach(e -> System.out.print(e + ", "));

        System.out.println("\n");

        System.out.println("sort comma separate with joining :"+ list1.stream().sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
        );

        List<Integer> list2 = new ArrayList<>(List.of(4,1,4,6,9,7));
        Collections.sort(list2);
        System.out.println("sort with collectiosn sort method : "+list2);

        /*-------------reverseOrder()-------------*/

        List<Integer> list3 = new ArrayList<>(List.of(4,1,4,6,9,7));
        Integer result = list3.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println("max 3rd number :" + result);

      //1)  Using Collections.sort()
        Collections.sort(list3, Collections.reverseOrder());
        System.out.println(list3);

      //2) Using List.sort()
        list3.sort(Collections.reverseOrder());
        System.out.println(list3);

     //3) Using Stream (creates new sorted list)
        List<Integer> desc = list3.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(desc);

      //4) If list is already sorted ascending, just reverse it
        Collections.reverse(list3);
        System.out.println(list3);

        /*-------------synchronizedList()-------------*/
//        List<Integer> syncList = Collections.synchronizedList(list3);
//        syncList.stream().map(String::valueOf).collect(Collectors.joining(","));

    }}
