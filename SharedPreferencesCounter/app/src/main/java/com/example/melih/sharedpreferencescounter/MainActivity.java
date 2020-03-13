package com.example.melih.sharedpreferencescounter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private SharedPreferences sp;
    private SharedPreferences.Editor e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("PersonalData",MODE_PRIVATE);
        e = sp.edit();
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e.putString("name","Radamel");
                e.putString("surname","Falcao");
                e.putInt("age",33);
                e.putFloat("height",1.77f);

                e.commit();

                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }
}
