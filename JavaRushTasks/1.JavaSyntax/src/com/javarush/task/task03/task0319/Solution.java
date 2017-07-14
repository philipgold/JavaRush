package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        //Коля получает 3000 через 5 лет.

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String sNumber1 = bufferedReader.readLine();
        String sNumber2 = bufferedReader.readLine();

        int number1 = Integer.parseInt(sNumber1), number2 = Integer.parseInt(sNumber2);
        System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");

    }
}
