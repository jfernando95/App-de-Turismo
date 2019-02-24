package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class    MapsActivityAlfareriaBarrioCera extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;

    Button botonSatelital, botonRelieve, botonHibrido, botonNormal, botonDesconocido;
    TextView lat,longit;

    ProgressDialog progressDialog;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_alfareria_barrio_cera);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        botonSatelital= (Button)findViewById(R.id.btnSatelitalA);
        botonRelieve= (Button)findViewById(R.id.btnRelieveA);
        botonHibrido= (Button)findViewById(R.id.btnHibridoA);
        botonNormal= (Button)findViewById(R.id.btnNormalA);
        botonDesconocido= (Button)findViewById(R.id.btnDesconocidoA);
        /*lat=(TextView)findViewById(R.id.txtLatitud);
        longit=(TextView)findViewById(R.id.txtLongitud);

        requestQueue = Volley.newRequestQueue(MapsActivity.this);
        cargarWebService();*/

        botonSatelital.setOnClickListener(this);
        botonRelieve.setOnClickListener(this);
        botonHibrido.setOnClickListener(this);
        botonNormal.setOnClickListener(this);
        botonDesconocido.setOnClickListener(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-3.9063889,-79.2863888);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Alfarería en el Barrio Cera"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSatelitalA:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.btnRelieveA:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.btnHibridoA:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.btnNormalA:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.btnDesconocidoA:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }
    }
}
