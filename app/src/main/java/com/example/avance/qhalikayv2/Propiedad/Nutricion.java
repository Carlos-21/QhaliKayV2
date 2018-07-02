package com.example.avance.qhalikayv2.Propiedad;

import android.widget.ProgressBar;

public class Nutricion {
    private ProgressBar barra1;
    private ProgressBar barra2;
    private ProgressBar barra3;

    public Nutricion(ProgressBar barra1, ProgressBar barra2, ProgressBar barra3) {
        this.barra1 = barra1;
        this.barra2 = barra2;
        this.barra3 = barra3;
    }

    public void mostrarDatosNutricionales(int dato1, int dato2, int dato3){
        barra1.setProgress(0);
        barra2.setProgress(0);
        barra3.setProgress(0);

        Hilo hilo1 = new Hilo(barra1, dato1);
        Hilo hilo2 = new Hilo(barra2, dato2);
        Hilo hilo3 = new Hilo(barra3, dato3);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
