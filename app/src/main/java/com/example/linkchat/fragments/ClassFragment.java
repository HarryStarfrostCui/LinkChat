package com.example.linkchat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.linkchat.DescriptionActivity;
import com.example.linkchat.MainActivity;
import com.example.linkchat.R;
import com.example.linkchat.object.CourseAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClassFragment extends Fragment {

    TextView mClassName;
    ExpandableListView mPlatform;
    String ml1;
    String ml2;
    ArrayList<String> mChatGroup;
    HashMap<String, ArrayList<String>> mChatItems;
    HashMap<String, ArrayList<String>> mChatKeys;
    CourseAdapter mAdapter;
    DatabaseReference mDatabase;

    public static ClassFragment newInstance(String l1, String l2, DatabaseReference Database) {

        Bundle args = new Bundle();

        ClassFragment fragment = new ClassFragment();
        fragment.setArguments(args);
        fragment.ml1 = l1;
        fragment.ml2 = l2;
        fragment.mDatabase = Database.child(l1).child(l2);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        mClassName = v.findViewById(R.id.class_name);
        mClassName.setText(ml2);
        mPlatform = v.findViewById(R.id.class_platform);
        mChatGroup = new ArrayList<>();
        mChatItems = new HashMap<>();
        mChatKeys = new HashMap<>();
        mAdapter = new CourseAdapter(getContext(), mChatGroup, mChatItems);
        mPlatform.setAdapter(mAdapter);
        getValues();
        mPlatform.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = new Intent(getContext(), DescriptionActivity.class);
                intent.putExtra("l1", ml1);
                intent.putExtra("l2", ml2);
                intent.putExtra("l3", mChatGroup.get(i));
                //intent.putExtra("l4", mChatKeys.get(mChatGroup.get(i)).get(i1));
                startActivity(intent);

                return false;
                //wait for database
            }
        });

        return v;
    }

    private void getValues(){
        Query reference = mDatabase;
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Firebase", "data change started");

                String key;
                String grandKey, grandVal;
                ArrayList<String> temp1;
                ArrayList<String> temp2;
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    key = (String)childSnapshot.getKey();
                    temp1 = new ArrayList<>();
                    temp2 = new ArrayList<>();
                    for (DataSnapshot grandChild: childSnapshot.getChildren()) {
                        grandVal =(String)grandChild.child("chatName").getValue();
                        grandKey =(String)grandChild.child("chatName").getKey();
                        temp1.add(grandVal);
                        temp2.add(grandKey);
                        Log.d("Firebase", grandKey + " " + key);

                    }
                    mChatGroup.add(key);
                    mChatItems.put(key, temp1);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
