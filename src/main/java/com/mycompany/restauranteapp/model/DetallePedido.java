/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.io.Serializable; 

/**
 *
 * @author roita
 */
public class DetallePedido implements Serializable {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    
    //constructor por defecto
    public DetallePedido(){
        
    }
    
    //constructor con parametros
    public DetallePedido(Producto producto, int cantidad, double precioUnitario){
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    
    public void setProducto(Producto producto){
        if(producto == null){
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        this.producto = producto;
    }

    public void setCantidad(int cantidad){
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario){
        if(precioUnitario < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precioUnitario = precioUnitario;
    }
    
    public double calcularSubtotal(){
        return cantidad * precioUnitario;
    }
}
