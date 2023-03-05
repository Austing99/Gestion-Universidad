package modelo;

import java.io.Serializable;
import java.util.Vector;

public class Usuario implements Serializable{
    private String cedula;
    private String contrasenia;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String dependencia;
    //SETTERS*******************************************************************
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setConstrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    //GETTERS*******************************************************************
    public String getCedula() {
        return cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDependencia() {
        return dependencia;
    }
    
    public Vector getDatos(){
        Vector datos = new Vector();
        
        datos.add(cedula);
        datos.add(nombres);
        datos.add(apellidos);
        datos.add(telefono);
        datos.add(correo);
        datos.add(contrasenia);
        datos.add(dependencia);
        
        return datos;
    }
    //CONSTRUCTORS**************************************************************
    public Usuario(String cedula, String contrasenia, String nombres, String apellidos, String telefono, String correo, String dependencia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.dependencia = dependencia;
    }
    public Usuario(){
        
    }
}
