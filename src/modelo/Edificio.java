package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Edificio implements Serializable{
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int num_plantas;
    private int num_espacios;
    
    private ArrayList<Espacio> espacios;
    //SETTERS*******************************************************************
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNum_plantas(int num_plantas) {
        this.num_plantas = num_plantas;
    }

    public void setNum_espacios(int num_espacios) {
        this.num_espacios = num_espacios;
    }
    //GETTERS*******************************************************************
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNum_plantas() {
        return num_plantas;
    }

    public int getNum_espacios() {
        return num_espacios;
    }
    
    public Vector getDatos(){
        Vector datos = new Vector();
        
        datos.add(codigo);
        datos.add(nombre);
        datos.add(ubicacion);
        datos.add(num_plantas);
        datos.add(num_espacios);
        
        return datos;
    }
    //CONSTRUCTORS**************************************************************
    public Edificio(String codigo, String nombre, String ubicacion, int num_plantas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.num_plantas = num_plantas;
        
        this.espacios = new ArrayList<Espacio>();
        this.num_espacios = espacios.size();
    }
    
    public Edificio(){
        this.espacios = new ArrayList<Espacio>();
        this.num_espacios = espacios.size();
    }
    //Funciones del ArrayList***************************************************
    public ArrayList<Espacio> getListaEspacios(){    
        return espacios;
    }
    
    public void setListaEspacios(ArrayList<Espacio> espacios) {
        this.espacios = espacios;
    }
    
    public void AgregarEspacio(Espacio e) {
        espacios.add(e);
        this.num_espacios = espacios.size();
    }
    
    public Espacio getEspacio(int index){
        return espacios.get(index);
    }
    
    public void LimpiarListaEspacios(){
        espacios.clear();
    }
    
    public int TamanioListaEspacios(){
        return espacios.size();
    }
    
    public void EliminarEspacio(int index){
        this.espacios.remove(index);
        this.num_espacios = espacios.size();
    }
    
    public int buscarEspacio(String codigo){
        for(int i=0;i<espacios.size();i++){
            if(espacios.get(i).getCodigo().equals(codigo)) return i;
        }
        return -1;
    }
}