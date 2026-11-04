/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class Restaurante 
{
    //Atributos de la clase 'Restaurante'
    private String nombre; 
    private Menu menu; 
    private List<Mesa> mesas; 
    private List<Pedido> pedidos; 
    private List<Cliente> clientes; 
    private List<Mesero> meseros; 
    private List<Reserva> reservas; 
    private GestionDescuento gestionDescuentos; 
    private String rutaLogo; 
    
}
