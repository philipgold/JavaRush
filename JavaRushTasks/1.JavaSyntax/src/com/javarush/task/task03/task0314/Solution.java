package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int x = 1; x<=10; x++){
            for (int y = 1; y<=10; y++){
                int z = x * y;
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }
}
