/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable; 
import java.util.UUID;
/**
 *
 * @author johan
 */
public class Reserva implements Serializable
{
    
   //Atributos
   private String idReserva; 
   private LocalDate fecha; 
   private LocalTime hora; 
   private int numPersonas; 
   
   //Constructor 
   public Reserva (LocalDate fecha, LocalTime hora, int numPersonas)
   {
       this.idReserva = "RVA-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
       this.fecha = fecha;
       this.hora = hora; 
       this.numPersonas = numPersonas; 
   }
   
   //Método #1 (DETALLES RESERVA)
   public String detallesReserva() 
   {
        return "Reserva \nID de reserva: " + idReserva +
               "\nFecha: " + fecha +
               "\nHora: " + hora +
               "\nNumero de personas: " + numPersonas;
    }
   
   //Método #2 (CANCE3LAR RESRVA)
   public void cancelarReserva() 
   {
        if (!this.idReserva.endsWith(" - CANCELADA")) {
            this.idReserva += " - CANCELADA";
        }
    }
   
    //Getters and setters
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
