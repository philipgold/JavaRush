package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fr = new FileReader(fileName);
        Map<Character, Integer> map = new HashMap<>();
        /*Посчитать частоту встречания каждого символа.*/
        while (fr.ready()){
            char c = (char)fr.read();
            if (!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c)+1);
        }
        //Отсортировать результат по возрастанию кода ASCII.
        char[] chars = new char[map.size()];
        int i = 0;
        for(Map.Entry<Character, Integer> pair : map.entrySet()) {
            chars[i]=pair.getKey();
            i++;
        }
        Arrays.sort(chars);

        //Вывести на консоль отсортированный результат
        for (char c : chars)
            System.out.println(c + " " + map.get(c));

        fr.close();
    }
}
