package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import java.io.FileReader;
import java.io.FileWriter;

public class ServerController{
    private ServerWindow serverWindow;
    public static final String LOG_PATH = "./src/main/java/log.txt";

    public void disconnectUser(ClientController clientController) {
        serverWindow.getClientControllers().remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }

    public boolean connectUser(ClientController clientController) {
        if (!serverWindow.work){
            return false;
        }
        serverWindow.getClientControllers().add(clientController);
        return true;
    }

    public String getHistory() {
        return readLog();
    }

    public void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void message(String string) {
        serverWindow.message(string);
    }

    public void setServerView(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
    }
}
