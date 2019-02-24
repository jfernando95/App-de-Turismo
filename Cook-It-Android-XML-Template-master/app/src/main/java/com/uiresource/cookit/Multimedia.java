package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class Multimedia extends AppCompatActivity {


    Button btnHome;
    CircleImageView listaImagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);


        btnHome = (Button) findViewById(R.id.btnHome);
        listaImagenes = (CircleImageView) findViewById(R.id.btnImagenes);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Multimedia.this, Navegacion.class);
                startActivity(i);
            }
        });

        listaImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Multimedia.this, Imagenes.class);
                startActivity(i2);
            }
        });

    }
}
