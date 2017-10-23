package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов — нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String original =outputStream.toString();

        System.setOut(consoleStream);


        System.out.println(calculate(original));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static String calculate (String s){
        String[] strings = s.split("[\\s]");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[2]);
        String opeparion = strings[1];
        if (opeparion.equals("+"))
            return String.format("%s + %s = %s", a, b, (a + b));
        else if (opeparion.equals("-"))
            return String.format("%s - %s = %s", a, b, (a - b));
        if (opeparion.equals("*"))
            return String.format("%s * %s = %s", a, b, (a * b));
        return s;
    }




}

