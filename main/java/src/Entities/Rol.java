package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "rol")
	private String rol;
	
	public Rol() {}
	
	public Rol(Integer id, String rol) {
		this.id = id;
		this.rol = rol;
	}
	
	// --- Getters ---
	public Integer getId() {
		return id;
	}
	
	public String getRol() {
		return rol;
	}
	
	// --- Setters ---
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
