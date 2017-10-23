package com.javarush.task.task25.task2506;

public class LoggingStateThread extends  Thread {
    private Thread thread;

    @Override
    public void run() {
        State state = this.thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.thread.getState())
            {
                state = this.thread.getState();
                System.out.println(state);
            }
        }
    }

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }
}
