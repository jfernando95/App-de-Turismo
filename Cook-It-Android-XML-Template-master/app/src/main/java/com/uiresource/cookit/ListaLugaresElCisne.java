package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaLugaresElCisne extends AppCompatActivity {

    CircleImageView lugarSantuarioElCisne;
    Button btnHome;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lugares_el_cisne);
        lugarSantuarioElCisne= (CircleImageView) findViewById(R.id.lugarSantuarioElCisne);
        btnHome= (Button) findViewById(R.id.btnHome);
        String d="El Cisne, fue nombrada Parroquia Rural en el año de 1986. La Parroquia El Cisne se encuentra a 70 Km de Loja." +
                "\n"+"El 30 de Mayo y el 15 de Agosto se celebran sus principales festividades. Inmediatamente después de la festividad de Agosto, se realiza un acto religioso muy impresionante ya que los devotos llevan en sus hombros la hermosa imagen hasta la ciudad de Loja, la tarde del 20 de agosto ingresa a Loja la Virgen del Cisne para presidir las festividades religiosas, comerciales y agrícolas que desde 1824 se efectúan el 8 de septiembre, según decreto del Libertador Simón Bolívar. " +
                "El 1ro de noviembre retorna a la parroquia en hombros de sus devotos.";
        desc=(TextView)findViewById(R.id.descElCisne);
        desc.setText(d);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ListaLugaresElCisne.this,Parroquias.class);
                startActivity(i);
            }
        });

        lugarSantuarioElCisne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ListaLugaresElCisne.this,lugarSantuarioElCisne.class);
                startActivity(i2);
            }
        });
    }
}
