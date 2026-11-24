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
public class Menu implements Serializable
{
    //Atributo
    private List<Categoria> categorias;
    
    //Constructor
    public Menu() 
    {
        this.categorias = new ArrayList<>();
    }
    
    //Método #1 (AGREGAR CATEGORÍA)
    public void agregarCategoria(Categoria categoria) 
    {
        if (categoria != null && !categorias.contains(categoria)) {
            categorias.add(categoria);
        }
    }
    
    //Método #2 (ELIMINAR CATEGORÍA)
    public void eliminarCategoria(Categoria categoria) 
    {
        categorias.remove(categoria);
    }
    
    //Método #3 (BUSCAR CATEGORÍA)
    public Categoria buscarCategoria(String nombre) 
    {
        if (nombre == null) {
            return null;
        }
        for (Categoria c : categorias) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
    
    //Método #4 (CONSULTAR CATEGORIAS)
    public List<Categoria> consultarCategorias()
    {
        return categorias; 
    }
    
}
