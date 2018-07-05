package com.example.avance.qhalikayv2.Ayuda;

import com.example.avance.qhalikayv2.BaseDatos.DAO.Datos.Usuario;

import java.util.ArrayList;

public class DocumentoUsuario {
    public static String idUsuario;
    public static int cantidadFavorito;
    public static Usuario usuario;
    public static ArrayList<String> favoritos = new ArrayList<>();
    public static boolean banderaAlimento;

    public static boolean existeFavorito(String alimento){
        for (String cadena : favoritos){
            if(alimento.equals(cadena)){
                return true;
            }
        }
        return false;
    }

}
