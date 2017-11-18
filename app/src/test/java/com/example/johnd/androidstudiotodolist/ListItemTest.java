package com.example.johnd.androidstudiotodolist;

import com.example.johnd.androidstudiotodolist.models.List;
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

    @Test
    public void canSetDescription(){
        ListItem item = new ListItem("wash car");
        item.setDescription("remember to hoover inside.");
        assertEquals("remember to hoover inside.",item.getDescription());
    }

    @Test
    public void canGetIfComplete(){
        ListItem item = new ListItem("wash bike");
        assertEquals(false,item.getComplete());
    }

}
