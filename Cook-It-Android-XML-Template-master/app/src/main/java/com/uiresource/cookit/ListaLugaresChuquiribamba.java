package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaLugaresChuquiribamba extends AppCompatActivity {

    CircleImageView lugarCentroITuristica,lugarMiradorLomaGallinazo;
    Button btnHome;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares_chuquiribamba);
        lugarCentroITuristica= (CircleImageView) findViewById(R.id.btnCentroITuristica);
        lugarMiradorLomaGallinazo= (CircleImageView) findViewById(R.id.btnMiradorLomadeGallinazo);
        btnHome= (Button) findViewById(R.id.btnHome);
        String d="La parroquia de Chuquiribamba cuenta con un sistema productivo de calidad, referenciada en los mercados de Catamayo y Loja. Es productora de  las siembras de temporada; la cuenca escurre paulatinamente las lluvias de tal manera que la producción a temporal, sale con las precipitaciones. Los  agricultores deben utilizar las técnicas modernas para optimizar" +
                "  las siembras y dar buen uso del suelo y del agua. Deben utilizar para su producción abonos orgánicos.";
        desc=(TextView)findViewById(R.id.descChuquiribamba);
        desc.setText(d);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ListaLugaresChuquiribamba.this,Parroquias.class);
                startActivity(i);
            }
        });
        lugarCentroITuristica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresChuquiribamba.this,lugarCentrodeInterpretacionTuristica.class);
                startActivity(i2);
            }
        });
        lugarMiradorLomaGallinazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresChuquiribamba.this,lugarMiradorLomaGallinazoo.class);
                startActivity(i2);
            }
        });
    }

}
