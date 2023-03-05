package controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import vista.*;

public class CtrlTabla implements ActionListener{
    private final GestionUsuarios usuario;
    private final GestionEdificios edificios;
    private final GestionEspacios espacios;
    private final VistaAgenda agenda;
    private final Tabla view;
    private int tipo;
    
    //Tabla e Imagen
    DefaultTableModel tabla;
    private Image iconoPropio = Toolkit.getDefaultToolkit().getImage("src/Imagenes/Logo.png");

    public CtrlTabla(GestionUsuarios usuario, GestionEdificios edificios,GestionEspacios espacios, Tabla view, VistaAgenda agenda){
        this.usuario = usuario;
        this.edificios = edificios;
        this.espacios = espacios;
        this.view = view;
        this.agenda = agenda;
        
        //Botones
        this.view.btnRegresar.addActionListener(this);
    }
    
    public void Inicio(String col[], int tipo){
        this.tipo=tipo;
        
        String data[][] = {};
        tabla = new DefaultTableModel(data,col);
        view.tblDatos.setModel(tabla);
    }
    
    public void AgregarFila(Vector fila){
        tabla.addRow(fila);
    }
    
    public void Regresar(){
        if(tipo==1) AbrirVentana(usuario,"Gestion Usuarios");
        if(tipo==2) AbrirVentana(edificios,"Gestion Edificios");
        if(tipo==3) AbrirVentana(espacios,"Gestion Espacios");
        if(tipo==4) AbrirVentana(agenda,"Agenda");
    }
    
    public void AbrirVentana(JFrame ventan,String nom){
        ventan.setIconImage(iconoPropio); //icono
        ventan.setTitle(nom);             //Título
        ventan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //Que no se cierre el programa al cerrar esta ventana
        ventan.setLocationRelativeTo(null);   //Ubicación al centro de la pantalla
        view.setVisible(false);
        ventan.setVisible(true);        //Sea visible
        ventan.setResizable(false);     //No se pueda maximizar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==view.btnRegresar) Regresar();
    }
}