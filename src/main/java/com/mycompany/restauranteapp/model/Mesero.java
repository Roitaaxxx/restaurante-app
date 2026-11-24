/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.io.Serializable; 

/**
 *
 * @author LaMar
 */
public class Mesero implements Serializable {
    private int id;
    private String nombre;
    private double salario;
    private double propinas;
    private Usuario usuario;

    public Mesero() { //Constructor vacío/por defecto para posible necesaria carga de datos despues
    }

    public Mesero(int id, String nombre, double salario, Usuario usuario) { //Constructor con parametros
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.usuario = usuario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void agregarPropina(double valor){
        propinas += valor; //Se le agrega al valor de lo que gana, la propina
    }
    
    
    public void actualizarSalarario(double nuevoSalario){
        salario = nuevoSalario;
    }
    
    
    public double calcularSueldoTotal(){
        return salario + propinas;
    }
    
    
    @Override
    public String toString(){
        return "Mesero ID: "+ id + "\nNombre: "+ nombre + "\nSalario: "+ salario + "\nUsuario: "+ usuario;
    }
    
}
