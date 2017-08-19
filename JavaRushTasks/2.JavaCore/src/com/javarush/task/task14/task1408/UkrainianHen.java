package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 15;
    }

    @Override
    public String getDescription(){
        String t= String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.UKRAINE,
                this.getCountOfEggsPerMonth());
        return t;
    }
}
