package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
Null Object Pattern
 Почитай на вики про паттерн «Null Object«.
 Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
 Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.


 */
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            boolean isHidden = Files.isHidden(Paths.get(pathToFile));
            boolean isExecutable = Files.isExecutable(Paths.get(pathToFile));
            boolean isDirectory = Files.isDirectory(Paths.get(pathToFile));
            boolean isWritable = Files.isWritable(Paths.get(pathToFile));
            fileData = new ConcreteFileData(isHidden, isExecutable,isDirectory,isWritable);
        } catch (Exception  e) {
            fileData = new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
