package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int x = 0;
        char[] chars = String.valueOf(number).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            x+= Integer.parseInt(String.valueOf(chars[i]));
        }
        return x;
    }
}