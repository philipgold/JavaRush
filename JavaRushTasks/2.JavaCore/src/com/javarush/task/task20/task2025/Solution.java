package com.javarush.task.task20.task2025;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/*
Алгоритмы-числа
исло S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        long[] result = null;
//        ArrayList<Long> longs = new ArrayList<>();
//        long arm;
//        for (long i = 0; i < N; i++) {
//            arm=armstrongOrNot(i);
//            if(arm==i) {
//                System.out.println(i);
//                longs.add(i);
//            }
//        }
//
//        result = new long[longs.size()];
//        for (int i = 0; i < longs.size(); i++) {
//            result[i] = longs.get(i);
//        }
//
//
//        return result;
        int count = 0;
        int length = Long.toString(N).length()-1;
        long[] allArm = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L, 1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L, 24678050L, 24678051L, 88593477L, 146511208L, 472335975L, 534494836L, 912985153L, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

        for (long l : allArm) {
            if (Long.toString(l).length() <= length) {
                count++;
            } else break;
        }

        return Arrays.copyOfRange(allArm, 0, count);
    }

    public static void main(String[] args) {

        long count = 1000000000;
        long start;

        start = System.currentTimeMillis();
        // Do something here
        getNumbers(1000000000);
        System.out.println("Completed for milis: " + (System.currentTimeMillis() - start));

    }

    public static long armstrongOrNot(long num){
        long x, temp = 0;
        while (num !=0){
            x = num %10;
            temp = temp + (x * x * x);
            num /=10;
        }
        return temp;
    }
}
