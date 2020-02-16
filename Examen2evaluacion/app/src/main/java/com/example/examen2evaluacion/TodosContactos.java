package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TodosContactos extends AppCompatActivity {
    ListView listaView;
    DataBase admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_contactos);
        ListView listaView = (ListView) findViewById(R.id.Lista); //Localizamos la ListView donde introduciremos nuestras notas

        //Llamo al metodo getAllRegistros que lista todos lo datos registrados de la base de datos.
        admin = new DataBase(this, "Contactos", null, 1);
        ArrayList array_list = admin.getAllRegistros();
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter);
    }
}
