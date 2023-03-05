/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinal;

import controlador.*;
import modelo.Agenda;
import modelo.Espacio;
import modelo.Listas;
import vista.*;

/**
 *
 * @author Mateo
 */
public class TrabajoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Instancias Vistas****************************************************
        MenuPrincipal menu = new MenuPrincipal();
        GestionUsuarios usuario = new GestionUsuarios();
        GestionEdificios edificios = new GestionEdificios();
        GestionEspacios espacios = new GestionEspacios();
        Login login = new Login();
        Reserva reserva = new Reserva();
        VistaAgenda agenda = new VistaAgenda();
        Tabla tabla = new Tabla();

        //Intancia listas*******************************************************
        Listas listas = new Listas();

        //Recuperacion de datos de listas***************************************
        listas.RecuperarClientesActuales();
        listas.RecuperarEdificiosActuales();

        //Iniciar Controladores*************************************************
        CtrlTabla ctrlTabla = new CtrlTabla(usuario, edificios, espacios, tabla,agenda);
        CtrlGestionUsuario ctrlUsuario = new CtrlGestionUsuario(menu, usuario, listas, tabla, ctrlTabla);
        CtrlGestionEdificios ctrlEdificios = new CtrlGestionEdificios(menu, edificios, listas, tabla, ctrlTabla);
        CtrlGestionEspacios ctrlEspacios = new CtrlGestionEspacios(menu, espacios, listas, tabla, ctrlTabla);
        CtrlAgenda ctrlAgenda = new CtrlAgenda(menu, agenda,listas,tabla,ctrlTabla);
        CtrlReserva ctrlReserva = new CtrlReserva(menu, reserva, listas,ctrlAgenda);
        CtrlInicio ctrlInicio = new CtrlInicio(menu, usuario, edificios, espacios, ctrlEspacios, listas, login, reserva,agenda,ctrlReserva,ctrlAgenda);
        CtrlLogin ctrlLogin = new CtrlLogin(login, menu, listas, ctrlInicio);
        
        

        //Iniciar Menu**********************************************************
        ctrlLogin.Iniciar();
        
        listas.CrearAdministrador();
    }
}
