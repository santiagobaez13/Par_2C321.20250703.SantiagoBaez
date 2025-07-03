/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Santiago
 */
public class Cliente implements Serializable{
    private String nombre;
    private String email;
    private String contraseña;

    public Cliente(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(email, other.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(email);

    }
    
    @Override
    public String toString(){
        return nombre + "(" + email + ")";
    }
}
