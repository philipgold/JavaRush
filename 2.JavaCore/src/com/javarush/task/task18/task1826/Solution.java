package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    private static byte key = 10;

    public static void main(String[] args) throws IOException {
        if (args.length < 3)
            return;
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);

        while (in.available()>0){
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            System.out.println(Arrays.toString(crypt(bytes)));
            out.write(crypt(bytes));
        }
        in.close();
        out.close();
    }

    private static byte [] crypt(byte[] bytes) {
        byte[] res = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            res[i] = (byte)(bytes[i] ^ key);
        }

        return res;
    }

}
