package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент — полный путь к файлу fileName.
Второй аргумент — путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию ‘new‘.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String zipPath = args[1];
        String fileName = new File(filePath).getName();
        Map<String, ByteArrayOutputStream> zipFiles = new HashMap<>();

        //сохранить содержимое всех энтри
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;

                while ((count = zis.read(buffer)) != -1)
                    stream.write(buffer, 0, count);
                zipFiles.put(entry.getName(), stream);
            }
        }

        //записать в архив все энтри вместе с добавленным файлом
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))){
            //проход по всем энтри
            for (Map.Entry<String, ByteArrayOutputStream> pair : zipFiles.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(fileName))
                    continue;
                zos.putNextEntry(new ZipEntry(pair.getKey()));
                zos.write(pair.getValue().toByteArray());
            }


            //запись нового файла
            ZipEntry zipEntry = new ZipEntry("new/" + filePath);
            zos.putNextEntry(zipEntry);
            Files.copy(Paths.get(filePath), zos);
        }
    }

}
