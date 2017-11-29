package com.example.johnd.androidstudiotodolist.models;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;

/**
 * Created by JohnD on 21/11/2017.
 */

public class Statistics extends AppCompatActivity {


    public Integer getPercentage(ArrayList<ListItem> items) {

        Integer total = items.size();

        Integer completed = 0;


        for(ListItem listItem :items) {
            if (listItem.getComplete() == true){
                completed++;
        }
        }


        Integer percentage = (completed *100)/ total;
        return percentage;

    }



}
