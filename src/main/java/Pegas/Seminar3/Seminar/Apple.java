package Pegas.Seminar3.Seminar;

import lombok.ToString;

@ToString
public class Apple implements Fruit {
    public static final float weight = 1.5f;

    @Override
    public float getWeight() {
        return weight;
    }
}
