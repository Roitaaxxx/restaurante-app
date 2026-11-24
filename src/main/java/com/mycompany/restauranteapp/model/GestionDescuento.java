/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.util.ArrayList;
import java.time.DayOfWeek;
import java.io.Serializable; 

/**
 *
 * @author roita
 */
public class GestionDescuento implements Serializable {
    private ArrayList<Descuento> descuentos;
    
    public GestionDescuento(){
        this.descuentos = new ArrayList<>();
    }
    
    public GestionDescuento(ArrayList<Descuento> descuentos){
        this.descuentos = new ArrayList<>();
        
        if(descuentos != null){
            this.descuentos.addAll(descuentos);
        }
    }
    
    public ArrayList<Descuento> getDescuentos(){
        return new ArrayList<>(descuentos);
    }
    
    public void setDescuentos(ArrayList<Descuento> descuentos) {
        if(descuentos == null){
            throw new IllegalArgumentException("La lista no puede ser nula");
        }

        this.descuentos = new ArrayList<>(descuentos);
    }
    
    public void agregarDescuento(Descuento descuento){
        if(descuento == null){
            throw new IllegalArgumentException("El descuento no puede ser nulo");
        }

        if(!validarDescuento(descuento.getDia(), descuento.getCategoria())){
            throw new IllegalArgumentException("Ya existe un descuento para ese dia y categoria");
        }

        this.descuentos.add(descuento);
    }
    
    public void eliminarDescuento(Descuento descuento){
        if(descuento != null){
            this.descuentos.remove(descuento);
        }
    }
    
    public Descuento buscarDescuento(DayOfWeek dia, Categoria categoria){
        for(Descuento descuento : descuentos){

            if(descuento.getDia() == dia &&
               descuento.getCategoria() == categoria &&
               descuento.isActivo()){

                return descuento;
            }
        }

        return null;
    }
    
    public ArrayList<Descuento> consultarDescuentos(){
        return new ArrayList<>(descuentos);
    }
    
    public boolean validarDescuento(DayOfWeek dia, Categoria categoria){
        if(dia == null || categoria == null){
            return false;
        }

        for(Descuento descuento : descuentos){

            if(descuento.getDia() == dia &&
               descuento.getCategoria() == categoria){

                return false;
            }
        }

        return true;
    }
}