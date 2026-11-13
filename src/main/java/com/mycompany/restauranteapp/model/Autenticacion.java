/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.restauranteapp.model;

import java.util.ArrayList;

public class Autenticacion {

    private final ArrayList<Usuario> usuarios;

    public Autenticacion(){
        this.usuarios = new ArrayList<>();
    }

    public Usuario registrarCliente(String correo, String contrasenaHash){
        if(buscarUsuario(correo) != null){
            return null;
        }
        else{
            int id = usuarios.size() + 1;
            Usuario nuevoCliente = new Usuario(id,correo,contrasenaHash,Rol.CLIENTE,true);
            usuarios.add(nuevoCliente);
            return nuevoCliente;
        }
    }

    public Usuario validarCredenciales(String correo, String contrasena){

        Usuario usuario = buscarUsuario(correo);
        if(usuario == null){
            return null;
        }
        if(!usuario.isActivo()){
            return null;
        }
        
        if(usuario.getContrasenaHash().equals(contrasena)){
            return usuario;
        }
        return null;
    }

    public Usuario buscarUsuario(String correo){
        if(correo == null || correo.isEmpty()){
            return null;
        }
        
        for(Usuario user : usuarios){
            if(user.getCorreo() != null && user.getCorreo().equalsIgnoreCase(correo)){
                return user;
            }
        }
        return null;
    }

    public boolean verificarPermiso(Usuario usuario, Rol rol){
        if(usuario == null || rol == null){
            return false;
        }
        if(!usuario.isActivo()){
            return false;
        }
        return usuario.getRol() == rol;
    }
}
