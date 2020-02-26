package com.example.facebookclone.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "fb_clone_db";
    public static final int DB_VERSION = 1;

    private static final String STUDENT_TABLE = "student";

//    private static final String STUDENT_ID = "id";
    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_MARKS = "marks";

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,int version){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate:"+"Database Create Successfull");
        db.execSQL("create table "+STUDENT_TABLE+"(id integer primary key autoincrement,name TEXT,age integer,marks integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
        onCreate(db);
    }

    public boolean insertStudent(String name, String age, String marks){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

//        contentValues.put(STUDENT_ID,id);
        contentValues.put(STUDENT_NAME,name);
        contentValues.put(STUDENT_AGE,age);
        contentValues.put(STUDENT_MARKS,marks);

        long rs = db.insert(STUDENT_TABLE,null,contentValues);

        if (rs==-1)
            return false;
        else
            return true;
    }
//    public void getAllStudent(){
//        SQLiteDatabase db = getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(SELECT_STUDENT,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                Log.d(TAG,"getAllStudent: "+"id :"+cursor.getString(cursor.getColumnIndex(STUDENT_ID))+"Name :"+cursor.getString(cursor.getColumnIndex(STUDENT_NAME))+" Age :"+cursor.getInt(cursor.getColumnIndex(STUDENT_AGE))+" Marks :"+cursor.getInt(cursor.getColumnIndex(STUDENT_MARKS)));
//            }while (cursor.moveToNext());
//        }
//    }
}
