package application;


import threads.Tumbler;

public class Main {

    private static final int MAX_TIMEOUT = 1000;
    private static final int MAX_ITERATION = 10;

    public static void main(String[] args) throws InterruptedException {
        Tumbler tumbler = new Tumbler(MAX_TIMEOUT, MAX_ITERATION);

        Thread user = new Thread(null, tumbler::tumblerOn, "Игрок");
        Thread box = new Thread(null, tumbler::tumblerOff, "Коробка");

        user.start();
        box.start();

        user.join();
        box.interrupt();

    }

}
