/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import java.util.List;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.core.deps.com.google.gson.annotations.SerializedName;

/**
 *
 * @author JuanCGallo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	@JsonProperty("title")
    private String titulo;
	@JsonProperty("runtime")
    private int duracion;
    @JsonProperty("vote_average")
    private double puntuacion;
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> genres;
    @JsonProperty("genre_ids")
    private List<Integer> genre_ids;
    private double precio;
    @JsonProperty("overview")
    private String sinopsis;
    @JsonProperty("backdrop_path")
    private String rutaPortada;
    private boolean active = true;
    private int cantidad = 0;
    private static int counter = 1;
    private int id;

    public Movie(
            String titulo,
            int duracion,
            double puntuacion,
            List<Genre> generos,
            double precio,
            String sinopsis,
            String rutaPortada,
            int cantidad
    ) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.genres = generos;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.rutaPortada = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }

    public List<Integer> getGenre_ids() {
    	return genre_ids;
    }
    
    public void setGenre_ids(List<Integer> genre_ids) {
    	this.genre_ids = genre_ids;
    }

    
    public Movie() {}

    public String getRutaPortada() {
        return rutaPortada;
    }

    @Override
    public String toString() {
        return "Pelicula{"
                + "titulo='" + titulo + '\''
                + ", generos=" + genres
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
    
    public void setDuracion(int duracion) {
    	this.duracion = duracion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public List<Genre> getGenres() {
        return genres;
    }
    
    public void setGenres(List<Genre> genres) {
    	this.genres = genres;
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
