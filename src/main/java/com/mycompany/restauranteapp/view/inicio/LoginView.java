
package com.mycompany.restauranteapp.view.inicio;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginView extends StackPane {

    public LoginView(Runnable accionRegistro, Runnable accionVolver) {

        // =====================================
        // IMAGEN DE FONDO
        // =====================================

        Image imagen = new Image(
            getClass().getResourceAsStream(
                "/com/mycompany/restauranteapp/images/hamburguesa-principal.png"
            )
        );

        ImageView fondo = new ImageView(imagen);
        fondo.setPreserveRatio(false);
        fondo.fitWidthProperty().bind(widthProperty());
        fondo.fitHeightProperty().bind(heightProperty());

        // Capa para oscurecer ligeramente el fondo
        Region capaOscura = new Region();
        capaOscura.getStyleClass().add("capa-login");

        // =====================================
        // ENCABEZADO DEL FORMULARIO
        // =====================================

        Label bienvenida = new Label("BIENVENIDO DE NUEVO");
        bienvenida.getStyleClass().add("bienvenida-login");

        Label titulo = new Label("INICIAR SESIÓN");
        titulo.getStyleClass().add("titulo-login");

        VBox encabezado = new VBox(8, bienvenida, titulo);
        encabezado.setAlignment(Pos.CENTER_LEFT);

        // =====================================
        // CAMPO CORREO
        // =====================================

        Label textoCorreo = new Label("Correo electrónico");
        textoCorreo.getStyleClass().add("etiqueta-campo");

        TextField campoCorreo = new TextField();
        campoCorreo.setPromptText("admin@antojados.com");
        campoCorreo.getStyleClass().add("campo-autenticacion");

        // =====================================
        // CAMPO CONTRASEÑA
        // =====================================

        Label textoContrasena = new Label("Contraseña");
        textoContrasena.getStyleClass().add("etiqueta-campo");

        PasswordField campoContrasena = new PasswordField();
        campoContrasena.setPromptText("Ingresa tu contraseña");
        campoContrasena.getStyleClass().add("campo-autenticacion");

        // =====================================
        // RECORDARME Y RECUPERAR CONTRASEÑA
        // =====================================

        CheckBox recordar = new CheckBox("Recordarme");
        recordar.getStyleClass().add("recordar-login");

        Button olvidar = new Button("¿Olvidaste tu clave?");
        olvidar.getStyleClass().add("boton-enlace");

        HBox opciones = new HBox(recordar, olvidar);
        opciones.setAlignment(Pos.CENTER_LEFT);
        opciones.setSpacing(10);
        HBox.setHgrow(olvidar, javafx.scene.layout.Priority.ALWAYS);
        olvidar.setAlignment(Pos.CENTER_RIGHT);

        // =====================================
        // BOTÓN INICIAR SESIÓN
        // =====================================

        Button botonLogin = new Button("INICIAR SESIÓN  →");
        botonLogin.getStyleClass().add("boton-principal");
        botonLogin.setMaxWidth(Double.MAX_VALUE);

        // =====================================
        // SEPARADOR
        // =====================================

        Region lineaIzquierda = new Region();
        lineaIzquierda.getStyleClass().add("linea-separador");

        Label textoO = new Label("O");
        textoO.getStyleClass().add("texto-separador");

        Region lineaDerecha = new Region();
        lineaDerecha.getStyleClass().add("linea-separador");

        HBox separador = new HBox(
            12,
            lineaIzquierda,
            textoO,
            lineaDerecha
        );

        separador.setAlignment(Pos.CENTER);
        HBox.setHgrow(lineaIzquierda, javafx.scene.layout.Priority.ALWAYS);
        HBox.setHgrow(lineaDerecha, javafx.scene.layout.Priority.ALWAYS);

        // =====================================
        // BOTÓN CREAR CUENTA
        // =====================================

        Button botonRegistro = new Button("CREAR CUENTA  →");
        botonRegistro.getStyleClass().add("boton-secundario");
        botonRegistro.setMaxWidth(Double.MAX_VALUE);
        botonRegistro.setOnAction(e -> accionRegistro.run());

        // =====================================
        // VOLVER A LA PORTADA
        // =====================================

        Button botonVolver = new Button("← Volver a la portada");
        botonVolver.getStyleClass().add("boton-enlace");
        botonVolver.setOnAction(e -> accionVolver.run());

        // =====================================
        // TARJETA DE AUTENTICACIÓN
        // =====================================

        VBox formulario = new VBox(
            13,
            encabezado,
            textoCorreo,
            campoCorreo,
            textoContrasena,
            campoContrasena,
            opciones,
            botonLogin,
            separador,
            botonRegistro,
            botonVolver
        );

        formulario.setAlignment(Pos.CENTER_LEFT);
        formulario.setMaxWidth(390);
        formulario.setPadding(new Insets(35));
        formulario.getStyleClass().add("panel-autenticacion");

        // =====================================
        // POSICIONAR TARJETA A LA DERECHA
        // =====================================

        StackPane.setAlignment(formulario, Pos.CENTER_RIGHT);

        StackPane.setMargin(
            formulario,
            new Insets(25, 55, 25, 25)
        );

        // =====================================
        // UNIR ELEMENTOS
        // =====================================

        getChildren().addAll(
            fondo,
            capaOscura,
            formulario
        );
    }
}
