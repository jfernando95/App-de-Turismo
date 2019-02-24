package com.uiresource.cookit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModeloRuta {
    double lati;
    double longi;

    ArrayList<ModeloRuta> lista;

    public ModeloRuta(double lati, double longi) {
        this.lati = lati;
        this.longi = longi;
    }

    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    public ModeloRuta(ArrayList<ModeloRuta> lista) {
        this.lista = lista;
    }

    public ArrayList<ModeloRuta> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ModeloRuta> lista) {
        this.lista = lista;
    }

    /*
    public ModeloRuta(JSONObject objetoJSON)throws JSONException {
        idrutataquil = objetoJSON.getInt("idrutataquil");
        latitudtaquil = objetoJSON.getDouble("latitudtaquil");
        longitudtaquil = objetoJSON.getDouble("longitudtaquil");
    }

    public int getIdrutataquil() {
        return idrutataquil;
    }

    public void setIdrutataquil(int idrutataquil) {
        this.idrutataquil = idrutataquil;
    }

    public double getLatitudtaquil() {
        return latitudtaquil;
    }

    public void setLatitudtaquil(double latitudtaquil) {
        this.latitudtaquil = latitudtaquil;
    }

    public double getLongitudtaquil() {
        return longitudtaquil;
    }

    public void setLongitudtaquil(double longitudtaquil) {
        this.longitudtaquil = longitudtaquil;
    }
    */
}
