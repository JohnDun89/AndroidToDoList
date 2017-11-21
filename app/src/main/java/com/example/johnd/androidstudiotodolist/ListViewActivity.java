package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.johnd.androidstudiotodolist.models.ListAdapter;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

public class ListViewActivity extends BaseActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//        List list = new List();

        DatabaseHelper databaseHelper = new DatabaseHelper(ListViewActivity.this);

//        ArrayList<ListItem> item = list.getList();

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        ListAdapter listAdapter = new ListAdapter(this, item);

        android.widget.ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onSwitch(View view) {

        ListItem listItem = (ListItem) view.getTag();

        if (listItem.getComplete() == false){
            view.setBackgroundColor(Color.RED);
        }
        listItem.flipComplete();

        DatabaseHelper db = new DatabaseHelper(this);

        db.update(listItem);

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


    public void onMoreButtonClicked(View view){
        ListItem listItem = (ListItem) view.getTag();
        Log.d("ListViewActivity", "More Button clicked");
        Intent intent = new Intent(ListViewActivity.this, MoreScreenActivity.class);
        intent.putExtra("ListItem", listItem);
        startActivity(intent);
    }


}
