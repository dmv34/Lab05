package com.example.drew.lab05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPrefs;
    private TextView prefTextView;

    // onCreate starts up the main activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefTextView = (TextView) findViewById(R.id.prefText);
        setPrefTextView();

    }
    //refreshes the preference viewer whenever returning to main activity
    @Override
    protected void onResume() {
        super.onResume();
        setPrefTextView();
    }

    //creates the menu in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // method is run when an Item is selected in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Determines what item was selected
        switch (item.getItemId()) {
            case R.id.show_about:
                //opens the new activity (about page)
                Intent aboutIntent = new Intent(this, AboutActivity.class);
                startActivity(aboutIntent);
                return true;

            case R.id.settings:     //opens settings tab
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //simple funciton that sets the pref text view to the correct value selected in settings page
    public void setPrefTextView(){
        prefTextView.setText("Preference: " + myPrefs.getBoolean("pref_test1", true));
    }

}
