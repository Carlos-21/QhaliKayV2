package com.example.avance.qhalikayv2.BaseDatos.DAO.Datos;

public class Alimento {
    private Integer caloria;
    private Integer grasa;
    private String nombre;
    private Integer proteina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCaloria() {
        return caloria;
    }

    public void setCaloria(Integer caloria) {
        this.caloria = caloria;
    }

    public Integer getGrasa() {
        return grasa;
    }

    public void setGrasa(Integer grasa) {
        this.grasa = grasa;
    }

    public Integer getProteina() {
        return proteina;
    }

    public void setProteina(Integer proteina) {
        this.proteina = proteina;
    }

}
