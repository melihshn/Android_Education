package com.example.melih.listview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView1);

        final ArrayList<String> countries = new ArrayList<String>();

        countries.add("Turkey");
        countries.add("Germany");
        countries.add("Austria");
        countries.add("U.S.D");
        countries.add("England");
        countries.add("Greece");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);

        listView.setAdapter(arrayAdapter);

        Bitmap turkey = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tr);
        Bitmap germany = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.germany);
        Bitmap austria = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.avusturya);
        Bitmap usd = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.usd);
        Bitmap england = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.england);
        Bitmap greece = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.greece);

        final ArrayList<Bitmap> flags = new ArrayList<>();

        flags.add(turkey);
        flags.add(germany);
        flags.add(austria);
        flags.add(usd);
        flags.add(england);
        flags.add(greece);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("country_name", countries.get(position));
                startActivity(intent);
            }
        });


    }
}