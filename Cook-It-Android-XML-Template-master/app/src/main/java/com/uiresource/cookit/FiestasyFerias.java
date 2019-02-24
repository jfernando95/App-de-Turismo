package com.uiresource.cookit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FiestasyFerias extends AppCompatActivity {

    Button btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiestasy_ferias);

        btnHome = (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(FiestasyFerias.this, Planificacion.class);
                startActivity(home);
            }
        });
    }
}
