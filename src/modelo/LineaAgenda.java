/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Austin
 */
public class LineaAgenda {
    private String horaInicial;
    private String horaFinal;
    private String actividad;
    private Solicitante solicitante;
    private Solicitud solicitud;
    //SETTERS*******************************************************************
    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    //GETTERS*******************************************************************
    public String getHoraInicial() {
        return horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public String getActividad() {
        return actividad;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
    //CONTRUCTORS***************************************************************
    public LineaAgenda(String horaInicial, String horaFinal, String actividad, Solicitante solicitante, Solicitud solicitud) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.actividad = actividad;
        this.solicitante = solicitante;
        this.solicitud = solicitud;
    }
    
    public void LineaAgenda(){
        this.solicitante = null;
        this.solicitud = null;
    }
}
