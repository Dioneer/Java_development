package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

public interface ServerView {
    void disconnectUser(ClientController clientController);
    boolean connectUser(ClientController clientController);
    String getHistory();
    void message(String string);
    void setServerView(ServerWindow serverWindow);
}
