package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        String fileSource = args[0];
        String fileDestination = args[1];

        FileInputStream fis = new FileInputStream(new File(fileSource));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        FileOutputStream fos = new FileOutputStream(new File(fileDestination));
        String s = new String(buffer, "UTF-8");
        fos.write(s.getBytes("Windows-1251"));
        fos.close();


    }
}
