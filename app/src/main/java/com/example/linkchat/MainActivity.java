package com.example.linkchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.linkchat.fragments.ClassFragment;
import com.example.linkchat.fragments.OpeningFragment;
import com.example.linkchat.object.CourseAdapter;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ImageView mAddChat;
    private ExpandableListView mCourseMenu;
    private CourseAdapter mAdapter;
    ArrayList<String> courseGroups;
    HashMap<String, ArrayList<String>> courseMap;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddChat = findViewById(R.id.main_add_chat);
        mCourseMenu = findViewById(R.id.main_menu);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Root");

        courseGroups = new ArrayList<>();
        courseMap = new HashMap<>();

        mAdapter = new CourseAdapter(this, courseGroups, courseMap);
        mCourseMenu.setAdapter(mAdapter);
        setupClasses();


        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_container, new OpeningFragment()).commit();
        mAddChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open intent to add-class activity
            }
        });
        mCourseMenu.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.main_container, ClassFragment.newInstance(courseMap.get(courseGroups.get(i))
                                .get(i1))).commit();
                return true;
            }
        });
    }

    void setupClasses(){
        Query reference = mDatabase;
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Firebase", "data change started");

                String key;
                String grandKey;
                ArrayList<String> temp;
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    key = (String)childSnapshot.getKey();
                    temp = new ArrayList<>();
                    for (DataSnapshot grandChild: childSnapshot.getChildren()) {
                        grandKey =(String)grandChild.getKey();
                        temp.add(grandKey);
                        Log.d("Firebase", grandKey + " " + key);

                    }
                    courseGroups.add(key);
                    courseMap.put(key, temp);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
