package com.example.harsh.activityfragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MesssageFragment.OnMessageReadListener {
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Check whether the fragment container is null or not
        if (findViewById(R.id.fragment_container) != null) {

            //Checking if the activity is resumed or is starting for the first time
            if (savedInstanceState != null) {
                return;
            } else {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MesssageFragment(), null).commit();
            }
        }

    }

    @Override
    public void onMessageRead(String message) {
        messageTextView = findViewById(R.id.txt_message_display);
        messageTextView.setText(message);
    }
}
