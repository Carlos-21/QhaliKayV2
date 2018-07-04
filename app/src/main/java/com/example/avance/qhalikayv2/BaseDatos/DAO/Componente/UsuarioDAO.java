package com.example.avance.qhalikayv2.BaseDatos.DAO.Componente;

import android.support.annotation.NonNull;

import com.example.avance.qhalikayv2.BaseDatos.Conexion.Conexion;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IUsuarioDAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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

                            }
                        } else {
                            System.out.println("error................");
                        }
                    }
                });
    }

}
