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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivityCentrodeInterpretacionTuristica extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;

    Button botonSatelital, botonRelieve, botonHibrido, botonNormal, botonDesconocido;
    TextView lat,longit;

    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_centrode_interpretacion_turistica);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        botonSatelital= (Button)findViewById(R.id.btnSatelitalC);
        botonRelieve= (Button)findViewById(R.id.btnRelieveC);
        botonHibrido= (Button)findViewById(R.id.btnHibridoC);
        botonNormal= (Button)findViewById(R.id.btnNormalC);
        botonDesconocido= (Button)findViewById(R.id.btnDesconocidoC);
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
        //LatLng sydneya = new LatLng(-3.8427778,-79.3438888);
        LatLng sydney = new LatLng(-3.845300,-79.344618);
        LatLng sydney1 = new LatLng(-3.844458,-79.344205);
        LatLng sydne2 = new LatLng(-3.843574,-79.344116);
        LatLng sydney3 = new LatLng(-3.842818,-79.344364);


        mMap.addMarker(new MarkerOptions().position(sydney).title("Centro de Interpretación Turística"));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Centro de Interpretación Turística1"));
        mMap.addMarker(new MarkerOptions().position(sydne2).title("Centro de Interpretación Turística2"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Centro de Interpretación Turística3"));

        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(sydney,sydney1,sydne2,sydney3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSatelitalC:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.btnRelieveC:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.btnHibridoC:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.btnNormalC:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.btnDesconocidoC:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }
    }
}
