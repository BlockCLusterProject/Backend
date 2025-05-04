/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 *
 * @author andre
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    
	@Column(name = "nombre")
    private String nombre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "id_rol")
    private String idRol;

    @Column(name = "age")
    private int edad;

    @Column(name = "email")
    private String correo;

    @Column(name = "phone")
    private String telefono;

    public Person(String nombre, String cedula, int edad, String correo, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Person() {};

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
