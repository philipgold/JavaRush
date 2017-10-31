package com.javarush.task.task34.task3403;

/**
Разложение на множители с помощью рекурсии
 Разложить целое число n > 1 на простые множители.
 Вывести в консоль через пробел все множители в порядке возрастания.
 Написать рекурсивный метод для вычисления простых множителей.
 Не создавай в классе Solution дополнительные поля.

 Пример:
 132

 Вывод на консоль:
 2 2 3 11
*/
public class Solution {
    public void recursion(int n) {
        int a = 2;
        while (a <= n) {
            if ((n % a) == 0) {
                if (a != n) {
                    System.out.print(a + " ");
                    recursion(n / a);
                } else {
                    System.out.print(a);
                }
                return;
            }
            a++;
        }
    }
}
