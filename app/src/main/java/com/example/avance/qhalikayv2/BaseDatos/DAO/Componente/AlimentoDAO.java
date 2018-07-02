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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Map;

public class AlimentoDAO implements IAlimentoDAO, OnCompleteListener<QuerySnapshot>{
    private ArrayList<Alimento> vegetales;

    @Override
    public ArrayList<Alimento> listarVegetales() {
        vegetales = new ArrayList<>();

        FirebaseFirestore database = Conexion.getCloudBase();
        /*database.collection("Vegetales")
                .get()
                .addOnCompleteListener(this);*/

        /*database.collection("Vegetales")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                System.out.println("Documento : "+ document.getData());
                            }
                        } else {
                            Log.d("documento", "Error getting documents: ", task.getException());
                        }
                    }
                });*/

        DocumentReference doc = database.document("Vegetales/vegetal1");
        doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    /*String cadena = documentSnapshot.getString("nombre");
                    long calorias = documentSnapshot.getLong("caloria");
                    System.out.println("Nombre documento : "+cadena);
                    System.out.println("Caloria cantidad : "+calorias);*/
                    Alimento al = documentSnapshot.toObject(Alimento.class);
                    System.out.println("Nombre : "+al.getNombre());
                    System.out.println("Caloria : "+al.getCaloria());

                }
                else{
                    System.out.println("Error documento : .........");
                }

            }
        });

        System.out.println("Cantidad 2 : ................."+vegetales.size());

        return vegetales;
    }

    @Override
    public ArrayList<Alimento> listarFrutas() {
        final ArrayList<Alimento> alimentos = new ArrayList<>();

        FirebaseFirestore database = Conexion.getCloudBase();
        database.collection("Frutas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot documento : task.getResult()) {
                                Alimento auxiliar = documento.toObject(Alimento.class);
                                alimentos.add(auxiliar);
                            }
                        }
                    }
                });

        return alimentos;
    }

    @Override
    public void mostrarVegetales(ArrayList<Carta> cartaVegetal, Calorias calorias) {
        ArrayList<Alimento> vegetales = listarVegetales();
        StorageReference storage = Conexion.getStorage().child("Vegetales");

        int i = 0;

        for(String cadena : Direccion.vegetales){

            Glide.with(calorias)
                    .using(new FirebaseImageLoader())
                    .load(storage.child("/"+cadena))
                    .into(cartaVegetal.get(i).getFoto());

            /*cartaVegetal.get(i).setAlimento(vegetales.get(i));
            cartaVegetal.get(i).getTexto().setText((CharSequence) vegetales.get(i).getNombre());*/

            i++;
        }

    }

    @Override
    public void mostrarFrutas(ArrayList<Carta> cartaFruta, Calorias calorias) {
        ArrayList<Alimento> frutas = listarFrutas();
        StorageReference storage = Conexion.getStorage().child("Frutas");

        int i = 0;

        while(vegetales == null){

        }

        for(String cadena : Direccion.vegetales){

            Glide.with(calorias)
                    .using(new FirebaseImageLoader())
                    .load(storage.child("/"+cadena))
                    .into(cartaFruta.get(i).getFoto());

            cartaFruta.get(i).setAlimento(frutas.get(i));
            cartaFruta.get(i).getTexto().setText((CharSequence) frutas.get(i).getNombre());

            i++;
        }
    }

    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        if (task.isSuccessful()) {
            for (DocumentSnapshot documento : task.getResult()) {

                //Map<String, Object> user = documento.getData();
                Alimento auxiliar = new Alimento();
                auxiliar.setNombre(documento.getString("nombre"));
                System.out.println("Objeto : " + auxiliar);
                System.out.println("Alimento : "+auxiliar.getNombre());
                alimentos.add(auxiliar);
            }

        }
        else{
            System.out.println("Error......................");
        }
        vegetales = alimentos;
    }
}
