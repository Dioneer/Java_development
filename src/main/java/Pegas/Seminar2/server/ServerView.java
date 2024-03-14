package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import java.util.List;

public interface ServerView {
    List<ClientController> getClientControllers();
    void message(String string);
    void answerAll(String text);
    void appendLog(String text);
}
