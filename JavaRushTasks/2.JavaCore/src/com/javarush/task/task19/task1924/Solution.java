package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();

        br.close();
        br = new BufferedReader(new FileReader(file));
        while (br.ready()){
            System.out.println(replace(br.readLine()));
        }
        br.close();


    }

    public static String replace(String s){
        s = s.replaceAll("(\\b0\\b)", String.format(" %s ", map.get(0)));
        s = s.replaceAll("(\\b1\\b)",String.format(" %s ", map.get(1)));
        s = s.replaceAll("(\\b2\\b)",String.format(" %s ", map.get(2)));
        s = s.replaceAll("(\\b3\\b)",String.format(" %s ", map.get(3)));
        s = s.replaceAll("(\\b4\\b)",String.format(" %s ", map.get(4)));
        s = s.replaceAll("(\\b5\\b)",String.format(" %s ", map.get(5)));
        s = s.replaceAll("(\\b6\\b)",String.format(" %s ", map.get(6)));
        s = s.replaceAll("(\\b7\\b)",String.format(" %s ", map.get(7)));
        s = s.replaceAll("(\\b8\\b)",String.format(" %s ", map.get(8)));
        s = s.replaceAll("(\\b9\\b)",String.format(" %s ", map.get(9)));
        s = s.replaceAll("(\\b10\\b)",String.format(" %s ", map.get(10)));
        s = s.replaceAll("(\\b11\\b)",String.format(" %s ", map.get(11)));
        s = s.replaceAll("(\\b12\\b)",String.format(" %s ", map.get(12)));
        return s;
    }
}
