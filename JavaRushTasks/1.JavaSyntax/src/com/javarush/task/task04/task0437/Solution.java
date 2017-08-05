package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 1;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < i; y++) {
                System.out.print(8);
            }
            System.out.println();
            i++;
        }

    }
}
