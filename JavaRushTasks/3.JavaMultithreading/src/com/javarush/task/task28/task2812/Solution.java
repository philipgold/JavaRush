package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
ShutdownNow!
Разберись в чем отличие методов shutdown и shutdownNow. Выведи список всех незавершенных задач на экран.

Должно получиться что-то вроде:
pool-1-thread-1, localId=1
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
java.util.concurrent.FutureTask@7e6cbb7a was not completed
java.util.concurrent.FutureTask@7c3df479 was not completed
java.util.concurrent.FutureTask@7106e68e was not completed
java.util.concurrent.FutureTask@7eda2dbb was not completed
java.util.concurrent.FutureTask@6576fe71 was not completed
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> list = executor.shutdownNow();
        for (Runnable r: list
                ) {
            System.out.println(r);
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
