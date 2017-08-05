package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i)) && i==0 && !Character.isDigit(sb.charAt(i)))
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            else if (Character.isWhitespace(sb.charAt(i))&& !Character.isDigit(sb.charAt(i+1)))
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
        }
        System.out.println(sb);




    }
}
