package Pegas.Seminar1.homework1.server;

import java.io.*;
import java.net.Socket;

public class TCPConnection {
    private final TCPConnectionListener listener;
    private final Socket socket;
    private Thread tr = null;

    public TCPConnection(TCPConnectionListener listener, String ip, int port)throws IOException  {
        this(listener, new Socket(ip, port));
    }

    public TCPConnection(TCPConnectionListener listener, Socket socket) throws IOException {
        this.listener = listener;
        this.socket = socket;
        try(BufferedReader  br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            tr = new Thread(() -> {
                try {
                    listener.onConnectionReady(TCPConnection.this);
                    while (!tr.isInterrupted()){
                        listener.onReceiveString(TCPConnection.this, br.readLine());
                    }
                    String msg = br.readLine();
                } catch (IOException e) {
                    listener.onException(TCPConnection.this, e);
                }finally {
                    listener.onDisconnect(TCPConnection.this);
                }

            });
            tr.start();
        }
    }
    public synchronized void sendString(String value) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            bw.write(value+"\r\n");
            bw.flush();
        } catch (IOException e) {
            listener.onException(TCPConnection.this, e);
            disconnect();
        }
    }
        public synchronized void disconnect(){
        tr.interrupt();
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
