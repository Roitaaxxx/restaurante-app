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
public class Recomendacion implements Serializable 
{
    //Método (RECOMENDAR PRODUCTO)
    public Producto recomendarProducto(Encuesta encuesta, Menu menu) {
        if (encuesta == null || menu == null) {
            return null;
        }
        
        Categoria categoria = menu.buscarCategoria(encuesta.getTipoProducto());
        if (categoria != null) {
            for (Producto p : categoria.consultarProductosDisponibles()) {
                if (p.getPrecio() >= encuesta.getPrecioMinimo() &&
                    p.getPrecio() <= encuesta.getPrecioMaximo()) {
                    return p;
                }
            }
        }
        
        for (Categoria c : menu.consultarCategorias()) {
            for (Producto p : c.consultarProductosDisponibles()) {
                if (p.getPrecio() >= encuesta.getPrecioMinimo() &&
                    p.getPrecio() <= encuesta.getPrecioMaximo()) {
                    return p;
                }
            }
        }

        return null;
    }
}
