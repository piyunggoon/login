package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //กำหนดเวอร์ชั่นดาต้าเบส
    private static  final int DATABASE_VERSION = 1;
    //กำหนดชื่อดาต้าเบส
    private static  final String DATABASE_NAME = "UserManger.db";
    //กำหนดชื่อตาราง
    private static  final String TABLE_USER = "user";

    //สร้างคอลัมน์
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_Username = "user_username";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    //คำสั่งในการ สร้างเทเบิ้ล
    private  String CREATE_USER_TABLE = "CREATE TABLE" + TABLE_USER + "("
        + COLUMN_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + "TEXT,"
        + COLUMN_USER_EMAIL + "TEXT," + COLUMN_USER_Username + "TEXT," + COLUMN_USER_PASSWORD + "TEXT" + ")";
    //คำสั่งในการ ลบเทเบิ้ล
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS" + TABLE_USER;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //ตรวจสอบว่ามีการสร้าง ดาต้าเบสหรือยัง ถ้ามีแล้วให่ลบทิ้งไป
        db.execSQL(DROP_USER_TABLE);
        //สร้างเทเบิ้ลใหม่
        onCreate(db);
    }
    public void addUser(User user){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_NAME,user.getName());
        //บันทึกข้อมูล
        db.insert(TABLE_USER,null,values);
        db.close();
    }
    public boolean checkUser(String username, String password) {
        String[] columns = {
                COLUMN_USER_ID
        };
     SQLiteDatabase db = this.getReadableDatabase();

     String selection = COLUMN_USER_Username + "= ?" + "AND"+COLUMN_USER_PASSWORD + "= ?";
     String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USER, //ชื่อดาต้าเบส
                columns,                     //คอลัมน์ ที่คืนกลับมาให้
                selection,                   // เงื่อนไขในการเลือก
                selectionArgs,               // คอลัมน์ที่ต้องการเลือก
                 null,               // กรุ๊พ
                 null,               // เงื่อไขการกรุ๊พ
                 null);             // ออร์เดอร์ของรายการข้อมูล
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        else
        {
            return false;
        }
    }
}
