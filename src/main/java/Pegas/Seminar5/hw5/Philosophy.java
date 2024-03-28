package Pegas.Seminar5.hw5;

public class Philosophy implements Runnable{
    private final Table table;
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countForEat;

    public Philosophy(String name, int leftFork, int rightFork, Table table) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.countForEat = 0;
        this.table = table;
    }

    public void think() throws InterruptedException {
        System.out.println("philosophy " +name+ " think");
        Thread.sleep(5000);
    }

    public void eat() throws InterruptedException {
        if(table.pickUpFork(leftFork, rightFork)) {
            System.out.println("philosophy " + name + " pick up forks: " + leftFork +" and "+ rightFork);
            Thread.sleep(300);
            System.out.println("philosophy " + name + " eat");
            Thread.sleep(300);
            table.putFork(leftFork, rightFork);
            System.out.println("philosophy " + name + " put forks: " + leftFork +" and "+ rightFork);
            countForEat++;
        }
    }

    @Override
    public void run() {
        try {
            while (countForEat<3) {
                think();
                eat();
            }
            System.out.println(name+ " is finish eating");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
