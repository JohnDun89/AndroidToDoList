package com.example.johnd.androidstudiotodolist.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        title.setText(currentListItem.getTitle().tostring);

        listItemView.setTag(currentListItem;
        return listItemView;

    }
}