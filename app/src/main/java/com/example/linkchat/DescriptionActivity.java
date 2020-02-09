package com.example.linkchat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DescriptionActivity extends AppCompatActivity {
    public static final String DATE_FORMAT = "MM-dd-yyyy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        //Chat Name
        TextView ChatName = (TextView) findViewById(R.id.chatName);
        ChatName.setText (" ");
        //Course Name
        TextView CourseName = (TextView) findViewById(R.id.courseName);
        CourseName.setText (" ");
        //Course Number
        TextView CourseNumber = (TextView) findViewById(R.id.courseNumber);
        CourseNumber.setText (" ");
        //Link
        TextView linkBox = (TextView) findViewById(R.id.linkFixed);
        linkBox.setText("Link: ");
        TextView linkID = (TextView) findViewById(R.id.link);
        linkID.setText(" ");
        //Date
        TextView dateBox = (TextView) findViewById(R.id.dateFixed);
        dateBox.setText ("Chat creation date: ");
        TextView date = (TextView) findViewById(R.id.dateLink);
        String chatDate = getCurrentDate();
        date.setText(chatDate);
        //Description
        TextView descriptionBox = (TextView) findViewById(R.id.descriptionFixed);
        descriptionBox.setText("Description: ");
        TextView chatDescription = (TextView) findViewById(R.id.descriptionLink);
        chatDescription.setText(" ");

        //Button to report
        Button report = (Button) findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
          @Override
          //  View checkBoxView = View.inflate(this, R.layout.checkbox, null);
            //CheckBox checkBox = (CheckBox) checkBoxView.findViewById(R.id.checkbox);
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DescriptionActivity.this).create(); //Read Update
                alertDialog.setTitle("Report");
                alertDialog.setMessage("A problem has been reported with the link for the group chat! ");
               // alertDialog.setView(checkBoxView);
                //selectedItems = new ArrayList();  // Where we track the selected items
              //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                alertDialog.show();
            }
        });

    }
    public static String getCurrentDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
