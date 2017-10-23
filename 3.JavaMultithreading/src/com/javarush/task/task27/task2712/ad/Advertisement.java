package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    /**
     * видео
     */
    private Object content;

    /**
     * имя/название
     */
    private String name;

    /**
     * начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
     */
    private long initialAmount;

    /**
     * количество оплаченных показов
     */
    private int hits;

    /**
     * продолжительность в секундах
     */
    private int duration;

    /**
     * равняться стоимости одного показа рекламного объявления в копейках (initialAmount/hits).
     */
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }


    public void revalidate() {
        if (hits <= 0)
            //Бросать UnsupportedOperationException, если количество показов не положительное число
            throw new UnsupportedOperationException();
        //Уменьшать количество показов
        hits--;
    }
}
