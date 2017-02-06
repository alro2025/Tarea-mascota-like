package com.alro2025.mascotaslike;

/**
 * Created by kikipo on 04/02/2017.
 */

public class ContactoMascota {

    private int foto;
    private String nombre;
    private int numlikes ;



    public ContactoMascota(int foto, String nombre){
        this.foto = foto;
        this.nombre = nombre;
        this.numlikes = 0;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getNumlikes() {
        return numlikes;
    }

    public void setNumlikes(int numlikes) {
        this.numlikes = numlikes;
    }
}
