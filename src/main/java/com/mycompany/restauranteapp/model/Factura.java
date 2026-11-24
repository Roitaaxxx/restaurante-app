/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteapp.model;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author johan
 */
public class Factura implements Serializable
{
    //Atributos 
    private int numero;
    private LocalDateTime fechaHora;
    private Pedido pedido;
    
    //Constructor
    public Factura(int numero, Pedido pedido) 
    {
        this.numero = numero;
        this.fechaHora = LocalDateTime.now();
        this.pedido = pedido;
    }
    
    //Método #1 (GENERAR PDF)
    public void generarPDF() 
    {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Factura_" + numero + ".pdf"));
            documento.open();
            documento.add(new Paragraph(this.toString()));
            documento.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Getters 
    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
    //Método #2 (TO STRING)
    @Override
    public String toString() 
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Factura \nNumero: " + numero +
               "\nFecha y hora: " + fechaHora.format(formato) +
               "\nPedido: " + (pedido != null ? pedido.toString() : "Sin pedido");
    }
    
}
