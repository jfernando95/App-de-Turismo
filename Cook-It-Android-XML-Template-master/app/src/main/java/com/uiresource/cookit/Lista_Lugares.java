package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Lista_Lugares extends AppCompatActivity {

    CircleImageView lugarMirador,lugarAlfareria;
    Button btnHome;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__lugares);

        lugarMirador= (CircleImageView) findViewById(R.id.lugarMirador);
        lugarAlfareria= (CircleImageView) findViewById(R.id.lugarAlfareria);
        String d="Taquil cuna de artistas, bien puede ser considerada la “Capital musical del cantón”, por los antecedentes de virtuosismo en la ejecución de diferentes instrumentos musicales de  sus habitantes." +
                "\n"+"Ubicada al noroccidente  de la ciudad de Loja, se encuentra la parroquia Taquil, cuya población es de 3.323 habitantes según el Censo Nacional del 2001. Este sitio prodigioso por su  naturaleza," +
                " patrimonio cultural, arqueológico, artesanal y musical, le ha permitido ganarse un espacio en la historia de Loja y el país.";
        desc=(TextView)findViewById(R.id.descTaquil);
        desc.setText(d);
        btnHome= (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Lista_Lugares.this,Parroquias.class);
                startActivity(i);
            }
        });

        lugarMirador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Lugares.this,Ruta.class);
                startActivity(i2);
            }
        });
        lugarAlfareria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lista_Lugares.this,lugarAlfareriaBarrioCera.class);
                startActivity(i2);
            }
        });


    }
}
