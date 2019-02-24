package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityChorreradeSillipara extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;

    Button botonSatelital, botonRelieve, botonHibrido, botonNormal, botonDesconocido;
    TextView lat,longit;

    ProgressDialog progressDialog;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_chorrerade_sillipara);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        botonSatelital= (Button)findViewById(R.id.btnSatelitalB);
        botonRelieve= (Button)findViewById(R.id.btnRelieveB);
        botonHibrido= (Button)findViewById(R.id.btnHibridoB);
        botonNormal= (Button)findViewById(R.id.btnNormalB);
        botonDesconocido= (Button)findViewById(R.id.btnDesconocidoB);
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

        LatLng sydney = new LatLng(-3.8799500,-79.3272000);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Chorrera de Shillipara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        mMap.setOnInfoWindowClickListener(this);
        Marker melbourne = mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Chorrera de Shillipara")
                .snippet("LatLong: -3.8799500,-79.3272000"));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSatelitalB:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.btnRelieveB:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.btnHibridoB:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.btnNormalB:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.btnDesconocidoB:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }
}
