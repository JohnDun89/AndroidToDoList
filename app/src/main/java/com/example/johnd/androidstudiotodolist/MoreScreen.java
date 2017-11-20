package com.example.johnd.androidstudiotodolist;

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

import com.example.johnd.androidstudiotodolist.models.ListItem;

public class MoreScreen extends BaseActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_screen);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();


        // using serializabe passes up the current instance of ListItem

        TextView title = findViewById(R.id.title_view);
        TextView description = findViewById(R.id.description);
        ListItem item = (ListItem) intent.getSerializableExtra("ListItem");
        title.setText(item.getTitle());
        description.setText(item.getDescription());



    }

    public void onDeleteButtonClicked(View view){
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ListItem listItem = (ListItem) getIntent().getSerializableExtra("ListItem");
        Log.d("MoreView", "Delete Button clicked");
        databaseHelper.deleteItem(listItem);
        Intent intent = new Intent(MoreScreen.this, ListView.class);

        startActivity(intent);
    }
}
