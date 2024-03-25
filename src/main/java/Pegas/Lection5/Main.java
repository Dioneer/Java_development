package Pegas.Lection5;

public class Main {
    public static void main(String[] args) {
        Thread tic = new Thread(new TickTack("["));
        Thread tac = new Thread(new TickTack("]"));
        tic.start();
        tac.start();
    }
}
