package com.parse.starter;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import org.w3c.dom.Text;

/**
 * Created by Caleb on 2/9/2015.
 */
public class SaveCardFragment extends Fragment {
    private String LOG_TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.save_card_layout, container, false);

        ((TextView) rootView.findViewById(R.id.card_value)).setTextColor(Color.BLACK);
        ((TextView) rootView.findViewById(R.id.card_suit)).setTextColor(Color.BLACK);
        ((TextView) rootView.findViewById(R.id.deck)).setTextColor(Color.BLACK);

        Button saveCardButton = (Button) rootView.findViewById(R.id.save_card_button);
        saveCardButton.setTextColor(Color.BLACK);
        saveCardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveCard(v.getRootView());
            }
        });

        return rootView;
    }

    private PokerCard saveCard(View v) {

        String value = ((TextView) v.findViewById(R.id.card_value)).getText().toString();
        String suit = ((TextView) v.findViewById(R.id.card_suit)).getText().toString();
        String deckLabel = ((TextView) v.findViewById(R.id.deck)).getText().toString();

        SharedPreferences.Editor editor = getActivity().getSharedPreferences(getActivity().getString(R.string.main_prefs), Context.MODE_PRIVATE).edit();
        editor.putString(getActivity().getString(R.string.pref_deck_label), deckLabel);
        editor.commit();

        try {
            PokerCard card = new PokerCard(value, suit);

            ParseObject pokerCard = new ParseObject("PokerCard");
            pokerCard.put("value", card.getValue());
            pokerCard.put("suit", card.getSuit());
            pokerCard.put("deck", card.getSuit());
            pokerCard.saveInBackground();

            Toast.makeText(getActivity(), "Card Created", Toast.LENGTH_LONG).show();

            return card;
        } catch (InvalidValueException e) {
            Toast.makeText(getActivity(), "Invalid Card Value", Toast.LENGTH_LONG).show();
        }

        return null;
    }
}
