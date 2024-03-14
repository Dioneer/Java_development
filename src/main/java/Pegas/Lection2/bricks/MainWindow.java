package Pegas.Lection2.bricks;

import Pegas.Lection2.circle.BackGround;
import Pegas.Lection2.circle.Ball;
import Pegas.Lection2.common.CanvasRepaintListener;
import Pegas.Lection2.common.MainCanvas;
import Pegas.Lection2.common.UpdRen;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame  implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y= 200;
    private static final int WIDTH= 800;
    private static final int HEIGHT= 600;
    private final UpdRen[] sprites = new UpdRen[10];
    private final BackGround backGround = new BackGround();

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Brick();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, float deltaTime, Graphics g){
        update(canvas, deltaTime);
        render(canvas,g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        backGround.update(canvas, deltaTime);
    }

    private void render(MainCanvas canvas,Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        backGround.render(canvas, g);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
