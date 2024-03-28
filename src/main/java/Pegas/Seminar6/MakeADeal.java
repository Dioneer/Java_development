package Pegas.Seminar6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MakeADeal {
    private final int playersCount;
    private final Player[] players;
    private final Random random;
    private final int DOOR = 3;
    private final int rounds;

    public MakeADeal(int playersCount, int rounds) {
        this.random = new Random();
        this.playersCount = playersCount;
        this.players = new Player[playersCount];
        this.rounds = rounds;
    }

    private void playersSet(int playersCount){
        for (int i = 0; i < playersCount; i++) {
            if(i%2==0){
                players[i] = new Player("Player" + (i + 1)+"_change_choice");
            }else {
                players[i] = new Player("Player" + (i + 1) + "_keep_choice");
            }
        }
    }
    public MakeADeal init(){
        playersSet(playersCount);
        gameRounds(rounds);
        return this;
    }

    private void gameRounds(int rounds){
        for (int round = 0; round < rounds; round++) {
            int successDoor = random.nextInt(DOOR);
            int firstChoice = random.nextInt(DOOR);
            gameStart(successDoor, firstChoice, round);
        }
    }

    private void gameStart(int successDoor, int firstChoice, int round){
        int openDoor = -1;
        for (int k = 0; k < DOOR; k++) {
             if(k!=successDoor&&k!= firstChoice)
                 openDoor = k;
        }
        for (int j = 0; j < players.length; j++) {
            System.out.println("Первый выбор "+firstChoice);
            System.out.println("Открытая дверь "+openDoor);
            int secondChoice;
            if(j%2==0){
                for (int m = 0; m < DOOR; m++) {
                    if(m!=firstChoice&&m!=openDoor){
                        secondChoice = m;
                        boolean res = successDoor == secondChoice;
                        players[j].getScore().put(round, res);
                        System.out.println("Выигрышная дверь-"+successDoor+ " игрок "+players[j].getName()+" выбрал "+m);
                    }
                }
            }else{
                boolean res = successDoor == firstChoice;
                players[j].getScore().put(round, res);
                System.out.println("Выигрышная дверь-"+successDoor+ " игрок "+players[j].getName()+" выбрал "+ firstChoice);
            }
        }
    }

    public Map<String, Integer> count(){
        Map<String, Integer> result = new HashMap<>();
        for (Player step: players) {
            int win = 0;
            for (Map.Entry<Integer, Boolean> entry : step.getScore().entrySet()) {
                if (entry.getValue()) {
                    win++;
                }
            }
            result.put(step.getName(), win);
        }
        return result;
    }
}
