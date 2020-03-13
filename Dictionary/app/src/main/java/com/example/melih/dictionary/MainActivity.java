package com.example.melih.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbm = new DatabaseManager(this);

        new WordsDao().addElement(dbm,"door","kapı");
        new WordsDao().addElement(dbm,"calculator","hesap makinesi");
        new WordsDao().addElement(dbm,"strawberry","çilek");
        new WordsDao().addElement(dbm,"beautiful","güzel");

        ArrayList<Words> getwordsList = new WordsDao().allWords(dbm);

        for(Words w : getwordsList){

         //   Log.e(w.getWordEN()+" - "+w.getWordTR());
            Log.e(String.valueOf(w.getWord_id()),w.getWordEN()+"-"+w.getWordTR());

         //   Log.e("id",String.valueOf(w.getWord_id()));
        }
    }
}
