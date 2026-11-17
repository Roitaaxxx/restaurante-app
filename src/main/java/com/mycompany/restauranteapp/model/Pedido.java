/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roita
 */
public abstract class Pedido {
    protected int codigo;
    protected ArrayList<DetallePedido> detalles;
    protected EstadoPedido estado;
    protected static final double IMPUESTO_IVA = 0.19;
    protected LocalDate fecha;
    
    //constructor por defecto
    public Pedido(){
        this.detalles = new ArrayList<>();
    }
    
    //constructor por parametros
    public Pedido(int codigo, EstadoPedido estado) {
        this.codigo = codigo;
        this.estado = estado;
        this.detalles = new ArrayList<>();
        this.fecha = LocalDate.now();
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public ArrayList<DetallePedido> getDetalles(){
        return detalles;
    }
    
    public EstadoPedido getEstado(){
        return estado;
    }
    
    public double getIMPUESTO_IVA(){
        return IMPUESTO_IVA;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setDetalles(ArrayList<DetallePedido> detalles) {
        this.detalles = detalles;
    }
    
    public void setEstado(EstadoPedido estado){
        this.estado = estado;
    }
    
    public void agregarProducto(Producto producto, int cantidad){
        // Verificar que el pedido esté abierto
        if (this.estado == EstadoPedido.CERRADO)
        {
            throw new IllegalStateException("El pedido está cerrado");
        }

        // Verificar que el producto no sea nulo
        if (producto == null)
        {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        // Verificar que la cantidad sea válida
        if (cantidad <= 0)
        {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        // Verificar que el producto esté disponible
        if (!producto.isDisponible())
        {
            throw new IllegalArgumentException("El producto no está disponible");
        }

        // Buscar si el producto ya existe en el pedido
        for (DetallePedido detalle : this.detalles)
        {
            if (detalle.getProducto().getId() == producto.getId())
            {
                detalle.setCantidad(detalle.getCantidad() + cantidad);
                return;
            }
        }

        // Crear un nuevo detalle si el producto no existe
        DetallePedido nuevoDetalle = new DetallePedido(
            producto,
            cantidad,
            producto.getPrecio()
        );

        this.detalles.add(nuevoDetalle);
    }
    
    // Metodo para eliminar productos
    public void eliminarProducto(Producto producto)
    {
        if (this.estado == EstadoPedido.CERRADO)
        {
            throw new IllegalStateException("El pedido está cerrado");
        }

        if (producto == null)
        {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        for (int i = 0; i < this.detalles.size(); i++)
        {
            if (this.detalles.get(i).getProducto().getId() == producto.getId())
            {
                this.detalles.remove(i);
                return;
            }
        }
    }
    
    // Metodo para modificar la cantidad
    public void modificarCantidad(Producto producto, int cantidad)
    {
        if (this.estado == EstadoPedido.CERRADO)
        {
            throw new IllegalStateException("El pedido está cerrado");
        }

        if (producto == null)
        {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        if (cantidad <= 0)
        {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        for (DetallePedido detalle : this.detalles)
        {
            if (detalle.getProducto().getId() == producto.getId())
            {
                detalle.setCantidad(cantidad);
                return;
            }
        }

        throw new IllegalArgumentException("El producto no está en el pedido");
    }
    
    public double calcularSubtotal(){
        double subtotal = 0.0;
        for (DetallePedido detalle : detalles) {
            subtotal += detalle.getPrecioUnitario() * detalle.getCantidad();
        }
        return subtotal;
    }
    
    // Metodo para calcular el descuento
    public double calcularDescuento(GestionDescuento gestion)
    {
        double descuentoTotal = 0;

        if(gestion == null)
        {
            throw new IllegalArgumentException("La gestion de descuentos no puede ser nula");
        }

        for(DetallePedido detalle : this.detalles)
        {
            Producto producto = detalle.getProducto();

            Categoria categoria = producto.getCategoria();

            Descuento descuento = gestion.buscarDescuento(
                this.fecha.getDayOfWeek(),
                categoria
            );

            if(descuento != null)
            {
                double subtotal = detalle.calcularSubtotal();

                double valorConDescuento = descuento.aplicarDescuento(subtotal);

                descuentoTotal += subtotal - valorConDescuento;
            }
        }

        return descuentoTotal;
    }
    
    public abstract double calcularTotal(GestionDescuento gestion);
    
    // Metodo para cerrar el pedido
    public void cerrarPedido()
    {
        if (this.estado == EstadoPedido.CERRADO)
        {
            throw new IllegalStateException("El pedido ya está cerrado");
        }

        if (this.detalles.isEmpty())
        {
            throw new IllegalStateException("No se puede cerrar un pedido vacío");
        }

        this.estado = EstadoPedido.CERRADO;
    }
}
