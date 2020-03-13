package com.example.melih.bundlesum;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonTopla;
    private EditText editSayi1, editSayi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTopla = findViewById(R.id.buttonTopla);
        editSayi1 = findViewById(R.id.editSayi1);
        editSayi2 = findViewById(R.id.editSayi2);


        buttonTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double sayi1 = Double.parseDouble(editSayi1.getText().toString());
                Double sayi2 = Double.parseDouble(editSayi2.getText().toString());
                Double toplam = sayi1 + sayi2;

                Bundle bundle = new Bundle();
                Intent intent = new Intent(getApplicationContext(),Activity2.class);

                bundle.putDouble("sonuc",toplam);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
/*
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)) {
                Bundle myResult = data.getExtras();
                Float vResult = myResult.getFloat("vResult");

            }

        }catch(Exception e){

            Toast.makeText(getApplicationContext(),
                    "Problems - " + requestCode + " " + resultCode, Toast.LENGTH_LONG)
                    .show();

        }
    }
    */
}
