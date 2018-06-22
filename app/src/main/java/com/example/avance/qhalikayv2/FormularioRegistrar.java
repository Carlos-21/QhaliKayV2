package com.example.avance.qhalikayv2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormularioRegistrar extends AppCompatActivity implements View.OnClickListener{
    private EditText nombre;
    private EditText apellido;
    private EditText usuario;
    private EditText contraseña;
    private Button registrar;
    // Write a message to the database
    private FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registrar);

        nombre = (EditText)findViewById(R.id.textoNombre);
        apellido = (EditText)findViewById(R.id.textoApellido);
        usuario = (EditText)findViewById(R.id.textoUsuario);
        contraseña = (EditText)findViewById(R.id.textoContraseña);
        registrar = (Button)findViewById(R.id.botonRegistrar);
        registrar.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();

    }

    @Override
    public void onClick(View v) {
        Usuario usuario = new Usuario();
        Map<String, Object> user = new HashMap<>();

        switch (v.getId()){
            case R.id.botonRegistrar :  usuario.setNombres(nombre.getText().toString());
                                        usuario.setApellidos(apellido.getText().toString());
                                        usuario.setUsuario(this.usuario.getText().toString());
                                        usuario.setContraseña(contraseña.getText().toString());

                                        user.put("Nombres",usuario.getNombres());
                                        user.put("Apellidos",usuario.getApellidos());
                                        user.put("Usuario",usuario.getUsuario());
                                        user.put("Contraseña",usuario.getContraseña());

                                        db.collection("Usuario").add(user);
                                        System.out.println("Envviado");
        }
    }
}
