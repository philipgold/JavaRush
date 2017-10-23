package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> map = new TreeMap<>();
        String fileName;
        /*Считывать с консоли и отсортирвать файлы в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.*/
        while (!(fileName = br.readLine()).equals("end")) {
            int beginIndex = fileName.lastIndexOf(".part");
            int partNumber = Integer.parseInt(fileName.substring(beginIndex + 5)); // 5 = .part
            map.put(partNumber, fileName);
        }

        //Get origin path and file name
        String originFileName = map.get(1);
        int endIndex = originFileName.lastIndexOf(".part");
        originFileName = originFileName.substring(0, endIndex);

        //В файл переписать все байты из файлов-частей используя буфер.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(originFileName));
        for(Map.Entry<Integer, String> pair : map.entrySet()){

            //Read
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pair.getValue()));
            byte[] bytes = new byte[bis.available()];
            bis.read(bytes);

            //Write
            bos.write(bytes);
            bis.close();
        }
        bos.close();
    }
}
