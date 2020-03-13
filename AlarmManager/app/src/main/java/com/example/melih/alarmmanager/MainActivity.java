package com.example.melih.alarmmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendNotification();
            }
        });
    }

    public void sendNotification(){

        //Başlamak için, bir NotificationCompat.Builder nesnesini kullanarak bildirimin içeriğini ve kanalını ayarlamanız gerekir.
        NotificationCompat.Builder builder;

        //NotificationManager'den bir nesne oluşturduk.
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Bildirime tıklayınca nereye gideceğimiz :
        Intent intent = new Intent(MainActivity.this, NotiActivity.class);

        intent.setAction(Long.toString(System.currentTimeMillis()));

        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){         //Oreo Sürümü için

            String channelid = "KOU_CENG";
            String channelName = "Embedded Lab";
            String channelIntro = "Gomulu ve Algilayici Sistemler Laboratuvari";
            int ch_importance = NotificationManager.IMPORTANCE_HIGH;

            //Oreo ile gelen yapı
            NotificationChannel channel = notificationManager.getNotificationChannel(channelid);

            //channel yeni oluşturulmuş yani boş ise;
            if(channel == null){

                channel = new NotificationChannel(channelid,channelName,ch_importance);
                channel.setDescription(channelIntro);
                notificationManager.createNotificationChannel(channel);
            }

            builder = new NotificationCompat.Builder(this,channelid);

            builder.setContentTitle("Bildirim Basligi");
            builder.setContentText("İcerik");
            builder.setSmallIcon(R.drawable.alarm_icon);
            builder.setAutoCancel(true);    //Bildirimin tıkladıktan sonra kaybolması için
            builder.setContentIntent(pendingIntent);

        }

        else{

            builder = new NotificationCompat.Builder(this);

            builder.setContentTitle("Bildirim Basligi");
            builder.setContentText("İcerik");
            builder.setSmallIcon(R.drawable.alarm_icon);
            builder.setAutoCancel(true);    //Bildirimin tıkladıktan sonra kaybolması için
            builder.setContentIntent(pendingIntent);

            builder.setPriority(Notification.PRIORITY_HIGH);
        }

        notificationManager.notify(1,builder.build());
    }
}

