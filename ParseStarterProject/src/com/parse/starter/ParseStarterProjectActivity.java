package com.parse.starter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class ParseStarterProjectActivity extends Activity {

    private SaveCardFragment saveCardFragment;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        if (savedInstanceState == null) {
            saveCardFragment = new SaveCardFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(saveCardFragment, "SaveCardFragment").commit();
        }

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "head");
        testObject.saveInBackground();

		ParseAnalytics.trackAppOpenedInBackground(getIntent());
	}
}
