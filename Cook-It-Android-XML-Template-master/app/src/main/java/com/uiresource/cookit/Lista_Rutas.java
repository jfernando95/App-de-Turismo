package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class Lista_Rutas extends AppCompatActivity {

    CircleImageView lblruta,lblAlfareria,lblChorreraSillipara,lblcentroInterpretacion,lblLomaGallinazo,lblCascadaSF,lblCascadaHumuto,lblSeLCisne;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__rutas);

        lblruta = (CircleImageView) findViewById(R.id.lblruta);
        lblAlfareria = (CircleImageView) findViewById(R.id.lblrutaAlfareriaBarrioCera);
        lblChorreraSillipara = (CircleImageView) findViewById(R.id.lblrutaChorreradeShillipara);
        lblcentroInterpretacion = (CircleImageView) findViewById(R.id.lblrutaCentroInterpretacionTuristica);
        lblLomaGallinazo = (CircleImageView) findViewById(R.id.lblrutaLomadeGallinazo);
        lblCascadaSF = (CircleImageView) findViewById(R.id.lblrutaCascadaSanFrancisco);
        lblCascadaHumuto = (CircleImageView) findViewById(R.id.lblrutaCascadaHumo);
        lblSeLCisne = (CircleImageView) findViewById(R.id.lblrutaSantuarioElCisne);
        btnHome = (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Lista_Rutas.this, Planificacion.class);
                startActivity(i);
            }
        });

        lblruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaMiradorTunduranga.class);
                startActivity(i2);
            }
        });
        lblAlfareria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaAlfareriaBarrioCera.class);
                startActivity(i2);
            }
        });
        lblChorreraSillipara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaChorreradeShillipara.class);
                startActivity(i2);
            }
        });
        lblcentroInterpretacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaCentrodeInterpretacionTuristica.class);
                startActivity(i2);
            }
        });
        lblLomaGallinazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaMTLomadeGallinazo.class);
                startActivity(i2);
            }
        });
        lblCascadaSF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaCascadaSanFrancisco.class);
                startActivity(i2);
            }
        });
        lblCascadaHumuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaCascadaHumuto.class);
                startActivity(i2);
            }
        });
        lblSeLCisne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Rutas.this, rutaSantuarioElCisne.class);
                startActivity(i2);
            }
        });
    }
    }