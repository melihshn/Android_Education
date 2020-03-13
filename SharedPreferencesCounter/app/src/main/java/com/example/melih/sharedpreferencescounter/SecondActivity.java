package com.example.melih.sharedpreferencescounter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private Button button_re,button_up;
    private TextView textOut;
    private SharedPreferences sp;
    private SharedPreferences.Editor e;
    private String name, surname;
    private int age;
    private float height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp = getSharedPreferences("PersonalData",MODE_PRIVATE);
        e = sp.edit();
        button_re = findViewById(R.id.button_re);
        button_up = findViewById(R.id.button_up);
        textOut = findViewById(R.id.text1);

        name = sp.getString("name","");
        surname = sp.getString("surname","");
        age = sp.getInt("age",0);
        height = sp.getFloat("height",0.0f);

        textOut.setText("Name : "+name+"\n"+"Surname : "+surname+"\n"+"Age : "+age+"\n"+"Height : "+height);

        button_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e.remove("name");
                e.remove("surname");
                e.commit();

                name = sp.getString("name","");
                surname = sp.getString("surname","");
                textOut.setText("Name : "+name+"\n"+"Surname : "+surname+"\n"+"Age : "+age+"\n"+"Height : "+height);
            }
        });

        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e.putString("name","Abdürrahim");
                e.putString("surname","Albayrak");
                e.commit();

                name = sp.getString("name","");
                surname = sp.getString("surname","");

                textOut.setText("Name : "+name+"\n"+"Surname : "+surname+"\n"+"Age : "+age+"\n"+"Height : "+height);
            }
        });
    }
}
