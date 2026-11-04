/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author johan
 */

public class ArchivoPersistencia {

    // Atributo privado (- rutaDatos: String)
    private String rutaDatos;

    // Constructor por defecto
    public ArchivoPersistencia() {
        this.rutaDatos = "restaurante_datos.dat";
    }

    // Constructor personalizado
    public ArchivoPersistencia(String rutaDatos) {
        this.rutaDatos = rutaDatos;
    }

    // Método para guardar (+ guardarDatos(r: Restaurante): void)
    public void guardarDatos(Restaurante r) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaDatos))) {
            oos.writeObject(r);
            System.out.println("Datos guardados correctamente en: " + rutaDatos);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para cargar (+ cargarDatos(): Restaurante)
    public Restaurante cargarDatos() {
        if (!existeArchivo()) {
            System.out.println("El archivo no existe todavía.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaDatos))) {
            Restaurante restaurante = (Restaurante) ois.readObject();
            System.out.println("Datos cargados correctamente.");
            return restaurante;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método para verificar la existencia (+ existeArchivo(): boolean)
    public boolean existeArchivo() {
        File archivo = new File(rutaDatos);
        return archivo.exists() && !archivo.isDirectory();
    }
}

