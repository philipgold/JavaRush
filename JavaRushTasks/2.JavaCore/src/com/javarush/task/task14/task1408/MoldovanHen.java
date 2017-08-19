package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 5;
    }
    @Override
    public String getDescription(){
        String t= String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.MOLDOVA,
                this.getCountOfEggsPerMonth());

        return t;
    }
}
