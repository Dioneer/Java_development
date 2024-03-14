package Pegas.Lection2.bricks;

import Pegas.Lection2.circle.BackGround;
import Pegas.Lection2.circle.Ball;
import Pegas.Lection2.circle.MainWindow;
import Pegas.Lection2.common.MainCanvas;
import Pegas.Lection2.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Brick extends Sprite {
    private static Random random = new Random();
    private final Color color;
    private float vX;
    private float vY;
    public Brick(){
        halfHeight = 20 + (float) (Math.random()*50f);
        halfWidth = halfHeight;
        color = new Color(random.nextInt());
        vX = 100f+(float)(Math.random()*200f);
        vY = 100f+(float)(Math.random()*200f);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x+=vX*deltaTime;
        y+=vY*deltaTime;
        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX=-vX;
        }
        if(getRight()>canvas.getRight()){
            setRight(canvas.getRight());
            vX=-vX;
        }
        if(getTop()< canvas.getTop()){
            setTop(canvas.getTop());
            vY=-vY;
        }
        if(getBottom()>canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY=-vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect((int) getLeft(), (int)getTop(),(int)getWidth(), (int)getHeight());
    }

    }
