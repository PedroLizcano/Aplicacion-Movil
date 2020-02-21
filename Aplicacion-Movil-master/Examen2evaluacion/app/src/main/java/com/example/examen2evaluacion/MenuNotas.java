package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuNotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_notas);
        getSupportActionBar().hide();
    }
    public void ingresar(View vista){
        Intent intent = new Intent(this, InsertarNotas.class);
        startActivity(intent);
    }
    public void ver(View vista){
        Intent intent = new Intent(this, VerNotas.class);
        startActivity(intent);
    }
    public void volver(View vista){
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}
