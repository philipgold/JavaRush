package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = br.readLine();
        String fileDestination = br.readLine();

        br.close();
        br = new BufferedReader(new FileReader(fileSource));
        StringBuilder digits = new StringBuilder();
        while (br.ready()){
            String[] strings = br.readLine().split("[\\s]+");
            for (String s : strings){
                if (s.matches("[0-9]+"))
                    digits.append(s + " ");
            }
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileDestination));
        bw.write(digits.toString());
        bw.close();
    }
}
