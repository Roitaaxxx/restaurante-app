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
public class PedidoDomicilio extends Pedido implements Serializable 
{
    //Atributos
    private Cliente cliente;
    private Direccion direccion;
    
    //Constructor
    public PedidoDomicilio(int codigo, EstadoPedido estado, Cliente cliente, Direccion direccion) 
    {
        super(codigo, estado);
        this.cliente = cliente;
        this.direccion = direccion;
    }
    
    //Método #1 (CALCULAR COSTO DE DOMICILIO)
    public double calcularCostoDomicilio() {
        if (direccion != null && direccion.getLocalidad() != null) 
        {
            return direccion.getLocalidad().getValorDomicilio();
        }
        return 0.0;
    }
    
    //Método abstracto 
    @Override
    public double calcularTotal(GestionDescuento gestion) 
    {
        double subtotal = calcularSubtotal();
        double descuento = (gestion != null) ? calcularDescuento(gestion) : 0.0;
        double baseImponible = subtotal - descuento;
        double iva = baseImponible * IMPUESTO_IVA;
        return baseImponible + iva + calcularCostoDomicilio();
    }
    
    //Getters and Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
