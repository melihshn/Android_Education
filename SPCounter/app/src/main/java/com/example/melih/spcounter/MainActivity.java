package com.example.melih.spcounter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text1);

        sp = getSharedPreferences("startCount",MODE_PRIVATE);
        editor = sp.edit();

        int counter = sp.getInt("count",0);

        editor.putInt("count",++counter);
        editor.commit();

        text.setText("Counter : "+String.valueOf(counter));
    }
}
