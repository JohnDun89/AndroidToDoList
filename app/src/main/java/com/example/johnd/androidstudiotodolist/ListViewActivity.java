package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johnd.androidstudiotodolist.models.ListAdapter;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

public class ListViewActivity extends BaseActivity implements GestureDetector.OnGestureListener {



    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//       final SwipeDetector swipeDetector = new SwipeDetector();

//        List list = new List();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

//        ArrayList<ListItem> item = list.getList();

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        ListAdapter listAdapter = new ListAdapter(this, item);

        android.widget.ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onSwipe(AdapterView<?> adapterView, View view, int i, long l) {
//                if (swipeDetector.swipeDetected()){
//                    if (swipeDetector.getAction() == SwipeDetector.Action.RL){
//
//                        ListItem listItem = (ListItem) view.getTag();
//
//                        listItem.flipComplete();
//
//                        DatabaseHelper db = new DatabaseHelper(ListViewActivity.this);
//
//                        db.update(listItem);
//                    }
//                }
//            }
//        });



    }



        public void onSwipe(View view){


//        SwipeDetector swipeDetector = new SwipeDetector();


        ListItem listItem = (ListItem) view.getTag();
        listItem.flipComplete();

        DatabaseHelper db = new DatabaseHelper(this);

        }





        public void onSwitch(View view) {

        ListItem listItem = (ListItem) view.getTag();

        listItem.flipComplete();

        DatabaseHelper db = new DatabaseHelper(this);

        db.update(listItem);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        ListAdapter listAdapter = new ListAdapter(this, item);

        android.widget.ListView listView = findViewById(R.id.list);

        listView.setAdapter(listAdapter);
//        Intent intent = getIntent();
//        finish();
//        startActivity(intent);

    }




    public void onMoreButtonClicked(View view){
        ListItem listItem = (ListItem) view.getTag();
        Log.d("ListViewActivity", "More Button clicked");
        Intent intent = new Intent(ListViewActivity.this, MoreScreenActivity.class);
        intent.putExtra("ListItem", listItem);
        startActivity(intent);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}

