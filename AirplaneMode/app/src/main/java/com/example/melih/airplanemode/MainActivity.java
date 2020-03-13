package com.example.melih.airplanemode;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AirplaneReceiver airRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airRec = new AirplaneReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");

        registerReceiver(airRec,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(airRec);
    }
}
