package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertarNotas extends AppCompatActivity {
    private EditText nota;
    ListView listas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_notas);
        getSupportActionBar().hide();
        nota=(EditText)findViewById(R.id.escribirnota);

    }
    public void insertar(View vista){
        String Notas=nota.getText().toString();
        DataBase2 data = new DataBase2(this, "Notas", null, 1);
        SQLiteDatabase sql = data.getWritableDatabase();
        ContentValues notas = new ContentValues();
        notas.put("Notas",Notas);
        sql.insert("Notas",null,notas);
        sql.close();
        ArrayList array_list = data.guardar();
        ArrayAdapter<String> arraylistas=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);
        Toast toast = Toast.makeText(this, "Nota guardada con exito", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(vista.getContext(), VerNotas.class);
        startActivityForResult(intent, 0);
        finish();


    }
}

