package com.example.avance.qhalikayv2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.avance.qhalikayv2.Propiedad.Nutricion;
import com.squareup.picasso.Picasso;

public class Vegetales extends AppCompatActivity {
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
    private boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetales);

        barra1 = (ProgressBar)findViewById(R.id.barra1);
        barra2 = (ProgressBar)findViewById(R.id.barra2);
        barra3 = (ProgressBar)findViewById(R.id.barra3);

        foto = (ImageView)findViewById(R.id.fotoVegetal);

        texto1 = (TextView)findViewById(R.id.textoCantidadCaloria);
        texto2 = (TextView)findViewById(R.id.textoCantidadGrasa);
        texto3 = (TextView)findViewById(R.id.textoCantidadProteina);

        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            Picasso.get().load((String) bun.get("imagen")).into(foto);

            caloria = (Double) bun.get("caloria");
            grasa = (Double) bun.get("grasa");
            proteina = (Double) bun.get("proteina");

            texto1.setText(String.valueOf(caloria));
            texto2.setText(String.valueOf(grasa));
            texto3.setText(String.valueOf(proteina));

        }

        bandera = false;
        Nutricion nutricion = new Nutricion(barra1, barra2, barra3);
        nutricion.mostrarDatosNutricionales(caloria,grasa,proteina);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorito:
                if(bandera){
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.estrellasf));
                    bandera = false;
                }
                else{
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.estrellaf));
                    bandera = true;
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
