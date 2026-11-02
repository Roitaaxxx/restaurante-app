/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

/**
 *
 * @author user LaMar
 */
public class Mesa {
    private int codigo;
    private int capacidad;
    private EstadoMesa estado;

    public Mesa() { //Constructor vacío o por defecto (para instanciar en el respectivo caso)
    }

    public Mesa(int codigo, int capacidad, EstadoMesa estado) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }
    
   
    
}
