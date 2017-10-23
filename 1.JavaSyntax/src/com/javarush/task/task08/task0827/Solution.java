package com.javarush.task.task08.task0827;

import java.util.Date;
import java.util.Calendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));

        int n = calendar.get(Calendar.DAY_OF_YEAR);

        if (n % 2 == 0)  {
            return false;
        }

        return true;
//        Date d = new Date(date);
//        Date curDate = new Date();
//        long msTimeDistance = curDate.getTime() - d.getTime();
//        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
//        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
//        boolean isDateOdd = !((dayCount%2)==0);
//        return isDateOdd;
    }
}
