package com.uiresource.cookit.VistaVirtual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.uiresource.cookit.R;

public class Lista_Virtual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__virtual);
    }

    public void Catedral(View view) {
        startActivity(new Intent(this, Catedral.class));
    }

    public void PuertaCiudad(View view) {
        startActivity(new Intent(this, PuertaCiudad.class));
    }
}
