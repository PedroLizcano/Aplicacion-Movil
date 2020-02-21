package com.example.examen2evaluacion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase2 extends SQLiteOpenHelper {
    public DataBase2(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Notas(codigo integer(200)  primary key,Notas varchar(140) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists Notas");
        db.execSQL("create table Notas(codigo integer(200)   primary key AUTOINCREMENT,Notas varchar(140) not null)");
    }

    public ArrayList<String> guardar()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Notas", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(" "+res.getString(1)
            );
            res.moveToNext();
        }
        return array_list;

    }


}
