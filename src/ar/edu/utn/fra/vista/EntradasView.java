
package ar.edu.utn.fra.vista;
import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;
import ar.edu.utn.fra.modelo.Entrada;
import java.util.List;
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
public class EntradasView {

    private Stage stage;
    private Cine cine;
    private Cliente cliente;
    private List<Entrada> lista;

    public EntradasView(Stage stage, Cine cine, Cliente cliente, List<Entrada> lista) {
        this.stage = stage;
        this.cine = cine;
        this.cliente = cliente;
        this.lista = lista;
    }

    public void mostrar() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Tus entradas");

        if (lista.isEmpty()) {
            root.getChildren().add(new Label("No compraste entradas todavia"));
        } else {
            for (Entrada e : lista) {
                root.getChildren().add(new Label(mostrarDetallesEntrada(e)));
            }
        }

        Button volverBtn = new Button("Volver");
        volverBtn.setOnAction(e -> new SalaView(stage, cine, cliente).mostrar());

        root.getChildren().addAll(titulo, volverBtn);

        stage.setTitle("Tus Entradas");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
    //Entrada pasaa ser un string legible dentro de Mis entradas

    private String mostrarDetallesEntrada(Entrada entrada) {
        return "Pelicula: " + entrada.getSala().getPelicula()
                + " | Sala: " + entrada.getSala().getNumero()
                + " | Fila: " + entrada.getButaca().getFila()
                + " | Asiento: " + entrada.getButaca().getNumero();
    }
}
