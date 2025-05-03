/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;
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
    
    private String user;
    private String password;
    private List<Genre> preference;
	@Column(name = "usuario")
    private String usuario;

	@Column(name = "contrasena")
    private String contrasena;

    public Client(String name, String id, String age, String email, String phone, String user, String password, List<Genre> preference) {
        super(name, id, age, email, phone);
        this.user = user;
        this.password = password;
        this.preference = preference;
    }
    
    public List<Genre> getPreference() {
        return preference;
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
