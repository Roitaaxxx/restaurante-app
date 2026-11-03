/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

/**
 *
 * @author LaMar
 */
public class Localidad {
    private String nombre;
    private double valorDomicilio;

    public Localidad() { //Constructor vacío/por defecto en caso de potencial posterior cargar de datos mas tarde
    }

    public Localidad(String nombre, double valorDomicilio) {
        this.nombre = nombre;
        this.valorDomicilio = valorDomicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorDomicilio() {
        return valorDomicilio;
    }

    public void setValorDomicilio(double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }
    
    
    public void modificarValor(double nuevoValor){ //El administrador actualiza el precio del domicilio en esa zona x
        valorDomicilio = nuevoValor; // nuevoValor es lo que mete el administrador y se guarda en localidad despues
    }
    
    
    @Override
    public String toString(){
        return "Nombre de zona/localidad"+ nombre +"\nValor del domicilio"+ valorDomicilio +"$";
    }
    
}
