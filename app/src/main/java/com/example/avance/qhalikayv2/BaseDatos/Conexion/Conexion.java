package com.example.avance.qhalikayv2.BaseDatos.Conexion;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Conexion {
    private static StorageReference storage;
    private static FirebaseFirestore database;
    private static FirebaseAuth autentificacion;

    public static StorageReference getStorage(){
        if(storage == null){
            storage = FirebaseStorage.getInstance().getReference();
            return storage;
        }
        else{
            return storage;
        }
    }

    public static FirebaseFirestore getCloudBase(){
        if(database == null){
            database = FirebaseFirestore.getInstance();
            return database;
        }
        else{
            return database;
        }
    }

    public static FirebaseAuth getAutentificacion(){
        if(autentificacion == null){
            autentificacion = FirebaseAuth.getInstance();
            return autentificacion;
        }
        else{
            return autentificacion;
        }
    }
}
