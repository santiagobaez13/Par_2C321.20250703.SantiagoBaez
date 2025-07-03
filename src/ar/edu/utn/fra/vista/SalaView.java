/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.vista;

import ar.edu.utn.fra.controlador.CompraController;
import ar.edu.utn.fra.modelo.Butaca;
import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;
import ar.edu.utn.fra.modelo.Entrada;
import ar.edu.utn.fra.modelo.Sala;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Santiago
 */
public class SalaView {

    private Stage stage;
    private Cine cine;
    private Cliente cliente;
    private CompraController ctrl;

    public SalaView(Stage stage, Cine cine, Cliente cliente) {
        this.stage = stage;
        this.cine = cine;
        this.cliente = cliente;
        this.ctrl = new CompraController(cine);
    }

    public void mostrar() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Elegi una sala");
        ComboBox<Sala> comboSalas = new ComboBox<>();
        comboSalas.getItems().addAll(cine.getSalas());

        GridPane grilla = new GridPane();
        Label mensaje = new Label();

        comboSalas.setOnAction(e -> {
            Sala salaSel = comboSalas.getValue();
            grilla.getChildren().clear();
            if (salaSel == null) {
                return;
            }

            Butaca[][] butacas = salaSel.getButacas();
            for (int f = 0; f < butacas.length; f++) {
                for (int c = 0; c < butacas[0].length; c++) {
                    Butaca b = butacas[f][c];
                    Button btn = new Button(b.isOcupada() ? "X" : "O");
                    btn.setDisable(b.isOcupada());
                    int fila = f, col = c;

                    btn.setOnAction(ev -> {
                        boolean ok = ctrl.comprar(cliente, salaSel, fila, col);
                        if (ok) {
                            Entrada ent = new Entrada(cliente, salaSel, salaSel.getButaca(fila, col));
                            new ConfirmView(stage, ent, cine, cliente).mostrar();
                        } else {
                            mensaje.setText("Butaca ocupada. Elegi otra por favor");
                        }
                    });
                    grilla.add(btn, c, f);
                }
            }
        });

        Button salirBtn = new Button("Salir del cine");
        salirBtn.setOnAction(e -> stage.close());
        Button misEntradas = new Button("Mis entradas");
        misEntradas.setOnAction(ev -> {
            List<Entrada> entradasCliente = cine.obtenerEntradasDel(cliente);
                    });

        root.getChildren().addAll(titulo, comboSalas, grilla, mensaje, misEntradas, salirBtn);
        stage.setTitle("Salas");
        stage.setScene(new Scene(root, 450, 400));
        stage.show();

    }
}
