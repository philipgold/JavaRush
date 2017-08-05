package com.javarush.task.task08.task0819;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
//        Iterator<Cat> iterator = cats.iterator();
//        iterator.next();
//        iterator.remove();

        cats.remove(new Cat());
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> catSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            catSet.add(new Cat());
        }
        return catSet;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        Iterator<Cat> catIterator = cats.iterator();
        while (catIterator.hasNext()){
            System.out.println(catIterator.next());
        }
    }

    // step 1 - пункт 1
    public static class Cat{

    }
}
