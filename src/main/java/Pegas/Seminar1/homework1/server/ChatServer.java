package Pegas.Seminar1.homework1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener{
    public static void main(String[] args) {
        new ChatServer();
    }
    private final ArrayList<TCPConnection>connections = new ArrayList<>();
    private ChatServer(){
        System.out.println("Server running...");
        try(ServerSocket serversocket = new ServerSocket(8081)){
            while(true){
                try{
                    new TCPConnection(this, serversocket.accept());
                }catch (IOException e){
                    System.out.println("TCPConnection exception: "+e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: "+ tcpConnection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Client disConnected: "+ tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exception: "+e);
    }

    private void sendToAllConnections(String value){
        System.out.println(value);
        for (TCPConnection i: connections){
            i.sendString(value);
        }
    }
}
