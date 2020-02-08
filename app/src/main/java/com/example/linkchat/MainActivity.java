package com.example.linkchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.linkchat.fragments.OpeningFragment;
import com.example.linkchat.object.CourseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ImageView mAddChat;
    private ExpandableListView mCourseMenu;
    private CourseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddChat = findViewById(R.id.main_add_chat);
        mCourseMenu = findViewById(R.id.main_menu);

        ArrayList<String> courseGroups = new ArrayList<>(Arrays.asList("CMPT","IAT","MACM","MATH"));
        HashMap<String, ArrayList<String>> courseMap = new HashMap<>();

        courseMap.put("CMPT", new ArrayList<String>(Arrays.asList("Official","120","125","225","295")));
        courseMap.put("MACM", new ArrayList<String>(Arrays.asList("Official","101","201","316")));
        courseMap.put("IAT", new ArrayList<String>(Arrays.asList("Official","110","210")));
        courseMap.put("MATH", new ArrayList<String>(Arrays.asList("Official","150","152","240")));

        mAdapter = new CourseAdapter(this, courseGroups, courseMap);
        mCourseMenu.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_container, new OpeningFragment()).commit();
        mAddChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open intent to add-class activity
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
