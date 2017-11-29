package com.example.johnd.androidstudiotodolist.models;

import android.widget.ListView;

import java.io.Serializable;

/**
 * Created by JohnD on 17/11/2017.
 */

public class ListItem implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private boolean completed;
    private String priority;


    public String getTitle() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getIdString(){
        return id.toString();
    }

    public void setID(String number) {
        Integer result = Integer.valueOf(number);
        this.id = result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void flipComplete() {
        this.completed = !this.completed;
    }

    public boolean getComplete() {
        return this.completed;
    }



    public void setCompleted(int status) {
        this.completed = status == 1;
    }

    public void setPriority(String numericPriority) {
        this.priority = numericPriority;
    }


    public String getPriority() {
        return this.priority;
    }
}
