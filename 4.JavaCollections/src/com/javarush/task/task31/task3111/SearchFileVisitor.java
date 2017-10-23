package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = 0;
    private int maxSize = 0;

    private boolean minSizeCheck;
    private boolean maxSizeCheck;
    private boolean partOfNameCheck;
    private boolean partOfContentCheck;

    private List<Path> foundFiles = new ArrayList<>();

    public SearchFileVisitor() {
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.partOfNameCheck = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.partOfContentCheck = true;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.minSizeCheck = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.maxSizeCheck = true;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (partOfNameCheck && !file.getFileName().toString().contains(partOfName)) {
            return FileVisitResult.CONTINUE;
        }

        if (partOfContentCheck && !new String(Files.readAllBytes(file)).contains(partOfContent)) {
            return FileVisitResult.CONTINUE;
        }
        if (minSizeCheck && attrs.size() < minSize) {
            return FileVisitResult.CONTINUE;
        }
        if (maxSizeCheck && attrs.size() > maxSize) {
            return FileVisitResult.CONTINUE;
        }

        foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
}