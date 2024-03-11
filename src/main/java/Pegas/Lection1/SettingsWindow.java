package Pegas.Lection1;

import javax.swing.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    public SettingsWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setLocation(getX()-WINDOW_WIDTH/2, getY()-WINDOW_HEIGHT/2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(0,3,3,3);
            setVisible(false);
        });
        add(btnStart);
    }
}
