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
public class PedidoMesa extends Pedido implements Serializable
{
    //Atributos
    private Mesa mesa;
    private double propina;
    private Mesero mesero;
    
    //Constructor
    public PedidoMesa(int codigo, EstadoPedido estado, Mesa mesa, Mesero mesero) 
    {
        super(codigo, estado);
        this.mesa = mesa;
        this.mesero = mesero;
        this.propina = 0.0;
    }
    
    //Método #1 (SELECCIONAR PROPINA)
    public void seleccionarPropina(double porcentaje) 
    {
        this.propina = calcularSubtotal() * (porcentaje / 100.0);
    }
    
    //Método #2 (ESTABLECER PROPINA)
    public void establecerPropina(double valor) 
    {
        if (valor >= 0) {
            this.propina = valor;
        }
    }
    
    //Método #3 (QUITAR PROPINA)
    public void quitarPropina() 
    {
        this.propina = 0.0;
    }
    
    //Método Abstracto 
    @Override
    public double calcularTotal(GestionDescuento gestion) 
    {
        double subtotal = calcularSubtotal();
        double descuento = (gestion != null) ? calcularDescuento(gestion) : 0.0;
        double baseImponible = subtotal - descuento;
        double iva = baseImponible * IMPUESTO_IVA;
        return baseImponible + iva + propina;
    }
    
    //Getters and Setters
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getPropina() {
        return propina;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }
}
