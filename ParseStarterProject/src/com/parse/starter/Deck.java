package com.parse.starter;

import java.util.ArrayList;

/**
 * Created by Caleb on 2/11/2015.
 */
public class Deck {

    private String label;
    private ArrayList<Card> contents;

    public Deck(String label) {
        this.label = label;
        contents = new ArrayList<Card>();
    }

    public Deck(String label, Card card) {
        this.label = label;
        contents = new ArrayList<Card>();
        contents.add(card);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<Card> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Card> contents) {
        this.contents = contents;
    }
}
