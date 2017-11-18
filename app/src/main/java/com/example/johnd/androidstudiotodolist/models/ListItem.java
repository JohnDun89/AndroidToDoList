package com.example.johnd.androidstudiotodolist.models;

/**
 * Created by JohnD on 17/11/2017.
 */

public class ListItem {

    private int id;
    private String name;
    private String description;
    private boolean completed;

    public ListItem(String name) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public Object getTitle() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
