package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaLugaresGualel extends AppCompatActivity {

    CircleImageView lugarCascadaSanFrancisco,lugarCascadaHumuto;
    Button btnHome;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares_gualel);
        lugarCascadaSanFrancisco= (CircleImageView) findViewById(R.id.btnCascadaSanFrancisco);
        lugarCascadaHumuto= (CircleImageView) findViewById(R.id.btnCascadaHumuto);
        btnHome= (Button) findViewById(R.id.btnHome);
        String d="La parroquia Gualel tiene sus límites plenamente establecidos por el relieve topográfico (línea de cumbre); ya que se encuentra rodeada por el nudo de Guagrahuma y las cordilleras de Fierrohurco." +
                "\n"+"Los habitantes de este sector consumen productos de su propia cosecha como: maíz, haba, fréjol, mellocos, papas, etc. Gualel goza de un clima tipo templado andino, debido a la diversidad de pisos altitudinales propios de la irregular topografía de la región;" +
                " favorable clima, porque se desarrolla una flora y fauna muy variada.";
        desc=(TextView)findViewById(R.id.descGualel);
        desc.setText(d);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ListaLugaresGualel.this,Parroquias.class);
                startActivity(i);
            }
        });
        lugarCascadaSanFrancisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresGualel.this,lugarCascadaSanFrancisco.class);
                startActivity(i2);
            }
        });
        lugarCascadaHumuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresGualel.this,lugarCascadaHumuto.class);
                startActivity(i2);
            }
        });
    }
}
