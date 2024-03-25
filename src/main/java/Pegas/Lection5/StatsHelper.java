package Pegas.Lection5;

import java.util.Scanner;

public class StatsHelper {
    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(()->{
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()) {
                in.nextLine();
                cnt++;
            }
        });
        readThread.start();
        while (true){
            System.out.println(cnt+" message input user");
            Thread.sleep(1000);
        }
    }
}
