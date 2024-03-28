package Pegas.Seminar6;

public class Main {
    public static void main(String[] args) {
        MakeADeal makeADeal = new MakeADeal(2, 1000).init();
        System.out.println(makeADeal.count());
    }
}

