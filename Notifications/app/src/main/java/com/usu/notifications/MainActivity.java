package com.usu.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {
    public int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChannel channel = new NotificationChannel(
                "mychannel",
                "App Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        findViewById(R.id.button).setOnClickListener(view -> {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, NotificationService.class);
            PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);
            alarmManager.
                    set(
                            AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            SystemClock.elapsedRealtime() + 30 * 1000,
                            pendingIntent
                    );

            alarmManager.setRE
        });
    }
}
