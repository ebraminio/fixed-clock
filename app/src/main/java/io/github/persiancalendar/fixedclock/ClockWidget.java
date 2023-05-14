package io.github.persiancalendar.fixedclock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class ClockWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (var appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.main);
            appWidgetManager.updateAppWidget(appWidgetId, views);
            views.setString(R.id.clock, "setTimeZone", "GMT+03:30");
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
