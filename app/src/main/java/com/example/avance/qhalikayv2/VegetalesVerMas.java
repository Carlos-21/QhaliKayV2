package com.example.avance.qhalikayv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avance.qhalikayv2.BaseDatos.Conexion.Conexion;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Alimento;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VegetalesVerMas extends AppCompatActivity {
    private EditText mSearchText;
    private RecyclerView mRecycleView;
    private List<Alimento> vegetal;
    private FirebaseRecyclerAdapter<Alimento, VegetalesViewHolder> FirebaseRecyclerAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetales_ver_mas);
        mSearchText = (EditText) findViewById(R.id.textoBusquedaVegetal);

        mRecycleView = (RecyclerView) findViewById(R.id.listaVegetales);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        vegetal = new ArrayList<>();

        databaseReference = Conexion.getRealTimeBase(1);


        mRecycleView.setHasFixedSize(true);



        mSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String searchText = mSearchText.getText().toString().trim();
                loadFireBasedata(searchText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void loadFireBasedata(String searchText) {
        if (searchText.isEmpty()) {

            mRecycleView.setAdapter(FirebaseRecyclerAdapter);

        }else{
            Query vegetalesQuery =  databaseReference.orderByChild("Vegetales").startAt(searchText).endAt(searchText+" \uf8ff" );

            FirebaseRecyclerOptions alimentosOptions = new FirebaseRecyclerOptions.Builder<Alimento>().setQuery(vegetalesQuery, Alimento.class).build();
            FirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Alimento, VegetalesViewHolder>(alimentosOptions) {

                @Override
                public VegetalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vegetal,parent,false);
                    VegetalesViewHolder vegetalesViewHolder = new VegetalesViewHolder(view);
                    return vegetalesViewHolder;
                }

                @Override
                protected void onBindViewHolder(VegetalesViewHolder holder, int position, Alimento model) {

                    holder.calorias.setText("Calorias : "+ model.getCaloria());
                    holder.grasa.setText("Grasa: "+ model.getGrasa());
                    holder.proteina.setText("Proteina : "+ model.getProteina());

                    holder.nombre.setText("Nombre : "+ model.getNombre());

                    Picasso.get().load(model.getImagen()).into(holder.foto);
                }
            }

            ;
        }
        mRecycleView.setAdapter(FirebaseRecyclerAdapter);

    }

    public static class VegetalesViewHolder extends RecyclerView.ViewHolder {
        TextView calorias;
        TextView grasa;
        TextView proteina;

        TextView nombre;
        ImageView foto;

        public VegetalesViewHolder(View itemView) {
            super(itemView);

            calorias = (TextView)itemView.findViewById(R.id.textoCaloriaVVM);
            grasa = (TextView)itemView.findViewById(R.id.textoGrasaVVM);
            proteina = (TextView)itemView.findViewById(R.id.textoProteinaVVM);

            nombre = (TextView)itemView.findViewById(R.id.textoVegetalVVM);

            foto = (ImageView)itemView.findViewById(R.id.fotoVVM);
        }
    }
}
