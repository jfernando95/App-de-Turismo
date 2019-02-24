package com.uiresource.cookit;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class Parroquias  extends AppCompatActivity {

    CircleImageView btnMirador,btnChantaco,btnChuquiribamba,btnGualel,btnElCisne;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parroquias);

        btnMirador= (CircleImageView) findViewById(R.id.btnMirador);
        btnChantaco= (CircleImageView) findViewById(R.id.btnChantacoo);
        btnChuquiribamba= (CircleImageView) findViewById(R.id.btnChuquiribamba);
        btnGualel= (CircleImageView) findViewById(R.id.btnGualel);
        btnElCisne= (CircleImageView) findViewById(R.id.btnElCisne);


        btnHome= (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Parroquias.this,Navegacion.class);
                startActivity(i);
            }
        });

        btnMirador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Parroquias.this,Lista_Lugares.class);
                startActivity(i2);
            }
        });
        btnChantaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Parroquias.this,ListaLugaresChantaco.class);
                startActivity(i2);
            }
        });
        btnChuquiribamba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Parroquias.this,ListaLugaresChuquiribamba.class);//
                startActivity(i2);
            }
        });
        btnGualel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Parroquias.this,ListaLugaresGualel.class);//
                startActivity(i2);
            }
        });
        btnElCisne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Parroquias.this,ListaLugaresElCisne.class);//
                startActivity(i2);
            }
        });
    }
}
