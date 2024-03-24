package io.github.persiancalendar.fixedclock;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.widget.RemoteViews;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class ClockWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, final int[] appWidgetIds) {
        for (final var appWidgetId : appWidgetIds) {
            final var intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    context, 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
            );
            final var views = new RemoteViews(context.getPackageName(), R.layout.main);
            views.setOnClickPendingIntent(R.id.clock, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
            views.setInt(R.id.clock, "setTextColor", Color.WHITE);
            views.setString(R.id.clock, "setTimeZone", "GMT+03:30");
            views.setCharSequence(R.id.clock, "setFormat12Hour", "h:mm");
            views.setCharSequence(R.id.clock, "setFormat24Hour", "h:mm");
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
