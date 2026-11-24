/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class Encuesta implements Serializable
{
    //Atributos
    private String preferencia;
    private String tipoProducto;
    private double precioMinimo;
    private double precioMaximo;
    
    //Constructor 
    public Encuesta(String preferencia, String tipoProducto, double precioMinimo, double precioMaximo) 
    {
        this.preferencia = preferencia;
        this.tipoProducto = tipoProducto;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }
    
    //Método (REGISTRAR PREFERENCIA)
    public void registrarPreferencia(String preferencia) 
    {
        this.preferencia = preferencia;
    }
    
    //Getters and Setters
    public String getPreferencia() {
        return preferencia;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }
    
    //Método (TO STRING)
    @Override
    public String toString() 
    {
        return "Encuesta \nPreferencia: " + preferencia +
               "\nTipo de producto: " + tipoProducto +
               "\nPrecio minimo: $" + precioMinimo +
               "\nPrecio maximo: $" + precioMaximo;
    }
}
