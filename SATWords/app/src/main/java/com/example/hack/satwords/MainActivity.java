package com.example.hack.satwords;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    static Draw draw;
    DisplayMetrics metrics;
    int h;
    int w;
    Paint p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        w = metrics.widthPixels;
        h = metrics.heightPixels;

        p = new Paint();
        draw = new Draw(getApplicationContext(),h,w,p);

        super.onCreate(savedInstanceState);
        setContentView(draw);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
