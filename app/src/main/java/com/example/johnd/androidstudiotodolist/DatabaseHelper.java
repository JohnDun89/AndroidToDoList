package com.example.johnd.androidstudiotodolist;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.johnd.androidstudiotodolist.models.ListItem;

import java.util.ArrayList;


/**
 * Created by JohnD on 17/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "todolist.db";
    public static final String TABLE_NAME = "list_table";
    public static final String COL_ID = "ID";
    public static final String COL_TITLE = "title";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_COMPLETED = "completed";
    public static final String COL_PRIORITY = "priority";
    private static DatabaseHelper mDatabaseInstance = null;
    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, DESCRIPTION TEXT, COMPLETED BOOLEAN, PRIORITY BIGINT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    // not sure the following is required - if issues remove.
    public static DatabaseHelper newInstance(Context context) {
        if (mDatabaseInstance == null) {
            mDatabaseInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return mDatabaseInstance;
    }

    public boolean insertData(String title, String description) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_DESCRIPTION, description);
        contentValues.put(COL_COMPLETED, false);
//        contentValues.put(COL_PRIORITY, priority);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return true;
    }




    public ArrayList<ListItem> getAllItems() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<ListItem> list = new ArrayList<ListItem>();
        ListItem listItem;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                listItem = new ListItem();
                listItem.setID(cursor.getString(0));
                listItem.setname(cursor.getString(1));
                listItem.setDescription(cursor.getString(2));
                listItem.setCompleted(cursor.getInt(3));
                listItem.setPriority(cursor.getString(4));
                list.add(listItem);
            }
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;

    }

    public void deleteItem(ListItem item){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.execSQL(" DELETE FROM " + TABLE_NAME + " WHERE " + COL_ID + " = ' " + item.getId() + "'");
    }

//    public void updateCompleted(String item){
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        if (item == "false")
//            sqLiteDatabase.execSQL(" UPDATE " + TABLE_NAME +  " SET " + COL_COMPLETED  + " = '" + true + "' WHERE COL_ID = " + );
//        else
//            sqLiteDatabase.execSQL(" UPDATE " + TABLE_NAME + " WHERE " + COL_COMPLETED + " 'false' ");
//
//
//    }

//    public void update(ListItem item){
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_TITLE, item.getTitle());
//        contentValues.put(COL_DESCRIPTION, item.getDescription());
//        contentValues.put(COL_COMPLETED, item.getComplete());
//        contentValues.put(COL_PRIORITY, item.getPriority());
//        sqLiteDatabase.update(TABLE_NAME, contentValues, COL_ID + " ? " , new String[]{item.getIdString()});
//
//    }

        public void update(ListItem item) {
//            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_TITLE, item.getTitle());
            contentValues.put(COL_DESCRIPTION, item.getDescription());
            contentValues.put(COL_COMPLETED, item.getComplete());
            contentValues.put(COL_PRIORITY, item.getPriority());

            String[] args = new String[] { item.getIdString() };

            int result = sqLiteDatabase.update(TABLE_NAME, contentValues, "id=?", args );

//            String query = "update " + TABLE_NAME + " set " + COL_TITLE + " = '" + item.getTitle() + "', " + COL_DESCRIPTION + " = '" + item.getDescription() + "', " + COL_PRIORITY + " = '" + item.getPriority() + "'," + COL_COMPLETED + " = '" + item.getComplete() + "' where " + COL_ID + " = " + item.getIdString();
//            sqLiteDatabase.execSQL(query);
            sqLiteDatabase.close();
        }


}
