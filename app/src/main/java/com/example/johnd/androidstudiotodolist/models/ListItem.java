package com.example.johnd.androidstudiotodolist.models;

/**
 * Created by JohnD on 17/11/2017.
 */

public class ListItem {

    private Integer id;
    private String name;
    private String description;
    private boolean completed;
    private String priority;

    public ListItem() {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
        this.priority = priority;
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

    public void setID(String number){
       Integer result = Integer.valueOf(number);
       this.id = result;
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

    public void setCompleted(String status){
        Boolean result = Boolean.valueOf(status);
        this.completed = result;
    }

    public void setPriority(String numericPriority){
        this.priority = numericPriority;
    }
}
