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

public class VerNotas extends AppCompatActivity {
    ListView listaView;
    DataBase2 admin;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notas);
        ListView listaView = (ListView) findViewById(R.id.Lista); //Localizamos la ListView donde introduciremos nuestras notas
        getSupportActionBar().hide();

        //Llamo al metodo getAllRegistros que lista todos lo datos registrados de la base de datos.
        admin = new DataBase2(this, "Notas", null, 1);
        final ArrayList array_list = admin.guardar();
        ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(
                        this,android.R.layout.simple_list_item_1, array_list);
        listaView.setAdapter(arrayAdapter);


        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(VerNotas.this, "Has pulsado: "+ array_list.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
