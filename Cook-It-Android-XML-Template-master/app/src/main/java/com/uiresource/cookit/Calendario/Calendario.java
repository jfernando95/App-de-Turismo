package com.uiresource.cookit.Calendario;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uiresource.cookit.R;

import java.util.Calendar;

public class Calendario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, 29);
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.YEAR, 2013);

        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 45);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis()+60*60*1000);

        intent.putExtra(CalendarContract.Events.ALL_DAY, false);
        intent.putExtra(CalendarContract.Events.RRULE , "FREQ=DAILY");
        intent.putExtra(CalendarContract.Events.TITLE, "Título de vuestro evento");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Descripción");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Calle ....");

        startActivity(intent);
    }
}
