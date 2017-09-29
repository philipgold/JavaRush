package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        br.close();

        FileInputStream fis = new FileInputStream(file);
        load(fis);
        fis.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        for (Map.Entry<String, String > pair : properties.entrySet()){
            p.setProperty(pair.getKey(), pair.getValue());
        }
        p.store(outputStream, null);

        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот
        Properties p = new Properties();
        p.load(inputStream);
        Enumeration enuKeys = p.keys();

        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            String value = p.getProperty(key);
            properties.put(key,value);
        }
    }

    public static void main(String[] args) {

    }
}
