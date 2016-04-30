package com.androidbegin.parselogintutorial;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class Alarm extends AppCompatActivity {


    TimePicker timePicker;
    DatePicker datePicker;
    Random random = new Random();
    private TextView activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        searchContent.getBackground().setColorFilter(getResources().getColor(R.color.whitE), PorterDuff.Mode.SRC_ATOP);



        Intent i = getIntent();
        Bundle b = i.getExtras();
        final String event = b.getString("event");
        //---Button view---
        Button btnOpen = (Button) findViewById(R.id.btnSetAlarm);
        btnOpen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int randomInteger = random.nextInt();
                //randomInteger = randomInteger%100;
                //if(randomInteger < 0)randomInteger = randomInteger + 100;

                //String s = Integer.toString(randomInteger);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                timePicker = (TimePicker) findViewById(R.id.timePicker);
                datePicker = (DatePicker) findViewById(R.id.datePicker);

                //---use the AlarmManager to trigger an alarm---
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                //---get current date and time---
                Calendar calendar = Calendar.getInstance();

                //---sets the time for the alarm to trigger---
                calendar.set(Calendar.YEAR, datePicker.getYear());
                calendar.set(Calendar.MONTH, datePicker.getMonth());
                calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                calendar.set(Calendar.SECOND, 0);

                //---PendingIntent to launch activity when the alarm triggers---
                Intent i = new Intent("com.androidbegin.parselogintutorial.WEL");
                i.putExtra("event", event);
                //---assign an ID of 1---
                i.putExtra("NotifID", randomInteger);

                PendingIntent displayIntent = PendingIntent.getActivity(
                        getBaseContext(), randomInteger, i, PendingIntent.FLAG_ONE_SHOT);

                //---sets the alarm to trigger---
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(), displayIntent);
                Toast.makeText(Alarm.this, "Reminder set", Toast.LENGTH_SHORT).show();
            }
        });

    }

}