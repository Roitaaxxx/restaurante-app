/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

/**
 *
 * @author LaMar
 */
public class Direccion {
    private int id;
    private String descripcion;
    private Localidad localidad;

    public Direccion() {
    }

    public Direccion(int id, String descripcion, Localidad localidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
    public void actualizarDescripcion(String nuevaDescripcion){
        descripcion = nuevaDescripcion;
    }
    
    
    @Override
    public String toString(){
        return "ID de direccion: "+ id + "\nDescripcion: "+ descripcion + "\nLocalidad: "+ localidad;
    }
    
}
