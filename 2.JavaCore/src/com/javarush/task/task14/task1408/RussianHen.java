package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription(){
        String t= String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.RUSSIA,
                this.getCountOfEggsPerMonth());

        return t;
    }
}
