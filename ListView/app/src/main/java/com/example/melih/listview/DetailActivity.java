package com.example.melih.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageview = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView2);

        Intent intent = getIntent();

        String c_name = intent.getStringExtra("country_name");
        textView.setText(c_name);
    }
}
