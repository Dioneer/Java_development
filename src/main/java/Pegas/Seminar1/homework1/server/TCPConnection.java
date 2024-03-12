package Pegas.Seminar1.homework1.server;

import java.io.*;
import java.net.Socket;

public class TCPConnection {
    private final TCPConnectionListener listener;
    private final Socket socket;
    private final Thread tr;
    private final BufferedReader br;
    private final BufferedWriter bw;

    public TCPConnection(TCPConnectionListener listener, String ip, int port)throws IOException  {
        this(listener, new Socket(ip, port));
    }

    public TCPConnection(TCPConnectionListener listener, Socket socket) throws IOException {
        this.listener = listener;
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        tr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listener.onConnectionReady(TCPConnection.this);
                    while (!tr.isInterrupted()){
                        listener.onReceiveString(TCPConnection.this, br.readLine());
                    }
                } catch (IOException e) {
                    listener.onException(TCPConnection.this, e);
                }finally {
                    listener.onDisconnect(TCPConnection.this);
                }
            }
        });tr.start();
    }
    public synchronized void sendString(String value) {
        try{
            bw.write(value+"\r\n");
            bw.flush();
        } catch (IOException e) {
            listener.onException(TCPConnection.this, e);
            disconnect();
        }
    }
        public synchronized void disconnect(){
        tr.interrupted();
        try {
            socket.close();
        } catch (IOException e) {
            listener.onException(TCPConnection.this, e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection{" +
                "socket=" + socket.getInetAddress()+
                ", socket=" + socket.getPort() +
                '}';
    }
}
