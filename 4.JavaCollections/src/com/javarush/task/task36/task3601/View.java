package com.javarush.task.task36.task3601;

public class View {
    public void fireEventShowData() {
        Controller c = new Controller();
        System.out.println(c.onDataListShow());
    }
}
