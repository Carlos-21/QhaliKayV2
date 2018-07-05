package com.example.avance.qhalikayv2.BaseDatos.DAO.Componente;

import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.avance.qhalikayv2.Ayuda.DocumentoUsuario;
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
    public void listarFrutas(final ArrayList<Carta> cartaFruta) {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Frutas");

        coleccion.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int i = 0;
                    for (DocumentSnapshot documento : task.getResult()) {
                        Alimento auxiliar = documento.toObject(Alimento.class);

                        if(i<5){
                            cartaFruta.get(i).getAlimento().setImagen(auxiliar.getImagen());
                            cartaFruta.get(i).getAlimento().setProteina(auxiliar.getProteina());
                            cartaFruta.get(i).getAlimento().setGrasa(auxiliar.getGrasa());
                            cartaFruta.get(i).getAlimento().setCaloria(auxiliar.getCaloria());
                            cartaFruta.get(i).getAlimento().setNombre(auxiliar.getNombre());

                            Picasso.get().load(auxiliar.getImagen()).into(cartaFruta.get(i).getFoto());
                            cartaFruta.get(i).getTexto().setText((CharSequence) auxiliar.getNombre());
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
    public void mostrarFrutas(final ArrayList<Carta> cartaFruta) {
        for(Carta carta : cartaFruta){
            carta.setAlimento(new Alimento());
        }

        listarFrutas(cartaFruta);
    }

    @Override
    public void mostrarFavoritos(ArrayList<Carta> cartaFavorito) {
        for(Carta carta : cartaFavorito){
            carta.setAlimento(new Alimento());
        }

        listarFavoritos(cartaFavorito);
    }

    @Override
    public void listarFavoritos(final ArrayList<Carta> cartaFavorito) {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Vegetales");

        coleccion.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int i = 0;
                    int j = 0;
                    for (DocumentSnapshot documento : task.getResult()) {
                        Alimento auxiliar = documento.toObject(Alimento.class);

                        if(i<5){
                            if(j<DocumentoUsuario.cantidadFavorito){
                                System.out.println("Cnatidad cafaf" + DocumentoUsuario.cantidadFavorito);
                                if(DocumentoUsuario.favoritos.get(j).equals(auxiliar.getNombre())){
                                    cartaFavorito.get(i).getAlimento().setImagen(auxiliar.getImagen());
                                    cartaFavorito.get(i).getAlimento().setProteina(auxiliar.getProteina());
                                    cartaFavorito.get(i).getAlimento().setGrasa(auxiliar.getGrasa());
                                    cartaFavorito.get(i).getAlimento().setCaloria(auxiliar.getCaloria());
                                    cartaFavorito.get(i).getAlimento().setNombre(auxiliar.getNombre());

                                    Picasso.get().load(auxiliar.getImagen()).into(cartaFavorito.get(i).getFoto());
                                    cartaFavorito.get(i).getTexto().setText((CharSequence) auxiliar.getNombre());

                                    i++;
                                    j++;
                                }
                            }
                        }

                    }
                }
                else{
                    System.out.println("error................");
                }
            }
        });
    }
}
