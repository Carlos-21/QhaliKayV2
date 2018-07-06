package com.example.avance.qhalikayv2.Pestañas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avance.qhalikayv2.Ayuda.DocumentoUsuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Componente.AlimentoDAO;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Carta;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IAlimentoDAO;
import com.example.avance.qhalikayv2.Frutas;
import com.example.avance.qhalikayv2.R;
import com.example.avance.qhalikayv2.Vegetales;

import java.util.ArrayList;


public class FavoritosFragment extends Fragment implements View.OnClickListener{
    private ImageView[] imagenVegetal =new android.widget.ImageView[5];
    private TextView[] textoVegetal = new TextView[5];
    private ArrayList<Carta> cartas;
    private IAlimentoDAO modelo = new AlimentoDAO();
    private TextView vegetales;
    private ArrayList<Carta> cartasFrutas;
    private ImageView[] imagenFruta =new android.widget.ImageView[5];
    private TextView[] textoFruta = new TextView[5];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        inicializar(view);

        vegetales = (TextView)view.findViewById(R.id.vegetalesMas);
        vegetales.setOnClickListener(this);

        mostrarComponentes();
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.vegetalesMas : intent = new Intent(getActivity(), Vegetales.class);
                startActivity(intent);
                break;
            case R.id.brocoli :   llamarActividadVegetales(intent, cartas.get(0));
                break;
            case R.id.berenjena :   llamarActividadVegetales(intent, cartas.get(1));
                break;
            case R.id.zanahoria :   llamarActividadVegetales(intent, cartas.get(2));
                break;
            case R.id.espinaca :   llamarActividadVegetales(intent, cartas.get(3));
                break;
            case R.id.pimiento :   llamarActividadVegetales(intent, cartas.get(4));
                break;
            case R.id.fruta1 :   llamarActividadFruta(intent, cartasFrutas.get(0));
                break;
            case R.id.fruta2 :   llamarActividadFruta(intent, cartasFrutas.get(1));
                break;
            case R.id.fruta3 :   llamarActividadFruta(intent, cartasFrutas.get(2));
                break;
            case R.id.fruta4 :   llamarActividadFruta(intent, cartasFrutas.get(3));
                break;
            case R.id.fruta5 :   llamarActividadFruta(intent, cartasFrutas.get(4));
                break;
        }
    }

    private void inicializar(View vista){
        inicializarVegetal(vista);
        inicializarFruta(vista);
    }

    private void inicializarVegetal(View vista){
        cartas = new ArrayList<>();

        imagenVegetal[0] = (ImageView)vista.findViewById(R.id.brocoli);
        imagenVegetal[0].setOnClickListener(this);
        imagenVegetal[1] = (ImageView)vista.findViewById(R.id.berenjena);
        imagenVegetal[1].setOnClickListener(this);
        imagenVegetal[2] = (ImageView)vista.findViewById(R.id.zanahoria);
        imagenVegetal[2].setOnClickListener(this);
        imagenVegetal[3] = (ImageView)vista.findViewById(R.id.espinaca);
        imagenVegetal[3].setOnClickListener(this);
        imagenVegetal[4] = (ImageView)vista.findViewById(R.id.pimiento);
        imagenVegetal[4].setOnClickListener(this);

        textoVegetal[0] = (TextView)vista.findViewById(R.id.textoVegetal);
        textoVegetal[1] = (TextView)vista.findViewById(R.id.textoVegetal2);
        textoVegetal[2] = (TextView)vista.findViewById(R.id.textoVegetal3);
        textoVegetal[3] = (TextView)vista.findViewById(R.id.textoVegetal4);
        textoVegetal[4] = (TextView)vista.findViewById(R.id.textoVegetal5);

        int i = 0;
        while(i<5){
            Carta auxiliar = new Carta();
            auxiliar.setFoto(imagenVegetal[i]);
            auxiliar.setTexto(textoVegetal[i]);

            cartas.add(auxiliar);

            i++;
        }
    }

    private void inicializarFruta(View vista){
        cartasFrutas = new ArrayList<>();

        imagenFruta[0] = (ImageView)vista.findViewById(R.id.fruta1);
        imagenFruta[0].setOnClickListener(this);
        imagenFruta[1] = (ImageView)vista.findViewById(R.id.fruta2);
        imagenFruta[1].setOnClickListener(this);
        imagenFruta[2] = (ImageView)vista.findViewById(R.id.fruta3);
        imagenFruta[2].setOnClickListener(this);
        imagenFruta[3] = (ImageView)vista.findViewById(R.id.fruta4);
        imagenFruta[3].setOnClickListener(this);
        imagenFruta[4] = (ImageView)vista.findViewById(R.id.fruta5);
        imagenFruta[4].setOnClickListener(this);

        textoFruta[0] = (TextView)vista.findViewById(R.id.textoFrutal);
        textoFruta[1] = (TextView)vista.findViewById(R.id.textoFruta2);
        textoFruta[2] = (TextView)vista.findViewById(R.id.textoFruta3);
        textoFruta[3] = (TextView)vista.findViewById(R.id.textoFruta4);
        textoFruta[4] = (TextView)vista.findViewById(R.id.textoFruta5);

        int i = 0;
        while(i<5){
            Carta auxiliar = new Carta();
            auxiliar.setFoto(imagenFruta[i]);
            auxiliar.setTexto(textoFruta[i]);

            cartasFrutas.add(auxiliar);

            i++;
        }
    }

    private void mostrarComponentes(){
        modelo.mostrarFavoritos(cartas,1);
        modelo.mostrarFavoritos(cartasFrutas,2);
    }

    private void llamarActividadVegetales(Intent intent, Carta carta){
        intent = new Intent(getActivity(), Vegetales.class);

        intent.putExtra("imagen",carta.getAlimento().getImagen());
        intent.putExtra("caloria",carta.getAlimento().getCaloria());
        intent.putExtra("grasa",carta.getAlimento().getGrasa());
        intent.putExtra("proteina",carta.getAlimento().getProteina());
        intent.putExtra("nombreAlimento", carta.getAlimento().getNombre());

        DocumentoUsuario.banderaAlimento = DocumentoUsuario.existeFavorito(carta.getAlimento().getNombre());

        startActivity(intent);
    }

    private void llamarActividadFruta(Intent intent, Carta carta){
        intent = new Intent(getActivity(), Frutas.class);

        intent.putExtra("imagen",carta.getAlimento().getImagen());
        intent.putExtra("caloria",carta.getAlimento().getCaloria());
        intent.putExtra("grasa",carta.getAlimento().getGrasa());
        intent.putExtra("proteina",carta.getAlimento().getProteina());
        intent.putExtra("nombreAlimento", carta.getAlimento().getNombre());

        DocumentoUsuario.banderaFruta = DocumentoUsuario.existeFavorito(carta.getAlimento().getNombre());

        startActivity(intent);
    }

}
