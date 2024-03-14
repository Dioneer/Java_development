package Pegas.Lection2.common;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, float deltaTime, Graphics g);
}
