package com.usu.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotificationService extends Service {

    @Override
    public int onStartCommand(Intent i, int flags, int startId) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new Notification
                .Builder(this, "mychannel")
                .setSmallIcon(R.drawable.ic_baseline_favorite_border_24)
                .setContentTitle("My notification")
                .setContentText("I am notifying you!!!!")
                .setContentIntent(pendingIntent)
                .build();
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.notify(1, notification);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
