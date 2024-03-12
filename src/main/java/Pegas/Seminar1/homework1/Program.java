package Pegas.Seminar1.homework1;

import Pegas.Seminar1.homework1.client.ClientGUI;
import Pegas.Seminar1.homework1.server.ServerWindow;

import javax.swing.*;
import java.io.IOException;

public class Program extends JFrame{
    public static void main(String[] args) throws IOException {
                ServerWindow serverWindow = new ServerWindow();
                ClientGUI clientGUI1 = new ClientGUI(serverWindow);
                ClientGUI clientGUI2 = new ClientGUI(serverWindow);
    }
}
