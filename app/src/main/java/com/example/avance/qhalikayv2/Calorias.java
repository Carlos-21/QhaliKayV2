package com.example.avance.qhalikayv2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Componente.AlimentoDAO;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Alimento;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Carta;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IAlimentoDAO;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.Serializable;
import java.util.ArrayList;

public class Calorias extends AppCompatActivity implements View.OnClickListener {
    private ImageView[] imagenVegetal =new ImageView[5];
    private TextView[] textoVegetal = new TextView[5];
    private ArrayList<Carta> cartas;
    private IAlimentoDAO modelo = new AlimentoDAO();
    private TextView vegetales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calorias);

        inicializar();

        vegetales = (TextView)findViewById(R.id.vegetalesMas);
        vegetales.setOnClickListener(this);

        mostrarComponentes();

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.vegetalesMas : intent = new Intent(this, Vegetales.class);
                                     startActivity(intent);
                                     break;
            case R.id.brocoli :   llamarActividadVegetales(intent, cartas.get(0));
                                  break;
            case R.id.berenjena :   llamarActividadVegetales(intent, cartas.get(1));
                break;
        }
    }

    private void inicializar(){
        cartas = new ArrayList<>();

        imagenVegetal[0] = (ImageView)findViewById(R.id.brocoli);
        imagenVegetal[0].setOnClickListener(this);
        imagenVegetal[1] = (ImageView)findViewById(R.id.berenjena);
        imagenVegetal[1].setOnClickListener(this);
        imagenVegetal[2] = (ImageView)findViewById(R.id.zanahoria);
        imagenVegetal[2].setOnClickListener(this);
        imagenVegetal[3] = (ImageView)findViewById(R.id.espinaca);
        imagenVegetal[3].setOnClickListener(this);
        imagenVegetal[4] = (ImageView)findViewById(R.id.pimiento);
        imagenVegetal[4].setOnClickListener(this);

        textoVegetal[0] = (TextView)findViewById(R.id.textoVegetal);
        textoVegetal[1] = (TextView)findViewById(R.id.textoVegetal2);
        textoVegetal[2] = (TextView)findViewById(R.id.textoVegetal3);
        textoVegetal[3] = (TextView)findViewById(R.id.textoVegetal4);
        textoVegetal[4] = (TextView)findViewById(R.id.textoVegetal5);

        int i = 0;
        while(i<5){
            Carta auxiliar = new Carta();
            auxiliar.setFoto(imagenVegetal[i]);
            auxiliar.setTexto(textoVegetal[i]);

            cartas.add(auxiliar);

            i++;
        }


    }

    private void mostrarComponentes(){
        modelo.mostrarVegetales(cartas);
    }

    private void llamarActividadVegetales(Intent intent, Carta carta){
        intent = new Intent(this, Vegetales.class);

        intent.putExtra("imagen",carta.getAlimento().getImagen());
        intent.putExtra("caloria",carta.getAlimento().getCaloria());
        intent.putExtra("grasa",carta.getAlimento().getGrasa());
        intent.putExtra("proteina",carta.getAlimento().getProteina());

        startActivity(intent);
    }
}
