package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Ruta extends AppCompatActivity {

    Button btnHome;
    ImageView btnRuta;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    TextView nombre_ruta,descripcionruta,ubicacion,actividadturi,recomendacion;
    TextView latitud,longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);
        nombre_ruta=(TextView)findViewById(R.id.txtnombreruta);
        descripcionruta=(TextView)findViewById(R.id.lblDescripcionRutas);
        btnRuta=(ImageView)findViewById(R.id.btnRuta);
        latitud=(TextView)findViewById(R.id.ttLatitud);
        actividadturi=(TextView)findViewById(R.id.ttActividadTurist);
        recomendacion=(TextView)findViewById(R.id.ttRecomendaciones);
        longitud=(TextView)findViewById(R.id.ttLongitud);
        ubicacion=(TextView)findViewById(R.id.ttUbicacion);

        /*btnRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Ruta.this,ActividadMapaPrincipalTaquil.class);
                //envio
                startActivity(i2);
            }
        });*/
        requestQueue = Volley.newRequestQueue(Ruta.this);
        cargarWebService();
        btnHome = (Button) findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ruta.this, Lista_Rutas.class);
                startActivity(i);
            }
        });


    }

    private void cargarWebService(){
        progressDialog= new ProgressDialog(Ruta.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/lugar/obtenerLugarporforaneo_fkparro.php?fkparro=1&fkcategoria=1";

        JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("lugar");
                        nombre_ruta.setText(json_array+"");
                        ubicacion.setText(json_array+"");
                        descripcionruta.setText(json_array+"");
                        actividadturi.setText(json_array+"");
                        recomendacion.setText(json_array+"");
                        latitud.setText(json_array+"");
                        longitud.setText(json_array+"");

                        String nombre ="";
                        String ubi ="";
                        String actividades ="";
                        String recomendacions ="";
                        String x ="";
                        String lat ="";
                        String lon ="";
                        for (int i = 0; i < json_array.length(); i++) {
                            try {
                                nombre = json_array.getJSONObject(i).getString("nombrelugar");
                                ubi = json_array.getJSONObject(i).getString("ubicacion");
                                x = json_array.getJSONObject(i).getString("descripcion");
                                actividades = json_array.getJSONObject(i).getString("actividadturistica");
                                recomendacions = json_array.getJSONObject(i).getString("recomendaciones");
                                lat = json_array.getJSONObject(i).getString("latitudlugar");
                                lon = json_array.getJSONObject(i).getString("longitudlugar");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        nombre_ruta.setText(nombre);
                        descripcionruta.setText(x);
                        actividadturi.setText(actividades);
                        ubicacion.setText(ubi);
                        recomendacion.setText(recomendacions);
                        //la=Double.parseDouble(lat);
                        //lo=Double.parseDouble(lon);
                        latitud.setText(lat);
                        longitud.setText(lon);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Ruta.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
