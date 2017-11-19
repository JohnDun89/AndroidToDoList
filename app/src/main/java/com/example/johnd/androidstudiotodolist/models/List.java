package com.example.johnd.androidstudiotodolist.models;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;


import com.example.johnd.androidstudiotodolist.DatabaseHelper;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

/**
 * Created by JohnD on 17/11/2017.
 */

public class List {

    private ArrayList<ListItem> ToDoList;
    DatabaseHelper databaseHelper;
    Cursor databaseItems;

    public List() {
    this.ToDoList = new ArrayList<>();

//        ToDoList.add(new ListItem("buy coffee"));
//        ToDoList.add(new ListItem("paint door"));
//        ToDoList.add(new ListItem("finish android project"));
//        ToDoList.add(new ListItem("create scrolling on android list view."));
//        ToDoList.add(new ListItem("finish oil painting"));
//        ToDoList.add(new ListItem("cancel gym membership"));
//        ToDoList.add(new ListItem("pratice illustrator"));
//        ToDoList.add(new ListItem("visit barbers"));
    }



    public void addItem(ListItem listItem){
        ToDoList.add(listItem);
    }

    public ArrayList<ListItem> getList(){
        return new ArrayList<>(ToDoList);
    }




}
