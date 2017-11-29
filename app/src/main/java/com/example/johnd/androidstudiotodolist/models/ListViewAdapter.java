package com.example.johnd.androidstudiotodolist.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


import com.example.johnd.androidstudiotodolist.R;

import java.util.ArrayList;

/**
 * Created by JohnD on 18/11/2017.
 */

public class ListViewAdapter extends ArrayAdapter<ListItem> {

    public ListViewAdapter(Context context, ArrayList<ListItem> listItem) {
        super(context, 0 ,listItem);
    }


    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
      if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);

        }





        ListItem currentListItem = getItem(position);
        TextView completed = listItemView.findViewById(R.id.state);

        if (currentListItem.getComplete() == false){
            listItemView.setBackgroundColor(Color.parseColor("#232e40"));
            completed.setText("Still To Do");

        } else {
            listItemView.setBackgroundColor(Color.parseColor("#de9b0d"));
            completed.setText("Completed");

        }
        TextView title = listItemView.findViewById(R.id.to_do_title);
        title.setText(currentListItem.getTitle().toString());



        listItemView.setTag(currentListItem);
        Button moreButton = listItemView.findViewById(R.id.more_button);
        moreButton.setTag(currentListItem);

//        Switch view = (Switch) listItemView.findViewById(R.id.completed_switch);
//        view.setChecked(currentListItem.getComplete());
//
//
//        view.setTag(currentListItem);

        return listItemView;
    }

}