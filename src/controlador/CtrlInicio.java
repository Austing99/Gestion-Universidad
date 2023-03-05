package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Listas;
import vista.*;

public class CtrlInicio implements ActionListener{
    private MenuPrincipal view;
    private GestionUsuarios usuario;
    private GestionEdificios edificios;
    private GestionEspacios espacios;
    private CtrlGestionEspacios ctrlEspacios;
    private Reserva reserva;
    private Listas listas;
    private Login login;
    private VistaAgenda agenda;
    private CtrlReserva ctrlReserva;
    private CtrlAgenda ctrlAgenda;
    //Icono
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/imagenes/Logo.png");

    public CtrlInicio(MenuPrincipal view, GestionUsuarios usuario,GestionEdificios edificios, 
            GestionEspacios espacios,CtrlGestionEspacios ctrlEspacios, Listas listas, 
            Login login, Reserva reserva, VistaAgenda agenda, CtrlReserva ctrlReserva, CtrlAgenda ctrlAgenda) {
        this.view = view;
        this.usuario = usuario;
        this.edificios = edificios;
        this.espacios = espacios;
        this.ctrlEspacios = ctrlEspacios;
        this.listas = listas;
        this.login = login;
        this.reserva = reserva;
        this.agenda = agenda;
        this.ctrlReserva = ctrlReserva;
        this.ctrlAgenda = ctrlAgenda;
        //Botones***************************************************************
        this.view.btnGestionUsuarios.addActionListener(this);
        this.view.btnGestionEdificios.addActionListener(this);
        this.view.btnGestionEspacios.addActionListener(this);
        this.view.btnReserva.addActionListener(this);
        this.view.btnAgenda.addActionListener(this);
        this.view.btnCerrar.addActionListener(this);
        //Funciones Iniciales***************************************************
        CargarImagenes();
    }
    //Activacion o desactivacion de botones dependiendo del cargo que tenga el usuario***************************************************************
    public void Inicio(){
            int aux = listas.buscarCorreo(listas.getIngreso());
            if(aux!=-1){
                if(listas.getUsuario(aux).getDependencia().equals("Administrador")){
                    view.btnGestionUsuarios.setEnabled(true);
                    view.btnGestionEdificios.setEnabled(true);
                    view.btnGestionEspacios.setEnabled(true);
                    view.btnReserva.setEnabled(true);
                    view.btnAgenda.setEnabled(true);
                    view.btnCerrar.setEnabled(true);
                }
                else if(listas.getUsuario(aux).getDependencia().equals("EstudianteB")){
                    view.btnGestionUsuarios.setEnabled(false);
                    view.btnGestionEdificios.setEnabled(false);
                    view.btnGestionEspacios.setEnabled(false);
                    view.btnReserva.setEnabled(false);
                    view.btnAgenda.setEnabled(true);
                    view.btnCerrar.setEnabled(true);
                }
                else{
                    view.btnGestionUsuarios.setEnabled(false);
                    view.btnGestionEdificios.setEnabled(false);
                    view.btnGestionEspacios.setEnabled(false);
                    view.btnReserva.setEnabled(true);
                    view.btnAgenda.setEnabled(true);
                    view.btnCerrar.setEnabled(true);
                }
            }
    }
    //Cargar imagen para logo del programa***********************************************************************************************************
    public void CargarImagenes(){
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/imagenes/Layer.png"));
        Image im1 = myImage.getImage();
        Image im2 = im1.getScaledInstance(view.lblLogo.getWidth(), view.lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(im2);
        view.lblLogo.setIcon(i);
    }
    //Abrir una ventana y cerrar la actual sin que el programa se termine****************************************************************************
    public void CaracteristicasVentana(JFrame ventan,String nom){
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        view.setVisible(false);
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
    }
    //Funciones para los botones*********************************************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.btnGestionUsuarios) CaracteristicasVentana(usuario,"Gestion Usuarios");
        
        if(e.getSource()==view.btnGestionEdificios) CaracteristicasVentana(edificios,"Gestion Edificios");
        
        if(e.getSource()==view.btnGestionEspacios)
            if(listas.TamanioListaEdificios()>0){
                CaracteristicasVentana(espacios,"Gestion Espacios");
                ctrlEspacios.Iniciar();
            }
            else JOptionPane.showMessageDialog(null,"No se ha ingresado un edificio");
        
        if(e.getSource() == view.btnReserva){
            CaracteristicasVentana(reserva, "Reserva");
            ctrlReserva.Iniciar();
        }
        
        if(e.getSource() == view.btnAgenda){
            CaracteristicasVentana(agenda, "Agenda");
            ctrlAgenda.Espacios();
        }
        
        if(e.getSource()==view.btnCerrar) CaracteristicasVentana(login,"Inicio de Sesión");
    }   
}