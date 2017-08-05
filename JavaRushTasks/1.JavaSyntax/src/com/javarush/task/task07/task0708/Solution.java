package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int longT = 0;

        for (int i = 0; i < 5; i++) {
            String t = br.readLine();
            list.add(t);
            if (longT<t.length())
                longT = t.length();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == longT)
                System.out.println(list.get(i));
        }

    }
}
