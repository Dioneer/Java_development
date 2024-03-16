package Pegas.Seminar3.Seminar;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Box <T extends Fruit>{
    private final List<T> container;

    public Box() {
        this.container = new ArrayList<>();
    }

    public void add(T fruit){
        container.add(fruit);
    }

    public T get(int index){
        return container.get(index);
    }
    public void  print(){
        System.out.println(getWeight());
    }
    private float getWeight(){
        return container.get(0).getWeight() * container.size();
    }
    public boolean compareByWeight(Box<?> with){
        return getWeight() == with.getWeight();
    }
    public void trnsferTo(Box<? super T> dest){
        dest.container.addAll(container);
        this.container.clear();
    }
}
