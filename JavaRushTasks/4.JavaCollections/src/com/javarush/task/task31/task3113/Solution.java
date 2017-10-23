package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.
*/
public class Solution {
    private static int totalDirectoris = 0;
    private static int totalFiles = 0;
    private static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String directory = br.readLine();

        if (!Files.isDirectory(Paths.get(directory))) {
            System.out.println(Paths.get(directory) + " - не папка");
            return;
        }

        Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                totalDirectoris++;
                return FileVisitResult.CONTINUE;
            }


            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                totalFiles++;
                totalSize += attrs.size();

                return FileVisitResult.CONTINUE;
            }
        });

        System.out.println("Всего папок - " + (totalDirectoris-1));
        System.out.println("Всего файлов - " + totalFiles);
        System.out.println("Общий размер - " + totalSize);
    }

}

