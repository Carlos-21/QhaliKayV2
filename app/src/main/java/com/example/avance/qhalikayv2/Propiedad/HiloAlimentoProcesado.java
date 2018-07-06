package com.example.avance.qhalikayv2.Propiedad;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.AlimentoProcesado;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IAlimentoDAO;

public class HiloAlimentoProcesado extends Thread {
    private IAlimentoDAO modelo;
    private String codigo;
    private AlimentoProcesado alimentoProcesado;

    public HiloAlimentoProcesado(IAlimentoDAO modelo, String codigo, AlimentoProcesado alimentoProcesado){
        this.modelo = modelo;
        this.codigo = codigo;
        this.alimentoProcesado = alimentoProcesado;
    }

    @Override
    public void run(){
        modelo.buscarAlimentoNoProcesado(codigo, alimentoProcesado);
    }

}
