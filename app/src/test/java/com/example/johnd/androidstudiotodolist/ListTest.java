package com.example.johnd.androidstudiotodolist;

import com.example.johnd.androidstudiotodolist.models.List;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by JohnD on 18/11/2017.
 */

public class ListTest {

    @Test
    public void getListTest(){
        List list = new List();
        assertEquals(8, list.getList().size());
    }

    @Test
    public void addToToDoList(){
        ListItem item = new ListItem("clean bike");
        List list = new List();
        list.addItem(item);
        assertEquals(9, list.getList().size());
    }
}


