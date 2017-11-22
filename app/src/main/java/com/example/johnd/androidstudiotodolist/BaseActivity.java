package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

/**
 * Created by JohnD on 20/11/2017.
 */

public class BaseActivity extends AppCompatActivity {



//    BottomNavigationView bottomNavigationView = new BottomNavigationView(BaseActivity.this);


    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    Intent intent1 = new Intent(BaseActivity.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                    return true;
                case R.id.navigation_ListView:
                    Intent intent2 = new Intent(BaseActivity.this, ListViewActivity.class);
                    startActivity(intent2);
                    finish();
                    return true;
                case R.id.navigation_Update:
                    Intent intent3 = new Intent(BaseActivity.this, SettingActivity.class);
                    startActivity(intent3);
                    finish();
                    return true;
            }
            return false;
        }
    };

    public BaseActivity() {
    }


    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);


    }
}
