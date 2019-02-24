package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uiresource.cookit.VistaVirtual.Lista_Virtual;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaMultimedia extends AppCompatActivity {

    CircleImageView btnImagenes,btnVideos,btnVirtual;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_multimedia);

        btnImagenes = (CircleImageView) findViewById(R.id.btnImagenes);
        btnVideos = (CircleImageView)findViewById(R.id.btnVideos);
        btnVirtual = (CircleImageView)findViewById(R.id.btnVirtual);

        btnHome = (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaMultimedia.this, Navegacion.class);
                startActivity(i);
            }
        });

        btnImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaMultimedia.this, Imagenes.class);
                startActivity(i2);
            }
        });


        btnVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(ListaMultimedia.this, Videos.class);
                startActivity(i3);
            }
        });


        btnVirtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(ListaMultimedia.this, Lista_Virtual.class);
                startActivity(i4);
            }
        });





    }



}
