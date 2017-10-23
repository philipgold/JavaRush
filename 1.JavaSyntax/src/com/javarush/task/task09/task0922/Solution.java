package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            Date d = dateFormat1.parse(br.readLine());
            System.out.println(dateFormat2.format(d).toUpperCase());
        }
        catch ( Exception e){
            e.printStackTrace();
            main(args);
        }
    }
}
