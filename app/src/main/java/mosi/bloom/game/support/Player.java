package mosi.bloom.game.support;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 12-10-2015.
 */
public class Player {
    private String playerName;
    int state, counter = 0;
    Card click1, click2;

    static List<String> faces = new ArrayList<>();


    public Player(String name){
        super();
        playerName = name;
        faces.add("bin");faces.add("ragon");faces.add("camera");faces.add("drov");
        faces.add("zero");faces.add("cross");faces.add("lense");faces.add("vallet");
    }

    public static Player createPlayer(String pName){
        Player player = new Player(pName);
        return player;
    }


    public List<Card> init() {
        Card.getDeck().clear();
        for (int id = 0; id < 16; id++) {
            int value = id;
            if (value > 7) {
                value -= 8;
            }
            String cardValue = faces.get(value);
            Card.createCard(id, cardValue);
        }
        return Card.getDeck();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}