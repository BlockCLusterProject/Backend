/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class Person {
    
	@Column(name = "nombre")
    private String nombre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "age")
    private int edad;

    @Column(name = "email")
    private String correo;

    @Column(name = "phone")
    private String telefono;
    
    @Column(name = "usuario")
    private String user;
    
    @Column(name = "contrasena")
    private String password;

   // @Convert(converter = GenreListConverter.class)
   // @Column(name = "preferences", columnDefinition = "json", nullable = true)
   // private List<Genre> preferences;

    public Person(
    		int id, 
    		int id_rol, 
    		String nombre, 
    		String cedula, 
    		int edad, 
    		String correo, 
    		String telefono, 
    		List<Genre> preferences,
    		String user,
    		String password
    		) {
    	this.id = id;
    	this.idRol = id_rol;
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        //this.preferences = preferences;
        this.user = user;
        this.password = password;
    }
    
    public Person() {};
    
    public String getUser() {
    	return user;
    }
    
    public void setUser(String user) {
    	this.user = user;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public List<Genre> getPreferences() {
    	return null ;
    }
    
    public void setPreferences(List<Genre> preferences) {
//    	this.preferences = preferences;
    }
    
    public int getId() {
    	return id;
    }
    
    public int getIdRol() {
    	return idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
    	this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
