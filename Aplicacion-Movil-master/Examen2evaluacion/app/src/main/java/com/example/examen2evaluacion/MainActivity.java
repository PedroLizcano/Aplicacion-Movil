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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;//creo los edittext que serviran para recoger la informacion de los plaintext
    private EditText apellidos;
    private EditText correo;
    private EditText telefono;
    ListView listas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para quitar el ActionBar
        getSupportActionBar().hide();

        nombre=(EditText)findViewById(R.id.escribirnombre);//cojo la informacion de los plaintext
        apellidos=(EditText)findViewById(R.id.escribirapellido);
        correo=(EditText)findViewById(R.id.escribircurso);
        telefono=(EditText)findViewById(R.id.escribirtelefono);




    }
    public void cambiarpantalla(View vista){
        Intent intent = new Intent(vista.getContext(), Main2Activity.class);//cambio de pantalla mandandole la informacion de los edittext
        startActivityForResult(intent, 0);
        intent.putExtra("dato",nombre.getText().toString());
        intent.putExtra("dato2",apellidos.getText().toString());
        intent.putExtra("dato3",correo.getText().toString());
        intent.putExtra("dato4",telefono.getText().toString());
        startActivityForResult(intent, 0);
    }
    public void guardardatos(View vista){
        String Nombre=nombre.getText().toString();//paso a string la informacion recogida de los plaintext
        String Apellidos=apellidos.getText().toString();
        String Correo=correo.getText().toString();
        String Telefono=telefono.getText().toString();
        DataBase data = new DataBase(this, "Contactos", null, 1);//creo un objeto de la base de datos de contactos
        SQLiteDatabase sql = data.getWritableDatabase();//creo unj objeto que la permita escribir en la base de datos
        ContentValues contactos = new ContentValues();//un objeto para seleccionar los datos que queremos meter
        contactos.put("Nombre",Nombre);//añado los datos
        contactos.put("Apellidos",Apellidos);
        contactos.put("Correo",Correo);
        contactos.put("Telefono",Telefono);
        sql.insert("Contactos",null,contactos);//los inserto en la base de datos
        sql.close();

        ArrayList array_list = data.guardar();//llamo al metodo de la base de datos de coger los registros
        ArrayAdapter<String> arraylistas=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, array_list);

        Toast toast = Toast.makeText(this, "Contacto guardado con exito", Toast.LENGTH_SHORT);//se muestra por pantalla el mensaje
        toast.show();
        Intent intent = new Intent(this, TodosContactos.class);
        startActivity(intent);


    }


}
