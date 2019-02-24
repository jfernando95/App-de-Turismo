package com.uiresource.cookit;

import android.app.ProgressDialog;
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
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivityruta extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener,GoogleMap.OnPolylineClickListener, GoogleMap.OnPolygonClickListener{

    private GoogleMap mMap;

    Button botonSatelital, botonRelieve, botonHibrido, botonNormal, botonDesconocido;
    TextView lat,longit;

    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activityruta);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        botonSatelital= (Button)findViewById(R.id.btnSatelitalD);
        botonRelieve= (Button)findViewById(R.id.btnRelieveD);
        botonHibrido= (Button)findViewById(R.id.btnHibridoD);
        botonNormal= (Button)findViewById(R.id.btnNormalD);
        botonDesconocido= (Button)findViewById(R.id.btnDesconocidoD);
        /*lat=(TextView)findViewById(R.id.txtLatitud);
        longit=(TextView)findViewById(R.id.txtLongitud);

        requestQueue = Volley.newRequestQueue(MapsActivity.this);
        cargarWebService();*/

        botonSatelital.setOnClickListener(this);
        botonRelieve.setOnClickListener(this);
        botonHibrido.setOnClickListener(this);
        botonNormal.setOnClickListener(this);
        botonDesconocido.setOnClickListener(this);

        requestQueue = Volley.newRequestQueue(MapsActivityruta.this);
        cargarWebService();

    }

    private void cargarWebService(){
        progressDialog= new ProgressDialog(MapsActivityruta.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachuquiribambagualel.php";

        final JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("rutachuquiribambagualel");



                        /*nombre_ruta.setText(json_array+"");
                        ubicacion.setText(json_array+"");
                        descripcionruta.setText(json_array+"");
                        actividadturi.setText(json_array+"");
                        recomendacion.setText(json_array+"");
                        latitud.setText(json_array+"");
                        longitud.setText(json_array+"");*/

                        String latit ="";
                        String ubi ="";
                        String actividades ="";
                        String recomendacions ="";
                        String x ="";
                        String lat ="";
                        String lon ="";
                        for (int i = 0; i < json_array.length(); i++) {
                            try {
                                //JSONObject c = json_array.getJSONObject(i);
                                Double latitud = json_array.getJSONObject(i).getDouble("latitud");
                                Double longitud = json_array.getJSONObject(i).getDouble("longitud");
                                Toast.makeText(MapsActivityruta.this,"lat"+latitud,Toast.LENGTH_SHORT).show();
                                Toast.makeText(MapsActivityruta.this,"long"+longitud,Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                       /* nombre_ruta.setText(nombre);
                        descripcionruta.setText(x);
                        actividadturi.setText(actividades);
                        ubicacion.setText(ubi);
                        recomendacion.setText(recomendacions);
                        //la=Double.parseDouble(lat);
                        //lo=Double.parseDouble(lon);
                        latitud.setText(lat);
                        longitud.setText(lon);*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(MapsActivityruta.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

String latitudes="";
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

        cargarWebService();

        Polyline polyline=googleMap.addPolyline(new PolylineOptions().clickable(true).add(

            new LatLng(-3.844962,-79.344697)

        ));
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);

        //LatLng sydney = new LatLng(-3.9100000,-79.2894444);
       /* 1LatLng sydney = new LatLng(-3.844962,-79.344697);
        LatLng sydney1 = new LatLng(-3.844845,-79.344613);
        LatLng sydne2 = new LatLng(-3.844745,-79.344518);
        LatLng sydney3 = new LatLng(-3.844673,-79.344445);
        LatLng sydney4 = new LatLng(-3.844202,-79.343764);*/

        /*LatLng sydney5 = new LatLng(-3.844673,-79.344445);
        LatLng sydney6 = new LatLng(-3.844673,-79.344445);
        LatLng sydney7 = new LatLng(-3.844673,-79.344445);
        LatLng sydney8 = new LatLng(-3.844673,-79.344445);
        LatLng sydney9 = new LatLng(-3.844673,-79.344445);
        LatLng sydney10 = new LatLng(-3.844673,-79.344445);*/


       /* 2mMap.addMarker(new MarkerOptions().position(sydney).title("Mirador Tunduranga"));
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Mirador Tunduranga1"));
        mMap.addMarker(new MarkerOptions().position(sydne2).title("Mirador Tunduranga2"));
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Mirador Tunduranga3"));
        mMap.addMarker(new MarkerOptions().position(sydney4).title("Mirador Tunduranga3"));*/

       /* 3Polyline polyline=mMap.addPolyline(new PolylineOptions().add(sydney,sydney1,sydne2,sydney3,sydney4));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSatelitalD:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;

            case R.id.btnRelieveD:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

            case R.id.btnHibridoD:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;

            case R.id.btnNormalD:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

            case R.id.btnDesconocidoD:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;
        }
    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }

    @Override
    public void onPolygonClick(Polygon polygon) {

    }
}
