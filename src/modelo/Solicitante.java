package modelo;

public class Solicitante{
    private int prioridad;
    private Usuario usuario;
    //SETTERS*******************************************************************
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        Prioridad();
    }
    //GETTERS*******************************************************************
    public int getPrioridad() {
        return prioridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    //CONSTRUCTORS**************************************************************
    public Solicitante(Usuario usuario) {
        this.usuario = usuario;
        Prioridad();
    }  

    public Solicitante() {
    }
    //Funtions******************************************************************
    public void Prioridad(){
        switch(usuario.getDependencia()){
            case "Decano":
                this.prioridad=5;
                break;
            case "Subdecano":
                this.prioridad=4;
                break;
            case "Director de carrera":
                this.prioridad=3;
                break;
            case "Docente":
                this.prioridad=2;
                break;
            default:
                this.prioridad=1;
                break;
        }
    }
}