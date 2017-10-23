package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://volume-images-test.s3-eu-west-1.amazonaws.com/1444x350/banner_1588.png", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream reader = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(reader,tempFile);

        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        Path dowloadedFile = Paths.get(downloadDirectory + "/" + fileName);

        return Files.move(tempFile, dowloadedFile);
    }
}
