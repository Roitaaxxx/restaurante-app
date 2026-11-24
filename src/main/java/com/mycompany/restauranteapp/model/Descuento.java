/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.time.DayOfWeek;
import java.io.Serializable; 

/**
 *
 * @author roita
 */
public class Descuento implements Serializable {
    private int id;
    private String nombre;
    private double porcentaje;
    private DayOfWeek dia;
    private Categoria categoria;
    private boolean activo;
    
    public Descuento(){
        
    }
    
    public Descuento(int id, String nombre, double porcentaje, DayOfWeek dia, Categoria categoria, boolean activo){
        this.id =id;
        this.porcentaje = porcentaje;
        this.nombre = nombre;
        this.categoria = categoria;
        this.activo = activo;
        this.dia = dia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public double aplicarDescuento(double valor){
        if(valor < 0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }

        return valor - (valor * porcentaje / 100);
    }
    
    public void activar(){
        activo = true;
    }
    
    public void desactivar(){
        activo = false;
    }
    
    public void modificarPorcentaje(double nuevoPorcentaje){
        if(nuevoPorcentaje < 0 || nuevoPorcentaje > 100){
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100");
        }

        porcentaje = nuevoPorcentaje;
    }
    
    
    public void modificarDia(DayOfWeek nuevoDia){
        if(nuevoDia == null){
            throw new IllegalArgumentException("El dia no puede ser nulo");
        }

        dia = nuevoDia;
    }
}
