
package com.mycompany.restauranteapp.view.inicio;

import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PortadaView extends StackPane {

    public PortadaView(Runnable accionLogin, Runnable accionRegistro) {

        // Fondo fotografico de toda la portada
        crearFondo();

        // Contenido principal
        VBox contenido = new VBox(25);
        contenido.getStyleClass().add("contenido-portada");
        contenido.setPadding(new Insets(25, 45, 25, 45));

        // Secciones de la portada
        HBox encabezado = crearEncabezado();

        HBox seccionPrincipal = crearSeccionPrincipal(
            accionLogin,
            accionRegistro
        );

        VBox galeria = crearGaleria();

        contenido.getChildren().addAll(
            encabezado,
            seccionPrincipal,
            galeria
        );

        // El contenido ocupa toda la ventana
        contenido.setMaxSize(
            Double.MAX_VALUE,
            Double.MAX_VALUE
        );

        getChildren().add(contenido);
    }

    // =========================================
    // FONDO PRINCIPAL
    // =========================================

    private void crearFondo() {

        URL recurso = getClass().getResource(
            "/com/mycompany/restauranteapp/images/antojados-fondo-portada.png"
        );

        if (recurso != null) {

            Image imagen = new Image(recurso.toExternalForm());

            ImageView fondo = new ImageView(imagen);

            fondo.fitWidthProperty().bind(widthProperty());
            fondo.fitHeightProperty().bind(heightProperty());

            fondo.setPreserveRatio(false);
            fondo.setSmooth(true);

            getChildren().add(fondo);

        } else {

            setStyle("-fx-background-color: #651A19;");
        }

        // Capa oscura para integrar la imagen
        Region capaOscura = new Region();
        capaOscura.getStyleClass().add("capa-fondo");

        getChildren().add(capaOscura);
    }

    // =========================================
    // ENCABEZADO
    // =========================================

    private HBox crearEncabezado() {

        // Logotipo
        StackPane logo = new StackPane();

        URL recursoLogo = getClass().getResource(
            "/com/mycompany/restauranteapp/images/logo-antojados.png"
        );

        if (recursoLogo != null) {

            Image imagenLogo = new Image(
                recursoLogo.toExternalForm()
            );

            ImageView vistaLogo = new ImageView(imagenLogo);

            vistaLogo.setFitWidth(65);
            vistaLogo.setFitHeight(55);
            vistaLogo.setPreserveRatio(true);

            logo.getChildren().add(vistaLogo);

        } else {

            Label provisional = new Label("🍔");
            logo.getChildren().add(provisional);
        }

        // Nombre de la marca
        Label nombre = new Label("ANTOJADOS");
        nombre.getStyleClass().add("nombre-logo");

        Label categoria = new Label("RESTAURANTE COMIDAS RAPIDAS");
        categoria.getStyleClass().add("categoria-logo");

        VBox marca = new VBox(2, nombre, categoria);
        marca.setAlignment(Pos.CENTER_LEFT);

        HBox identidad = new HBox(12, logo, marca);
        identidad.setAlignment(Pos.CENTER_LEFT);

        // Navegación
        Label inicio = new Label("Inicio");
        inicio.getStyleClass().addAll(
            "opcion-menu",
            "opcion-activa"
        );

        Label menu = new Label("Menú");
        menu.getStyleClass().add("opcion-menu");

        Label nosotros = new Label("Nosotros");
        nosotros.getStyleClass().add("opcion-menu");

        HBox navegacion = new HBox(
            30,
            inicio,
            menu,
            nosotros
        );

        navegacion.setAlignment(Pos.CENTER);

        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        HBox encabezado = new HBox(
            20,
            identidad,
            espacio,
            navegacion
        );

        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.getStyleClass().add("encabezado");

        return encabezado;
    }

    // =========================================
    // SECCION PRINCIPAL
    // =========================================

    private HBox crearSeccionPrincipal(
        Runnable accionLogin,
        Runnable accionRegistro
    ) {

        // Texto superior
        Label etiqueta = new Label("MÁS QUE UN ANTOJO");
        etiqueta.getStyleClass().add("etiqueta-principal");

        // Primera parte del titulo
        Label tituloUno = new Label("ANTOJATE QUE TE");
        tituloUno.getStyleClass().add("titulo-principal");

        // Segunda parte del titulo
        Label tituloDos = new Label("CONVIENE");
        tituloDos.getStyleClass().add("titulo-destacado");

        VBox titulo = new VBox(0, tituloUno, tituloDos);
        titulo.setAlignment(Pos.CENTER_LEFT);

        // Descripcion
        Label descripcion = new Label(
            "Hamburguesas, pizzas, perros calientes y mucho más.\n"
            + "Descubre sabores preparados para convertir cada\n"
            + "antojo en una experiencia inolvidable."
        );

        descripcion.getStyleClass().add("descripcion-principal");

        // Boton de inicio de sesion
        Button iniciarSesion = new Button(
            "INICIAR SESIÓN   →"
        );

        iniciarSesion.getStyleClass().add("boton-principal");
        iniciarSesion.setOnAction(e -> accionLogin.run());

        // Boton de registro
        Button registrarse = new Button(
            "REGISTRARSE   →"
        );

        registrarse.getStyleClass().add("boton-secundario");
        registrarse.setOnAction(e -> accionRegistro.run());

        HBox botones = new HBox(
            15,
            iniciarSesion,
            registrarse
        );

        botones.setAlignment(Pos.CENTER_LEFT);

        // Eslogan
        Label eslogan = new Label(
            "ALGO MÁS QUE UN ANTOJO"
        );

        eslogan.getStyleClass().add("eslogan-principal");

        // Contenedor de textos
        VBox textos = new VBox(
            17,
            etiqueta,
            titulo,
            descripcion,
            botones,
            eslogan
        );

        textos.setAlignment(Pos.CENTER_LEFT);
        textos.setMaxWidth(570);
        textos.setPrefWidth(570);

        // Espacio libre para dejar visible la hamburguesa
        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        HBox principal = new HBox(
            10,
            textos,
            espacio
        );

        principal.setAlignment(Pos.CENTER_LEFT);
        principal.setPrefHeight(390);
        principal.setMinHeight(350);
        principal.getStyleClass().add("seccion-principal");

        return principal;
    }

    // =========================================
    // GALERIA DE PRODUCTOS
    // =========================================

    private VBox crearGaleria() {

        Label tituloGaleria = new Label(
            "DESCUBRE NUESTROS ANTOJOS"
        );

        tituloGaleria.getStyleClass().add("titulo-galeria");

        HBox productos = new HBox(14);
        productos.setAlignment(Pos.CENTER_LEFT);

        productos.getChildren().addAll(

            crearTarjetaProducto(
                "/com/mycompany/restauranteapp/images/hamburguesa-1.png",
                "🍔",
                "Hamburguesas"
            ),

            crearTarjetaProducto(
                "/com/mycompany/restauranteapp/images/pizza.png",
                "🍕",
                "Pizzas"
            ),

            crearTarjetaProducto(
                "/com/mycompany/restauranteapp/images/perro-caliente.png",
                "🌭",
                "Perros calientes"
            ),

            crearTarjetaProducto(
                "/com/mycompany/restauranteapp/images/hamburguesa-2.png",
                "🍔",
                "Especiales"
            ),

            crearTarjetaProducto(
                "/com/mycompany/restauranteapp/images/papas.png",
                "🍟",
                "Acompañantes"
            )
        );

        VBox galeria = new VBox(
            12,
            tituloGaleria,
            productos
        );

        galeria.setAlignment(Pos.CENTER_LEFT);

        return galeria;
    }

    // =========================================
    // TARJETAS DE PRODUCTOS
    // =========================================

    private VBox crearTarjetaProducto(
        String ruta,
        String emoji,
        String nombre
    ) {

        StackPane imagen = crearImagen(
            ruta,
            125,
            82,
            emoji
        );

        imagen.getStyleClass().add("imagen-producto");

        Label texto = new Label(nombre);
        texto.getStyleClass().add("nombre-producto");

        VBox tarjeta = new VBox(
            8,
            imagen,
            texto
        );

        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.getStyleClass().add("tarjeta-producto");

        return tarjeta;
    }

    // =========================================
    // CARGA DE IMAGENES
    // =========================================

    private StackPane crearImagen(
        String ruta,
        double ancho,
        double alto,
        String emoji
    ) {

        StackPane contenedor = new StackPane();

        contenedor.setMinSize(ancho, alto);
        contenedor.setPrefSize(ancho, alto);

        URL recurso = getClass().getResource(ruta);

        if (recurso != null) {

            Image imagen = new Image(
                recurso.toExternalForm()
            );

            ImageView vista = new ImageView(imagen);

            vista.setFitWidth(ancho);
            vista.setFitHeight(alto);
            vista.setPreserveRatio(true);
            vista.setSmooth(true);

            contenedor.getChildren().add(vista);

        } else {

            Label icono = new Label(emoji);
            icono.getStyleClass().add("emoji-producto");

            contenedor.getChildren().add(icono);
        }

        return contenedor;
    }
}