package com.example.javi.pruebavolley;

import android.content.Context;

/**
 * Created by Javi on 24/3/17.
 */

public class Item {

    String sCiudad;
    String sTemperatura;
    String sPred;
    Context context;

    public Item(String sCiudad, String sTemperatura, String sPred, Context context) {
        this.sCiudad = sCiudad;
        this.sTemperatura = sTemperatura;
        this.sPred = sPred;
        this.context = context;
    }

    public String getsCiudad() {
        return sCiudad;
    }

    public void setsCiudad(String sCiudad) {
        this.sCiudad = sCiudad;
    }

    public String getsTemperatura() {
        return sTemperatura;
    }

    public void setsTemperatura(String sTemperatura) {
        this.sTemperatura = sTemperatura;
    }

    public String getsPred() {
        return sPred;
    }

    public void setsPred(String sPred) {
        this.sPred = sPred;
    }
}
