package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final String LOG_PATH = "./src/main/java/log.txt";
    private ServerController serverController;

    private final List<ClientController> clientControllers;

    private JButton btnStart, btnStop;
    private JTextArea log;
    public boolean work;

    public ServerWindow(){
        clientControllers = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    public boolean connectUser(ClientController clientController){
        if (!work){
            return false;
        }
        this.clientControllers.add(clientController);
        return true;
    }

    public String getLog() {
        return readLog();
    }

    public void disconnectUser(ClientController clientController){
        clientControllers.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }
    public void setServerController(ServerController serverController){
        this.serverController = serverController;
    }

    public void message(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for ( ClientController  clientController: clientControllers){
            clientController.showOnWindow(text);
        }
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text){
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
                    disconnectUser(clientControllers.get(clientControllers.size()-1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
