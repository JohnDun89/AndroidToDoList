package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

public class SettingActivity extends BaseActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        DatabaseHelper databaseHelper = new DatabaseHelper(SettingActivity.this);
        ArrayList<ListItem> itemsArray = databaseHelper.getAllItems();
        Statistics stats = new Statistics();

        Integer statistics = stats.getPercentage(itemsArray);
        String stringStat = statistics.toString();
        TextView title = (TextView)findViewById(R.id.percentage);
        title.setText(stringStat);

//        ArrayList<ListItem> item = list.getList();

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


//
//    ListItem currentListItem = getItem(position);
//
//    TextView title = listItemView.findViewById(R.id.to_do_title);
//        title.setText(currentListItem.getTitle().toString());
}
