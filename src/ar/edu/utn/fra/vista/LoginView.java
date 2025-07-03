/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.vista;

import ar.edu.utn.fra.controlador.LoginController;
import ar.edu.utn.fra.modelo.Cine;
import ar.edu.utn.fra.modelo.Cliente;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Santiago
 */
public class LoginView {

    private Stage stage;
    private LoginController controller;
    private Cine cine;

    public LoginView(Stage stage, Cine cine) {
        this.stage = stage;
        this.cine = cine;
        this.controller = new LoginController(cine);
    }

    public void mostrar() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Sistema de entradas de cine");

        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passField = new PasswordField();
        passField.setPromptText("Contraseña");

        Label mensaje = new Label();

        Button loginBtn = new Button("Iniciar sesion");
        Button regBtn = new Button("Registrarse");

        loginBtn.setOnAction(e -> {
            String email = emailField.getText();
            String pass = passField.getText();

            if (email.isEmpty() || pass.isEmpty()) {
                mensaje.setText("Completa todos los campos para iniciar sesion.");
                return;
            }
            Cliente c = controller.login(emailField.getText(), passField.getText());
            if (c != null) {
                mensaje.setText("Ingreso exitoso " + c.getNombre());
                new SalaView(stage, cine, c).mostrar();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de inicio de sesion");
                alert.setContentText("Email o contraseña incorrectos");
                alert.showAndWait();
            }
        });

        regBtn.setOnAction(e -> {
            String nombre = nombreField.getText();
            String email = emailField.getText();
            String pass = passField.getText();

            if (nombre.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                mensaje.setText("Completa todos los campos para registrarte.");
                return;
            }
            boolean ok = controller.registrar(
                    nombreField.getText(),
                    emailField.getText(),
                    passField.getText());
            mensaje.setText(ok ? "Registrado con exito." : "El cliente ya existe.");
        });

        root.getChildren().addAll(
                titulo,
                nombreField, emailField, passField,
                loginBtn, regBtn,
                mensaje);

        stage.setTitle("Login / Registro");
        stage.setScene(new Scene(root, 320, 300));
        stage.show();
    }
}
