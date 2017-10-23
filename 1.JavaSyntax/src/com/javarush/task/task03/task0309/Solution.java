package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 1;
        int sum = 0;
        while (i<11){

            System.out.println(sum + i);
            sum = sum + i;
            i++;
        }
    }
}
