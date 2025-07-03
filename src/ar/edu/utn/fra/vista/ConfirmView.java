/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.vista;

import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;
import ar.edu.utn.fra.modelo.Entrada;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Santiago
 */
public class ConfirmView {

    private Stage stage;
    private Entrada entrada;
    private Cine cine;
    private Cliente cliente;

    public ConfirmView(Stage stage, Entrada entrada, Cine cine, Cliente cliente) {
        this.stage = stage;
        this.entrada = entrada;
        this.cine = cine;
        this.cliente = cliente;
    }

    public void mostrar() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                new Label("Compra confirmada!"),
                new Label("Cliente: "  + entrada.getCliente().getNombre()),
                new Label("Sala: "     + entrada.getSala().getNumero()),
                new Label("Película: " + entrada.getSala().getPelicula()),
                new Label("Butaca: Fila " + entrada.getButaca().getFila() +
                          " Nº " + entrada.getButaca().getNumero())
        );

        Button volverBtn = new Button("Volver a selección");
        volverBtn.setOnAction(e ->
            new SalaView(stage, cine, cliente).mostrar()
        );

        root.getChildren().add(volverBtn);

        stage.setTitle("Confirmación");
        stage.setScene(new Scene(root, 320, 280));
        stage.show();
    }
}