package com.javarush.task.task19.task1909;

/* 
Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки «.» на знак «!«.
Результат вывести во второй файл.
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
            strings.append(br.readLine().replaceAll("[.]", "!"))
            .append(" ");
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileDestination));
        bw.write(strings.toString());
        bw.close();
    }
}
