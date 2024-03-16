package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private ServerController serverController;

    private JButton btnStart, btnStop;
    private JTextArea log;

    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
    }
    @Override
    public void setServerController(ServerController serverController){
        this.serverController = serverController;
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(e -> {
            serverController.start();
        });

        btnStop.addActionListener(e -> {
            serverController.stop();
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
    @Override
    public void showMessage(String msg) {
        log.append(msg + "\n");
    }
}
