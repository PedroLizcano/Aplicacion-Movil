package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void ingresar(View vista){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void ver(View vista){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void lista(View vista){
        Intent intent = new Intent(this, TodosContactos.class);
        startActivity(intent);
    }
}
