package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(file));

        while (br.ready()){
            String line = br.readLine();
            ArrayList<String> st = new ArrayList<>();
            Collections.addAll(st, line.split("\\s"));
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                if (st.contains(words.get(i)))
                    count++;
            }

            //Если совпадений 2 - выводим в консоль изнаальную строку
            if (count == 2) System.out.println(line);
        }
        br.close();

    }
}
