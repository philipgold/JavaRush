package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName — путь к файлу;
2) number — число, позиция в файле;
3) text — текст.

Считать текст с файла начиная с позиции number, длинной такой же как и длинна переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку ‘true‘, иначе записать ‘false‘.
Используй RandomAccessFile и его методы seek(long pos), read(byte b[], int off, int len), write(byte b[]).
Используй convertByteToString(byte readBytes[]) для конвертации считанной строчки в текст.
*/

public class Solution {
    public static void main(String... args) throws IOException  {
        if (args != null && args.length == 3) {
            String fileName = args[0];
            long number = Integer.parseInt(args[1]);
            String text = args[2];
            byte[] bt = new byte[text.length()];
            try {
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                raf.seek(number);
                raf.read(bt, 0, text.length());
                String text2 = convertByteToString(bt);
                raf.seek(raf.length());
                if (text.equals(text2)) {
                    raf.writeBytes("true");
                } else {
                    raf.writeBytes("false");
                }
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String convertByteToString (byte readBytes[]) {
        return new String(readBytes);
    }
}
