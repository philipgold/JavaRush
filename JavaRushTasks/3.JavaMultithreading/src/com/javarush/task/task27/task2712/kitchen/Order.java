package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;
    private String totalCookingTime;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;

        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        if (dishes == null)
            return "";
        return "Your order: " + dishes.toString() +" of "+  tablet.toString();
    }

    /**
     * пределяет есть ли какие либо блюда в заказе
     * @return
     */
    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }

    /**
     *  Подсчитывает суммарное время приготовления всех блюд в заказе
     * @return
     */
    public int getTotalCookingTime() {
        int totalDuration = 0;
        for (Dish dish : dishes) {
            totalDuration += dish.getDuration();
        }
        return totalDuration;
    }


}
