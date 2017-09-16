package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        try {
            while (true){
                fileName = br.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
