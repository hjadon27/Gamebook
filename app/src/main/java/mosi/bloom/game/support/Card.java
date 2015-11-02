package mosi.bloom.game.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {



    public static Map<Integer, Card> cardMap;
    static List<Card> deck = new ArrayList<Card>();

    public Card(String value){
        super();
        this.value=value;
    }

    private Integer cardId;
    private String value ;
    private Boolean exposed;

    public static Card createCard(int id,String cardValue){
        if(cardMap==null){
            cardMap = new HashMap<Integer, Card>();
        }
        Card card = new Card(cardValue);
        card.setExposed(false);
        card.setCardId(id);

        deck.add(card);
        cardMap.put(id, card);
        return card;
    }


    public Integer getCardId() {
        return cardId;
    }
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getExposed() {
        return exposed;
    }

    public void setExposed(Boolean exposed) {
        this.exposed = exposed;
    }

    @Override
    public String toString() {
        return cardId + ":[" + value + "," + exposed + "]";
    }

    public static Map<Integer, Card> getCardMap() {
        return cardMap;
    }

    public static void setCardMap(Map<Integer, Card> cardMap) {
        Card.cardMap = cardMap;
    }

    public static List<Card> getDeck() {
        return deck;
    }

    public static List<Card> getDeck(boolean shuffle) {
        if(shuffle)
        Collections.shuffle(deck);
        return deck;
    }

    public static void setDeck(List<Card> deck) {
        Card.deck = deck;
    }
}

