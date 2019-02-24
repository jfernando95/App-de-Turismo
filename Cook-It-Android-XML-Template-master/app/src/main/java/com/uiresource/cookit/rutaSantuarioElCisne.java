package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rutaSantuarioElCisne extends AppCompatActivity {

    ImageView btnRuta;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    TextView nombre_ruta,ubicacion;
    TextView latitud,longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta_santuario_el_cisne);
        nombre_ruta=(TextView)findViewById(R.id.txtnombrerutaSantuarioElCisne);
        btnRuta=(ImageView)findViewById(R.id.btnRutaSantuarioElCisne);
        latitud=(TextView)findViewById(R.id.tgtLatitudSantuarioElCisne);
        longitud=(TextView)findViewById(R.id.tgtLongitudSantuarioElCisne);
        ubicacion=(TextView)findViewById(R.id.tgtUbicacionSantuarioElCisne);

        requestQueue = Volley.newRequestQueue(rutaSantuarioElCisne.this);
        cargarWebService();

        btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(rutaSantuarioElCisne.this, MapsActivityAlfareriaBarrioCera.class);//
                startActivity(i);
            }
        });
    }
    private void cargarWebService(){
        progressDialog= new ProgressDialog(rutaSantuarioElCisne.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/lugar/obtenerLugarporforaneo_fkparro.php?fkparro=5&fkcategoria=2";

        JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("lugar");
                        nombre_ruta.setText(json_array+"");
                        ubicacion.setText(json_array+"");
                        latitud.setText(json_array+"");
                        longitud.setText(json_array+"");

                        String nombre ="";
                        String ubi ="";
                        String lat ="";
                        String lon ="";
                        for (int i = 0; i < json_array.length(); i++) {
                            try {
                                nombre = json_array.getJSONObject(i).getString("nombrelugar");
                                ubi = json_array.getJSONObject(i).getString("ubicacion");
                                lat = json_array.getJSONObject(i).getString("latitudlugar");
                                lon = json_array.getJSONObject(i).getString("longitudlugar");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        nombre_ruta.setText(nombre);
                        ubicacion.setText(ubi);
                        latitud.setText(lat);
                        longitud.setText(lon);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(rutaSantuarioElCisne.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
