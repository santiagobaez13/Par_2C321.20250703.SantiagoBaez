
package ar.edu.utn.fra.app;
import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Sala;
import ar.edu.utn.fra.persistencia.PersistenciaDatos;
import ar.edu.utn.fra.vista.LoginView;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Santiago
 */
public class Main extends Application {

    private Cine cine;

    @Override
    public void init() {
        try {
            cine = PersistenciaDatos.cargarEstado();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("️ERROR al cargar estado: " + e.getMessage());
            cine = new Cine();
        }

        if (cine.getSalas().isEmpty()) {
            cine.agregarSala(new Sala(1, "Star Wars 3", 5, 6));
            cine.agregarSala(new Sala(2, " Superman", 6, 7));
            cine.agregarSala(new Sala(3, "Jurassic Park", 4, 5));
            cine.agregarSala(new Sala(4, "Los 4 Fantasticos", 5, 5));
            cine.agregarSala(new Sala(5, "John Wick", 6, 6));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView(primaryStage, cine);
        loginView.mostrar();
    }

    @Override
    public void stop() {
        try {
            PersistenciaDatos.guardarEstado(cine);
        } catch (IOException e) {
            System.err.println(" ERROR al guardar estado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}