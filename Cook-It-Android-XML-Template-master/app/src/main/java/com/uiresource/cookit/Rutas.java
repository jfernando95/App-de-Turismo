package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Rutas extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    Marker myMarker;
    Polyline p;
    RequestQueue requestQueue;
    ProgressDialog progressDialog;

    Button botonSatelital,botonRelieve,botonHibrido,botonNormal,botonDesconocido;
    ModeloRuta rut;
    ArrayList<ModeloRuta> listas;
    ArrayList<LatLng> dts;
    LatLng d [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);
        botonSatelital=(Button) findViewById(R.id.btnSt);
        botonRelieve=(Button) findViewById(R.id.btnRe);
        botonHibrido=(Button) findViewById(R.id.btnHi);
        botonNormal=(Button) findViewById(R.id.btnNo);
        //botonDesconocido=(Button) findViewById(R.id.btnDes);
        botonSatelital.setOnClickListener(this);
        botonRelieve.setOnClickListener(this);
        botonHibrido.setOnClickListener(this);
        botonNormal.setOnClickListener(this);
        //botonDesconocido.setOnClickListener(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        requestQueue = Volley.newRequestQueue(Rutas.this);
        cargarWebService();

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
        float zoomLevel = 14.0f; //This goes up to 21


        // Add a marker in Sydney and move the camera
        LatLng taquil = new LatLng(-3.8847434, -79.2888043);
        //BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.chantaco);
        //Bitmap b=bitmapdraw.getBitmap();
        //Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
        mMap.addMarker(new MarkerOptions().position(taquil).title("TAQUIL"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taquil,zoomLevel));
    }

    private void cargarWebService(){
        /*progressDialog= new ProgressDialog(Rutas.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutaltaquil.php";
        final String url1 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachantaco.php";
        final String url2 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachuquiribambagualel.php";
        final String url3 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutagualelcisneuno.php";*/
        progressDialog= new ProgressDialog(Rutas.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutaltaquil.php";
        final String url1 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachantaco.php";
        final String url2 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachuquiribambagualel.php";
        final String url3 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutagualelcisneuno.php";

        JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        Toast.makeText(Rutas.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutataquil");
                        LatLng c [] = new LatLng[json_array.length()];
                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Taquil = new LatLng(Double.parseDouble(jsonObject.get("latitudtaquil").toString()), Double.parseDouble(jsonObject.get("longitudtaquil").toString()));
                                //mMap.addMarker(new MarkerOptions().position(Taquil).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.chantaco)));
                                mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudtaquil").toString()), Double.parseDouble(jsonObject.get("longitudtaquil").toString()))).width(4).color(Color.RED));
                                c[i] = Taquil;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Rutas.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);




        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, url1,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        Toast.makeText(Rutas.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutachantaco");
                        LatLng c [] = new LatLng[json_array.length()];

                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Chantaco = new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()));
                                //mMap.addMarker(new MarkerOptions().position(Chantaco).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                                mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()))).width(4).color(Color.RED));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()))));
                                c[i] = Chantaco;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Rutas.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, url2,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        Toast.makeText(Rutas.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutachuquiribambagualel");
                        LatLng c [] = new LatLng[json_array.length()];

                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Chuquiribamba = new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()), Double.parseDouble(jsonObject.get("longitud").toString()));
                                //mMap.addMarker(new MarkerOptions().position(Chantaco).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()), Double.parseDouble(jsonObject.get("longitud").toString()))).width(4).color(Color.RED));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()), Double.parseDouble(jsonObject.get("longitud").toString()))));
                                c[i] = Chuquiribamba;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Rutas.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.GET, url3,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        Toast.makeText(Rutas.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutagualelcisne1");
                        LatLng c [] = new LatLng[json_array.length()];

                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng cisne1 = new LatLng(Double.parseDouble(jsonObject.get("latitudgc").toString()), Double.parseDouble(jsonObject.get("longitudgc").toString()));
                                //mMap.addMarker(new MarkerOptions().position(cisne1).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                                mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudgc").toString()), Double.parseDouble(jsonObject.get("longitudgc").toString()))).width(4).color(Color.RED));
                                mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudgc").toString()), Double.parseDouble(jsonObject.get("longitudgc").toString()))));
                                c[i] = cisne1;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Rutas.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
        requestQueue.add(jsonObjectRequest1);
        requestQueue.add(jsonObjectRequest2);
        requestQueue.add(jsonObjectRequest3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSt:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.btnRe:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.btnHi:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.btnNo:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            /*case R.id.btnDes:
                mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
                break;*/
        }
    }
}
