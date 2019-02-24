
package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaPlanes extends AppCompatActivity {

    Button btnHome;
    CircleImageView gastronomia,agenciadeviajes,transporte,alojamiento;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planes);


        btnHome = (Button) findViewById(R.id.btnHome);
        gastronomia = (CircleImageView) findViewById(R.id.gastronomia);
        agenciadeviajes = (CircleImageView) findViewById(R.id.agenciadeviajes);
        transporte = (CircleImageView) findViewById(R.id.transporte);
        alojamiento = (CircleImageView) findViewById(R.id.alojamiento);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent home = new Intent(ListaPlanes.this, Planificacion.class);
                startActivity(home);
            }
        });


        gastronomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListaPlanes.this, Gastronomia.class);
                startActivity(home);
            }
        });


        agenciadeviajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListaPlanes.this, AgenciasdeViajes.class);
                startActivity(home);
            }
        });


        transporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListaPlanes.this, Transporte.class);
                startActivity(home);
            }
        });


        alojamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ListaPlanes.this, Alojamiento.class);
                startActivity(home);
            }
        });



    }
}
