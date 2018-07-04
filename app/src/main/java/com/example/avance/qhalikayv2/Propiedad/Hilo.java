package com.example.avance.qhalikayv2.Propiedad;

import android.widget.ProgressBar;

public class Hilo extends Thread{
    private ProgressBar barra;
    private Double dato;

    public Hilo(ProgressBar barra, Double dato){
        this.barra = barra;
        this.dato = dato;
    }

    @Override
    public void run(){
        int progreso = 0;

        while(progreso < dato) {
            try {
                progreso += 5.0;
                barra.setProgress(progreso);
                sleep(200);
            }
            catch (InterruptedException e) {
                //Log.e(TAG, e.getMessage());
            }
        }
    }
}
