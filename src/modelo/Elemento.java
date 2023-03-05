/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Austin
 */
public class Elemento implements Serializable{
    private String descripcion;
    private int cantidad;
    //SETTERS*******************************************************************
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //GETTERS*******************************************************************
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public Vector getDatos(){
        Vector datos = new Vector();
        
        datos.add(descripcion);
        datos.add(cantidad);
        
        return datos;
    }
    //CONSTRUCTORS**************************************************************
    public Elemento(String descripcion, int cantidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    
    public Elemento() {
    } 
}