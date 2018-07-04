package com.example.avance.qhalikayv2.BaseDatos.DAO.Componente;

import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.avance.qhalikayv2.BaseDatos.Conexion.Conexion;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Alimento;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Carta;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IAlimentoDAO;
import com.example.avance.qhalikayv2.Calorias;
import com.example.avance.qhalikayv2.Propiedad.Direccion;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class AlimentoDAO implements IAlimentoDAO{

    @Override
    public void mostrarVegetales(ArrayList<Carta> cartaVegetal) {
        for(Carta carta : cartaVegetal){
            carta.setAlimento(new Alimento());
        }

        listarVegetales(cartaVegetal);
    }

    @Override
    public void mostrarFrutas(ArrayList<Carta> cartaFruta) {

    }

    @Override
    public void listarVegetales(final ArrayList<Carta> cartaVegetal) {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Vegetales");

        coleccion.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int i = 0;
                    for (DocumentSnapshot documento : task.getResult()) {
                        Alimento auxiliar = documento.toObject(Alimento.class);

                        if(i<5){
                            cartaVegetal.get(i).getAlimento().setImagen(auxiliar.getImagen());
                            cartaVegetal.get(i).getAlimento().setProteina(auxiliar.getProteina());
                            cartaVegetal.get(i).getAlimento().setGrasa(auxiliar.getGrasa());
                            cartaVegetal.get(i).getAlimento().setCaloria(auxiliar.getCaloria());
                            cartaVegetal.get(i).getAlimento().setNombre(auxiliar.getNombre());

                            Picasso.get().load(auxiliar.getImagen()).into(cartaVegetal.get(i).getFoto());
                            cartaVegetal.get(i).getTexto().setText((CharSequence) auxiliar.getNombre());
                            i++;
                        }

                    }
                }
                else{
                    System.out.println("error................");
                }
            }
        });

    }

    @Override
    public void listarFrutas(ArrayList<Carta> cartaFruta) {

    }
}
