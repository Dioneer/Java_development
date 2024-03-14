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
    private final List<ClientController> clientControllers;

    private JButton btnStart, btnStop;
    private JTextArea log;
    public boolean work;

    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        clientControllers = new ArrayList<>();
        setVisible(true);
    }
    public void setServerController(ServerController serverController){
        this.serverController = serverController;
    }
    public List<ClientController> getClientControllers() {
        return clientControllers;
    }
    @Override
    public void message(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
        serverController.saveInLog(text);
    }
    @Override
    public void answerAll(String text){
        for ( ClientController  clientController: clientControllers){
            clientController.showOnWindow(text);
        }
    }
    @Override
    public void appendLog(String text){
        log.append(text + "\n");
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
            if (work){
                appendLog("Сервер уже был запущен");
            } else {
                work = true;
                appendLog("Сервер запущен!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!work){
                appendLog("Сервер уже был остановлен");
            } else {
                work = false;
                while (!clientControllers.isEmpty()){
                    serverController.disconnectUser(clientControllers.get(clientControllers.size()-1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
