package com.example.melih.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textdata;
    private Button buttonExit;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textdata = findViewById(R.id.textdata);
        buttonExit = findViewById(R.id.buttonExit);

        sp = getSharedPreferences("LoginData",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","Not Found Username");
        password = sp.getString("password","Not Found Password");

        textdata.setText(username + "\n" + password );

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.remove("username");
                editor.remove("password");
                editor.commit();

                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                finish();
            }
        });


    }
}
