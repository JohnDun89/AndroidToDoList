package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
//    private DatabaseHelper mDBHelper;
//    private SQLiteDatabase mDataBase;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(Color.WHITE));


//        mDBHelper = new DatabaseHelper(this);
//        mDataBase = mDBHelper.getWritableDatabase();
//        mDataBase.close();
    }

//    @Override
    public void onAddbuttonClicked(View view){
        Log.d("MainActivity", "Add Button clicked");
        Intent intent = new Intent(this, AddFormActivity.class);
        startActivity(intent);


    }

}
