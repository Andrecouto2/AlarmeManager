package com.example.logonrm.alarmemanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disparar(View view) {
        EditText text = (EditText) findViewById(R.id.time);
        EditText text1 = (EditText) findViewById(R.id.hour);
        EditText text2 = (EditText) findViewById(R.id.min);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = Integer.parseInt(text.getText().toString());
        int x = Integer.parseInt(text1.getText().toString());
        int z = Integer.parseInt(text2.getText().toString());
        calendar.set(Calendar.HOUR_OF_DAY, x);
        calendar.set(Calendar.MINUTE, z);

        Intent intent = new Intent(this, AlarmeReceiver.class);

        PendingIntent pendingIntent = PendingIntent. getBroadcast(
                this.getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * i, pendingIntent);

        Toast.makeText(this, "Alarm set in " +i+ " seconds",Toast.LENGTH_LONG).show();
    }
}
