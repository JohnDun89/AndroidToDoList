package com.example.johnd.androidstudiotodolist;

import com.example.johnd.androidstudiotodolist.models.List;
import com.example.johnd.androidstudiotodolist.models.ListItem;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by JohnD on 18/11/2017.
 */

public class ListTest {

//    @Test
//    public void getListTest(){
//        List list = new List();
//        assertEquals(8, list.getList().size());
//    }
//
//    @Test
//    public void addToToDoList(){
//        ListItem item = new ListItem();
//        List list = new List();
//        list.addItem(item);
//        assertEquals(9, list.getList().size());
//    }


    @Test
    public void getPercentage(){
        Statistics stats = new Statistics();

        ArrayList list = new ArrayList();
        assertNotNull(stats.getPercentage(list));
    }
}


