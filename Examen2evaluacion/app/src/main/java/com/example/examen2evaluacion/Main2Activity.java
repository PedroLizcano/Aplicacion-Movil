package com.example.examen2evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {



    Button subirdatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String dato = getIntent().getStringExtra("dato");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");
        String dato4 = getIntent().getStringExtra("dato4");
        LinearLayout verNombre = findViewById(R.id.layoutnombre);
        TextView nombres=new TextView(this);
        nombres.setText(dato);
        verNombre.addView(nombres);

        LinearLayout verApellidos = findViewById(R.id.layoutapellidos);
        TextView apellidos=new TextView(this);
        apellidos.setText(dato2);
        verApellidos.addView(apellidos);

        LinearLayout verCurso = findViewById(R.id.layoutcurso);
        TextView curso=new TextView(this);
        curso.setText(dato3);
        verCurso.addView(curso);

        LinearLayout vertelefono= findViewById(R.id.layouttelefono);
        TextView telefono=new TextView(this);
        telefono.setText(dato4);
        vertelefono.addView(telefono);



        subirdatos=findViewById(R.id.cambiarescribir);
        subirdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void cambiolista(View Vista) {
        Intent intent = new Intent(Vista.getContext(), TodosContactos.class);
        startActivityForResult(intent, 0);

    }
    public void cambiomenu(View Vista) {
        Intent intent = new Intent(Vista.getContext(), Menu.class);
        startActivityForResult(intent, 0);

    }

}
