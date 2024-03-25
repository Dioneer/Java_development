package Pegas.Seminar5.seminar;

import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private final String name;
    private CountDownLatch count;

    public Runner(String name, CountDownLatch count) {
        this.name = name;
        this.count = count;
    }

    public void goToStart() throws InterruptedException {
        System.out.println(name + " walking to the start");
        Thread.sleep((long)Math.random()*3000L);
        System.out.println(name + " on start");
        count.countDown();
    }
    public void goToFinish() throws InterruptedException {
            System.out.println(name + " start walking to the finish line");
            Thread.sleep((long) Math.random() * 3000L);
            System.out.println(name + " on finish");
    }

    @Override
    public void run() {
        try {
            goToStart();
            count.await();
            goToFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
