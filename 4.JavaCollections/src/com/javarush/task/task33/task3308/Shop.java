package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Shop {
    @XmlElement(name = "goods", nillable = true)
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods{
        @XmlElement(name = "names")
        public List<String> names = new ArrayList<>();
    }
}


