package com.example.melih.bundlesum;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button buttonBack;
    private TextView textSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        buttonBack = findViewById(R.id.buttonBack);
        textSonuc = findViewById(R.id.textSonuc);

        Bundle aliciBundle = getIntent().getExtras();
        Double gelen = aliciBundle.getDouble("sonuc");

        textSonuc.setText(Double.toString(gelen));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent(Activity2.this,MainActivity.class);

                startActivity(backIntent);
            }
        });
    }
}
