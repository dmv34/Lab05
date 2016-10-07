package com.example.drew.lab05;

import android.app.Activity;
import android.os.Bundle;


public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lab04 - About Page");
        //links preferences to activity
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment() )
                .commit();


    }
}
