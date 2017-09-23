package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        FileWriter fw = new FileWriter(file2);
        while (br.ready()){
            String[] strings = br.readLine().split("\\s");
            for (String s : strings){
                if (s.matches(".+[0-9].+"))
                    fw.write(s + " ");
            }
        }
        br.close();
        fw.close();

    }
}
