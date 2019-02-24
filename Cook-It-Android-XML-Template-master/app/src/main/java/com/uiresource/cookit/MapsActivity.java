package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;
    Marker myMarker;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    Button botonSatelital, botonRelieve, botonHibrido, botonNormal, botonDesconocido;
    TextView lat,longit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        botonSatelital= (Button)findViewById(R.id.btnSatelital);
        botonRelieve= (Button)findViewById(R.id.btnRelieve);
        botonHibrido= (Button)findViewById(R.id.btnHibrido);
        botonNormal= (Button)findViewById(R.id.btnNormal);
        botonDesconocido= (Button)findViewById(R.id.btnDesconocido);


        botonSatelital.setOnClickListener(this);
        botonRelieve.setOnClickListener(this);
        botonHibrido.setOnClickListener(this);
        botonNormal.setOnClickListener(this);
        botonDesconocido.setOnClickListener(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

        LatLng ecuador = new LatLng(-3.844962,-79.2888698);
        LatLng pChuquiribamba = new LatLng(-3.8434782,-79.3430353);

        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.chuquiribamba);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker =  Bitmap.createScaledBitmap(b,100,100,false);

        BitmapDrawable bitmapdraw1= (BitmapDrawable)getResources().getDrawable(R.drawable.chuquiribamba);
        Bitmap b1= bitmapdraw1.getBitmap();
        Bitmap smallMarker1= Bitmap.createScaledBitmap(b1,100,100,false);
        myMarker = mMap.addMarker(new MarkerOptions().position(pChuquiribamba).title("Marker").icon(BitmapDescriptorFactory.fromBitmap(smallMarker1)));

       mMap.moveCamera(CameraUpdateFactory.newLatLng(ecuador));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));

        mMap.setOnMarkerDragListener((GoogleMap.OnMarkerDragListener) this);

        //LatLng sydney = new LatLng(-3.9100000,-79.2894444);
       /* LatLng sydney = new LatLng(-3.949519,-79.269697);
        LatLng sydney1 = new LatLng(-3.946336,-79.268772);
        LatLng sydne2 = new LatLng(-3.944058,-79.269333);
        LatLng sydney3 = new LatLng(-3.941381,-79.268778);


        mMap.addMarker(new MarkerOptions().position(sydney).title("Mirador Tunduranga"));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Mirador Tunduranga1"));
        mMap.addMarker(new MarkerOptions().position(sydne2).title("Mirador Tunduranga2"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Mirador Tunduranga3"));

        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(sydney,sydney1,sydne2,sydney3));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

    }
    private void cargarWebService(){
        progressDialog= new ProgressDialog(MapsActivity.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachuquiribambagualel.php";

        JSONObject json = new JSONObject();

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("rutachuquiribambagualel");
                        LatLng c []=new LatLng[json_array.length()];
                        for (int i = 0; i < json_array.length(); i++) {
                            try {
                                JSONObject jsonObject= json_array.getJSONObject(i);
                                LatLng Chuquiribamba = new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()),Double.parseDouble(jsonObject.get("longitud").toString()));
                                mMap.addMarker(new MarkerOptions().position(Chuquiribamba).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(MapsActivity.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSatelital:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.btnRelieve:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.btnHibrido:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.btnNormal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.btnDesconocido:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }
    }
}
