package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johnd.androidstudiotodolist.models.DatabaseHelper;
import com.example.johnd.androidstudiotodolist.models.ListViewAdapter;
import com.example.johnd.androidstudiotodolist.models.ListItem;
import com.example.johnd.androidstudiotodolist.models.OverrideTouch;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class ListViewActivity extends BaseActivity  {


    private ListView listView;
    private ArrayList LIST;
    private ListViewAdapter adapter;
    ArrayList<ListItem> item;

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//       final SwipeDetector swipeDetector = new SwipeDetector();

//        List list = new List();

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

//        ArrayList<ListItem> item = list.getList();

        item = databaseHelper.getAllItems();
        final ListViewAdapter listViewAdapter = new ListViewAdapter(this, item);
        final android.widget.ListView listView = findViewById(R.id.list);
        listView.setAdapter(listViewAdapter);


        final OverrideTouch<com.hudomju.swipe.adapter.ListViewAdapter> touchListener =
                new OverrideTouch<>(
                        new com.hudomju.swipe.adapter.ListViewAdapter(listView),
                        new OverrideTouch.DismissCallbacks<com.hudomju.swipe.adapter.ListViewAdapter>() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

//                            @Override
                            public void onPendingDismiss(com.hudomju.swipe.adapter.ListViewAdapter recyclerView, int position) {

                            }

                            @Override
                            public void onDismiss(com.hudomju.swipe.adapter.ListViewAdapter view, int position) {
                                Log.d("SWIPING", String.valueOf(position));
                                ListItem listItem = item.get(position);
                                listItem.flipComplete();
                                databaseHelper.update(listItem);

//                                DatabaseHelper databaseHelper = new DatabaseHelper(this);

//                                ArrayList<ListItem> item = databaseHelper.getAllItems();

//                                ListViewAdapter listViewAdapter = new ListViewAdapter(this, item);

                                android.widget.ListView listView = findViewById(R.id.list);
                                listView.setAdapter(listViewAdapter);

                            }

//                            @Override
//                            public void setDismissDelay(long dismissDelayMillis) {
//                                this.m = dismissDelayMillis;
//                            }

                        });
// Dismiss the item automatically after 3 seconds
       touchListener.processPendingDismisses();

        listView.setOnTouchListener(touchListener);


        listView.setOnScrollListener((AbsListView.OnScrollListener) touchListener.makeScrollListener());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (touchListener.existPendingDismisses()) {
                    touchListener.undoPendingDismiss();
                } else {
                    Toast.makeText(ListViewActivity.this, "Position " + position, LENGTH_SHORT).show();
                }
            }
        });
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


//            mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

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






//        public void onSwipe(View view){
//
//
////        SwipeDetector swipeDetector = new SwipeDetector();
//
//
//        ListItem listItem = (ListItem) view.getTag();
//        listItem.flipComplete();
//
//        DatabaseHelper db = new DatabaseHelper(this);
//
//        }





        public void onSwitch(View view) {

        ListItem listItem = (ListItem) view.getTag();

        listItem.flipComplete();

        DatabaseHelper db = new DatabaseHelper(this);

        db.update(listItem);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        ListViewAdapter listViewAdapter = new ListViewAdapter(this, item);

        android.widget.ListView listView = findViewById(R.id.list);

        listView.setAdapter(listViewAdapter);
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



}

