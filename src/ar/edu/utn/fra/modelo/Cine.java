
package ar.edu.utn.fra.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class Cine implements Serializable {

    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Entrada> obtenerEntradasDel(Cliente c) {
        return entradas.stream()
                .filter(e -> e.getCliente().equals(c))
                .toList();
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void registrarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public Cliente login(String email, String contraseña) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email) && c.getContraseña().equals(contraseña)) {
                return c;
            }
        }
        return null;
    }

    public boolean comprarEntrada(Cliente cliente, Sala sala, int fila, int columna) {
        Butaca butaca = sala.getButaca(fila, columna);
        if (butaca != null && !butaca.isOcupada()) {
            butaca.setOcupada(true);
            Entrada entrada = new Entrada(cliente, sala, butaca);
            entradas.add(entrada);
            return true;
        }
        return false;
    }
}
