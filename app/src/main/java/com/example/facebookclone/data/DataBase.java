package com.example.facebookclone.data;

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

    private static final String STUDENT_ID = "id";
    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_MARKS = "marks";

    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE "+STUDENT_TABLE+" ("+STUDENT_ID+" INT PRIMARY KEY,"+STUDENT_NAME+" VARCHAR(50),"+STUDENT_AGE+" INT,"+STUDENT_MARKS+" INT);";

    private static final String DROP_TABLE = "DROP TABLE "+STUDENT_TABLE;

    private static final String SELECT_STUDENT = "SELECT * FROM "+STUDENT_TABLE;

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
        Log.d(TAG,"onCreate:"+"Database Create Successfull");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public long insertStudent(int id,String name, int age, int marks){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO "+STUDENT_TABLE+" VALUES("+id+",'"+name+"',"+age+","+marks+")");
        getAllStudent();
        db.close();
        return 0;
    }
    public void getAllStudent(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(SELECT_STUDENT,null);

        if (cursor.moveToFirst()){
            do {
                Log.d(TAG,"getAllStudent: "+"id :"+cursor.getString(cursor.getColumnIndex(STUDENT_ID))+"Name :"+cursor.getString(cursor.getColumnIndex(STUDENT_NAME))+" Age :"+cursor.getInt(cursor.getColumnIndex(STUDENT_AGE))+" Marks :"+cursor.getInt(cursor.getColumnIndex(STUDENT_MARKS)));
            }while (cursor.moveToNext());
        }
    }
}
