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
public class Restaurante implements Serializable
{
    //Atributos
    private String nombre;
    private Menu menu;
    private List<Mesa> mesas;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Mesero> meseros;
    private List<Reserva> reservas;
    private GestionDescuento gestionDescuentos;
    private String rutaLogo;
    
    //Constructor 
    public Restaurante(String nombre, String rutaLogo) 
    {
        this.nombre = nombre;
        this.rutaLogo = rutaLogo;
        this.menu = new Menu();
        this.mesas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.meseros = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.gestionDescuentos = new GestionDescuento();
    }
    
    //Método #1 (AGREGAR MESA)
    public void agregarMesa(Mesa mesa) 
    {
        if (mesa != null && !this.mesas.contains(mesa)) 
        {
            this.mesas.add(mesa);
        }
    }
    
    //Método #2 (AGREGAR CLIENTE)
    public void agregarCliente(Cliente cliente) 
    {
        if (cliente != null && !this.clientes.contains(cliente)) 
        {
            this.clientes.add(cliente);
        }
    }
    
    //Método #3 (AGREGAR MESEROS)
    public void agregarMeseros (Mesero mesero)
    {
        if (mesero != null && !this.meseros.contains(mesero))
        {
            this.meseros.add(mesero); 
        }
    }
    
    //Método #4 (AGREGAR PEDIDO)
    public void agregarPedido(Pedido pedido) 
    {
        if (pedido != null && !this.pedidos.contains(pedido)) 
        {
            this.pedidos.add(pedido);
        }
    }
    
    //Método #5 (AGREGAR RESERVA)
    public void agregarReserva(Reserva reserva) 
    {
        if (reserva != null && !this.reservas.contains(reserva)) 
        {
            this.reservas.add(reserva);
        }
    }
    
    //Método #6 (CONSULTAR MESA DISPONIBLE)
    public List<Mesa> consultarMesaDisponible() 
    {
        List<Mesa> disponibles = new ArrayList<>();
        for (Mesa m : this.mesas) 
        {
            if (m.getEstado() == EstadoMesa.Libre) 
            {
                disponibles.add(m);
            }
        }
        return disponibles;
    }
    
    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Mesero> getMeseros() {
        return meseros;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public GestionDescuento getGestionDescuentos() {
        return gestionDescuentos;
    }

    public void setGestionDescuentos(GestionDescuento gestionDescuentos) {
        this.gestionDescuentos = gestionDescuentos;
    }

    public String getRutaLogo() {
        return rutaLogo;
    }

    public void setRutaLogo(String rutaLogo) {
        this.rutaLogo = rutaLogo;
    }

}
