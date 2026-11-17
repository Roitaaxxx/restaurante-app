
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import com.mycompany.restauranteapp.view.administrador.PanelAdministradorView;

public class App extends Application {

    @Override
    public void start(Stage escenario) {

        PanelAdministradorView panel = new PanelAdministradorView();

        Scene escena = new Scene(panel, 1200, 750);

        escena.getStylesheets().add(
            App.class.getResource(
                "/com/mycompany/restauranteapp/estilos.css"
            ).toExternalForm()
        );

        escenario.setTitle("Antojados - Panel de administración");
        escenario.setScene(escena);
        escenario.show();
    }

    // ========================================
    // PANTALLA DE BIENVENIDA
    // ========================================

    private void mostrarPortada(Stage escenario) {

        // Capa de texto: ANTOJADOS
        Label textoBack1 = new Label("ANTOJADOS");
        textoBack1.getStyleClass().add("titulo-fondo");

        Label textoBack2 = new Label("ANTOJADOS");
        textoBack2.getStyleClass().add("titulo-fondo");

        Label textoBack3 = new Label("ANTOJADOS");
        textoBack3.getStyleClass().add("titulo-fondo");

        VBox contenedorTexto = new VBox(
            -35,
            textoBack1,
            textoBack2,
            textoBack3
        );

        contenedorTexto.setAlignment(Pos.CENTER);

        // Capa de imagen: hamburguesa
        ImageView imagenHamburguesa = new ImageView();

        try {
            var stream = App.class.getResourceAsStream(
                "/com/mycompany/restauranteapp/burger.png"
            );

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

        superposicion.setPadding(
            new Insets(0, 0, 30, 0)
        );

        superposicion.getChildren().addAll(
            contenedorTexto,
            imagenHamburguesa
        );

        StackPane.setAlignment(
            imagenHamburguesa,
            Pos.CENTER
        );

        // Botón iniciar sesión
        Button btnIniciarSesion = new Button("INICIAR SESIÓN");
        btnIniciarSesion.getStyleClass().add("boton-accion");

        btnIniciarSesion.setOnAction(e ->
            mostrarInicioSesion(escenario)
        );

        // Botón registrarse
        Button btnRegistrarse = new Button("REGISTRARSE");
        btnRegistrarse.getStyleClass().add("boton-accion");

        btnRegistrarse.setOnAction(e ->
            mostrarMensaje(
                "Registro",
                "Próximamente podrás registrarte."
            )
        );

        HBox contenedorBotones = new HBox(
            40,
            btnIniciarSesion,
            btnRegistrarse
        );

        contenedorBotones.setAlignment(Pos.CENTER);

        // Eslogan
        Label eslogan = new Label("ALGO MÁS QUE UN ANTOJO");
        eslogan.getStyleClass().add("eslogan");

        // Contenedor general
        VBox layoutPrincipal = new VBox(
            20,
            superposicion,
            contenedorBotones,
            eslogan
        );

        layoutPrincipal.setAlignment(Pos.CENTER);
        layoutPrincipal.getStyleClass().add("contenedor-principal");
        layoutPrincipal.setMaxSize(950, 600);

        StackPane raiz = new StackPane(layoutPrincipal);
        raiz.setStyle("-fx-background-color: #db561d;");

        Scene escena = new Scene(raiz, 1000, 650);

        cargarEstilos(escena);

        escenario.setTitle("Antojados - Comidas Rápidas");
        escenario.setScene(escena);
        escenario.show();
    }

    // ========================================
    // PANTALLA DE INICIO DE SESIÓN
    // ========================================

    private void mostrarInicioSesion(Stage escenario) {

        // --------------------------------
        // TÍTULO Y SUBTÍTULO
        // --------------------------------

        Label titulo = new Label("¡Bienvenido!");
        titulo.getStyleClass().add("titulo-login");

        Label subtitulo = new Label("Inicia sesión para continuar");
        subtitulo.getStyleClass().add("subtitulo-login");

        VBox encabezado = new VBox(
            8,
            titulo,
            subtitulo
        );

        encabezado.setAlignment(Pos.CENTER);
        encabezado.setMaxWidth(Double.MAX_VALUE);

        // --------------------------------
        // CAMPO DE CORREO
        // --------------------------------

        Label etiquetaCorreo = new Label("Correo electrónico");
        etiquetaCorreo.getStyleClass().add("etiqueta-campo");

        TextField campoCorreo = new TextField();
        campoCorreo.setPromptText("Ingresa tu correo electrónico");
        campoCorreo.getStyleClass().add("campo-login");

        // --------------------------------
        // CAMPO DE CONTRASEÑA
        // --------------------------------

        Label etiquetaContrasena = new Label("Contraseña");
        etiquetaContrasena.getStyleClass().add("etiqueta-campo");

        PasswordField campoContrasena = new PasswordField();
        campoContrasena.setPromptText("Ingresa tu contraseña");
        campoContrasena.getStyleClass().add("campo-login");

        // --------------------------------
        // BOTÓN INICIAR SESIÓN
        // --------------------------------

        Button btnIngresar = new Button("INICIAR SESIÓN");
        btnIngresar.getStyleClass().add("boton-login");

        btnIngresar.setMaxWidth(Double.MAX_VALUE);

        btnIngresar.setOnAction(e ->
            mostrarMensaje(
                "Inicio de sesión",
                "Aún no he implementado el acceso."
            )
        );

        // --------------------------------
        // REGISTRO
        // --------------------------------

        Label textoRegistro = new Label("¿No tienes una cuenta?");
        textoRegistro.getStyleClass().add("texto-registro");

        Button btnRegistro = new Button("Regístrate aquí");
        btnRegistro.getStyleClass().add("boton-enlace");

        btnRegistro.setOnAction(e ->
            mostrarMensaje(
                "Registro",
                "Aún no he implementado el registro."
            )
        );

        HBox contenedorRegistro = new HBox(
            5,
            textoRegistro,
            btnRegistro
        );

        contenedorRegistro.setAlignment(Pos.CENTER);

        // --------------------------------
        // BOTÓN VOLVER
        // --------------------------------

        Button btnVolver = new Button("← Volver");
        btnVolver.getStyleClass().add("boton-volver");

        btnVolver.setOnAction(e ->
            mostrarPortada(escenario)
        );

        // --------------------------------
        // FORMULARIO COMPLETO
        // --------------------------------

        VBox formulario = new VBox(
            18,
            btnVolver,
            encabezado,
            etiquetaCorreo,
            campoCorreo,
            etiquetaContrasena,
            campoContrasena,
            btnIngresar,
            contenedorRegistro
        );

        formulario.setAlignment(Pos.TOP_LEFT);
        formulario.setPadding(
            new Insets(22, 50, 30, 50)
        );

        formulario.getStyleClass().add("panel-formulario");

        formulario.setMinWidth(0);
        formulario.setMaxWidth(Double.MAX_VALUE);

        // --------------------------------
        // CARGAR IMAGEN DE COMIDAS RÁPIDAS
        // --------------------------------

        ImageView imagen = new ImageView();

        try {

            var stream = App.class.getResourceAsStream(
                "/com/mycompany/restauranteapp/comida-rapida.png"
            );

            // Utilizar la hamburguesa si no existe
            // la nueva fotografía.
            if (stream == null) {

                stream = App.class.getResourceAsStream(
                    "/com/mycompany/restauranteapp/burger.png"
                );
            }

            if (stream != null) {
                imagen.setImage(new Image(stream));
            } else {
                System.out.println("No se encontró ninguna imagen.");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        imagen.setPreserveRatio(false);

        // --------------------------------
        // DEGRADADO INFERIOR
        // --------------------------------

        Region degradado = new Region();

        degradado.getStyleClass().add("degradado-imagen");

        degradado.setPrefHeight(240);
        degradado.setMaxHeight(240);

        degradado.setMaxWidth(Double.MAX_VALUE);

        // --------------------------------
        // MARCA Y ESLOGAN
        // --------------------------------

        Label marca = new Label("ANTOJADOS");
        marca.getStyleClass().add("marca-login");

        Label frase = new Label("ALGO MÁS QUE UN ANTOJO");
        frase.getStyleClass().add("frase-login");

        VBox contenidoMarca = new VBox(
            8,
            marca,
            frase
        );

        contenidoMarca.setAlignment(Pos.CENTER);

        contenidoMarca.setPadding(
            new Insets(20, 10, 45, 10)
        );

        // --------------------------------
        // PANEL DE IMAGEN
        // --------------------------------

        StackPane panelImagen = new StackPane(
            imagen,
            degradado,
            contenidoMarca
        );

        panelImagen.getStyleClass().add("panel-imagen");

        panelImagen.setMinWidth(0);
        panelImagen.setMaxWidth(Double.MAX_VALUE);

        // Ajustar la fotografía al panel
        imagen.fitWidthProperty().bind(
            panelImagen.widthProperty()
        );

        imagen.fitHeightProperty().bind(
            panelImagen.heightProperty()
        );

        // Colocar el degradado y la marca abajo
        StackPane.setAlignment(
            degradado,
            Pos.BOTTOM_CENTER
        );

        StackPane.setAlignment(
            contenidoMarca,
            Pos.BOTTOM_CENTER
        );

        // --------------------------------
        // UNIR LOS DOS PANELES
        // --------------------------------

        HBox pantalla = new HBox(
            formulario,
            panelImagen
        );

        pantalla.getStyleClass().add("pantalla-login");

        // Permitir que los paneles se ajusten
        HBox.setHgrow(formulario, Priority.ALWAYS);
        HBox.setHgrow(panelImagen, Priority.ALWAYS);

        // Distribución proporcional del espacio
        formulario.prefWidthProperty().bind(
            pantalla.widthProperty().multiply(0.46)
        );

        panelImagen.prefWidthProperty().bind(
            pantalla.widthProperty().multiply(0.54)
        );

        // --------------------------------
        // CREAR ESCENA
        // --------------------------------

        Scene escena = new Scene(pantalla, 1000, 650);

        cargarEstilos(escena);

        escenario.setTitle("Iniciar sesión - Antojados");
        escenario.setScene(escena);
        escenario.show();
    }

    // ========================================
    // CARGAR ARCHIVO CSS
    // ========================================

    private void cargarEstilos(Scene escena) {

        escena.getStylesheets().add(
            App.class.getResource(
                "/com/mycompany/restauranteapp/estilos.css"
            ).toExternalForm()
        );
    }

    // ========================================
    // MOSTRAR MENSAJES
    // ========================================

    private void mostrarMensaje(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    // ========================================
    // MÉTODO PRINCIPAL
    // ========================================

    public static void main(String[] args) {
        launch(args);
    }
}
