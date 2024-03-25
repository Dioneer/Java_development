package Pegas.Lection5;

public class TickTack implements Runnable{
    private final String bracket;
    private final Object monitor;

    public TickTack(String bracket) {
        this.bracket = bracket;
        this.monitor = TickTack.class;
    }

    @Override
    public void run() {
        while (true){
            synchronized (monitor) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(bracket);
                monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
