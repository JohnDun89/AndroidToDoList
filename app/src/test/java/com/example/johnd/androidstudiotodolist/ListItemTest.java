package com.example.johnd.androidstudiotodolist;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by JohnD on 18/11/2017.
 */

public class ListItemTest {

    @Test
    public void canGetDescription(){
        ListItem item = new ListItem("wash car");
        assertEquals(null, item.getDescription());
    }


}
