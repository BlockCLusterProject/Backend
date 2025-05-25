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

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author JuanCGallo
 */
@Entity
@Table(name = "movies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title", nullable = false)
	@JsonProperty("title")
    private String titulo;

	@Column(name = "vote_average", nullable = false)
    @JsonProperty("vote_average")
    private double vote_average;

	@JsonProperty("runtime")
	@Column(name = "runtime", nullable = false)
	@SerializedName("runtime")
    private int runtime;

	@Column(name = "genres", columnDefinition = "JSON", nullable = true)
	@Convert(converter = GenreListConverter.class)
    @JsonProperty("genres")
    @SerializedName("genres")
    private List<Genre> genres;

	@Column(name = "genre_ids", nullable = true)
    @JsonProperty("genre_ids")
    private List<Integer> genre_ids;

	@Column(name = "overview", nullable = false)
    @JsonProperty("overview")
	@SerializedName("overview")
    private String overview;


	@Column(name = "backdrop_path", nullable = false)
    @JsonProperty("backdrop_path")
	@SerializedName("rutaPortada")
    private String backdrop_path;

	@Column(name = "is_active", nullable = false)
    @SerializedName("active")
    @JsonProperty("active")
    private boolean active = true;

	@Column(name = "quantity", nullable = false)
    @SerializedName("quantity")
    private int quantity = 0;

    @JsonProperty("counter")
    private static int counter = 1;

	@Column(name = "price", nullable = false)
    @SerializedName("precio")
    @JsonProperty("price")
    private double price;
    
    
    public Movie() {}

    public Movie(
            String title,
            int duracion,
            double vote_average,
            List<Genre> generos,
            double precio,
            String sinopsis,
            String rutaPortada,
            int cantidad
    ) {
        this.titulo = title;
        this.runtime = duracion;
        this.vote_average = vote_average;
        this.genres = generos;
        this.price = precio;
        this.overview = sinopsis;
        this.backdrop_path = rutaPortada;
        this.id = this.counter;
        this.counter++;
    }

    @Override
    public String toString() {
        return "Pelicula{"
                + "title='" + titulo + '\''
                + ", generos=" + genres
                + ", duracion=" + runtime
                + ", vote_average=" + vote_average
                + ", overview='" + overview + '\''
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

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double rate) {
        this.vote_average = rate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int cantidad) {
        this.quantity = cantidad;
    }

    public int getId() {
        return id;
    }

	public void setId(int id) {
        this.id = id;
    }
}
