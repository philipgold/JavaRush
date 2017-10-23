package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder sb = new StringBuilder();
        while (in.ready()) {
            String line = in.readLine();
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.length() > 6)
                    sb.append(word + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.write(sb.toString());
        in.close();
        out.close();

    }
}
