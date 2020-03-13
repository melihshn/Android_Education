package com.example.melih.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner =  findViewById(R.id.spinner);
// String dizisi ve spinner layout kullanarak bir ArrayAdapter oluşturma:
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Seçenekler listesinin düzeni :
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Adapter'ı spinner'a bağlama :
        spinner.setAdapter(adapter);
    }
}
