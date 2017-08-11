package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String t = list.get(i);
            for (int j = 0; j < t.length(); j++) {
                char c = t.charAt(j);
                if (Character.isWhitespace(c))
                    continue;
                if (!map.containsKey(c)){
                    map.put(c,1);
                }
                else if (map.containsKey(c)){
                    int v = map.get(c);
                    map.replace(c, v, v+1);
                }
            }
        }
        for (int i = 0; i < alphabet.size(); i++) {
            int v = 0;
            char c = alphabet.get(i);
            if (map.get(c) !=null){
                v = map.get(c);
            }
            System.out.println(alphabet.get(i) + " " + v);
        }

    }

}
