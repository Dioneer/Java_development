package Pegas.Seminar5.seminar;

public class DeadLock {
    record Animal(String name) {
        public synchronized void bow(Animal animal) {
            System.out.println("animal " + animal.name +" bow");
            animal.bowback(this);
        }

        public synchronized void bowback(Animal animal) {
            System.out.println("animal " + animal.name+" bowback");
        }
    }
}
class Program{
    public static void main(String[] args) {
        DeadLock.Animal vinny = new DeadLock.Animal("Vinny");
        DeadLock.Animal pookh = new DeadLock.Animal("Pookh");
        Runnable runnable1 = () -> {
            vinny.bow(pookh);
        };
        Runnable runnable2 = () -> {
            pookh.bow(vinny);
        };
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}