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

import java.util.ArrayList;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellidos;
    private EditText correo;
    private EditText telefono;
    ListView listas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText)findViewById(R.id.escribirnombre);
        apellidos=(EditText)findViewById(R.id.escribirapellido);
        correo=(EditText)findViewById(R.id.escribircurso);
        telefono=(EditText)findViewById(R.id.escribirtelefono);




    }
    public void cambiarpantalla(View vista){
        Intent intent = new Intent(vista.getContext(), Main2Activity.class);
        startActivityForResult(intent, 0);
        intent.putExtra("dato",nombre.getText().toString());
        intent.putExtra("dato2",apellidos.getText().toString());
        intent.putExtra("dato3",correo.getText().toString());
        intent.putExtra("dato4",telefono.getText().toString());
        startActivityForResult(intent, 0);
    }
    public void guardardatos(View vista){
        String Nombre=nombre.getText().toString();
        String Apellidos=apellidos.getText().toString();
        String Correo=correo.getText().toString();
        String Telefono=telefono.getText().toString();
        DataBase data = new DataBase(this, "Contactos", null, 1);
        SQLiteDatabase sql = data.getWritableDatabase();
        ContentValues contactos = new ContentValues();
        contactos.put("Nombre",Nombre);
        contactos.put("Apellidos",Apellidos);
        contactos.put("Correo",Correo);
        contactos.put("Telefono",Telefono);
        sql.insert("Contactos",null,contactos);
        sql.close();

        ArrayList array_list = data.getAllRegistros();
        ArrayAdapter<String> arraylistas=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);

        listas.setAdapter(arraylistas);
        Intent intent = new Intent(this, TodosContactos.class);
        startActivity(intent);

    }


}
