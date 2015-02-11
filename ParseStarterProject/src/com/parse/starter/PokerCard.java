package com.parse.starter;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Caleb on 2/9/2015.
 */
public class PokerCard implements Card {
    private final String LOG_TAG = this.getClass().getSimpleName();

    private String STATE_DECK = "deck";

    private ArrayList<String> SUITS = new ArrayList<String>();
    private ArrayList<String> VALUES = new ArrayList<String>();
    private String suit;
    private String value;
    private String state;

    public PokerCard (String suit, String value) throws InvalidValueException {
        initializeConstants();
        this.suit = suit;
        this.value = value;
        state = STATE_DECK;
    }

    private void initializeConstants() {
        SUITS.add("heart");
        SUITS.add("diamond");
        SUITS.add("club");
        SUITS.add("spade");
        VALUES.add("A");
        VALUES.add("2");
        VALUES.add("3");
        VALUES.add("4");
        VALUES.add("5");
        VALUES.add("6");
        VALUES.add("7");
        VALUES.add("8");
        VALUES.add("9");
        VALUES.add("10");
        VALUES.add("J");
        VALUES.add("Q");
        VALUES.add("K");
    }

    public String getColor(String suit) {
        if (suit.equals("heart") || suit.equals("diamond")) {
            return "red";
        } else {
            return "black";
        }
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
