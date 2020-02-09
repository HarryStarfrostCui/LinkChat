package com.example.linkchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import android.content.SharedPreferences;
import android.content.*;

public class AddChat extends AppCompatActivity {

    private static String tempCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<String> platforms = new ArrayList<>();
        platforms.add("FaceBook");
        platforms.add("Discord");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);



        final SharedPreferences pref = getApplication().getSharedPreferences("MyPref", MODE_PRIVATE);

        //date , platform
        //upper case course category
        // make sure descrption has  ascorlling part :<<<<
        TextView mText;


        Spinner platformSpinner = (Spinner) findViewById(R.id.editPlatform);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, platforms);
        platformSpinner.setAdapter(adapter);
        platformSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        String selectedPlatform = platformSpinner.getSelectedItem().toString();



//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        Date today = Calendar.getInstance().getTime();
//        String todayDate  = dateFormat.format(today);

        //come back here after u finish with making 4 empty text locations


        //System.out.println("please print" +  courseCategory + "   " + courseNumber + "  " + link + "   " + description + "   ");

        Button b = findViewById(R.id.ButtonSomething);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences.Editor editor = pref.edit();
                //EditText categoryText = findViewById(R.id.editCouCatg);


                EditText editOfChatName = (EditText) findViewById(R.id.editText);
                EditText editOfCourseCategory = (EditText) findViewById(R.id.editCouCatg);
                EditText editOfCourseNumber = (EditText) findViewById(R.id.editCourNum);
                EditText editOfLink = (EditText) findViewById(R.id.editLink);
                EditText editDescri = (EditText) findViewById(R.id.editDescription);


                editor.putString("category", editOfCourseCategory.getText().toString());
                editor.putString("coursenum", editOfCourseNumber.getText().toString().toUpperCase());
                editor.putString("link", editOfLink.getText().toString());
                editor.putString("description", editDescri.getText().toString());
                editor.commit();
                //what happens after you click the submit file owowowow
//                if(courseNumberInt < 100 || courseNumberInt > 899){
//                    editOfCourseNumber.setError("Your course number is not valid");
//                }
//                else{
                //editOfCourseNumber.setError(null);

                //Toast.makeText(getApplicationContext(), "please print" +  courseCategory + "   " + courseNumber + "  " + link + "   " + description + "   ", Toast.LENGTH_SHORT).show();
                //}
            }
        });

        System.out.println(pref.getString("category", null));
        //Toast.makeText(getApplicationContext(), "please print" +  courseCategory + "   " + courseNumber + "  " + link + "   " + description + "   ", Toast.LENGTH_SHORT).show();

        mText= (TextView) findViewById(R.id.textView);
        //mText.setText("i just want to kms tbh " + beingStoredRn + " owo ?");




    }


}
