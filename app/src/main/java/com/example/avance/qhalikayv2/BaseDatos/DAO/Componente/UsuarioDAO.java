package com.example.avance.qhalikayv2.BaseDatos.DAO.Componente;

import android.support.annotation.NonNull;

import com.example.avance.qhalikayv2.Ayuda.DocumentoUsuario;
import com.example.avance.qhalikayv2.BaseDatos.Conexion.Conexion;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Favorito;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IUsuarioDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public void buscarUsuario(final Usuario usuario) {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Usuarios");

        coleccion.whereEqualTo("usuario", usuario.getUsuario())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot documento : task.getResult()) {
                                Usuario auxiliar = documento.toObject(Usuario.class);

                                usuario.setAltura(auxiliar.getAltura());
                                usuario.setApellido(auxiliar.getApellido());
                                usuario.setContraseña(auxiliar.getContraseña());
                                usuario.setFoto(auxiliar.getFoto());
                                usuario.setGenero(auxiliar.getGenero());
                                usuario.setNombre(auxiliar.getNombre());
                                usuario.setPeso(auxiliar.getPeso());
                                usuario.setUsuario(auxiliar.getUsuario());

                                DocumentoUsuario.idUsuario = documento.getId();

                            }
                        } else {
                            System.out.println("error................");
                        }
                    }
                });
    }

    @Override
    public void añadirFavorito(Usuario usuario, Favorito favorito) {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Usuarios").document(DocumentoUsuario.idUsuario).collection("Favoritos");
        coleccion.document("Favorito"+DocumentoUsuario.cantidadFavorito).set(favorito);
        cantidadFavorito();
    }

    @Override
    public void cantidadFavorito() {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Usuarios").document(DocumentoUsuario.idUsuario).collection("Favoritos");

        coleccion.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i = 0;
                            for (DocumentSnapshot documento : task.getResult()) {
                                i++;
                            }
                            if(i == 0){
                                DocumentoUsuario.cantidadFavorito = i+1;
                            }
                            DocumentoUsuario.cantidadFavorito = i;
                        } else {
                            System.out.println("error................");
                        }
                    }
                });
    }

    @Override
    public void nombresFavoritos() {
        FirebaseFirestore database = Conexion.getCloudBase();
        CollectionReference coleccion = database.collection("Usuarios").document(DocumentoUsuario.idUsuario).collection("Favoritos");

        coleccion.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot documento : task.getResult()) {
                                Favorito auxiliar = documento.toObject(Favorito.class);

                                DocumentoUsuario.favoritos.add(auxiliar.getIdAlimento());
                            }
                        } else {
                            System.out.println("error................");
                        }
                    }
                });
    }

}
