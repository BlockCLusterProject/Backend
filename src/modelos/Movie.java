/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import persistencia.Serializadora;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JuanCGallo
 */
public class Movie implements Serializable {

    private String titulo;
    private int duracion;
    private double puntuacion;
    private ArrayList<Generos> generos;
    private double precio;
    // Se crea una clase ENUM para guardar los todos los generos
    // que vamos a usar en el proyecto, para darle orden y que todos se
    // escriban de la misma manera; lo hago en un ArrayList, porque una
    // sola pelicula puede tener mas de 1 genero
    private String sinopsis;
    private String rutaPortada;
    private boolean active = true;
    private int cantidad = 0;
    private static int counter = 1;
    private int id;

    public Movie(
            String titulo,
            int duracion,
            double puntuacion,
            ArrayList<Generos> generos,
            double precio,
            String sinopsis,
            String rutaPortada,
            int cantidad
    ) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.generos = generos;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.rutaPortada = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    @Override
    public String toString() {
        return "Pelicula{"
                + "titulo='" + titulo + '\''
                + ", duracion=" + duracion
                + ", puntuacion=" + puntuacion
                + ", sinopsis='" + sinopsis + '\''
                + '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public ArrayList<Generos> getGeneros() {
        return generos;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public boolean getActive() {
        return this.active;
    }

    public int getId() {
        return this.id;
    }
}
