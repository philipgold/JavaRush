package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sDays[] = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

        String sDayNumber = bufferedReader.readLine();

        int dayNumber = Integer.parseInt(sDayNumber);

        if ((dayNumber>7)||dayNumber<=0){
            System.out.println("такого дня недели не существует");
            return;
        }
        else
            System.out.println(sDays[dayNumber-1]);



    }
}