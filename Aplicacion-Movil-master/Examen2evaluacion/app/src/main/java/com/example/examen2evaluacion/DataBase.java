package com.example.examen2evaluacion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Contactos(telefono varchar (45) primary key,Nombre varchar(45) not null, Apellidos varchar(300) not null,Correo varchar(20)  not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists Contactos");
        db.execSQL("create table Contactos(telefono varchar (45) primary key,Nombre varchar(45) not null, Apellidos varchar(300) not null,Correo varchar(20)  not null)");
    }

    public ArrayList<String> guardar()
    {
        ArrayList<String> array_list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Contactos", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(" "+res.getString(0) +"\n "+"\n "+" "+
                    res.getString(1) + "\n "+"\n "+ res.getString(2)+ "\n "+"\n "+ res.getString(3));
            res.moveToNext();}
        return array_list;
    }


}

