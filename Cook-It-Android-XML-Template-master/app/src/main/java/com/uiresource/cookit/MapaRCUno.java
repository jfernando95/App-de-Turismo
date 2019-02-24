package com.uiresource.cookit;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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

public class MapaRCUno extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private View popup=null;
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
        setContentView(R.layout.activity_mapa_rcuno);
        botonSatelital=(Button) findViewById(R.id.btnSt);
        botonRelieve=(Button) findViewById(R.id.btnRe);
        botonHibrido=(Button) findViewById(R.id.btnHi);
        botonNormal=(Button) findViewById(R.id.btnNo);
        //botonDesconocido=(Button) findViewById(R.id.btnDes);
        /*botonSatelital.setOnClickListener(this);
        botonRelieve.setOnClickListener(this);
        botonHibrido.setOnClickListener(this);
        botonNormal.setOnClickListener(this);*/
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        requestQueue = Volley.newRequestQueue(MapaRCUno.this);
        cargarWebService();
    }

    private void cargarWebService(){
        /*progressDialog= new ProgressDialog(Rutas.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutaltaquil.php";
        final String url1 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachantaco.php";
        final String url2 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachuquiribambagualel.php";
        final String url3 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutagualelcisneuno.php";*/
        progressDialog= new ProgressDialog(MapaRCUno.this);
        progressDialog.setMessage("CARGANDO DATOS....");
        progressDialog.show();
        final String url = "https://proyectobasedatos2.000webhostapp.com/obtenerrutaltaquil.php";
        final String url1 = "https://proyectobasedatos2.000webhostapp.com/obtenerrutachantaco.php";
        final String url2 = "https://proyectobasedatos2.000webhostapp.com/obtenerRutaComplementariaUno.php";

        JSONObject json = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        JSONArray json_array = response.optJSONArray("rutataquil");
                        LatLng c [] = new LatLng[json_array.length()];
                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Taquil = new LatLng(Double.parseDouble(jsonObject.get("latitudtaquil").toString()), Double.parseDouble(jsonObject.get("longitudtaquil").toString()));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudtaquil").toString()), Double.parseDouble(jsonObject.get("longitudtaquil").toString()))).width(4).color(Color.RED));
                                c[i] = Taquil;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c).width(8).color(ContextCompat.getColor(getApplicationContext(),R.color.colorPinkTrans)).geodesic(true));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(MapaRCUno.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);




        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, url1,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        //Toast.makeText(Navegacion.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutachantaco");
                        LatLng c [] = new LatLng[json_array.length()];

                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Chantaco = new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()));
                                //mMap.addMarker(new MarkerOptions().position(Chantaco).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()))).width(4).color(Color.RED));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitudchantaco").toString()), Double.parseDouble(jsonObject.get("longitudchantaco").toString()))));
                                c[i] = Chantaco;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c).width(8).color(ContextCompat.getColor(getApplicationContext(),R.color.colorPinkTrans)).geodesic(true));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(MapaRCUno.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, url2,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.hide();
                        //Toast.makeText(Navegacion.this, "EXITO",Toast. LENGTH_SHORT).show();
                        JSONArray json_array = response.optJSONArray("rutaunochuq");
                        LatLng c [] = new LatLng[json_array.length()];

                        for (int i = 0; i < json_array.length(); i++) {
                            try {

                                JSONObject jsonObject = json_array.getJSONObject(i);
                                LatLng Chuquiribamba = new LatLng(Double.parseDouble(jsonObject.get("latitudchuq").toString()), Double.parseDouble(jsonObject.get("longitudchuq").toString()));
                                //mMap.addMarker(new MarkerOptions().position(Chuquiribamba).title("Linea "+i).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()), Double.parseDouble(jsonObject.get("longitud").toString()))).width(4).color(Color.RED));
                                //mMap.addPolyline(new PolylineOptions().add(new LatLng(Double.parseDouble(jsonObject.get("latitud").toString()), Double.parseDouble(jsonObject.get("longitud").toString()))));
                                c[i] = Chuquiribamba;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Polyline polyline=mMap.addPolyline(new PolylineOptions().add(c).width(8).color(ContextCompat.getColor(getApplicationContext(),R.color.colorPinkTrans)).geodesic(true));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(MapaRCUno.this, "ERROR"+error ,Toast.LENGTH_SHORT).show();

            }
        });

                //imagen
        /*
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.chantaco);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
        mMap.addMarker(new MarkerOptions().position(new LatLng(-3.8847434, -79.2888043)).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
*/
        requestQueue.add(jsonObjectRequest);
        requestQueue.add(jsonObjectRequest1);
        requestQueue.add(jsonObjectRequest2);
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
    public void mostrarPictogramas(){
        ImageView iv=(ImageView)popup.findViewById(R.id.icons);
        ImageView pic1=(ImageView)popup.findViewById(R.id.icon1);
        ImageView pic2=(ImageView)popup.findViewById(R.id.icon2);
        ImageView pic3=(ImageView)popup.findViewById(R.id.icon3);
        ImageView pic4=(ImageView)popup.findViewById(R.id.icon4);
        ImageView pic5=(ImageView)popup.findViewById(R.id.icon5);
        ImageView pic6=(ImageView)popup.findViewById(R.id.icon6);
        pic3.setVisibility(View.VISIBLE);
        pic4.setVisibility(View.VISIBLE);
        pic5.setVisibility(View.VISIBLE);
        pic6.setVisibility(View.VISIBLE);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // HOTELES
        //BitmapDrawable bitmapdraw1=(BitmapDrawable)getResources().getDrawable(R.mipmap.p2alojamiento);
        //Bitmap b1=bitmapdraw1.getBitmap();
        //Bitmap smallMarker1 = Bitmap.createScaledBitmap(b1, 100, 100, false);
        /*LatLng p21Taquil = new LatLng(-3.904837, -79.2888043);
        myMarker= mMap.addMarker(new MarkerOptions().position(p21Taquil).title("Palmeras de Machay").icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntohotel)));
        /*LatLng hotel = new LatLng(-3.904837, -79.301651);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.p2alojamiento)).position(hotel).title("Hotel Palmeras de Machay"));
*/
        /*LatLng elmirador = new LatLng(-3.851864, -79.426586);
        myMarker= mMap.addMarker(new MarkerOptions().position(elmirador).title("El Mirador").icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntohotel)));
        */
        /*LatLng medina = new LatLng(-3.852068, -79.425494);
        myMarker= mMap.addMarker(new MarkerOptions().position(medina).title("Medina").icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntohotel)));
        */
        /*LatLng carrions = new LatLng(-3.851750, -79.425486);
        myMarker= mMap.addMarker(new MarkerOptions().position(carrions).title("Carrion’S").icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntohotel)));
        */
        /*LatLng samayHuasy = new LatLng(-3.851753, -79.426447);
        myMarker= mMap.addMarker(new MarkerOptions().position(samayHuasy).title("Samay Huasy").icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntohotel)));
        */
        //RESTAURANTES
        /*LatLng restauranteNorOccidental = new LatLng(-3.878766, -79.329007);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(restauranteNorOccidental).title("Restaurante NorOccidental"));

        LatLng saborChuquiribancense = new LatLng(-3.843179, -79.344327);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(saborChuquiribancense).title("Sabor Chuquiribancense"));

        LatLng santabarbarasaborytradicion = new LatLng(-3.842444, -79.344018);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(santabarbarasaborytradicion).title("Santa bárbara sabor y tradición"));

        LatLng comedor = new LatLng(-3.842562, -79.344275);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(comedor).title("Comedor"));

        /*LatLng lotipicodemitierra = new LatLng(-3.771531, -79.375866);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(lotipicodemitierra).title("Lo típico de mi tierra"));

        LatLng mercadoGualel  = new LatLng(-3.771018, -79.377105);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(mercadoGualel).title("Mercado Gualel"));
        */
        /*LatLng cuenquita  = new LatLng(-3.851024, -79.427193);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(cuenquita).title("Cuenquita"));
        */
        /*LatLng elConquistador  = new LatLng(3.851760, -79.426810);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(elConquistador).title("El Conquistador"));

        LatLng elOlmeñito  = new LatLng(3.850804, -79.426783);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(elOlmeñito).title("El Olmeñito"));

        /*LatLng johanna  = new LatLng(-3.850684, -79.426740);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(johanna).title("Johanna"));
        */
        /*LatLng yesenia  = new LatLng(-3.850368, -79.426519);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(yesenia).title("Yesenia"));
        */
        /*LatLng central  = new LatLng(-3.850531, -79.426750);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(central).title("Central"));
        */
        /*LatLng saboresCostaySierra  = new LatLng(-3.851832, -79.425627);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(saboresCostaySierra).title("Sabores Costa & Sierra"));
        */
        /*LatLng balconCisneño  = new LatLng(-3.851694, -79.425957);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(balconCisneño).title("Balcón Cisneño"));
        */
        /*LatLng elMarinero  = new LatLng(-3.850726, -79.427016);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(elMarinero).title("El Marinero"));
        */
        /*LatLng elCisne  = new LatLng(-3.850118, -79.426749);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(elCisne).title("El Cisne"));
        */
        /*LatLng alPaso  = new LatLng(-3.851392, -79.426360);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(alPaso).title("Al Paso"));
        */
        /*LatLng justin  = new LatLng(-3.850642, -79.426020);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.puntorestaurante)).position(justin).title("Justin"));
        */
        float zoomLevel = 14.0f; //This goes up to 21


        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                if(popup == null){
                    popup=getLayoutInflater().inflate(R.layout.popusmaps,null);
                }
                TextView tv= (TextView)popup.findViewById(R.id.title);

                /*ImageView iv=(ImageView)popup.findViewById(R.id.icon);

                iv.setImageResource(R.drawable.tunduranga);*/
                //iv.setImageResource(R.drawable.chuquiribamba);
                //obtiene el nombre del titulo
                tv.setText(marker.getTitle());
                tv=(TextView)popup.findViewById(R.id.snippet);
                tv.setText(marker.getSnippet());


                ImageView iv=(ImageView)popup.findViewById(R.id.icons);
                ImageView im1=(ImageView)popup.findViewById(R.id.icon1);
                ImageView im2=(ImageView)popup.findViewById(R.id.icon2);
                ImageView im3=(ImageView)popup.findViewById(R.id.icon3);
                ImageView im4=(ImageView)popup.findViewById(R.id.icon4);
                ImageView im5=(ImageView)popup.findViewById(R.id.icon5);
                ImageView im6=(ImageView)popup.findViewById(R.id.icon6);
                ImageView im7=(ImageView)popup.findViewById(R.id.icon7);


                if(marker.getTitle().equalsIgnoreCase("Petroglifos")){
                    //Toast.makeText(Navegacion.this,"Estas en"+marker.getTitle(),Toast.LENGTH_SHORT).show();
                    im3.setVisibility(View.GONE);
                    im4.setVisibility(View.GONE);
                    im5.setVisibility(View.GONE);
                    im6.setVisibility(View.GONE);
                    im7.setVisibility(View.GONE);
                    im1.setVisibility(View.GONE);
                    im2.setVisibility(View.GONE);
                    iv.setImageResource(R.drawable.petroglifos);
                    //im1.setImageResource(R.drawable.pic9);
                    //im2.setImageResource(R.drawable.pic6);
                }else if(marker.getTitle().equalsIgnoreCase("Chorrera de Shillipara")){
                    im3.setVisibility(View.GONE);
                    im4.setVisibility(View.GONE);
                    im5.setVisibility(View.GONE);
                    im6.setVisibility(View.GONE);
                    im7.setVisibility(View.GONE);
                    iv.setImageResource(R.mipmap.chosillipara);
                    im1.setVisibility(View.GONE);
                    im2.setVisibility(View.GONE);

                }else if(marker.getTitle().equalsIgnoreCase("Fábrica de horchata “la lojana”")){
                    im3.setVisibility(View.GONE);
                    im4.setVisibility(View.GONE);
                    im5.setVisibility(View.GONE);
                    im6.setVisibility(View.GONE);
                    im7.setVisibility(View.GONE);
                    iv.setImageResource(R.mipmap.fabhorchata);
                    im1.setVisibility(View.GONE);
                    im2.setVisibility(View.GONE);

                }

                return (popup);

            }
        });
        LatLng Petroglifos = new LatLng(-3.8766716, -79.2942095);
        mMap.addMarker(new MarkerOptions().position(Petroglifos).title("Petroglifos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Petroglifos,zoomLevel));

        LatLng ChorreradeShillipara = new LatLng(-3.866689, -79.346562);
        mMap.addMarker(new MarkerOptions().position(ChorreradeShillipara).title("Chorrera de Shillipara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ChorreradeShillipara,zoomLevel));

        LatLng fabricadehorchata = new LatLng(-3.845133, -79.342200);
        mMap.addMarker(new MarkerOptions().position(fabricadehorchata).title("Fábrica de horchata “la lojana”"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fabricadehorchata,zoomLevel));
        // LUGARES
       /* LatLng miradortunduranga = new LatLng(-3.9100000, -79.2894444);
        mMap.addMarker(new MarkerOptions().position(miradortunduranga).title("Mirador Tunduranga").snippet("Es un cerro en forma de cono que termina en ángulo cubierto por vegetación bosque montano bajo constituido por paja, matorral, alisal y pastos. Es un mirador natural desde donde se puede divisar el Valle de Catamayo y la parroquia Taquil, su altura permite observar hermosos paisajes. \n" +
                "En el punto final del cerro se encuentra una cruz de aproximadamente un metro de altura."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miradortunduranga,zoomLevel));

        LatLng alfareriacera = new LatLng(-3.9063889, -79.2863888);
        mMap.addMarker(new MarkerOptions().position(alfareriacera).title("Alfarería en el Barrio Cera").snippet("La cerámica tradicional que se elabora en los barrio Cera de la parroquia Taquil, tienen una forma zoomorfa principalmente en las ollas que son elaboradas principalmente en los hogares y en ciertos casos son producidas por asociaciones conformadas por pequeños grupos de ciudadanos de la localidad. "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(alfareriacera,zoomLevel));

        LatLng iglesiaChantaco = new LatLng(-3.8799500, -79.3272000);
        mMap.addMarker(new MarkerOptions().position(iglesiaChantaco).title("Iglesia Chantaco").snippet("La iglesia de la parroquia Chantaco fue construida en 1980 y ha sido reconstruida una sola vez empleando hormigón armado. Su arquitectura es moderna y" +
                " es conocida por ser una de las iglesias de mayor altitud a nivel provincial. "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iglesiaChantaco,zoomLevel));

        LatLng centroITuristica = new LatLng(-3.8427778, -79.3438888);
        mMap.addMarker(new MarkerOptions().position(centroITuristica).title("Corredor Patrimonial NorOccidental").snippet("Se adecuaron salas para resaltar el valor cultural, gastronómico, social, económico y musical de las parroquias de Taquil, Chantaco, " +
                "Chuquiribamba, Gualel, El Cisne, inclusive del cantón Zaruma de la provincia de El Oro." +
                " Es considerado el primer centro de interpretación del sur del Ecuador"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centroITuristica,zoomLevel));


        LatLng miradorTLomaGallinazo = new LatLng(-3.8394444, -79.3472222);
        mMap.addMarker(new MarkerOptions().position(miradorTLomaGallinazo).title("Mirador Turístico “Loma de gallinazo”").snippet("El mirador está estructurado en dos partes: la parte inferior que consta de dos cabañas con mesones y el área de los baños; " +
                "la parte superior de cabañas y una área para tomar fotografías de donde se puede apreciar el área paisajística de la parroquia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miradorTLomaGallinazo,zoomLevel));

        /*LatLng cascadaSF = new LatLng(-3.7578333, -79.3763333);
        mMap.addMarker(new MarkerOptions().position(cascadaSF).title("Cascada San Francisco").snippet("La Cascada cuenta con un área verde y natural, es un lugar encantador para propios y extraños que visitan el lugar.\n" +
                "Cuenta con una pequeña cabaña ubicada en la parte inferior, la cual es utilizada como área de descanso."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cascadaSF,zoomLevel));*/

        /*LatLng cascadaHumuto = new LatLng(-3.7831111, -79.3580277);
        mMap.addMarker(new MarkerOptions().position(cascadaHumuto).title("Cascada Humuto").snippet("La cascada  tiene aproximadamente 10 metros de altura," +
                " recorre parte de la parroquia en una parte se une con el río Aurinoco (principal) y Fierrohurco formando el río Gualel."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cascadaHumuto,zoomLevel));*/

        /*LatLng santuarioElCisne = new LatLng(-3.8510056, -79.4262944);
        mMap.addMarker(new MarkerOptions().position(santuarioElCisne).title("Santuario El Cisne").snippet("El Santuario está conformado por La Basílica, museo de arte religioso y la torre de reloj.  La Basílica de El Cisne comenzó " +
                "a edificarse el 15 de agosto de 1534 y se concluyó en el año 1978, tiene elementos arquitectónicos del estilo gótico."));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(santuarioElCisne,zoomLevel));
   */ }
    @Override
    public void onClick(View view) {

    }
}
