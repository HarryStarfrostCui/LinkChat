package com.example.linkchat.object;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.linkchat.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseAdapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<String> courseGroup;
    HashMap<String, ArrayList<String>> courseItem;
    public CourseAdapter(Context context, ArrayList<String> courseList,
                         HashMap<String, ArrayList<String>> courseMap){
        this.context = context;
        this.courseGroup = courseList;
        this.courseItem = courseMap;
    }
    @Override
    public int getGroupCount() {
        return courseGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return courseItem.get(courseGroup.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return courseGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return courseItem.get(courseGroup.get(i))
                .get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String group = (String) getGroup(i);
        if(view == null){
            LayoutInflater l = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = l.inflate(R.layout.list_group, null);
        }
        TextView t = view.findViewById(R.id.list_parent);
        t.setText(group);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String child = (String) getChild(i,i1);
        if(view == null){
            LayoutInflater l = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = l.inflate(R.layout.list_item, null);
        }
        TextView t = view.findViewById(R.id.list_child);
        t.setText(child);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
