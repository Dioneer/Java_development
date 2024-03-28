package Pegas.Seminar6;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Player {
    private Map<Integer, Boolean> score;
    private final String name;

    public Player(String name) {
        this.score = new HashMap<>();
        this.name = name;
    }
}
