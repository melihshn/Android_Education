package com.example.melih.broadcastreceiversms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    SmsManager sms = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        Object [] pdusObject = (Object []) bundle.get("pdus");  //Sms'ler pdus formatında geliyor

        for(int i = 0; i < pdusObject.length; i++){

            SmsMessage message = SmsMessage.createFromPdu((byte []) pdusObject[i]);

            String telNo = message.getDisplayOriginatingAddress();
            String msgbody = message.getDisplayMessageBody();

            Toast.makeText(context,"Tel No : "+telNo+"\n"+" Message : "+msgbody,Toast.LENGTH_LONG).show();

        }

    }
}
