package com.chat.cstmbrodcast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="NUMBERMANAGER";
    private static final String DATABASE_TABLE="NUMBERTABLE";
    private static final String id="ID";
    private static final String name="NAME";
    private static final String home="HOME";
    private static final String occupation="OCCUPATION";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create=("CREATE TABLE " +DATABASE_TABLE+"(" +id+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +name+ " TEXT, " +home+ " TEXT, " +occupation+ " TEXT "+")");
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DATABASE_TABLE);
        onCreate(db);
    }

    public void SaveData(String Bname, String Bhome, String Boccupation, SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues= new ContentValues();
        contentValues.put(name, Bname);
        contentValues.put(home, Bhome);
        contentValues.put(occupation, Boccupation);
        sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public Cursor DisplayData(){
        SQLiteDatabase sqLiteDatabase= getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+DATABASE_TABLE, null);
        return cursor;
    }
}
