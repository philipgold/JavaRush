package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader (ImageTypes imageTypes){
        ImageReader reader = null;
        if (imageTypes == ImageTypes.BMP)
            reader = new BmpReader();
        else if (imageTypes == ImageTypes.JPG)
            reader = new JpgReader();
        else if (imageTypes == ImageTypes.PNG)
            reader = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
        return reader;
    }
}
