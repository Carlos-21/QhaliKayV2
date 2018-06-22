package com.example.avance.qhalikayv2;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

import static com.example.avance.qhalikayv2.R.layout.plato;

public class CrearPlatos extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        lv = (ListView) findViewById(R.id.listView);
        Query query = FirebaseDatabase.getInstance().getReference().child("Platos");
        FirebaseListOptions<Plato> options = new FirebaseListOptions.Builder<Plato>()
                .setLayout(R.layout.plato)
                .setQuery(query, Plato.class).build();
        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView nombre = v.findViewById(R.id.Nombre);
                TextView calorias = v.findViewById(R.id.Calorias);
                TextView grasas = v.findViewById(R.id.Grasa);
                TextView proteinas = v.findViewById(R.id.Proteinas);
                TextView carbohidratos = v.findViewById(R.id.Carbohidratos);

                Plato plato = (Plato) model;
                nombre.setText("Nombre: "+plato.getNombre().toString());
                calorias.setText("Calorias: "+plato.getCalorias().toString());
                grasas.setText("Grasa: "+plato.getGrasa().toString());
                proteinas.setText("Proteinas: "+plato.getProteinas().toString());
                carbohidratos.setText("Carbohidratos: "+plato.getNombre().toString());


            }
        };


        lv.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
