package com.example.johnd.androidstudiotodolist;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
//    private DatabaseHelper mDBHelper;
//    private SQLiteDatabase mDataBase;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_ListView:
                    Intent intent2 = new Intent(MainActivity.this, ListView.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_Update:
                    Intent intent3 = new Intent(MainActivity.this, Update.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        mDBHelper = new DatabaseHelper(this);
//        mDataBase = mDBHelper.getWritableDatabase();
//        mDataBase.close();
    }

//    @Override
    protected void onAddbuttonClicked(View view){
        Log.d("MainActivity", "Add Button clicked");
        Intent intent = new Intent(this, AddForm.class);
        startActivity(intent);

    }

}
