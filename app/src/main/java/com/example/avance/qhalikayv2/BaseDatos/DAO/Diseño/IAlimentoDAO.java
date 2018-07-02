package com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Alimento;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Carta;
import com.example.avance.qhalikayv2.Calorias;

import java.util.ArrayList;

public interface IAlimentoDAO {
    public ArrayList<Alimento> listarVegetales();
    public ArrayList<Alimento> listarFrutas();
    public void mostrarVegetales(ArrayList<Carta> cartaVegetal, Calorias calorias);
    public void mostrarFrutas(ArrayList<Carta> cartaFruta, Calorias calorias);
}
