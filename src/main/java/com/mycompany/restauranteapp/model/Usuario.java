/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

/**
 *
 * @author roita
 */
public class Usuario {
    private int id;
    private String correo;
    private String contrasenaHash;
    private Rol rol;
    private boolean activo;
    
    //constructor por defecto
    public Usuario(){
        
    }
    
    //contructor con parametros
    public Usuario(int id, String correo, String contrasenaHash, Rol rol, boolean activo){
        this.id = id;
        this.correo = correo;
        this.contrasenaHash = contrasenaHash;
        this.rol = rol;
        this.activo = activo;
    }
    
    public int getId(){
        return id;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public String getContrasenaHash(){
        return contrasenaHash;
    }
    
    public Rol getRol(){
        return rol;
    }
    
    public boolean isActivo(){
        return activo;
    }
    
    public void cambiarContrasena(String nuevaContrasena){
        this.contrasenaHash = nuevaContrasena;
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
