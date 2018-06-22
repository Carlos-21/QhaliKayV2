package com.example.avance.qhalikayv2;

public class Plato {

    String nombre;
    String calorias;
    String grasa;
    String proteinas;
    String carbohidratos;


    public Plato(){

    }
    public Plato(String nombre, String calorias, String grasa, String proteinas, String carbohidratos) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.grasa = grasa;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getGrasa() {
        return grasa;
    }

    public void setGrasa(String grasa) {
        this.grasa = grasa;
    }

    public String getProteinas() {
        return proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
}
