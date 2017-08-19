package com.javarush.task.task14.task1408;

public class BelarusianHen extends  Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }
    @Override
    public String getDescription(){
        //String tt = this.getDescription();
        String t= String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.BELARUS,
                5);

        return t;
    }
}
