package modelo;

public class Agenda {
    private String fechaInicio;
    private String fechaFin;
    private LineaAgenda lineaAgenda;
    //Setters*******************************************************************
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setLineaAgenda(LineaAgenda lineaAgenda) {
        this.lineaAgenda = lineaAgenda;
    }
    //Getters*******************************************************************
    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public LineaAgenda getLineaAgenda() {
        return lineaAgenda;
    }
    //Constructors**************************************************************
    public Agenda(String fechaInicio, String fechaFin, LineaAgenda lineaAgenda) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lineaAgenda = lineaAgenda;
    }
    
    public Agenda(){
        this.lineaAgenda = null;
    }
}
