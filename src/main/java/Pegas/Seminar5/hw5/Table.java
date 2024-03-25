package Pegas.Seminar5.hw5;


public class Table {
    private static final int COUNT = 5;
    private final Philosophy[] senate= new Philosophy[COUNT];
    private final Fork[] forks= new Fork[COUNT];

    public void putFork(int left, int right){
        forks[left].setUsing(false);
        forks[right].setUsing(false);
    }

    public synchronized boolean pickUpFork(int left, int right){
        if(!forks[left].isUsing() && !forks[right].isUsing()){
            forks[left].setUsing(true);
            forks[right].setUsing(true);
            return true;
        }
        return false;
    }

    public void start(){
        for (int i = 0; i < COUNT; i++) {
            forks[i] = new Fork();
        }
        for (int i = 1; i <= COUNT; i++) {
            senate[i-1] = new Philosophy("Philosophy "+i, i-1, (i)%COUNT, this);
        }
        for (Philosophy i: senate){
            new Thread(i).start();
        }
    }
}
