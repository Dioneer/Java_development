package Pegas.Seminar3.Seminar;

import lombok.ToString;

@ToString
public class Orange implements Fruit{
    public static final float weight = 1.5f;
    @Override
    public float getWeight() {
        return weight;
    }
}
