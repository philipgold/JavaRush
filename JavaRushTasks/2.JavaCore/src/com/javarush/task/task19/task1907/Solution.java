package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(file));

        int count = 0;
        while (br.ready()) {
            String[] wordsInLine = br.readLine().split("[\\p{Punct}\\s]+");
            for (int i=0; i<wordsInLine.length; i++){
                if (wordsInLine[i].equals("world"))
                    count++;
            }
        }
        br.close();
        System.out.println(count);

    }
}
