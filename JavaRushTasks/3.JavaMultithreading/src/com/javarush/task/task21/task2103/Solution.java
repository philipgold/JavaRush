package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
Упростить. Переменные не переименовывать, комментарии не оставлять.
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
       // return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
       //return a && b && c && !d || !a && c || !b && c || c && d;
        return c;

    }

    public static void main(String[] args) {
        System.out.println(calculate(true, true, true, true));
    }
}
