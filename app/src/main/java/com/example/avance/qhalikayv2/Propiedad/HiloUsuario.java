package com.example.avance.qhalikayv2.Propiedad;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;
import com.example.avance.qhalikayv2.BaseDatos.DAO.Diseño.IUsuarioDAO;

public class HiloUsuario extends Thread{
    private IUsuarioDAO modelo;
    private Usuario usuario;

    public HiloUsuario(IUsuarioDAO modelo, Usuario usuario){
        this.modelo = modelo;
        this.usuario = usuario;
    }

    @Override
    public void run(){
        modelo.buscarUsuario(usuario);
    }

}
