package com.example.melih.servicetimer;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class MyService extends Service {

    private Handler handler = new Handler();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler.postDelayed(runnable,4000);

        Toast.makeText(this,"Service is start",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service is stop",Toast.LENGTH_SHORT).show();

        handler.removeCallbacks(runnable);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Toast.makeText(MyService.this,"Service is working",Toast.LENGTH_SHORT).show();

            MyService.this.handler.postDelayed(runnable,4000);
        }
    };
}