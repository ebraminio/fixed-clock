package io.github.persiancalendar.fixedclock;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.os.Build;
import android.widget.RemoteViews;

public class MainApplication extends Application {
    @SuppressLint("NotificationPermission")
    @Override
    public void onCreate() {
        super.onCreate();
        final var notificationManager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU &&
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
                notificationManager != null) {
            final var channelId = "Clock";
            final var channel = new NotificationChannel(channelId, "Fixed Clock", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setSound(null, null);
            channel.setVibrationPattern(null);
            notificationManager.createNotificationChannel(channel);
            final var views = new RemoteViews(getPackageName(), R.layout.main);
            views.setString(R.id.clock, "setTimeZone", "GMT+03:30");
            views.setCharSequence(R.id.clock, "setFormat12Hour", "h:mm");
            views.setCharSequence(R.id.clock, "setFormat24Hour", "h:mm");
            final var notification = new Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setCustomContentView(views)
                    .build();
            notificationManager.notify(1, notification);
        }
    }
}
