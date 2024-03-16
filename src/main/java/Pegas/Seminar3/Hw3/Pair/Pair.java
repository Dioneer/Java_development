package Pegas.Seminar3.Hw3.Pair;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Pair <T, E>{
    private final T first;
    private final E second;
}
class Main{
    public static void main(String[] args) {
        Pair<Integer, String> obj = new Pair<>(8, "Big Bro");
        System.out.println(obj);
    }
}
