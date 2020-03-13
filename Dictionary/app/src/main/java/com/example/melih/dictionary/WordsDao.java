package com.example.melih.dictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Dictionary;

public class WordsDao {

    public void addElement(DatabaseManager dbm,String eng,String tr){

        SQLiteDatabase dbx = dbm.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("wordTR",tr);
        values.put("wordEN",eng);

        dbx.insertOrThrow("words",null,values);
        dbx.close();
    }

    public ArrayList<Words> allWords(DatabaseManager dm){

        ArrayList<Words> wordsArrayList = new ArrayList<>();
        SQLiteDatabase dbx = dm.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM words",null);

        while (c.moveToNext()){

            Words words = new Words(c.getInt(c.getColumnIndex("word_id"))
            ,c.getString(c.getColumnIndex("wordEN"))
            ,c.getString(c.getColumnIndex("wordTR")));

            wordsArrayList.add(words);
        }

        return wordsArrayList;
    }


}
