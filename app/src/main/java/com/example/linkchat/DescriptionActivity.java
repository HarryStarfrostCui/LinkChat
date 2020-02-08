package com.example.linkchat;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    public static final String DATE_FORMAT = "MM-dd-yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        TextView linkID = (TextView) findViewById(R.id.link);
        linkID.setText("www.facebook.com");
        TextView date = (TextView) findViewById(R.id.date);
        String chatDate = getCurrentDate();
        date.setText(chatDate);
        TextView chatDescription = (TextView) findViewById(R.id.description);
        chatDescription.setText("blah blah blah");
    }
    public static String getCurrentDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
