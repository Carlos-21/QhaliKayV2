package com.example.avance.qhalikayv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;
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
            case R.id.botonRegistrar :  break;
        }
    }
}
