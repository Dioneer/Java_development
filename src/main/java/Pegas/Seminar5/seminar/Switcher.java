package Pegas.Seminar5.seminar;

public class Switcher {

    private static volatile Boolean switcher = false;

    public static void main(String[] args) {
        Thread tr1 = new Thread(()->{
            while (true){
                switcher = !switcher;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread tr2 = new Thread(()->{
            int ii = 100;
            while(ii>0){
                if(switcher){
                    System.out.println(ii--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        tr1.start();
        tr2.start();
    }
}
