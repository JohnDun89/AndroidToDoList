package com.example.johnd.androidstudiotodolist;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddForm extends AppCompatActivity {


    private TextView mTextMessage;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDataBase;
    EditText editTitle, editDescription, editPriority;
    Button submit_button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        mDBHelper = new DatabaseHelper(this);
        mDataBase = mDBHelper.getWritableDatabase();

//        mDataBase.close();

        editTitle = (EditText)findViewById(R.id.edit_title);
        editDescription = (EditText)findViewById(R.id.edit_description);
        submit_button = (Button)findViewById(R.id.submit_button);
        addData();

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//

    }

    public void addData(){
        submit_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDBHelper.insertData(editTitle.getText().toString(),
                                editDescription.getText().toString());
//                                editPriority.getText().toString());
                        Intent intent = new Intent(AddForm.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

}