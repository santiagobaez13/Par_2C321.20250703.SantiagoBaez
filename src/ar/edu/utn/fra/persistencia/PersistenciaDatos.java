/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.persistencia;

import ar.edu.utn.fra.modelo.Cine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Santiago
 */
public class PersistenciaDatos {

    private static final String ARCHIVO = "cine.ser";

    public static void guardarEstado(Cine cine) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
        }
    }

    public static Cine cargarEstado() throws IOException, ClassNotFoundException {
        File file = new File(ARCHIVO);
        if (!file.exists()) {
            return new Cine(); // estado nuevo
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Cine) ois.readObject();
        }
    }
}
