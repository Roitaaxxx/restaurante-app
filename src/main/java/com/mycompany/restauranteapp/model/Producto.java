package com.mycompany.restauranteapp.model;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;
    private int id;
    private String rutaImagen;
    
    //constructor por defecto
    public Producto(){
        
    }
    
    public Producto(String nombre, String descripcion, double precio, boolean disponible, int id, String rutaImagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
        this.id = id;
        this.rutaImagen = rutaImagen;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public boolean isDisponible(){
        return disponible;
    }
    
    public int getId(){
        return id;
    }
    
    public String getRutaImagen(){
        return rutaImagen;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPrecio(double precio){
        if(precio > 0){
            this.precio = precio;
        }
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void marcarDisponible(){
        disponible = true;
    }
    
    public void marcarNoDisponible(){
        disponible = false;
    }
    
    public void modificarPrecio(double nuevoPrecio){
        if(nuevoPrecio > 0){
            precio = nuevoPrecio;
        }
    }
    
    public void modificarDescripcion(String nuevaDescripcion){
        descripcion = nuevaDescripcion;
    }
    
    @Override
    public String toString(){
        return "Producto: "+ nombre + "\nId: "+ id + "\nDescripcion: " + descripcion + "\nPrecio: " + precio + "\nDisponible: " + disponible;
    }
}