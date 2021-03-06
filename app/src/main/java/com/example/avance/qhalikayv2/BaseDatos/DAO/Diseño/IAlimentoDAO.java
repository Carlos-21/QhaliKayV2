package com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Alimento;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.AlimentoProcesado;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Carta;
import com.example.avance.qhalikayv2.Calorias;

import java.util.ArrayList;

public interface IAlimentoDAO {
    public void mostrarVegetales(ArrayList<Carta> cartaVegetal);
    public void mostrarFrutas(ArrayList<Carta> cartaFruta);
    public void listarVegetales(ArrayList<Carta> cartaVegetal);
    public void listarFrutas(ArrayList<Carta> cartaFruta);
    public void listarFavoritos(ArrayList<Carta> cartaFavorito, int tipo);
    public void mostrarFavoritos(ArrayList<Carta> cartaFavorito, int tipo);

    public void buscarAlimentoNoProcesado(String codigoBarra, AlimentoProcesado alimentoProcesado);
}
