package com.example.hp2.myapplication2;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;

        String action = intent.getAction();


        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context,"This is Received by User",Toast.LENGTH_LONG).show();
            showNotification("awwwww");
        }


    }

    void showNotification(String message){

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Receiver");
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.ic_launcher);

        builder.setDefaults(Notification.DEFAULT_ALL); // VIBRATE permission in manifest

        Notification notification = builder.build();

        notificationManager.notify(101,notification);

    }


}
