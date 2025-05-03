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
public class Client extends Person{
    
	@Column(name = "usuario")
    private String usuario;

	@Column(name = "contrasena")
    private String contrasena;

    public Client(String nombre, String id, String edad, String correo, String telefono, String usuario, String contrasena) {
        super(nombre, id, edad, correo, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
    
}
