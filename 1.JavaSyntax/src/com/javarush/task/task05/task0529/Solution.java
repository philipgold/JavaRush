package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        while (true){
            String t = r.readLine();
            if (t.equals("сумма")){
                break;
            }
            else
                s += Integer.parseInt(t);
        }
        System.out.println(s);
    }
}
