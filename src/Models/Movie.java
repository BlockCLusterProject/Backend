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
	@SerializedName("runtime")
    private int runtime;
	@SerializedName("puntuacion")
	@JsonProperty("rate")
    private double rate;
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> genres;
    @JsonProperty("genre_ids")
    private List<Integer> genre_ids;
    @SerializedName("precio")
    @JsonProperty("price")
    private double price;
    @JsonProperty("overview")
    @SerializedName("sinopsis")
    private String overview;
    @JsonProperty("backdrop_path")
    @SerializedName("rutaPortada")
    private String backdrop_path;
    @SerializedName("active")
    @JsonProperty("active")
    private boolean active = true;
    @SerializedName("cantidad")
    private int cantidad = 0;
    @JsonProperty("counter")
    private static int counter = 1;
    @JsonProperty("id")
    @SerializedName("id")
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
        this.runtime = duracion;
        this.rate = puntuacion;
        this.genres = generos;
        this.price = precio;
        this.overview = sinopsis;
        this.backdrop_path = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }
    
    public Movie() {}

    @Override
    public String toString() {
        return "Pelicula{"
                + "titulo='" + titulo + '\''
                + ", generos=" + genres
                + ", duracion=" + runtime
                + ", puntuacion=" + rate
                + ", sinopsis='" + overview + '\''
                + '}';
    }
    
    public String getTitle() {
        return titulo;
    }

    public void setTitle(String title) {
        this.titulo = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double precio) {
        this.price = precio;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
