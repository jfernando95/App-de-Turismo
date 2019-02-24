package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Mapa extends AppCompatActivity {
    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

    }
    private void cargarWebService(){
        progressDialog= new ProgressDialog(Mapa.this);
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
                               // mMap.addMarker(new MarkerOptions().position(Chuquiribamba).title("sdfg").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Mapa.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
