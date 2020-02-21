package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                Inicio();
                return true;
            case R.id.action_nuevo:
                Toast toast = Toast.makeText(this, "Aplicacion creada por Pedro Solano para la clase de Programacion de Dispositivos Moviles", Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.action_buscar:
                imagen();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void Contactos(View vista){
        Intent intent = new Intent(this, menucontactos.class);
        startActivity(intent);
    }

    public void Notas(View vista){
        Intent intent = new Intent(this,MenuNotas.class);
        startActivity(intent);
    }
    public void Inicio(){
        Intent intent = new Intent(this,MenuPrincipal.class);
        startActivity(intent);
    }
    public void imagen(){
        Intent intent = new Intent(this,Imagen.class);
        startActivity(intent);
    }

}
