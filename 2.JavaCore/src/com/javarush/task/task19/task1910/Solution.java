package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F

Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = br.readLine();
        String fileDestination = br.readLine();
        br.close();

        StringBuilder strings = new StringBuilder();
        br = new BufferedReader(new FileReader(fileSource));
        while (br.ready()){
            strings.append(br.readLine().replaceAll("[\\p{Punct}\\s]+", "")).append(" ");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileDestination));
        bw.write(strings.toString());
        bw.close();

    }
}
