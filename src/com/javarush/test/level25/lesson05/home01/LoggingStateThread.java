package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {
    private Thread target;
    private State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State currentState = target.getState();
        System.out.println(currentState);

        while (state != State.TERMINATED) {
            currentState = target.getState();
            if (currentState != state) {
                state = currentState;
                System.out.println(state);
            }
        }
    }
}