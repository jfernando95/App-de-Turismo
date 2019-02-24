package com.uiresource.cookit.VistaVirtual;

import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;
import com.uiresource.cookit.R;

//import co.gofynd.gravityview.GravityView;

public class Catedral extends AppCompatActivity {


    private GyroscopeObserver gyroscopeObserver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catedral);

        gyroscopeObserver = new GyroscopeObserver();

        PanoramaImageView panoramaImageView = (PanoramaImageView) findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);

    }


    @Override
    protected void onResume() {
        super.onResume();
        gyroscopeObserver.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }




}