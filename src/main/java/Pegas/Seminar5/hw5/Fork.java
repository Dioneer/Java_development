package Pegas.Seminar5.hw5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fork {
    private boolean isUsing;

    public Fork() {
        this.isUsing = false;
    }

}
