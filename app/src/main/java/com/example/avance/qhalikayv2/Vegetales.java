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

import com.example.avance.qhalikayv2.Propiedad.Nutricion;

public class Vegetales extends AppCompatActivity {
    private ProgressBar barra1;
    private ProgressBar barra2;
    private ProgressBar barra3;
    private ImageView foto;
    private Integer caloria;
    private Integer proteina;
    private Integer grasa;
    private boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetales);

        barra1 = (ProgressBar)findViewById(R.id.barra1);
        barra2 = (ProgressBar)findViewById(R.id.barra2);
        barra3 = (ProgressBar)findViewById(R.id.barra3);
        foto = (ImageView)findViewById(R.id.fotoVegetal);

        Intent inten = getIntent();
        Bundle bun = inten.getExtras();

        if(bun != null){
            foto = (ImageView) bun.get("imagen");
            caloria = (Integer) bun.get("caloria");
            grasa = (Integer) bun.get("grasa");
            proteina = (Integer) bun.get("proteina");
        }

        bandera = false;
        /*Nutricion nutricion = new Nutricion(barra1, barra2, barra3);
        nutricion.mostrarDatosNutricionales(caloria,proteina,grasa);*/
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
