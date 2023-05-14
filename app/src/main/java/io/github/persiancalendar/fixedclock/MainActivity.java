package io.github.persiancalendar.fixedclock;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextClock;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextClock clock = findViewById(R.id.clock);
        clock.setBackgroundColor(Color.BLACK);
        clock.setTimeZone("GMT+03:30");
    }
}