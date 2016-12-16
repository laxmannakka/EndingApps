package com.bridgelabz.newipl.utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bridgelabz.newipl.model.TeamsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgeit007 on 24/11/16.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "TeamsData";
    // Table Name
    public static String TABLE_NAME = "Teamlist";
    //  contact names and columns
    private static final String TEAM_NAME ="teamname";
    private static final String KEY_IMAGE_URL = "imageurl";
    private static final String OWNER_NAME = "OWNERNAME";
    public static int DATABASE_NUMBER = 2;


    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_NUMBER);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String historytable= "CREATE TABLE " + TABLE_NAME + "(" + TEAM_NAME + " TEXT not null," + KEY_IMAGE_URL + "  PRIMARY KEY,"
                + OWNER_NAME + " TEXT not null)";
        sqLiteDatabase.execSQL(historytable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public  void addStoreDataToDataBase(TeamsModel model)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TEAM_NAME, model.getTeamname());
        values.put(KEY_IMAGE_URL, model.getUrl());
        values.put(OWNER_NAME,model.getOwner());
        // Inserting Row
        db.insert(TABLE_NAME,null, values);
        db.close(); // Closing database connection
    }
    public List<TeamsModel > getAllStoredData() {

        List<TeamsModel> TeamList = new ArrayList<TeamsModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TeamsModel model = new TeamsModel();

                model.setTeamname(cursor.getString(0));
                model.setUrl(cursor.getString(1));
                model.setOwner(cursor.getString(2));

                // Adding contact to list
                TeamList.add(model);
            } while (cursor.moveToNext());
        }

        // return contact list
        return TeamList;
    }
}
