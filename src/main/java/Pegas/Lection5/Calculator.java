package Pegas.Lection5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Task> queue = new ArrayDeque<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread tasks = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(2000);
                    Task task1  = queue.poll();
                    if(task1 != null) {
                        executorService.submit(() -> {
                            System.out.println("Task " + task1 + " started");
                            task1.run();
                        });
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tasks.start();
        while (in.hasNextLine()){
            String[] num = in.nextLine().split("\\+");
            int left = Integer.parseInt(num[0]);
            int right = Integer.parseInt(num[1]);
            Task task = new Task(left,right);
            queue.add(task);
        }
    }
}
