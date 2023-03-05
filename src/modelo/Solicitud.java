package modelo;

public class Solicitud {
    private String codigo;
    private String estado;
    //Setters*******************************************************************
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //Getters*******************************************************************
    public String getCodigo() {
        return codigo;
    }
    
    public String getEstado() {
        return estado;
    }
    //Constructors***************************************************************
    public Solicitud(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }
    
    public Solicitud(){
        
    }
}
