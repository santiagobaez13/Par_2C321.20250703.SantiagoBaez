
package ar.edu.utn.fra.modelo;

import java.io.Serializable;

/**
 *
 * @author Santiago
 */
public class Butaca implements Serializable {

    private int fila;
    private int numero;
    private boolean ocupada;

    public Butaca(int fila, int numero, boolean estado) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = estado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean estado) {
        this.ocupada = estado;
    }

    @Override
    public String toString() {
        return "Fila " + fila + ", Asiento " + numero + " [" + (ocupada ? "X" : "O") + "]";
    }
}
