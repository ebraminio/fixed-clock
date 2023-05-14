package io.github.persiancalendar.fixedclock;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ClockWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (var appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    context, 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
            views.setOnClickPendingIntent(R.id.clock, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
            views.setString(R.id.clock, "setTimeZone", "GMT+03:30");
            views.setCharSequence(R.id.clock, "setFormat12Hour", "h:mm");
            views.setCharSequence(R.id.clock, "setFormat24Hour", "h:mm");
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
