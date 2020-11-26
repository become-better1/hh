package com.example.coursedesign;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL="create table myTable(_id integer primary key autoincrement,word text)";
    public static final String name = "myDb";
    public static final String table_name = "myTable";
    public DBOpenHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("生活小助手","--版本更新"+oldVersion+"-->"+newVersion);
    }
    public List<String> readAllCommodities() {
        List<String> allCommodities = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from myTable order by _id",null);
        if(cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex("word"));
                allCommodities.add(title);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return allCommodities;
    }
    public boolean addMyCollection(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("word",s);
        db.insert(table_name,null,values);
        values.clear();
        return true;
    }
    public void deleteMyCollection(String word) {
        SQLiteDatabase db = this.getWritableDatabase();
        if(db.isOpen()) {
         db.delete(table_name,"word=?",new String[]{word+""});
            db.close();
        }
    }

    public boolean updateUser(String word,String wordP) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "update  myTable set word=? where word=?";
        String[] obj = new String[]{word,wordP};
        db.execSQL(sql,obj);
        return true;
    }

	

}
