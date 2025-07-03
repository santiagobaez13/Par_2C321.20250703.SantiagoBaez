
package ar.edu.utn.fra.controlador;

import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Sala;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class SalaController {
    private Cine cine;
    
    public SalaController(Cine cine){
        this.cine = cine;
    }
    
    public List<Sala> obtenerSalas(){
        return cine.getSalas();
    }
    
    public Sala obtenerSalaPorNumero(int numero){
        return cine.getSalas()
                .stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
}
