package Pegas.Seminar1.homework1.client;

import Pegas.Seminar1.homework1.server.ServerWindow;
import Pegas.Seminar1.homework1.server.TCPConnection;
import Pegas.Seminar1.homework1.server.TCPConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ClientGUI extends JFrame implements TCPConnectionListener {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 300;
    private final JButton btnSend;
    private final JButton btnLogin;
    private final JPanel panelTop;
    private final JPanel panelBottom;
    private final JTextField ip;
    private final JPasswordField pass;
    private final JTextField message;
    private final JTextArea clientMessage;
    private final String[] userName = {"Vasya","Masha","Sasha"};
    private final String[] userPort= {"4561","8086","8081"};
    private JComboBox<String> cbFirst;
    private JComboBox<String> cbSecond;
    private DefaultComboBoxModel<String> cbModel1;
    private DefaultComboBoxModel<String> cbModel2;
    private ServerWindow serverWindow;
    private TCPConnection connection;

    public ClientGUI(ServerWindow serverWindow) throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        setResizable(false);
        setAlwaysOnTop(true);
        btnSend = new JButton("Send");
        btnLogin = new JButton("Login");
        panelTop = new JPanel(new GridLayout(2,3));
        panelBottom = new JPanel(new BorderLayout());
        ip = new JTextField("127.0.0.1");
        cbModel1 = new DefaultComboBoxModel();
        cbModel2 = new DefaultComboBoxModel();
        List<String> list1 = Arrays.asList(userPort);
        List<String> list2 = Arrays.asList(userName);
        cbModel1.addAll(list1);
        cbModel1.setSelectedItem("8081");
        cbModel2.addAll(list2);
        cbModel2.setSelectedItem("Vasya");
        cbFirst = new JComboBox(cbModel1);
        pass= new JPasswordField("123456");
        message = new JTextField();
        cbSecond = new JComboBox(cbModel2);
        clientMessage = new JTextArea();
        clientMessage.setEditable(false);
        clientMessage.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(clientMessage);
        panelTop.add(ip);
        panelTop.add(cbFirst);
        panelTop.add(new JLabel(""));
        panelTop.add(cbSecond);
        panelTop.add(pass);
        panelTop.add(btnLogin);
        panelBottom.add(message, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(scrollPane);
        add(panelBottom, BorderLayout.SOUTH);
        btnSend.addActionListener(e->{
            clientMessage.append(message.getText()+"\r\n");
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/Pegas/log.txt", true))){
                bw.write(cbSecond.getSelectedItem()+": "+message.getText()+"\r\n");
                bw.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            serverWindow.addMsg(cbSecond.getSelectedItem()+": "+message.getText());
            message.setText("");
        });
        if(serverWindow.isFocusableWindow()){
            setVisible(true);
            connection = new TCPConnection(this, "127.0.0.1", 8081);
                try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/Pegas/log.txt"))){
                    String st;
                    while((st = br.readLine())!=null) {
                        clientMessage.append(st+"\r\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        System.out.println("Connection ready");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }
    private synchronized void printMsg(String msg){
        SwingUtilities.invokeLater(()->{
            System.out.println(msg+"\n");
        });
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        System.out.println("Connection close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("Connection exception");
    }
}
