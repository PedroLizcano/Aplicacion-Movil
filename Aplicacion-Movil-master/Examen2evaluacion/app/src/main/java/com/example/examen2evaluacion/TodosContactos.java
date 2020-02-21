package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodosContactos extends AppCompatActivity {
    ListView listaView;
    DataBase admin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_contactos);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        ListView listaView = (ListView) findViewById(R.id.Lista); //Localizamos la ListView donde introduciremos nuestras notas

        //Llamo al metodo getAllRegistros que lista todos lo datos registrados de la base de datos.
        admin = new DataBase(this, "Contactos", null, 1);
        final ArrayList array_list = admin.guardar();
        ArrayAdapter<String> arrayAdapter=//sirve para guardar los datos de un array y luego mostrarlos en una listview
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter);


        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(TodosContactos.this, "Has pulsado: "+ array_list.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void vaciarlista(View vista){
        admin = new DataBase(this, "Contactos", null, 1);

    }
}
