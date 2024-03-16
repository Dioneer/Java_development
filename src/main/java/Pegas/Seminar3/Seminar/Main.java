package Pegas.Seminar3.Seminar;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        for (int i = 0; i < 3; i++) {
            appleBox.add(new Apple());
            orangeBox.add(new Orange());
            fruitBox.add(new Apple());
            fruitBox.add(new Orange());
        }
        System.out.println(appleBox.compareByWeight(orangeBox));
        appleBox.trnsferTo(fruitBox);
        System.out.println(fruitBox);

        for (Integer i: MuIterator.fromTo(5,25)){
            System.out.println(i);
        }

    }


}
class MuIterator<T extends Integer> implements Iterable<Integer>{
    private Integer from;
    private Integer to;

    private MuIterator(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public static MuIterator<Integer> fromTo(Integer from, Integer to){
        return new MuIterator<>(from, to);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIter(to);
    }

    class MyIter implements Iterator<Integer> {
        private Integer to;
        public MyIter(Integer to) {
            this.to = to;
        }

        @Override
        public boolean hasNext() {
            if(from<=to)return true;
            return false;
        }

        @Override
        public Integer next() {
            return Integer.valueOf(from++);
        }
    }

}
