/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;
import java.util.ArrayList;
/**
 *
 * @author LaMar
 */
public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private Usuario usuario;
    private ArrayList<Direccion> direccion;

    public Cliente() { //Constructor vacío/por defecto en caso de potencial posterior carga de datos mas tarde
    }

    public Cliente(int id, String nombre, String telefono, Usuario usuario, ArrayList<Direccion> direccion) { //Constructor con parametros
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<Direccion> direccion) {
        this.direccion = direccion;
    }
    
    
    public void actualizarDatos(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono; //Uso la palabra reservada this porque los parametros se llama exactamente igual
    }
    
    
    public void agregarDireccion(Direccion nuevaDireccion){ //Validacion, que coja por ramas y no se crashee
          if (nuevaDireccion !=  null){ //La direccion solo se va a agregar si no hay nada/no es nula
              direccion.add(nuevaDireccion);
          }
    }
    
    
    public void eliminarDireccion(Direccion direccionAEliminar){ //Validacion, verificacion de que se puede proceder
        if (direccion.contains(direccionAEliminar)){ //Se revisa si la direccion esta en la lista
            direccion.remove(direccionAEliminar); //Al confirmar/verificar que efectuvamente es así se elimina la direaccion
        }
    }
    
    
    @Override
    public String toString(){
        String nombreDir = (direccion.isEmpty()) ? "Ninguna" : direccion.get(0).getDescripcion(); //Escoge la primera direccion porque no se bien que poner exactamente
        return "Cliente \nID de cliente: "+ id + "\nNombre: "+ nombre + "\nTelefono: "+ telefono + "Direccion principal: "+nombreDir;
    }
    
    
}
