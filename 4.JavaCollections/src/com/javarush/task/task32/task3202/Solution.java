package com.javarush.task.task32.task3202;

import java.io.*;

/**
Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (is != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            char[] buf = new char[1024];
            int count;
            while (inputStreamReader.ready()) {
                count = inputStreamReader.read(buf);
                stringWriter.write(buf, 0, count);
            }
            inputStreamReader.close();
        }
        return stringWriter;
    }
}