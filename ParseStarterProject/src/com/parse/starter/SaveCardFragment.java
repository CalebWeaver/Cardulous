package com.parse.starter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by Caleb on 2/9/2015.
 */
public class SaveCardFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private PokerCard saveCard(View v) {

        String value = ((TextView) v.findViewById(R.id.card_value)).getText().toString();
        String suit = ((TextView) v.findViewById(R.id.card_suit)).getText().toString();

        try {
            PokerCard card = new PokerCard(value, suit);

            ParseObject pokerCard = new ParseObject("PokerCard");
            pokerCard.put("value", card.getValue());
            pokerCard.put("suit", card.getSuit());
            pokerCard.saveInBackground();

            return card;
        } catch (InvalidValueException e) {
            Toast.makeText(getActivity(), "Invalid Card Value", Toast.LENGTH_LONG).show();
        }

        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.save_card_layout, container, false);

        Button saveCardButton = (Button) rootView.findViewById(R.id.save_card_button);
        saveCardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveCard(v.getRootView());
            }
        });

        return rootView;
    }
}
