package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sYear = bufferedReader.readLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        simpleDateFormat.parse(sYear);

        Calendar calendar = simpleDateFormat.getCalendar();
        int numofDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

        System.out.println("количество дней в году: " +
                numofDays);
    }
}