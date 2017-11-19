package com.example.johnd.androidstudiotodolist.models;

/**
 * Created by JohnD on 17/11/2017.
 */

public class ListItem {

    private Integer id;
    private String name;
    private String description;
    private boolean completed;

    public ListItem() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public Object getTitle() {
        return name;
    }

    public void setname(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setID(Integer number){
        this.id = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getComplete(){
        return this.completed;
    }

    public void complete(){
        this.completed = true;
    }

    public void unComplete(){
        this.completed = false;
    }
}
