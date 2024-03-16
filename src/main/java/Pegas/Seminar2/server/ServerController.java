package Pegas.Seminar2.server;

import Pegas.Seminar2.client.ClientController;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerController{
    private ServerView serverView;
    public static final String LOG_PATH = "./src/main/java/log.txt";
    private final List<ClientController> clientControllers;
    public boolean work;

    public ServerController() {
        this.clientControllers = new ArrayList<>();
    }

    public void disconnectUser(ClientController clientController) {
        clientControllers.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }

    public boolean connectUser(ClientController clientController) {
        if (work){
            return false;
        }
        clientControllers.add(clientController);
        return true;
    }

    public String getHistory() {
        return readLog();
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void message(String text){
        if (!work){
            return;
        }
        serverView.showMessage(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for ( ClientController  clientController: clientControllers){
            clientController.showOnWindow(text);
        }
    }
    public void start(){
        if (work){
            serverView.showMessage("Сервер уже был запущен");
        } else {
           work = true;
            serverView.showMessage("Сервер запущен!");
        }
    }
    public void stop(){
        if (!work){
            serverView.showMessage("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientControllers.isEmpty()){
                disconnectUser(clientControllers.get(clientControllers.size()-1));
            }
            serverView.showMessage("Сервер остановлен!");
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


    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }
}
