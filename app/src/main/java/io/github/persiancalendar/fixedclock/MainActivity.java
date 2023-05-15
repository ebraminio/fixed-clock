package io.github.persiancalendar.fixedclock;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextClock;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final var window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER |
                WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(Color.TRANSPARENT);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextClock clock = findViewById(R.id.clock);
        clock.setTimeZone("GMT+03:30");
        clock.setFormat12Hour("h:mm");
        clock.setFormat24Hour("h:mm");
    }
}