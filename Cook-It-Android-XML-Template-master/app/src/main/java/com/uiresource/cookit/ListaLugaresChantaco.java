package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaLugaresChantaco extends AppCompatActivity {
    CircleImageView lugarChorrera;
    Button btnHome;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares_chantaco);
        lugarChorrera= (CircleImageView) findViewById(R.id.lugarChorreradeShillipara);
        btnHome= (Button) findViewById(R.id.btnHome);
        String d="Los pobladores de Chantaco desde sus inicios han sido muy trabajadores y entusiastas para fojar el desarrollo de su pueblo, para ello han conformado organizaciones y comités. En 1810 se organiza el comité pro construcción de la capilla, hasta lograr su terminación. En 1930, se crea la escuela fiscal mixta Benjamín Franklin, la misma que ha educado a miles de ciudadanos; en 1949 al ser nombrado párroco de Chuquiribamba el padre José María Narváez, llega con el primer carro Ford 350 a estos pueblos, que por falta de carretera no podía llegar hasta Chuquiribamba," +
                " entonces  sus pobladores deciden trabajar una vía piloto para transportar el vehículo desde Catamayo pasando por Chiniloma la parte alta de la hacienda Chichaca, Chantaco hasta llegar a Chuquiribamba..";
        desc=(TextView)findViewById(R.id.descChantaco);
        desc.setText(d);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ListaLugaresChantaco.this,Parroquias.class);
                startActivity(i);
            }
        });

        lugarChorrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresChantaco.this, lugarIglesiaChantaco.class);
                startActivity(i2);
            }
        });
    }
}
