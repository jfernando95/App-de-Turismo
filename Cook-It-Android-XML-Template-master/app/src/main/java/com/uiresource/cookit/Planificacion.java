package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class Planificacion extends AppCompatActivity {

    CircleImageView listaRuta,informacion,fiestasyferias,armatuplan;
    Button btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificacion);
        listaRuta = (CircleImageView) findViewById(R.id.btnlistaRuta);
        btnHome = (Button) findViewById(R.id.btnHome);
        informacion = (CircleImageView) findViewById(R.id.informacion);
        fiestasyferias=(CircleImageView)findViewById(R.id.fiestasyferias);
        armatuplan=(CircleImageView)findViewById(R.id.armatuplan);

        listaRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listaruta = new Intent(Planificacion.this, Lista_Rutas.class);
                startActivity(listaruta);

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Planificacion.this, Navegacion.class);
                startActivity(home);
            }
        });


        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Planificacion.this, Informacion.class);
                startActivity(home);
            }
        });

        fiestasyferias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Planificacion.this, FiestasyFerias.class);
                startActivity(home);
            }
        });

        armatuplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Planificacion.this, ListaPlanes.class);
                startActivity(home);
            }
        });


    }
}
