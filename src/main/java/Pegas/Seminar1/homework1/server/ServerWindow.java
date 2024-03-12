package Pegas.Seminar1.homework1.server;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 300;
    private final JButton btnStart;
    private final JButton btnStop;
    private final JTextArea serverMessage;
    private boolean isServerWorking;

    public ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Server");
        setResizable(false);
        setAlwaysOnTop(true);
        serverMessage = new JTextArea();
        JPanel panel = new JPanel(new GridLayout(1,2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        JScrollPane scrollPane = new JScrollPane(serverMessage);
        btnStart.addActionListener(e->{
            if(isServerWorking) {
                serverMessage.append("Server already started\n");
            }else{
                isServerWorking = true;
                serverMessage.append("Server started\n");
            }
        });
        btnStop.addActionListener(e-> {
            if(isServerWorking) {
                isServerWorking = false;
                System.exit(0);
                serverMessage.append("Server stopped\n");
            }else{
                serverMessage.append("Server is not working\n");
            }

        });
        panel.add(btnStart);
        panel.add(btnStop);
        add(scrollPane);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
        serverLog();

    }
    public void serverLog(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/Pegas/log.txt"))){
            String st;
            while((st = br.readLine())!=null) {
                serverMessage.append(st+"\r\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMsg(String msg){
        serverMessage.append(msg+"\r\n");
    }
}
