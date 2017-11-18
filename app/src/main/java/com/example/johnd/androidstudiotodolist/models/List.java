package com.example.johnd.androidstudiotodolist.models;

import android.widget.Toast;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

/**
 * Created by JohnD on 17/11/2017.
 */

public class List {

    private ArrayList<ListItem> ToDoList;

    public List(){
        ToDoList = new ArrayList<ListItem>();
        ToDoList.add(new ListItem("buy coffee"));
        ToDoList.add(new ListItem("paint door"));
        ToDoList.add(new ListItem("finish android project"));
        ToDoList.add(new ListItem("create scrolling on android list view."));
    }


    public ArrayList<ListItem> getList(){
        return new ArrayList<>(ToDoList);
    }
}
