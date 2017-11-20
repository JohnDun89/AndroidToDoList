package com.example.johnd.androidstudiotodolist.models;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.example.johnd.androidstudiotodolist.ListView;
import com.example.johnd.androidstudiotodolist.MoreScreen;
import com.example.johnd.androidstudiotodolist.R;

import java.util.ArrayList;

/**
 * Created by JohnD on 18/11/2017.
 */

public class ListAdapter extends ArrayAdapter<ListItem> {

    public ListAdapter(Context context, ArrayList<ListItem> listItem) {
        super(context, 0 ,listItem);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }

        ListItem currentListItem = getItem(position);

        TextView title = listItemView.findViewById(R.id.to_do_title);
        title.setText(currentListItem.getTitle().toString());

        listItemView.setTag(currentListItem);
        Button moreButton = listItemView.findViewById(R.id.more_button);
        moreButton.setTag(currentListItem);

        View view = listItemView.findViewById(R.id.completed_switch);

        view.setTag(currentListItem);

        return listItemView;
    }

}