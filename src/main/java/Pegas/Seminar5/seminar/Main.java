package Pegas.Seminar5.seminar;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(4);
        new Thread(new Runner("Sima",count)).start();
        new Thread(new Runner("Kira",count)).start();
        new Thread(new Runner("Dima",count)).start();
        while (count.getCount() != 1){

        }
        System.out.println("Ready");
        Thread.sleep(1000);
        System.out.println("Steady");
        Thread.sleep(1000);
        System.out.println("Go");
        Thread.sleep(1000);
        count.countDown();
    }
}
