package com.example.linkchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        EditText editOfChatName;
        EditText editOfCourseCategory;
        EditText editOfCourseNumber;
        EditText editOfLink;
        EditText editDescri;
        //date , platform
        //upper case course category
        // make sure descrption has  ascorlling part :<<<<
        TextView mText;
        Button b = findViewById(R.id.ButtonSomething);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what happens after you click the submit file owowowow
                Toast.makeText(getApplicationContext(), "you have submitted your desired information right now", Toast.LENGTH_SHORT).show();
            }
        });
        editOfChatName = (EditText) findViewById(R.id.editText);
        String chatName  = editOfChatName.getText().toString().trim();

        editOfCourseCategory = (EditText) findViewById(R.id.editCouCatg);
        String courseCategory = editOfCourseCategory.getText().toString().trim().toUpperCase();

        //make this a number for easy comparision
        editOfCourseNumber = (EditText) findViewById(R.id.editCourNum);
        String courseNumber = editOfCourseNumber.getText().toString().trim();

        editOfLink = (EditText) findViewById(R.id.editLink);
        String link = editOfLink.getText().toString().trim();

        editDescri = (EditText) findViewById(R.id.editDescription);
        String description = editDescri.getText().toString().trim();
        // if its between 1 and 8 accept if not dont

        //come back here after u finish with making 4 empty text locations

        mText= (TextView) findViewById(R.id.textView);
        //mText.setText("i just want to kms tbh " + beingStoredRn + " owo ?");


    }


}
