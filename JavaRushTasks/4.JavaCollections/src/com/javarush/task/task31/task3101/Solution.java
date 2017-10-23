package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя существующего файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
*/
public class Solution {

    private static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        String resultFileAbsolutePath = args[1];


        //сканируем папки и отбираем файлы
        scanDirectories(path);

        //сортируем
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });

        //если список файлов случайно содержит файл для результатов - удаляем его из списка
        fileList.remove(new File(resultFileAbsolutePath));

        //переименовываем файл результатов

        Path resFile = Paths.get(resultFileAbsolutePath);
        //Path renamedResFile = Files.move(resFile, resFile.resolveSibling("allFilesContent.txt"));
        File source = new File(path.toString(),resultFileAbsolutePath);
        File destination = new File(path + "\\allFilesContent.txt");
        FileUtils.renameFile(source, destination);


        //Пишем содержимое отобранных файлов в переименованный файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            //BufferedWriter writer = new BufferedWriter(new FileWriter(renamedResFile.toFile()));

            for (File file : fileList) {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }
                reader.close();
            }

        }


    }

    public static void scanDirectories(File path) {

        // Перебираем все папки и файлы начиная со стартового пути
        for (File file : path.listFiles()) {
            //если это каталог
            if (file.isDirectory())  {

                //если не пуст, то вызываем этот метод повторно
                if (file.listFiles().length != 0) {
                    scanDirectories(file);
                }

                //если пуст - удаляем
                else {
                    file.delete();
                }
            }
            else {

                if (file.length() > 50) {
                    file.delete();
                }
                else {
                    fileList.add(file);
                }
            }
        }

    }





}
