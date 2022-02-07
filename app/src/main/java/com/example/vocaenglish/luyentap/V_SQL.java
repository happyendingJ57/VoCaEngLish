package com.example.vocaenglish.luyentap;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class V_SQL extends SQLiteOpenHelper {
    private static final String DB_NAME = "Contact.db";
    private static final String DB_NAME_TABLE_CONTACTNUMBER = "ContactNumber";
    private static final String DB_NAME_TABLE_PRODUCT ="Product.db";
    private static final String DB_CONTACTNUMBER_TUVUNG = "tuvung";
    private static final String DB_CONTACTNUMBER_PHIENAM = "phienam";
    private static final String DB_CONTACTNUMBER_DICHNGHIA = "dichnghia";
    private static final String DB_CONTACTNUMBER_IMG = "img";
    private static final String DB_CONTACTNUMBER_VIDU = "vidu";
    private static final String DB_CONTACTNUMBER_PHATAM = "phatam";
    private static final int DB_VERSION = 5;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;


    public V_SQL(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryContactNumber = "CREATE TABLE "+ DB_NAME_TABLE_CONTACTNUMBER + "(" +
                "tuvung TEXT NOT NULL PRIMARY KEY ," +
                "phienam TEXT,"+
                "dichnghia TEXT,"+
                "img TEXT,"+
                "vidu TEXT,"+
                "phatam TEXT"+
                ")";
        sqLiteDatabase.execSQL(queryContactNumber);
    }

    public int getDbVersion() {
        return DB_VERSION;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVS, int newVS) {
        if (oldVS != newVS){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME_TABLE_CONTACTNUMBER);
            onCreate(sqLiteDatabase);
        }
    }

    public void add(String tuvung, String phienam, String dichnghia, String img,String vidu, String phatam){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put(DB_CONTACTNUMBER_TUVUNG, tuvung);
        contentValues.put(DB_CONTACTNUMBER_PHIENAM, phienam);
        contentValues.put(DB_CONTACTNUMBER_DICHNGHIA, dichnghia);
        contentValues.put(DB_CONTACTNUMBER_IMG, img);
        contentValues.put(DB_CONTACTNUMBER_VIDU, vidu);
        contentValues.put(DB_CONTACTNUMBER_PHATAM, phatam);

        sqLiteDatabase.insert(DB_NAME_TABLE_CONTACTNUMBER, null, contentValues);
    }


    public void delete(String tuvung){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_NAME_TABLE_CONTACTNUMBER, "tuvung=?",
                new String[]{tuvung});
    }




    public List<V_TuVung> getAllContact(){
        List<V_TuVung> contacts = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_NAME_TABLE_CONTACTNUMBER, null, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") String tuvung = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_TUVUNG));
            @SuppressLint("Range") String phienam = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_PHIENAM));
            @SuppressLint("Range") String dichnghia = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_DICHNGHIA));
            @SuppressLint("Range") String img = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_IMG));
            @SuppressLint("Range") String vidu = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_VIDU));
            @SuppressLint("Range") String phatam = cursor.getString(cursor.getColumnIndex(DB_CONTACTNUMBER_PHATAM));

            contacts.add(new V_TuVung(tuvung,phienam, dichnghia,img,vidu,phatam));
        }
        return contacts;
    }
}
