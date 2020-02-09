package com.example.linkchat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.linkchat.R;
import com.example.linkchat.object.CourseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClassFragment extends Fragment {

    TextView mClassName;
    ExpandableListView mPlatform;
    String mPath;
    ArrayList<String> mChatGroup;
    HashMap<String, ArrayList<String>> mChatItems;
    CourseAdapter mAdapter;

    public static ClassFragment newInstance(String path) {

        Bundle args = new Bundle();

        ClassFragment fragment = new ClassFragment();
        fragment.setArguments(args);
        fragment.mPath = path;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        mClassName = v.findViewById(R.id.class_name);
        mClassName.setText(mPath);
        mPlatform = v.findViewById(R.id.class_platform);
        getValues();
        mPlatform.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                return false;
                //wait for database
            }
        });

        return v;
    }

    private void getValues(){
        ArrayList<String> mChatGroup = new ArrayList<>(Arrays.asList("CMPT","IAT","MACM","MATH"));
        HashMap<String, ArrayList<String>> mChatItems = new HashMap<>();

        mChatItems.put("CMPT", new ArrayList<String>(Arrays.asList("Official","120","125","225","295")));
        mChatItems.put("MACM", new ArrayList<String>(Arrays.asList("Official","101","201","316")));
        mChatItems.put("IAT", new ArrayList<String>(Arrays.asList("Official","110","210")));
        mChatItems.put("MATH", new ArrayList<String>(Arrays.asList("Official","150","152","240")));

        mAdapter = new CourseAdapter(getContext(), mChatGroup, mChatItems);
        mPlatform.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
