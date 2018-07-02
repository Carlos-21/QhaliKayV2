package com.example.avance.qhalikayv2.BaseDatos.DAO.Datos;

import android.widget.ImageView;
import android.widget.TextView;

public class Carta {
    private ImageView foto;
    private TextView texto;
    private Alimento alimento;

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

}
