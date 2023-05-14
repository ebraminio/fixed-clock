package io.github.persiancalendar.fixedclock;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextClock;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextClock clock = findViewById(R.id.clock);
        clock.setTimeZone("GMT+03:30");
    }
}