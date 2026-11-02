package com.mycompany.restauranteapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage escenario) {
        try {
            Font fuente = Font.loadFont(
                App.class.getResourceAsStream(
                    "/com/mycompany/restauranteapp/Crazy Blocks.otf"), 72
            );

            if (fuente != null) {
                System.out.println("Fuente cargada: " + fuente.getFamily());
            } else {
                System.out.println("No se pudo cargar la fuente.");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar la fuente: " + e.getMessage());
        }
        
        //Capa de texto: ANTOJADOS
        Label textoBack1 = new Label("ANTOJADOS");
        textoBack1.getStyleClass().add("titulo-fondo");
        
        Label textoBack2 = new Label("ANTOJADOS");
        textoBack2.getStyleClass().add("titulo-fondo");
        
        Label textoBack3 = new Label("ANTOJADOS");
        textoBack3.getStyleClass().add("titulo-fondo");

        VBox contenedorTexto = new VBox(-35, textoBack1, textoBack2, textoBack3);
        contenedorTexto.setAlignment(Pos.CENTER);
        
        //Capa de imagen: Hamburguesa
        ImageView imagenHamburguesa = new ImageView();
        try {
            var stream = App.class.getResourceAsStream("/com/mycompany/restauranteapp/burger.png");
            if (stream != null) {
                Image img = new Image(stream);
                imagenHamburguesa.setImage(img);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        imagenHamburguesa.setFitWidth(360);
        imagenHamburguesa.setPreserveRatio(true);
        imagenHamburguesa.setTranslateY(95);


        StackPane superposicion = new StackPane();
        superposicion.setPadding(new Insets(0, 0, 30, 0));
        superposicion.getChildren().addAll(contenedorTexto, imagenHamburguesa);
        StackPane.setAlignment(imagenHamburguesa, Pos.CENTER);
        
        //Botones
        Button btnIniciarSesion = new Button("INICIAR SESIÓN");
        btnIniciarSesion.getStyleClass().add("boton-accion");
        btnIniciarSesion.setOnAction(e -> mostrarMensaje("Iniciar Sesión", "Aun no lo hago"));

        Button btnRegistrarse = new Button("REGISTRARSE");
        btnRegistrarse.getStyleClass().add("boton-accion");
        btnRegistrarse.setOnAction(e -> mostrarMensaje("Registro", "Tampoco lo he hecho"));

        HBox contenedorBotones = new HBox(40, btnIniciarSesion, btnRegistrarse);
        contenedorBotones.setAlignment(Pos.CENTER);

        Label eslogan = new Label("ALGO MAS QUE UN ANTOJO");
        eslogan.getStyleClass().add("eslogan");


        // CONTENEDOR GENERAL
        VBox layoutPrincipal = new VBox(20, superposicion, contenedorBotones, eslogan);
        layoutPrincipal.setAlignment(Pos.CENTER);
        layoutPrincipal.getStyleClass().add("contenedor-principal");
        layoutPrincipal.setMaxSize(950, 600);

        StackPane raiz = new StackPane(layoutPrincipal);
        raiz.setStyle("-fx-background-color: #db561d;");

        
        Scene escena = new Scene(raiz, 1000, 650);
        escena.getStylesheets().add(
            App.class.getResource("/com/mycompany/restauranteapp/estilos.css").toExternalForm()
        );

        escenario.setTitle("Restaurante Antojados - Comidas Rapidas");
        escenario.setScene(escena);
        escenario.show();
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