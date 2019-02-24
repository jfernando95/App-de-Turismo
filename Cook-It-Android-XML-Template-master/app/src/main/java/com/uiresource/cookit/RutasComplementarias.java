package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class RutasComplementarias extends AppCompatActivity {

    CircleImageView lugarrutauno,lugarrutados;
    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas_complementarias);
        lugarrutauno= (CircleImageView) findViewById(R.id.lugarRutaUno);
        lugarrutados= (CircleImageView) findViewById(R.id.lugarRutaDos);
        btnHome= (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(RutasComplementarias.this,Navegacion.class);
                startActivity(i);
            }
        });

        lugarrutauno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(RutasComplementarias.this,MapaRCUno.class);
                startActivity(i2);
            }
        });
        lugarrutados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(RutasComplementarias.this,MapaRCDos.class);
                startActivity(i2);
            }
        });


    }
}
