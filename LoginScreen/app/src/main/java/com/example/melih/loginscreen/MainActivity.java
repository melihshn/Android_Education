package com.example.melih.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername,editPassword;
    private Button buttonLogin;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private String userName,defaultUser;
    private String passWord,defaultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        buttonLogin = findViewById(R.id.buttonLogin);

        sp = getSharedPreferences("LoginData",MODE_PRIVATE);
        editor = sp.edit();

        defaultUser = sp.getString("username","");
        defaultPass = sp.getString("password","");

        if (defaultUser.equals("admin") && defaultPass.equals("123")){
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
            finish();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = editUsername.getText().toString();
                passWord = editPassword.getText().toString();

                if(userName.equals("admin") && passWord.equals("123")){

                    editor.putString("username",userName);
                    editor.putString("password",passWord);
                    editor.commit();

                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR :!!! "+userName+"\n"+passWord,Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
