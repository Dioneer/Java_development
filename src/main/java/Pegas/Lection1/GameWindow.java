package Pegas.Lection1;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private final JButton btnStart = new JButton("New Game");
    private final JButton btnExit = new JButton("Exit");
    private final Map map;
    private final SettingsWindow settingsWindow;

    public GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);
        map = new Map();
        settingsWindow = new SettingsWindow(this);
        btnExit.addActionListener(e -> System.exit(0));
        btnStart.addActionListener(e -> settingsWindow.setVisible(true));
        settingsWindow.setVisible(true);
        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }
    void startNewGame(int mode, int zX, int zY, int wLen){
        map.startNewGame(mode, zX, zY, wLen);
    }
}
