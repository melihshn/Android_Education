package com.example.melih.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private Button buttonSms, buttonAra;
    private EditText editNumara, editSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSms = findViewById(R.id.editSms);
        editNumara = findViewById(R.id.editNumara);
        buttonAra = findViewById(R.id.buttonAra);
        buttonSms = findViewById(R.id.buttonSMS);

        buttonAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    String numara = editNumara.getText().toString();
                    intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + numara));

                    startActivity(intent);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),
                            "Lutfen dogru bilgi giriniz", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        buttonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    String numara = editNumara.getText().toString();
                    String mesaj = editSms.getText().toString();
             //     intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + numara));
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + numara));
                    intent.putExtra("sms_body", mesaj);
                    startActivity(intent);

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),
                            "Lutfen dogru bilgi giriniz", Toast.LENGTH_LONG)
                            .show();

                }
            }
        });

    }
}
