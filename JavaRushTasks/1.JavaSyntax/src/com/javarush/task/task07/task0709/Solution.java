package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            String t = br.readLine();
            list.add(t);
            if (t.length() <=min){
                min = t.length();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i).length()){
                System.out.println(list.get(i));
            }
        }
    }
}
