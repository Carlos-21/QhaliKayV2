package com.example.avance.qhalikayv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Componente.UsuarioDAO;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IUsuarioDAO;
import com.squareup.picasso.Picasso;

public class DatosPersonales extends AppCompatActivity implements View.OnClickListener {
    private ImageButton botonInicio;
    private ImageButton botonCalorias;
    private ImageButton botonComidas;
    private ImageButton botonEjercicios;
    private ImageButton botonAyuda;
    private ImageButton botonSalir;

    private TextView nombres;
    private TextView apellidos;
    private TextView genero;
    private TextView altura;
    private TextView peso;
    private ImageView foto;

    private IUsuarioDAO modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        Inicializar();

        llamarModelo();

        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            Picasso.get().load((String) bun.get("foto")).into(foto);

            nombres.setText((String) bun.get("nombres"));
            apellidos.setText((String) bun.get("apellidos"));
            genero.setText((String) bun.get("genero"));
            altura.setText((String) bun.get("altura"));
            peso.setText((String) bun.get("peso"));

        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.botonInicio : //Definir
                                    break;
            case R.id.botonCalorias :   intent = new Intent(this, TabVer.class);
                                        startActivity(intent);
                                        break;
        }
    }

    private void Inicializar(){
        modelo = new UsuarioDAO();

        botonInicio = (ImageButton)findViewById(R.id.botonInicio);
        botonInicio.setOnClickListener(this);

        botonCalorias = (ImageButton)findViewById(R.id.botonCalorias);
        botonCalorias.setOnClickListener(this);

        botonComidas = (ImageButton)findViewById(R.id.botonComidas);
        botonComidas.setOnClickListener(this);

        botonEjercicios = (ImageButton)findViewById(R.id.botonEjercicios);
        botonEjercicios.setOnClickListener(this);

        botonAyuda = (ImageButton)findViewById(R.id.botonAyuda);
        botonAyuda.setOnClickListener(this);

        botonSalir = (ImageButton)findViewById(R.id.botonSalir);
        botonSalir.setOnClickListener(this);


        nombres = (TextView)findViewById(R.id.textoNombreDP);
        apellidos = (TextView)findViewById(R.id.textoApellidoDP);
        genero = (TextView)findViewById(R.id.textoGeneroDP);
        altura = (TextView)findViewById(R.id.textoAlturaDP);
        peso = (TextView)findViewById(R.id.textoPesoDP);
        foto = (ImageView)findViewById(R.id.fotoUsuarioDP);
    }

    private void llamarModelo(){
        modelo.cantidadFavorito();
        modelo.nombresFavoritos();
    }
}
