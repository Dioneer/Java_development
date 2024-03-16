package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import java.util.List;

public interface ServerView {
    void setServerController(ServerController serverController);
    void showMessage(String msg);
}
