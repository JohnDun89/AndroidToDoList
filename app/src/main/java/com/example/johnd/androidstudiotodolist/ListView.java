package com.example.johnd.androidstudiotodolist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.johnd.androidstudiotodolist.models.List;
import com.example.johnd.androidstudiotodolist.models.ListAdapter;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    private TextView mTextMessage;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(ListView.this, MainActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.navigation_ListView:
                        Intent intent2 = new Intent(ListView.this, ListView.class);
                        startActivity(intent2);
                        return true;
                    case R.id.navigation_Update:
                        Intent intent3 = new Intent(ListView.this, Update.class);
                        startActivity(intent3);
                        return true;
                }
                return false;
            }
        };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//        List list = new List();

        DatabaseHelper databaseHelper = new DatabaseHelper(ListView.this);

//        ArrayList<ListItem> item = list.getList();

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        ListAdapter listAdapter = new ListAdapter(this, item);

        android.widget.ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    public void onMoreButtonClicked(View view){
        Log.d("ListView", "More Button clicked");
        Intent intent = new Intent(ListView.this, MoreScreen.class);
        startActivity(intent);
    }


}

