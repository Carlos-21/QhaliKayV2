package com.example.avance.qhalikayv2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.avance.qhalikayv2.Ayuda.DocumentoUsuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Componente.UsuarioDAO;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Favorito;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IUsuarioDAO;
import com.example.avance.qhalikayv2.Propiedad.Nutricion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Frutas extends AppCompatActivity {
    private ProgressBar barra1;
    private ProgressBar barra2;
    private ProgressBar barra3;
    private ImageView foto;
    private Double caloria;
    private Double proteina;
    private Double grasa;
    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private Favorito favorito;
    private IUsuarioDAO modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);
        Inicializar();

        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            Picasso.get().load((String) bun.get("imagen")).into(foto);

            caloria = (Double) bun.get("caloria");
            grasa = (Double) bun.get("grasa");
            proteina = (Double) bun.get("proteina");

            favorito.setIdAlimento((String)bun.get("nombreAlimento"));

            texto1.setText(String.valueOf(caloria));
            texto2.setText(String.valueOf(grasa));
            texto3.setText(String.valueOf(proteina));

        }

        Nutricion nutricion = new Nutricion(barra1, barra2, barra3);
        nutricion.mostrarDatosNutricionales(caloria,grasa,proteina);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        if(DocumentoUsuario.banderaFruta){
            menu.findItem(R.id.favorito).setIcon(ContextCompat.getDrawable(this, R.drawable.estrellaf));
        }
        else{
            menu.findItem(R.id.favorito).setIcon(ContextCompat.getDrawable(this, R.drawable.estrellasf));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorito:
                if(DocumentoUsuario.banderaFruta){
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.estrellasf));
                    DocumentoUsuario.banderaFruta= false;
                }
                else{
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.estrellaf));
                    DocumentoUsuario.banderaFruta = true;
                    llamarModelo();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void Inicializar(){
        favorito = new Favorito();
        modelo = new UsuarioDAO();

        barra1 = (ProgressBar)findViewById(R.id.barraF1);
        barra2 = (ProgressBar)findViewById(R.id.barraF2);
        barra3 = (ProgressBar)findViewById(R.id.barraF3);

        foto = (ImageView)findViewById(R.id.fotoFruta);

        texto1 = (TextView)findViewById(R.id.textoCantidadCaloria);
        texto2 = (TextView)findViewById(R.id.textoCantidadGrasa);
        texto3 = (TextView)findViewById(R.id.textoCantidadProteina);

    }

    private void llamarModelo(){
        modelo.añadirFavorito(DocumentoUsuario.usuario, favorito);
        modelo.cantidadFavorito();
        DocumentoUsuario.favoritos = new ArrayList<>();
        modelo.nombresFavoritos();
    }

}
