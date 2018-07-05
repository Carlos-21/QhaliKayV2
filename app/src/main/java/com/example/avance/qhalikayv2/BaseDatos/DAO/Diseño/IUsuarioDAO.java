package com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Favorito;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;

public interface IUsuarioDAO {
    public void buscarUsuario(Usuario usuario);
    public void añadirFavorito(Usuario usuario, Favorito favorito);
    public void cantidadFavorito();
    public void nombresFavoritos();
}
