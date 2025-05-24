package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchases_history")
public class PurchaseHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "client_id")
	@JsonProperty("client_id")
	private Integer client_id;

	@Column(name = "movie_id")
	@JsonProperty("movie_id")
	private Integer movie_id;

	@Column(name = "quantity")
	@JsonProperty("quantity")
	private Integer quantity;
	
	@Column(name = "price")
	@JsonProperty("price")
	private Double price;
	
	public PurchaseHistory() {}
	
	

	public PurchaseHistory(Integer client_id, Integer movie_id, Integer quantity, Double price) {
		this.client_id = client_id;
		this.movie_id = movie_id;
		this.quantity = quantity;
		this.price = price;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [id=" + id + ", client_id=" + client_id + ", movie_id=" + movie_id + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
}
