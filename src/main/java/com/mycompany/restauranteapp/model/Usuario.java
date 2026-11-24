/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.io.Serializable; 

/**
 *
 * @author roita
 */
public class Usuario implements Serializable {
    private int id;
    private String correo;
    private String contrasena;
    private Rol rol;
    private boolean activo;
    
    //contructor con parametros
    public Usuario(int id, String correo, String contrasena, Rol rol, boolean activo){
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.activo = activo;
    }
    
    public int getId(){
        return id;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public Rol getRol(){
        return rol;
    }
    
    public boolean isActivo(){
        return activo;
    }
    
    public void cambiarContrasena(String nuevaContrasena){
        this.contrasena = nuevaContrasena;
    }
    
    public void activarCuenta(){
        activo = true;
    }
    
    public void desactivarCuenta(){
        activo = false;
    }
    
    public boolean verificarEstado(){
        return activo;
    }
}
