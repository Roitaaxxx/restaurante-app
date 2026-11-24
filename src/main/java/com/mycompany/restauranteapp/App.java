
package com.mycompany.restauranteapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import com.mycompany.restauranteapp.view.inicio.PortadaView;
import com.mycompany.restauranteapp.view.inicio.LoginView;

public class App extends Application {

    private Stage escenario;

    @Override
    public void start(Stage escenario) {

        this.escenario = escenario;

        Font.loadFont(
            getClass().getResourceAsStream(
                "/com/mycompany/restauranteapp/fonts/spicy_sauce.ttf"
            ), 14
        );

        mostrarPortada();

        escenario.setTitle("ANTOJADOS - ALGO MAS QUE UN ANTOJO");
        escenario.setMinWidth(900);
        escenario.setMinHeight(600);
        escenario.show();
    }

    // Mostrar portada
    private void mostrarPortada() {

        PortadaView portada = new PortadaView(
            () -> mostrarLogin(),
            () -> mostrarMensaje("Registro", "Aquí construiremos el registro.")
        );

        Scene escena = new Scene(portada, 1200, 750);

        cargarEstilos(escena);

        escenario.setScene(escena);
    }

    // Mostrar login
    private void mostrarLogin() {

        LoginView login = new LoginView(
            () -> mostrarMensaje("Registro", "Aquí construiremos el registro."),
            () -> mostrarPortada()
        );

        Scene escena = new Scene(login, 1200, 750);

        cargarEstilos(escena);

        escenario.setScene(escena);
    }

    // Cargar estilos CSS
    private void cargarEstilos(Scene escena) {

        var estiloGlobal = App.class.getResource("global.css");
        var estiloInicio = App.class.getResource("inicio.css");
        var estiloAutenticacion = App.class.getResource("autenticacion.css");

        if (estiloGlobal == null) {
            throw new RuntimeException("No se encontró global.css");
        }

        if (estiloInicio == null) {
            throw new RuntimeException("No se encontró inicio.css");
        }

        if (estiloAutenticacion == null) {
            throw new RuntimeException("No se encontró autenticacion.css");
        }

        escena.getStylesheets().add(estiloGlobal.toExternalForm());
        escena.getStylesheets().add(estiloInicio.toExternalForm());
        escena.getStylesheets().add(estiloAutenticacion.toExternalForm());
    }

    private void mostrarMensaje(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}