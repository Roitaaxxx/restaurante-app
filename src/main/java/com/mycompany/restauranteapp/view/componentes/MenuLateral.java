/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.restauranteapp.view.componentes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuLateral extends VBox {

    private final List<Button> botones;
    private final Consumer<String> accionSeleccion;

    public MenuLateral(String rol, Consumer<String> accionSeleccion, String... opciones) {

        this.accionSeleccion = accionSeleccion;
        botones = new ArrayList<>();

        setPrefWidth(245);
        setPadding(new Insets(25, 15, 20, 15));
        setSpacing(12);
        getStyleClass().add("menu-lateral");

        // Nombre del restaurante
        Label marca = new Label("ANTOJADOS");
        marca.getStyleClass().add("marca-menu");

        Label subtitulo = new Label("SISTEMA DE GESTIÓN");
        subtitulo.getStyleClass().add("subtitulo-menu");

        VBox encabezado = new VBox(4, marca, subtitulo);
        encabezado.setPadding(new Insets(5, 5, 25, 5));

        Label tituloMenu = new Label("MENÚ PRINCIPAL");
        tituloMenu.getStyleClass().add("titulo-menu");

        getChildren().addAll(encabezado, tituloMenu);

        // Crear botones de navegación
        for (int i = 0; i < opciones.length; i++) {

            String opcion = opciones[i];

            Button boton = new Button(opcion);
            boton.getStyleClass().add("opcion-menu");
            boton.setMaxWidth(Double.MAX_VALUE);
            boton.setAlignment(Pos.CENTER_LEFT);

            botones.add(boton);
            getChildren().add(boton);

            final int posicion = i;

            boton.setOnAction(e -> {
                seleccionarBoton(posicion);
                this.accionSeleccion.accept(opcion);
            });
        }

        // Seleccionar la primera opción
        if (!botones.isEmpty()) {
            seleccionarBoton(0);
        }

        VBox espacio = new VBox();
        VBox.setVgrow(espacio, javafx.scene.layout.Priority.ALWAYS);
        getChildren().add(espacio);

        Label etiquetaRol = new Label("Sesión: " + rol);
        etiquetaRol.getStyleClass().add("rol-menu");

        getChildren().add(etiquetaRol);
    }

    private void seleccionarBoton(int seleccionado) {

        for (int i = 0; i < botones.size(); i++) {

            Button boton = botones.get(i);

            boton.getStyleClass().remove("opcion-seleccionada");

            if (i == seleccionado) {
                boton.getStyleClass().add("opcion-seleccionada");
            }
        }
    }
}

