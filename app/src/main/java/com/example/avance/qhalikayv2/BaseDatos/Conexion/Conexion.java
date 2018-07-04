package com.example.avance.qhalikayv2.BaseDatos.Conexion;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Conexion {
    private static StorageReference storage;
    private static FirebaseFirestore database;
    private static FirebaseAuth autentificacion;
    private static DatabaseReference databaseReference;

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

    public static DatabaseReference getRealTimeBase(int valor){
        if(databaseReference == null){
            switch (valor){
                case 1 : databaseReference = FirebaseDatabase.getInstance().getReference("Vegetales");
                         break;

                case 2 : databaseReference = FirebaseDatabase.getInstance().getReference("Frutas");
                         break;
            }
            return databaseReference;
        }
        else{
            return databaseReference;
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
