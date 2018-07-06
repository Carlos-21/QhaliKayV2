package com.example.avance.qhalikayv2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.avance.qhalikayv2.Ayuda.DocumentoUsuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Componente.AlimentoDAO;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.AlimentoProcesado;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IAlimentoDAO;
import com.example.avance.qhalikayv2.Propiedad.HiloAlimentoProcesado;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class RegistrarANP extends AppCompatActivity implements View.OnClickListener, ZXingScannerView.ResultHandler{
    private ZXingScannerView escanerView;
    private Button boton;
    private AlimentoProcesado alimentoProcesado;
    private IAlimentoDAO modelo;
    private ProgressDialog progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_anp);

        boton = (Button)findViewById(R.id.botonBarra);
        boton.setOnClickListener(this);

        alimentoProcesado = new AlimentoProcesado();
        modelo = new AlimentoDAO();
    }


    public void EscannerBarra(){
        escanerView = new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonBarra : EscannerBarra();
                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        HiloAlimentoProcesado hilo = new HiloAlimentoProcesado(modelo, result.getText(), alimentoProcesado);
        hilo.run();

        progreso = new ProgressDialog(RegistrarANP.this);
        progreso.setMessage("Escaneando...."); // Setting Message
        progreso.setTitle("Reconociendo"); // Setting Title
        progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progreso.show();
        progreso.setCancelable(false);

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1800);
                    llamarActividadProcesados(alimentoProcesado);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progreso.dismiss();
            }
        }).start();

        escanerView.resumeCameraPreview(this);
    }

    private void llamarActividadProcesados(AlimentoProcesado alimentoProcesado){
        Intent intent = new Intent(this, Procesados.class);

        intent.putExtra("imagen",alimentoProcesado.getImagen());
        intent.putExtra("caloria",alimentoProcesado.getCaloria());
        intent.putExtra("grasa",alimentoProcesado.getGrasa());
        intent.putExtra("proteina",alimentoProcesado.getProteina());
        intent.putExtra("nombreAlimento", alimentoProcesado.getDenominacion());

        DocumentoUsuario.banderaAlimento = DocumentoUsuario.existeFavorito(alimentoProcesado.getDenominacion());

        startActivity(intent);
    }

}
