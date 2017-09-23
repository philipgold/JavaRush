package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным индексом.

Пример:
второй символ, четвертый символ, шестой символ и т.д.

Закрыть потоки ввода-вывод
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();
        int i = 0;
        while(fr.ready()){
            i++;
            int data = fr.read();
            if(i%2 == 0)
                fw.write(data);
        }
        fr.close();
        fw.close();
    }
}
