package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        //int x = ((int) (Math.random()*20));
        int[] i5 = new int[5];
        int[] i2 = new int[2];
        int[] i4 = new int[4];
        int[] i7 = new int[7];
        int[] i0 = new int[0];

        for (int i = 0; i < i5.length; i++)
            i5[i] = getRandom();
        list.add(i5);

        for (int i = 0; i < i2.length; i++)
            i2[i] = getRandom();
        list.add(i2);

        for (int i = 0; i < i4.length; i++)
            i4[i] = getRandom();
        list.add(i4);

        for (int i = 0; i < i7.length; i++)
            i7[i] = getRandom();
        list.add(i7);

        list.add(i0);

        return list;
    }

    public static int getRandom(){
        return (int) (Math.random()*20);
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
