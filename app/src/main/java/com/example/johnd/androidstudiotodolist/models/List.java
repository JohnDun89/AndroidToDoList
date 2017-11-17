package com.example.johnd.androidstudiotodolist.models;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

/**
 * Created by JohnD on 17/11/2017.
 */

public class List {

    private ArrayList<ListItem> ToDoList;

    public List(){
        ToDoList = new ArrayList<ListItem>();
    }
}
