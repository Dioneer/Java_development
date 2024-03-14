package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

public class ServerController implements ServerView{
    private ServerWindow serverWindow;

    @Override
    public void disconnectUser(ClientController clientController) {
        serverWindow.disconnectUser(clientController);
    }

    @Override
    public boolean connectUser(ClientController clientController) {
        return serverWindow.connectUser(clientController);
    }

    @Override
    public String getHistory() {
        return serverWindow.getLog();
    }

    @Override
    public void message(String string) {
        serverWindow.message(string);
    }

    @Override
    public void setServerView(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
    }
}
