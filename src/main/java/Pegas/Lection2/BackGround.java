package Pegas.Lection2;

import java.awt.*;

public class BackGround implements UpdRen{
    private float time;
    private static final float AMPLITUDE =255f/2f;
    private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        time+=deltaTime*0.2;
        int red = Math.round(AMPLITUDE+AMPLITUDE*(float)Math.sin(time*2f));
        int green = Math.round(AMPLITUDE+AMPLITUDE*(float)Math.sin(time*2f));
        int blue = Math.round(AMPLITUDE+AMPLITUDE*(float)Math.sin(time));
        color = new Color(red,green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
