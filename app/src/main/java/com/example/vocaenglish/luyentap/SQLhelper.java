package com.example.vocaenglish.luyentap;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Contact.db";
    private static final String DB_NAME_TABLE_TUVUNG = "TuVung";
    private static final String DB_TUVUNG_TUVUNG = "tuvung";
    private static final String DB_TUVUNG_PHIENAM = "phienam";
    private static final String DB_TUVUNG_DICHNGHIA = "dichnghia";
    private static final String DB_TUVUNG_IMG = "img";
    private static final String DB_TUVUNG_VIDU = "vidu";
    private static final String DB_TUVUNG_PHATAM = "phatam";
    private static final int DB_VERSION = 5;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;


    public SQLhelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryTuVung = "CREATE TABLE "+ DB_NAME_TABLE_TUVUNG + "(" +
                "ID INTERGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "tuvung TEXT,"+
                "phienam TEXT,"+
                "dichnghia TEXT,"+
                "img TEXT,"+
                "vidu TEXT," +
                "phatam TEXT" +
                ")";
        sqLiteDatabase.execSQL(queryTuVung);
    }

    public int getDbVersion() {
        return DB_VERSION;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVS, int newVS) {
        if (oldVS != newVS){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME_TABLE_TUVUNG);
            onCreate(sqLiteDatabase);
        }
    }

    public void add(String tuvung,String phienam, String dichnghia, String img,String vidu,String phatam){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put(DB_TUVUNG_TUVUNG, tuvung);
        contentValues.put(DB_TUVUNG_PHIENAM,phienam);
        contentValues.put(DB_TUVUNG_DICHNGHIA,dichnghia);
        contentValues.put(DB_TUVUNG_IMG, img);
        contentValues.put(DB_TUVUNG_VIDU, vidu);
        contentValues.put(DB_TUVUNG_PHATAM, phatam);


        sqLiteDatabase.insert(DB_NAME_TABLE_TUVUNG, null, contentValues);
    }



    public void delete(int id){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(DB_NAME_TABLE_TUVUNG, "ID=?",
                new String[]{String.valueOf(id)});
    }




    public List<TuVung_LuyenTap> getAllContact(){
        List<TuVung_LuyenTap> contacts = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_NAME_TABLE_TUVUNG, null, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") String tuvung = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_TUVUNG));
            @SuppressLint("Range") String phienam = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_PHIENAM));
            @SuppressLint("Range") String dichnghia = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_DICHNGHIA));
            @SuppressLint("Range") String img = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_IMG));
            @SuppressLint("Range") String vidu = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_VIDU));
            @SuppressLint("Range") String phatam = cursor.getString(cursor.getColumnIndex(DB_TUVUNG_PHATAM));


            contacts.add(new TuVung_LuyenTap(tuvung,phienam,dichnghia,img,vidu,phatam));
        }
        return contacts;
    }
}
