/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

/**
 *
 * @author johan
 */
public class Reserva 
{
    
   private String idReserva; 
   private LocalDate fecha; 
   private LocalTime hora; 
   private int numPersonas; 
   
   
   public Reserva (LocalDate fecha, LocalTime hora, int numPersonas)
   {
       this.fecha = fecha;
       this.hora = hora; 
       this.numPersonas = numPersonas; 
   }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
   

    
}
