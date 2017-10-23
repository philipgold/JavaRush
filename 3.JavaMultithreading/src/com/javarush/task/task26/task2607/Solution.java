package com.javarush.task.task26.task2607;

/* 
Вежливость - это искусственно созданное хорошее настроение
В классе Solution создай public static класс IntegerHolder.
IntegerHolder должен быть для типа int (имя переменной должно быть value), быть thread safe и изменяемым.
В этом классе должны быть два public метода get и set.
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static class IntegerHolder{
        private int value;

        public synchronized int get() {
            return value;
        }

        public synchronized void set(int value) {
            this.value = value;
        }
    }
}
