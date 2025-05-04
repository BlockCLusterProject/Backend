/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "users")
public class Admin extends Person{
    
	@Column(name = "usuario")
    private String user;
	
	@Column(name = "contrasena")
    private String password;

	public Admin() {};

    public Admin(String nombre, String id, int edad, String correo, String telefono, String usuario, String contrasena) {
        super(nombre, id, edad, correo, telefono);
        this.user = usuario;
        this.user = contrasena;
    }

    public String getUsuario() {
        return user;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String contrasena) {
        this.password = contrasena;
    }

    
    

    
    
}
