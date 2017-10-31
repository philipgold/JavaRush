package com.javarush.task.task34.task3402;

/**
Факториал с помощью рекурсии
 Почитай про вычисление факториала.
 Реализуй рекурсивную логику метода factorial, где n — это число, факториал которого нужно вычислить.
 Не создавай в классе Solution дополнительные поля.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
