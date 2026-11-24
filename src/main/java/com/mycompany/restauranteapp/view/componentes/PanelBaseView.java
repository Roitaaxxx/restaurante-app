/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.restauranteapp.view.componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PanelBaseView extends BorderPane {

    private final String nombreRol;
    private final VBox contenido;

    public PanelBaseView(String nombreRol, String nombreUsuario, String... opciones) {

        this.nombreRol = nombreRol;

        getStyleClass().add("panel-principal");

        // Menú lateral fijo
        MenuLateral menu = new MenuLateral(
            nombreRol,
            this::mostrarSeccion,
            opciones
        );

        setLeft(menu);

        // Barra superior
        Label usuario = new Label(nombreUsuario);
        usuario.getStyleClass().add("nombre-usuario");

        Label rol = new Label(nombreRol);
        rol.getStyleClass().add("rol-usuario");

        VBox datosUsuario = new VBox(3, usuario, rol);
        datosUsuario.setAlignment(Pos.CENTER_RIGHT);

        Label inicial = new Label(
            nombreUsuario.isEmpty()
                ? "?"
                : nombreUsuario.substring(0, 1).toUpperCase()
        );

        inicial.getStyleClass().add("avatar-usuario");

        HBox barraSuperior = new HBox(12, datosUsuario, inicial);
        barraSuperior.setAlignment(Pos.CENTER_RIGHT);
        barraSuperior.setPadding(new Insets(15, 30, 15, 30));
        barraSuperior.getStyleClass().add("barra-superior");

        setTop(barraSuperior);

        // Contenido central
        contenido = new VBox(20);
        contenido.setPadding(new Insets(30));
        contenido.getStyleClass().add("contenido-central");

        setCenter(contenido);

        // Mostrar la primera sección
        if (opciones.length > 0) {
            mostrarSeccion(opciones[0]);
        }
    }

    private void mostrarSeccion(String seccion) {

        contenido.getChildren().clear();

        Label titulo = new Label(seccion);
        titulo.getStyleClass().add("titulo-seccion");

        Label descripcion = new Label(
            "Bienvenido al módulo de " + seccion.toLowerCase() + "."
        );
        descripcion.getStyleClass().add("descripcion-seccion");

        contenido.getChildren().addAll(titulo, descripcion);

        if (seccion.equals("Inicio") || seccion.equals("Resumen")) {
            mostrarResumen();
        } else {
            mostrarContenidoTemporal(seccion);
        }
    }

    private void mostrarResumen() {

        HBox tarjetas = new HBox(15);

        String[] titulos = obtenerTitulosTarjetas();

        for (String texto : titulos) {

            VBox tarjeta = new VBox(12);

            Label nombre = new Label(texto);
            nombre.getStyleClass().add("titulo-tarjeta");

            Label valor = new Label("--");
            valor.getStyleClass().add("valor-tarjeta");

            Label detalle = new Label("Información pendiente");
            detalle.getStyleClass().add("detalle-tarjeta");

            tarjeta.getChildren().addAll(nombre, valor, detalle);
            tarjeta.getStyleClass().add("tarjeta-resumen");

            HBox.setHgrow(tarjeta, Priority.ALWAYS);
            tarjetas.getChildren().add(tarjeta);
        }

        VBox actividad = new VBox(12);

        Label tituloActividad = new Label("Actividad reciente");
        tituloActividad.getStyleClass().add("titulo-tarjeta");

        Label mensaje = new Label(
            "Aquí aparecerán los movimientos del restaurante."
        );
        mensaje.getStyleClass().add("descripcion-seccion");

        actividad.getChildren().addAll(tituloActividad, mensaje);
        actividad.getStyleClass().add("tarjeta-resumen");

        contenido.getChildren().addAll(tarjetas, actividad);
    }

    private String[] obtenerTitulosTarjetas() {

        switch (nombreRol) {

            case "Administrador":
                return new String[]{
                    "Pedidos del día",
                    "Productos",
                    "Mesas"
                };

            case "Mesero":
                return new String[]{
                    "Mis pedidos",
                    "Mesas asignadas",
                    "Propinas"
                };

            default:
                return new String[]{
                    "Mis pedidos",
                    "Productos disponibles",
                    "Mis domicilios"
                };
        }
    }

    private void mostrarContenidoTemporal(String seccion) {

        VBox tarjeta = new VBox(12);

        Label titulo = new Label("Módulo de " + seccion);
        titulo.getStyleClass().add("titulo-tarjeta");

        Label mensaje = new Label(
            "Esta sección está preparada para desarrollar sus funcionalidades."
        );
        mensaje.getStyleClass().add("descripcion-seccion");

        tarjeta.getChildren().addAll(titulo, mensaje);
        tarjeta.getStyleClass().add("tarjeta-resumen");

        contenido.getChildren().add(tarjeta);
    }
}

