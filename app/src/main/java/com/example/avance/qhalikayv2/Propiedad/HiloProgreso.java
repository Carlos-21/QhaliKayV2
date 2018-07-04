package com.example.avance.qhalikayv2.Propiedad;

import android.app.ProgressDialog;

public class HiloProgreso extends Thread{
    private ProgressDialog progreso;

    public HiloProgreso(ProgressDialog progreso){
        this.progreso = progreso;
    }

    @Override
    public void run(){
        progreso.show();
        progreso.setCancelable(false);
        progreso.dismiss();
    }

}
