package com.javarush.task.task36.task3601;

import java.util.List;

public class Controller {

    public List<String> onDataListShow() {
        Model m = new Model();
        return m.getStringDataList();
    }
}
