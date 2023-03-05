/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Austin
 */
public class Espacio implements Serializable{
    private String codigo;
    private String descripcion;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private ArrayList<Usuario> encargados;
    private ArrayList<Elemento> elementos;
    private ArrayList<Agenda> agenda;
    //SETTERS*******************************************************************
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    //GETTERS*******************************************************************
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    public int getSizeAgenda(){
        return agenda.size();
    }
    public Vector getDatos(){
        Vector datos = new Vector();
        
        datos.add(codigo);
        datos.add(descripcion);
        datos.add(ubicacion);
        datos.add(tipo);
        datos.add(capacidad);
        
        return datos;
    }
    //CONTRUCTORS***************************************************************
    public Espacio(String codigo, String descripcion, String ubicacion, String tipo, int capacidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.encargados = new ArrayList<Usuario>();
        this.elementos = new ArrayList<Elemento>();
        this.agenda = new ArrayList<Agenda>();
    }

    public Espacio() {
        this.encargados = new ArrayList<Usuario>();
        this.elementos = new ArrayList<Elemento>();
        this.agenda = new ArrayList<Agenda>();
    }
    //Funciones del ArrayList***************************************************
    public ArrayList<Elemento> getListaElementos(){    
        return elementos;
    }
    
    public void setListaElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public void AgregarElementos(Elemento e) {
        this.elementos.add(e);
    }
    
    public Elemento getElemento(int index){
        return elementos.get(index);
    }
    
    public void LimpiarListaElementos(){
        elementos.clear();
    }
    
    public int TamanioListaElementos(){
        return elementos.size();
    }
    
    public void EliminarElementos(int index){
        this.elementos.remove(index);
    }
    
    public int buscarElemento(String descripcion){
        for(int i=0;i<elementos.size();i++){
            if(elementos.get(i).getDescripcion().equals(descripcion)) return i;
        }
        return -1;
    }
    //Funciones del ArrayList***************************************************
    public ArrayList<Usuario> getListaEncargados(){    
        return encargados;
    }
    
    public void setListaEncargados(ArrayList<Usuario> encargados) {
        this.encargados = encargados;
    }
    
    public void AgregarEncargado(Usuario u) {
        this.encargados.add(u);
    }
    
    public Usuario getEncargado(int index){
        return encargados.get(index);
    }
    
    public void LimpiarListaEncargados(){
        encargados.clear();
    }
    
    public int TamanioListaEncargados(){
        return encargados.size();
    }
    
    public void EliminarEncargado(int index){
        this.encargados.remove(index);
    }
    
    public int buscarEncargado(String nombre){
        for(int i=0;i<encargados.size();i++){
            String nombres = encargados.get(i).getNombres() + " " + encargados.get(i).getApellidos();
            if(nombres.equals(nombre)) return i;
        }
        return -1;
    }
    
    public int buscarCorreoEncargado (String correo){
        for(int i=0;i<encargados.size();i++){
            if(encargados.get(i).getCorreo().equals(correo)) return i;
        }
        return -1;
    }
    //Funciones del ArrayList***************************************************
    public ArrayList<Agenda> getListaAgenda(){    
        return agenda;
    }
    
    public void setListaAgenda(ArrayList<Agenda> agenda) {
        this.agenda = agenda;
    }
    
    public void AgregarAgenda(Agenda a) {
        this.agenda.add(a);
    }
    
    public Agenda getAgenda(int index){
        return agenda.get(index);
    }
    
    public void LimpiarListaAgenda(){
        agenda.clear();
    }
    
    public int TamanioListaAgenda(){
        return agenda.size();
    }
    
    public void EliminarAgenda(int index){
        this.agenda.remove(index);
    }
    
    public int buscarAgenda(String codigo){
        for(int i=0;i<agenda.size();i++){
            if(agenda.get(i).getLineaAgenda().getSolicitud().getCodigo().equals(codigo)) return i;
        }
        return -1;
    }
    
    public String GenerarCodigoReserva(){
        String reserva="";
        int aux = 0;
        do{
            aux++;
            reserva=this.codigo+aux;
        }while(buscarAgenda(reserva)!=-1);
        return reserva;
    }
}