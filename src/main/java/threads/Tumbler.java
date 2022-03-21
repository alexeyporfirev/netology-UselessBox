package threads;

import java.util.Random;

public class Tumbler {

    private volatile boolean tumbler;
    private int timeout;
    private int maxIteration;
    private int currentIteration;
    private Random rand;


    /**
     * Создание объекта-тумблера с заданным временем периодичности включения и кол-вом итераций работы
     * @param timeout Заданное временя периодичности включения
     * @param maxIteration Кол-во итераций работы
     */
    public Tumbler(int timeout, int maxIteration) {
        this.timeout = timeout;
        this.maxIteration = maxIteration;
        this.rand = new Random();
    }


    /**
     * Включение тумблера
     */
    public void tumblerOn() {
        while (currentIteration < maxIteration) {
            if (!tumbler) {
                System.out.println("Игрок переключил тумблер.");
                tumbler = true;
                currentIteration++;
            }
            try {
                Thread.currentThread().sleep(rand.nextInt(timeout));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Выключение тумблера
     */
    public void tumblerOff() {
        while(!Thread.currentThread().isInterrupted()) {
            if(tumbler) {
                System.out.println("Коробка сбросила тумблер.\n----------------");
                tumbler = false;
            }
        }
    }
}

