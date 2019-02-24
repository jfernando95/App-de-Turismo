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

public class Lugar extends AppCompatActivity {
    ImageView btnSanSebas;
    ProgressDialog progressDialog;
    RequestQueue requestQueue;
    TextView nombre_lugar,descripcion;
    TextView latitud,longitud;
    double la,lo;

    Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);
        nombre_lugar=(TextView)findViewById(R.id.txtnombrelugar);
        descripcion=(TextView)findViewById(R.id.lblDescripcion);
        btnSanSebas=(ImageView)findViewById(R.id.btnSagrarios);
        latitud=(TextView)findViewById(R.id.textLatitud);
        longitud=(TextView)findViewById(R.id.textLongitud);

        btnSanSebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Lugar.this,MapsActivity.class);
                //envio
                i2.putExtra("lat",la);
                i2.putExtra("lon",lo);
                startActivity(i2);

            }
        });

        requestQueue = Volley.newRequestQueue(Lugar.this);
        cargarWebService();

        btnHome= (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Lugar.this,Lista_Lugares.class);
                startActivity(i);
            }
        });

    }
    private void cargarWebService(){
        progressDialog= new ProgressDialog(Lugar.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/lugar/obtener_lugar.php";

        JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("lugar");
                        nombre_lugar.setText(json_array+"");
                        descripcion.setText(json_array+"");
                        latitud.setText(json_array+"");
                        longitud.setText(json_array+"");

                        String nombre ="";
                        String x ="";
                        String lat ="";
                        String lon ="";
                        for (int i = 0; i < json_array.length(); i++) {
                            try {
                                nombre = json_array.getJSONObject(i).getString("nombrelugar");
                                x = json_array.getJSONObject(i).getString("descripcion");
                                lat = json_array.getJSONObject(i).getString("latitudlugar");
                                lon = json_array.getJSONObject(i).getString("longitudlugar");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        nombre_lugar.setText(nombre);
                        descripcion.setText(x);
                        la=Double.parseDouble(lat);
                        lo=Double.parseDouble(lon);
                        latitud.setText(lat);
                        longitud.setText(lon);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(Lugar.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
