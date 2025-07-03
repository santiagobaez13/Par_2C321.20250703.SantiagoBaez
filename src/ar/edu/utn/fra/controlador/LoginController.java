
package ar.edu.utn.fra.controlador;

import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;

/**
 *
 * @author Santiago
 */
public class LoginController {
    private Cine cine;
    
    public LoginController(Cine cine){
        this.cine = cine;
    }
    
    public Cliente login(String email, String contraseña){
        return cine.login(email, contraseña);
    }
    
    public boolean registrar(String nombre, String email, String contraseña){
        Cliente nuevo = new Cliente(nombre, email, contraseña);
        if (!cine.getClientes().contains(nuevo)){
            cine.registrarCliente(nuevo);
            return true;
        }
        return false;
    }
}