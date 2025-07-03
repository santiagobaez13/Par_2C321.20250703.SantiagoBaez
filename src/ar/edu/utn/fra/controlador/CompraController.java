
package ar.edu.utn.fra.controlador;

import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;
import ar.edu.utn.fra.modelo.Sala;

/**
 *
 * @author Santiago
 */
public class CompraController {

    private Cine cine;

    public CompraController(Cine cine) {
        this.cine = cine;
    }

    public boolean comprar(Cliente cliente, Sala sala, int fila, int columna) {
        return cine.comprarEntrada(cliente, sala, fila, columna);
    }
}
