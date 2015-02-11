package com.parse.starter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class ParseStarterProjectActivity extends Activity {

    private SaveCardFragment saveCardFragment;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        if (savedInstanceState == null) {
            saveCardFragment = new SaveCardFragment();
            getFragmentManager().beginTransaction()
                .add(R.id.container, saveCardFragment)
                .commit();
        }

		ParseAnalytics.trackAppOpenedInBackground(getIntent());
	}
}
