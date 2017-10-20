package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger count = new AtomicInteger(0);

    private void updatePriority(){
        this.setPriority(count.incrementAndGet());
        if (count.get()>=10)
            count.set(0);
    }

    public MyThread() {
        updatePriority();
    }

    public MyThread(Runnable target) {
        super(target);
        updatePriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        updatePriority();
    }

    public MyThread(String name) {
        super(name);
        updatePriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        updatePriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        updatePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        updatePriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        updatePriority();
    }
}
